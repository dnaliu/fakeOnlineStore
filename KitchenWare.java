public class KitchenWare extends Product {

    // subclass or child of product class
    private int wattage;
    private String color;
    private String brand;


    // get wattage method to obtain wattage value
    public int getWattage() {
        return wattage;
    }

    // set wattage method to store wattage value
    public void setWattage(int watts) {
        this.wattage = watts;
    }

    // get color method to obtain color value
    public String getColor() {
        return color;
    }

    // set color method to store color value
    void setColor(String kColor) {
        this.color = kColor;
    }

    // get brand method to obtain brand value
    String getBrand() {
        return brand;
    }

    //set brand method to store brand value
    void setBrand(String kBrand) {
        this.brand = kBrand;

    }


    // kitchenware constructor with parameters int watts, string kColor, String kBrand
    // kitchenware constructor also inherits from product class, so it inherits product class constructor

    KitchenWare(double pPrice, int pStockQuantity, int watts, String kColor, String kBrand) {
        super(pPrice, pStockQuantity);
        setWattage(watts);
        setColor(kColor);
        setBrand(kBrand);
    }
}