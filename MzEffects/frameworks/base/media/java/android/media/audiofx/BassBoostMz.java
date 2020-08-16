package android.media.audiofx;

import android.media.audiofx.AudioEffect;
import android.util.Log;
import java.util.StringTokenizer;
import java.util.UUID;

public class BassBoostMz extends AudioEffect {
    public static final UUID EFFECT_TYPE_BASS_BOOST_EX = UUID.fromString("47164cd2-526a-49f5-8f90-0ba88c408cd7");
    public static final int PARAM_STRENGTH = 1;
    public static final int PARAM_STRENGTH_SUPPORTED = 0;
    private static final String TAG = "BassBoostMz";
    private BaseParameterListener mBaseParamListener = null;
    /* access modifiers changed from: private */
    public OnParameterChangeListener mParamListener = null;
    /* access modifiers changed from: private */
    public final Object mParamListenerLock = new Object();
    private boolean mStrengthSupported = false;

    public interface OnParameterChangeListener {
        void onParameterChange(BassBoostMz bassBoostMz, int i, int i2, short s);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BassBoostMz(int priority, int audioSession) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_BASS_BOOST_EX, EFFECT_TYPE_NULL, priority, audioSession);
        boolean z = true;
        if (audioSession == 0) {
            Log.w(TAG, "WARNING: attaching a BassBoostMz to global output mix is deprecated!");
        }
        int[] value = new int[1];
        checkStatus(getParameter(0, value));
        this.mStrengthSupported = value[0] == 0 ? false : z;
    }

    public boolean getStrengthSupported() {
        return this.mStrengthSupported;
    }

    public int setEnabled(boolean enabled) {
        return super.setEnabled(enabled);
    }

    public void setStrength(short strength) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(1, strength));
    }

    public short getRoundedStrength() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        short[] value = new short[1];
        checkStatus(getParameter(1, value));
        return value[0];
    }

    private class BaseParameterListener implements AudioEffect.OnParameterChangeListener {
        /* synthetic */ BaseParameterListener(BassBoostMz this$02, BaseParameterListener baseParameterListener) {
            this();
        }

        private BaseParameterListener() {
        }

        public void onParameterChange(AudioEffect effect, int status, byte[] param, byte[] value) {
            OnParameterChangeListener l = null;
            synchronized (BassBoostMz.this.mParamListenerLock) {
                if (BassBoostMz.this.mParamListener != null) {
                    l = BassBoostMz.this.mParamListener;
                }
            }
            if (l != null) {
                int p = -1;
                short v = -1;
                if (param.length == 4) {
                    p = BassBoostMz.byteArrayToInt(param, 0);
                }
                if (value.length == 2) {
                    v = BassBoostMz.byteArrayToShort(value, 0);
                }
                if (p != -1 && v != -1) {
                    l.onParameterChange(BassBoostMz.this, status, p, v);
                }
            }
        }
    }

    public void setParameterListener(OnParameterChangeListener listener) {
        synchronized (this.mParamListenerLock) {
            if (this.mParamListener == null) {
                this.mParamListener = listener;
                this.mBaseParamListener = new BaseParameterListener(this, (BaseParameterListener) null);
                super.setParameterListener(this.mBaseParamListener);
            }
        }
    }

    public static class Settings {
        public short strength;

        public Settings() {
        }

        public Settings(String settings) {
            StringTokenizer st = new StringTokenizer(settings, "=;");
            int countTokens = st.countTokens();
            if (st.countTokens() != 3) {
                throw new IllegalArgumentException("settings: " + settings);
            }
            String key = st.nextToken();
            if (!key.equals(BassBoostMz.TAG)) {
                throw new IllegalArgumentException("invalid settings for BassBoostMz: " + key);
            }
            try {
                key = st.nextToken();
                if (!key.equals("strength")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                this.strength = Short.parseShort(st.nextToken());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid value for key: " + key);
            }
        }

        public String toString() {
            return new String("BassBoostMz;strength=" + Short.toString(this.strength));
        }
    }

    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        Settings settings = new Settings();
        short[] value = new short[1];
        checkStatus(getParameter(1, value));
        settings.strength = value[0];
        return settings;
    }

    public void setProperties(Settings settings) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(1, settings.strength));
    }
}
