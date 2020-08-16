package android.media.audiofx;

import android.media.audiofx.AudioEffect;
import java.util.StringTokenizer;
import java.util.UUID;

public class EnvironmentalReverbMz extends AudioEffect {
    public static final UUID EFFECT_TYPE_ENV_REVERB_EX = UUID.fromString("38a6a248-94be-4007-bbe1-337d7dc49e6d");
    public static final int PARAM_DECAY_HF_RATIO = 3;
    public static final int PARAM_DECAY_TIME = 2;
    public static final int PARAM_DENSITY = 9;
    public static final int PARAM_DIFFUSION = 8;
    private static final int PARAM_PROPERTIES = 10;
    public static final int PARAM_REFLECTIONS_DELAY = 5;
    public static final int PARAM_REFLECTIONS_LEVEL = 4;
    public static final int PARAM_REVERB_DELAY = 7;
    public static final int PARAM_REVERB_LEVEL = 6;
    public static final int PARAM_ROOM_HF_LEVEL = 1;
    public static final int PARAM_ROOM_LEVEL = 0;
    private static int PROPERTY_SIZE = 26;
    private static final String TAG = "EnvironmentalReverb";
    private BaseParameterListener mBaseParamListener = null;
    /* access modifiers changed from: private */
    public OnParameterChangeListener mParamListener = null;
    /* access modifiers changed from: private */
    public final Object mParamListenerLock = new Object();

    public interface OnParameterChangeListener {
        void onParameterChange(EnvironmentalReverbMz environmentalReverbMz, int i, int i2, int i3);
    }

    public EnvironmentalReverbMz(int priority, int audioSession) throws IllegalArgumentException, UnsupportedOperationException, RuntimeException {
        super(EFFECT_TYPE_ENV_REVERB_EX, EFFECT_TYPE_NULL, priority, audioSession);
    }

