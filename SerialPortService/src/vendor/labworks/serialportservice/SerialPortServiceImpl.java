package vendor.labworks.serialportservice;

import android.content.Context;

class SerialPortServiceImpl extends ISerialPortService.Stub {
    public static final String SERIALPORT_PERM =
        "vendor.labworks.serialportservice.permission.SERIALPORT";
    private final Context mContext;

    static {
        System.loadLibrary("jni_serialportservice");
    }

    public SerialPortServiceImpl(Context context) {
        mContext = context;
    }

    public void tx(byte data) {
        mContext.enforceCallingOrSelfPermission(SERIALPORT_PERM, null);
        nativeTx(data);
    }

    public byte rx() {
        mContext.enforceCallingOrSelfPermission(SERIALPORT_PERM, null);
        return nativeRx();
    }

    private static native void nativeTx(byte data);
    private static native byte nativeRx();
}
