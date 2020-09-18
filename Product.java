public abstract class Product {

    // danna liu
    // 101140823

    //parent class

    private double price;
    private int stockQuantity;
    private int soldQuantity;

    //product constructor with parameters double price, int stock quantity
    Product(double pPrice, int pStockQuantity){
        this.price = pPrice;
        this.stockQuantity = pStockQuantity;

        // initialize and give soldQuantity variable a value of 0 to start
        this.soldQuantity = 0;
    }

    // get price method to obtain price
    double getPrice(){
        return this.price;
    }

    // set price method to store value of price
    void setPrice(double pPrice){
        this.price = pPrice;
    }

    // get stock quantity method to obtain stock value
    int getStockQuantity(){
        return this.stockQuantity;
    }

    // set stock quantity method to store stock value
    void setStockQuantity(int pStockQuantity){
        this.stockQuantity = pStockQuantity;
    }

    // get sold quantity method to obtain sold quantity value
    int getSoldQuantity(){
        return this.soldQuantity;
    }

    // set sold quantity method to store sold quantity
    void setSoldQuantity(int pSoldQuantity){
        this.soldQuantity = pSoldQuantity;
    }


    //sell units method
    public double sellUnits(int amount){

        int sellStock = getStockQuantity();
        double sellPrice = getPrice();
        double sellRevenue = 0.0;
        int sellSold = 0;
        // condition: if the stock is greater than amount, then it is possible to sell
        if (sellStock >= amount){

            // stock is equal to total stock - sold amount
            sellStock -= amount;

            // use setStockQuantity method to store new value of stock
            setStockQuantity(sellStock);

            // calculate revenue from sale
            sellRevenue = amount * sellPrice;

            //find new sold quantity of stock from store
            sellSold = getSoldQuantity() + amount;
            setSoldQuantity(sellSold);

        }

        // if there is no sale, revenue is 0
        else{
            sellRevenue = 0.0;
        }
        // return revenue made from sale
        return sellRevenue;
    }

    // return string of product description
    // description is only of the 3 variables from Product class

    public String getPrdDsc (){

        // prints stock in the store
        // return "(" + this.price + " dollars each, " + this.stockQuantity + " in stock, " + this.soldQuantity + " sold)";

        // return only the product
        return "";
    }
}