    public void setRoomLevel(short room) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(0, shortToByteArray(room)));
    }

    public short getRoomLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(0, param));
        return byteArrayToShort(param);
    }

    public void setRoomHFLevel(short roomHF) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(1, shortToByteArray(roomHF)));
    }

    public short getRoomHFLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(1, param));
        return byteArrayToShort(param);
    }

    public void setDecayTime(int decayTime) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(2, intToByteArray(decayTime)));
    }

    public int getDecayTime() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[4];
        checkStatus(getParameter(2, param));
        return byteArrayToInt(param);
    }

    public void setDecayHFRatio(short decayHFRatio) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(3, shortToByteArray(decayHFRatio)));
    }

    public short getDecayHFRatio() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(3, param));
        return byteArrayToShort(param);
    }

    public void setReflectionsLevel(short reflectionsLevel) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(4, shortToByteArray(reflectionsLevel)));
    }

    public short getReflectionsLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(4, param));
        return byteArrayToShort(param);
    }

    public void setReflectionsDelay(int reflectionsDelay) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(5, intToByteArray(reflectionsDelay)));
    }

    public int getReflectionsDelay() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[4];
        checkStatus(getParameter(5, param));
        return byteArrayToInt(param);
    }

    public void setReverbLevel(short reverbLevel) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(6, shortToByteArray(reverbLevel)));
    }

    public short getReverbLevel() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(6, param));
        return byteArrayToShort(param);
    }

    public void setReverbDelay(int reverbDelay) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(7, intToByteArray(reverbDelay)));
    }

    public int getReverbDelay() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[4];
        checkStatus(getParameter(7, param));
        return byteArrayToInt(param);
    }

    public void setDiffusion(short diffusion) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(8, shortToByteArray(diffusion)));
    }

    public short getDiffusion() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(8, param));
        return byteArrayToShort(param);
    }

    public void setDensity(short density) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(9, shortToByteArray(density)));
    }

    public short getDensity() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[2];
        checkStatus(getParameter(9, param));
        return byteArrayToShort(param);
    }

    private class BaseParameterListener implements AudioEffect.OnParameterChangeListener {
        /* synthetic */ BaseParameterListener(EnvironmentalReverbMz this$02, BaseParameterListener baseParameterListener) {
            this();
        }

        private BaseParameterListener() {
        }

        public void onParameterChange(AudioEffect effect, int status, byte[] param, byte[] value) {
            OnParameterChangeListener l = null;
            synchronized (EnvironmentalReverbMz.this.mParamListenerLock) {
                if (EnvironmentalReverbMz.this.mParamListener != null) {
                    l = EnvironmentalReverbMz.this.mParamListener;
                }
            }
            if (l != null) {
                int p = -1;
                int v = -1;
                if (param.length == 4) {
                    p = EnvironmentalReverbMz.byteArrayToInt(param, 0);
                }
                if (value.length == 2) {
                    v = EnvironmentalReverbMz.byteArrayToShort(value, 0);
                } else if (value.length == 4) {
                    v = EnvironmentalReverbMz.byteArrayToInt(value, 0);
                }
                if (p != -1 && v != -1) {
                    l.onParameterChange(EnvironmentalReverbMz.this, status, p, v);
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
        public short decayHFRatio;
        public int decayTime;
        public short density;
        public short diffusion;
        public int reflectionsDelay;
        public short reflectionsLevel;
        public int reverbDelay;
        public short reverbLevel;
        public short roomHFLevel;
        public short roomLevel;

        public Settings() {
        }

        public Settings(String settings) {
            StringTokenizer st = new StringTokenizer(settings, "=;");
            int countTokens = st.countTokens();
            if (st.countTokens() != 21) {
                throw new IllegalArgumentException("settings: " + settings);
            }
            String key = st.nextToken();
            if (!key.equals(EnvironmentalReverbMz.TAG)) {
                throw new IllegalArgumentException("invalid settings for EnvironmentalReverb: " + key);
            }
            try {
                key = st.nextToken();
                if (!key.equals("roomLevel")) {
                    throw new IllegalArgumentException("invalid key name: " + key);
                }
                this.roomLevel = Short.parseShort(st.nextToken());
                String key2 = st.nextToken();
                if (!key2.equals("roomHFLevel")) {
                    throw new IllegalArgumentException("invalid key name: " + key2);
                }
                this.roomHFLevel = Short.parseShort(st.nextToken());
                String key3 = st.nextToken();
                if (!key3.equals("decayTime")) {
                    throw new IllegalArgumentException("invalid key name: " + key3);
                }
                this.decayTime = Integer.parseInt(st.nextToken());
                String key4 = st.nextToken();
                if (!key4.equals("decayHFRatio")) {
                    throw new IllegalArgumentException("invalid key name: " + key4);
                }
                this.decayHFRatio = Short.parseShort(st.nextToken());
                String key5 = st.nextToken();
                if (!key5.equals("reflectionsLevel")) {
                    throw new IllegalArgumentException("invalid key name: " + key5);
                }
                this.reflectionsLevel = Short.parseShort(st.nextToken());
                String key6 = st.nextToken();
                if (!key6.equals("reflectionsDelay")) {
                    throw new IllegalArgumentException("invalid key name: " + key6);
                }
                this.reflectionsDelay = Integer.parseInt(st.nextToken());
                String key7 = st.nextToken();
                if (!key7.equals("reverbLevel")) {
                    throw new IllegalArgumentException("invalid key name: " + key7);
                }
                this.reverbLevel = Short.parseShort(st.nextToken());
                String key8 = st.nextToken();
                if (!key8.equals("reverbDelay")) {
                    throw new IllegalArgumentException("invalid key name: " + key8);
                }
                this.reverbDelay = Integer.parseInt(st.nextToken());
                String key9 = st.nextToken();
                if (!key9.equals("diffusion")) {
                    throw new IllegalArgumentException("invalid key name: " + key9);
                }
                this.diffusion = Short.parseShort(st.nextToken());
                String key10 = st.nextToken();
                if (!key10.equals("density")) {
                    throw new IllegalArgumentException("invalid key name: " + key10);
                }
                this.density = Short.parseShort(st.nextToken());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid value for key: " + key);
            }
        }

        public String toString() {
            return new String("EnvironmentalReverb;roomLevel=" + Short.toString(this.roomLevel) + ";roomHFLevel=" + Short.toString(this.roomHFLevel) + ";decayTime=" + Integer.toString(this.decayTime) + ";decayHFRatio=" + Short.toString(this.decayHFRatio) + ";reflectionsLevel=" + Short.toString(this.reflectionsLevel) + ";reflectionsDelay=" + Integer.toString(this.reflectionsDelay) + ";reverbLevel=" + Short.toString(this.reverbLevel) + ";reverbDelay=" + Integer.toString(this.reverbDelay) + ";diffusion=" + Short.toString(this.diffusion) + ";density=" + Short.toString(this.density));
        }
    }

    public Settings getProperties() throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        byte[] param = new byte[PROPERTY_SIZE];
        checkStatus(getParameter(10, param));
        Settings settings = new Settings();
        settings.roomLevel = byteArrayToShort(param, 0);
        settings.roomHFLevel = byteArrayToShort(param, 2);
        settings.decayTime = byteArrayToInt(param, 4);
        settings.decayHFRatio = byteArrayToShort(param, 8);
        settings.reflectionsLevel = byteArrayToShort(param, 10);
        settings.reflectionsDelay = byteArrayToInt(param, 12);
        settings.reverbLevel = byteArrayToShort(param, 16);
        settings.reverbDelay = byteArrayToInt(param, 18);
        settings.diffusion = byteArrayToShort(param, 22);
        settings.density = byteArrayToShort(param, 24);
        return settings;
    }

    public void setProperties(Settings settings) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        checkStatus(setParameter(10, concatArrays(new byte[][]{shortToByteArray(settings.roomLevel), shortToByteArray(settings.roomHFLevel), intToByteArray(settings.decayTime), shortToByteArray(settings.decayHFRatio), shortToByteArray(settings.reflectionsLevel), intToByteArray(settings.reflectionsDelay), shortToByteArray(settings.reverbLevel), intToByteArray(settings.reverbDelay), shortToByteArray(settings.diffusion), shortToByteArray(settings.density)})));
    }
}
