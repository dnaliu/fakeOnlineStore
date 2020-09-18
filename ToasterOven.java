public class ToasterOven extends KitchenWare{

    private int width;
    private boolean convection;

    // ToasterOven class inherits from kitchenware, thus also from Product class

    // Toaster oven constructor
    // holds parameters from kitchenWare constructor as well as Product constructor , also has parameters int toWidth and boolean hasConvection

    ToasterOven(double productPrice, int productStockQuantity, int watts, String kColor, String kBrand, int toWidth, boolean hasConvection) {
        super(productPrice, productStockQuantity, watts, kColor, kBrand);
        this.width = toWidth;
        this.convection = hasConvection;
    }

    // return string for toaster oven description

    public String toString() {

        // use product description first
        String returnString = getPrdDsc();
        int watts = getWattage();
        String color = getColor();
        String brand = getBrand();

        // if convection value is true
        if (convection) {

            return this.width + " inch " + brand + " Toaster " + "with convention (" + color + ", " + watts + ") " + returnString;
        }

        // if convection value is false
        else {
            return this.width + " inch " + brand + " Toaster (" + color + ", " + watts + ") " + returnString;
        }
    }
}