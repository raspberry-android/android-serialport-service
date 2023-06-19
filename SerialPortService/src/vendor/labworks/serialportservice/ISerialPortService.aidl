package vendor.labworks.serialportservice;

interface ISerialPortService {
    void tx(byte data);
    byte rx();
}
