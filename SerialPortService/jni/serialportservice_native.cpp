#include <aidl/vendor/raspdroid/serialport/ISerialPort.h>
#include <android/binder_manager.h>
#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

using aidl::vendor::raspdroid::serialport::ISerialPort;

static std::shared_ptr<ISerialPort> serialport = nullptr;

JNIEXPORT void JNICALL
  Java_vendor_raspdroid_serialportservice_SerialPortServiceImpl_nativeTx
  (JNIEnv *, jclass, jbyte data) {
    if (serialport == nullptr) {
        const std::string instance = std::string() + ISerialPort::descriptor + "/default";
        serialport = ISerialPort::fromBinder(ndk::SpAIBinder(AServiceManager_checkService(instance.c_str())));
    }
    serialport->tx(data);
}

JNIEXPORT jbyte JNICALL
  Java_vendor_raspdroid_serialportservice_SerialPortServiceImpl_nativeRx
  (JNIEnv *, jclass) {
    if (serialport == nullptr) {
        const std::string instance = std::string() + ISerialPort::descriptor + "/default";
        serialport = ISerialPort::fromBinder(ndk::SpAIBinder(AServiceManager_checkService(instance.c_str())));
    }
    int8_t data = 0;
    serialport->rx(&data);
    return data;
}

#ifdef __cplusplus
}
#endif