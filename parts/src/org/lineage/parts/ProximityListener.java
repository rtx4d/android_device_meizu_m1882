/*
* Copyright (C) 2020 The MoKee Open Source Project
*
* SPDX-License-Identifier: Apache-2.0
*
*/

package org.lineageos.device.parts;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

class ProximityListener implements SensorEventListener {

private static final String TAG = "ProximityListener";
private static final boolean DEBUG = false;

private final AODService mService;

private final SensorManager mSensorManager;
private final Sensor mSensor;

private boolean mIsListening = false;

ProximityListener(AODService service) {
        mService = service;
        mSensorManager = (SensorManager) service.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY, false);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.values[0] < mSensor.getMaximumRange()) {
            mService.onProximityNear();
        } else {
            mService.onProximityFar();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    void enable() {
        if (mIsListening) return;
        if (DEBUG) Log.d(TAG, "Enabling");
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
        mIsListening = true;
    }

    void disable() {
        if (!mIsListening) return;
        if (DEBUG) Log.d(TAG, "Disabling");
        mSensorManager.unregisterListener(this, mSensor);
        mIsListening = false;
    }

}
