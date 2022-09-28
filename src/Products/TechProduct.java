package Products;

public abstract class TechProduct extends Product {
    private int storage;
    private int ram;
    private float screenSize;
    private float batteryPower;
    private int cameraPixel;

    public TechProduct(int id, String name, float price, float discountRate, int stock, String brand, int storage, int ram, float screenSize, float batteryPower, int cameraPixel) {
        super(id, name, price, discountRate, stock, brand);
        this.storage = storage;
        this.ram = ram;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.cameraPixel = cameraPixel;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public float getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }

    public float getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(float batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int getCameraPixel() {
        return cameraPixel;
    }

    public void setCameraPixel(int cameraPixel) {
        this.cameraPixel = cameraPixel;
    }
}
