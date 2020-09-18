public class Fridge extends KitchenWare {

    private double cubicFeet;
    boolean hasFreezer;

    // fridge class inherits from kitchenware class, which inherits from product class

    // fridge constructor with parameters double cb and boolean freezer
    // the other parameters are inherited
    Fridge(double productPrice, int productStockQuantity, int watts, String kColor, String kBrand, double cb, boolean freezer) {
        super(productPrice, productStockQuantity, watts, kColor, kBrand);
        this.cubicFeet = cb;
        this.hasFreezer = freezer;
    }

    // return string
    // also using description from product
    public String toString() {
        // return string is first the value of what is obtained from getPrdDsc
        // add the rest of the description of fridge
        String returnString = getPrdDsc();
        int watts = getWattage();
        String color = getColor();
        String brand = getBrand();

        // if freezer has value of true, return the following
        if (hasFreezer) {
            return this.cubicFeet + " cu. ft. " + brand + " Fridge with freezer (" + color + ", " + watts + " watts) " + returnString;
        }

        // freezer has value of false, return the following
        else {
            return this.cubicFeet + " cu. ft. " + brand + " Fridge (" + color + ", " + watts + " watts) " + returnString;
        }
    }
}