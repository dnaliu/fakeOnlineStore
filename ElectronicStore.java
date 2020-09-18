import java.util.Scanner;

public class ElectronicStore {

    private final int MAX_PRODUCTS = 10;
    private String name;
    private double revenue;
    private Product[] products = new Product[MAX_PRODUCTS];
    Scanner input = new Scanner(System.in);

    private Product[] popItems = new Product[3];

    // create array to get initial 3 most popular items
    // append the products from index 0, 1, 2

    public Product[] getInitPopItems(){
        for (int i = 0; i < 3; i++){
            popItems[i] = products[i];
        }
        return popItems;
    }

    // check if chkVal is in the array
    private static boolean chkInArray(int[] arr, int chkVal) {
        for (int e : arr) {
            if (e == chkVal) {
                return true;
            }
        }

        return false;
    }


    // method to find most popular items
    public Product[] getPopItemsBySold() {
        int maxSold;
        int prodSold;
        int maxIndex;

        // non existing values for popular items index
        int[] popIndex = new int[] {-1,-1,-1};


        // run loop 3 times to populate popular items list with the top 3 popular items
        for (int i=0; i<3; i++) {

            //Reset variable in every loop
            maxSold = -1;
            maxIndex = -1;

            for (int j = 0; j < MAX_PRODUCTS; j++) {
                //If not null and not already in the pop list
                if (products[j] != null && ! chkInArray(popIndex, j)) {

                    // get sold quantity of products in the loop
                    prodSold = products[j].getSoldQuantity();

                    // if sold quantity is greater than max, then that sold quantity is equivalent to the max sold
                    if (prodSold > maxSold) {
                        maxSold = prodSold;
                        maxIndex = j;
                    }
                }
            }

            // popular item is set
            popItems[i] = products[maxIndex];
            popIndex[i] = maxIndex;

        }
        return popItems;
    }

    // ElectronicStore constructor with parameter String storeName
    ElectronicStore(String storeName) {
        this.name = storeName;

    }

    // get name method to obtain value of name
    String getName() {
        return name;
    }

    //get products list

    public Product[] getProducts(){
        return products;
    }

    // addProduct method returns a boolean value of true or false

    boolean addProduct(Product p) {
        int i;

        // the first available index to add a product to into the array
        int firstAvail = -1;

        // for loop to find first available index to append new product to array
        // the loop starts at index 0 and finishes before it reaches the value of MAX_PRODUCTS which is 10

        for (i = 0; i < MAX_PRODUCTS; i++) {

            // if products at the index is null, then it is the first available index to add a product to
            // break if the index is available and null
            if (products[i] == null) {
                firstAvail = i;
                break;
            }
        }
        // if firstAvail has still a value of -1, there is no available space to append
        // there is no null value for any of the 10 products in the array
        // all the spaces in the array are filled with a product
        if (firstAvail == -1) {
            // return false if you cannot add a product
            return false;

        } else {
            // add product at index of firstAvail
            products[firstAvail] = p;

            // return true when product can be added and is added to array of products
            return true;
        }
    }

    // sell products method
    void sellProducts() {
        int item, amount;
        printStock();
        int l = products.length;

        // reads user input of what they would like to purchase
        System.out.println("Which item would you like to purchase. Please enter the item number code.");
        item = input.nextInt();

        // check if item exists
        if (item <= l) {

            // if item exists, proceed to ask how many units the user would like to purchase
            System.out.println("How many of this product would you like to purchase?");
            amount = input.nextInt();

            // call sell products method below (different parameters)
            sellProducts(item, amount);

            // if item does not exist then, output is that there input is invalid
        } else {
            System.out.println("That is an invalid item. This item does not exist");
        }

    }

    // set revenue to store the total store revenue
    void setRevenue(double tR){
        this.revenue = tR;
    }

    // get revenue to obtain the total store revenue
    double getRevenue() {
        return revenue;
    }

    // sell products method with arguments int amount and int item
    void sellProducts(int item, int amount) {
        double transaction = 0.0;

        // item is also the index of array products
        // check if item to sell has a value of greater or equal to 0 (product exists)
        // check if the index is less than the index of max products (product exists)
        // ensure products[items] does not have a value of null (product exists)
        // the amount to purchase must be greater than 0 (purchase is possible)

        if (item >= 0 && item < MAX_PRODUCTS && products[item] != null && amount >=0 ) {
            // the transaction value is equivalent to the revenue for the product sold
            transaction = products[item].sellUnits(amount);

            // call set revenue, get revenue
            // use set revenue to store value of the revenue which is the current revenue + the new sales (transaction)
            setRevenue(getRevenue() + transaction);
        }
    }



    // print stock to user
    void printStock() {
        int i;
        int l = products.length;


        // for loop to print each product from array products
        // loop from 0 to the length of the array
        for (i = 0; i < l; i++) {
            // only print the product if it does not have a value of null (product exists in the index space)
            if (products[i] != null) {
                System.out.println(String.valueOf(i) + ". " + products[i].toString());
            }

        }
    }


    // Electronic Store Instance
    public static ElectronicStore createStore(){
        ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
        Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
        Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
        Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
        Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
        Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
        Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
        ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
        ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        return store1;
    }
}