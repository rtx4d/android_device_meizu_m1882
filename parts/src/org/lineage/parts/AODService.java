/*
* Copyright (C) 2020 The MoKee Open Source Project
*
* SPDX-License-Identifier: Apache-2.0
*
*/

package org.lineageos.device.parts;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

public class AODService extends Service {

private static final String TAG = "AODService";
private static final boolean DEBUG = false;

private static final long AOD_DELAY_MS = 1000;

private SettingObserver mSettingObserver;
private ScreenReceiver mScreenReceiver;
private ProximityListener mProximityListener;

private Handler mHandler = new Handler(Looper.getMainLooper());
private boolean mInteractive = true;
private boolean mCovered = false;
private boolean mInAOD = false;

@Override
public void onCreate() {
super.onCreate();
if (DEBUG) Log.d(TAG, "Creating service");

mSettingObserver = new SettingObserver(this);
mScreenReceiver = new ScreenReceiver(this);
mProximityListener = new ProximityListener(this);

mSettingObserver.enable();

if (Utils.isAODEnabled(this)) {
mScreenReceiver.enable();
}
}

@Override
public void onDestroy() {
super.onDestroy();
if (DEBUG) Log.d(TAG, "Destroying service");

mSettingObserver.disable();
mScreenReceiver.disable();
mProximityListener.disable();
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
if (DEBUG) Log.d(TAG, "Starting service");
return START_STICKY;
}

@Override
public IBinder onBind(Intent intent) {
return null;
}

void onSettingChange() {
if (Utils.isAODEnabled(this)) {
Log.d(TAG, "AOD enabled");
mScreenReceiver.enable();
} else {
Log.d(TAG, "AOD disabled");
mScreenReceiver.disable();
}
}

void onDisplayOn() {
Log.d(TAG, "Device interactive");
mInteractive = true;
mProximityListener.disable();
mHandler.removeCallbacksAndMessages(null);
}

void onDisplayOff() {
Log.d(TAG, "Device non-interactive");
mInAOD = false;
mInteractive = false;
mHandler.postDelayed(() -> {
mProximityListener.enable();
updateAOD();
}, AOD_DELAY_MS);
}

void onProximityNear() {
Log.d(TAG, "Device covered");
mCovered = true;
updateAOD();
}

void onProximityFar() {
Log.d(TAG, "Device uncovered");
mCovered = false;
updateAOD();
}

private void updateAOD() {
final boolean state = !mInteractive && !mCovered;
if (mInAOD != state) {
mInAOD = state;
if (state) {
Log.d(TAG, "Enter AOD");
Utils.enterAOD();
} else {
Log.d(TAG, "Exit AOD");
Utils.exitAOD();
}
}
}

}
