public class Electronics extends Product {
    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;


    // getCpuSpeed method to obtain CPU speed value
    double getCpuSpeed() {

        return this.cpuSpeed;
    }

    // setCPUSpeed method to store CPU speed value
    void setCpuSpeed(double CPU) {

        this.cpuSpeed = CPU;
    }

    // getRam method to obtain ram value
    int getRam() {

        return this.ram;
    }

    // gstRam method to store ram value
    void setRam(int gbRam) {

        this.ram = gbRam;
    }

    // obtain value of ssd
    boolean getSsd() {

        return this.ssd;
    }

    // store value of ssd
    void setSsd(boolean hasSSD) {
        this.ssd = hasSSD;
    }

    // obtain value of storage
    int getStorage() {

        return this.storage;
    }

    // store value of storage
    void setStorage(int gbStorage) {

        this.storage = gbStorage;
    }


    // Electronics constructor with parameters double CPU, int gbRam, boolean hasSSD, and int gbStorage
    // inherits from Products class, thus Products constructor is inherited
    Electronics(double pPrice, int pStockQuantity, double CPU, int gbRam, boolean hasSSD, int gbStorage) {
        super(pPrice, pStockQuantity);
        setCpuSpeed(CPU);
        setRam(gbRam);
        setSsd(hasSSD);
        setStorage(gbStorage);
    }

    // return string of electronics added to the product description that can be obtained using getPrdDsc method
    public String getElcDsc() {

        // obtain description of product string
        String desc = getPrdDsc();

        // if SSD is true, print with ssd
        if (ssd) {
            return "PC with " + this.cpuSpeed + "ghz CPU, " + this.ram + "GB RAM, " + storage + " SSD drive " + desc ;

            // if ssd is false, print with hdd
        } else {
            return "PC with " + this.cpuSpeed + "ghz CPU, " + this.ram + "GB RAM, " + storage + " HDD drive " + desc;
        }
    }
}

