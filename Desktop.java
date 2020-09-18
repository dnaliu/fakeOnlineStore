public class Desktop extends Electronics {

    private String profile;

    // desktop class inherits from electronics class, also from product class

    // desktop constructor with parameters from Product constructor and Electronics constructor
    Desktop(double pPrice, int pStockQuantity, double CPU, int gbRam, boolean hasSSD, int gbStorage, String dkProfile) {
        super(pPrice, pStockQuantity, CPU, gbRam, hasSSD, gbStorage);
        this.profile = dkProfile;
    }


    // return string with desktop description
    public String toString() {
        String returnString = getElcDsc();

        return this.profile + " Desktop " + returnString;
    }

}