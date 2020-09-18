public class Laptop extends Electronics{

    // laptop class inherits from electronics class (also inherits from product class)
    private double screenSize;

    // laptop constructor with parameter double screen
    // the other parameters inherited from electronics and product classes
    Laptop(double pPrice, int pStockQuantity, double CPU, int gbRam, boolean hasSSD, int gbStorage, double screen) {
        super(pPrice, pStockQuantity, CPU, gbRam, hasSSD, gbStorage);
        this.screenSize = screen;
    }

    // return string of description of laptop product
    public String toString() {
        String returnString = getElcDsc();
        return this.screenSize + " inch laptop " + returnString;
    }
}