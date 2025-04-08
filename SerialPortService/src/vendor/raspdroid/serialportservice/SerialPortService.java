package vendor.raspdroid.serialportservice;

import android.app.Application;
import android.os.ServiceManager;
import android.util.Log;

public class SerialPortService extends Application {
    private static final String SERVICE_NAME = "serialport";
    private SerialPortServiceImpl serviceImpl;

    public void onCreate() {
        super.onCreate();
        Log.i("SerialPortService", "Starting service...");
        serviceImpl = new SerialPortServiceImpl(getApplicationContext());
        ServiceManager.addService(SERVICE_NAME, serviceImpl);
    }

    public void onTerminate() {
        super.onTerminate();
    }
}