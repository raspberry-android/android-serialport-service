package vendor.raspdroid.serialportservice;

interface ISerialPortService {
    void tx(byte data);
    byte rx();
}