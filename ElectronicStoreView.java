// danna liu
// 101140823

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import java.text.NumberFormat;
import java.util.ArrayList;

public class ElectronicStoreView extends Pane{

    private Button resetStore;

    private TextField salesNumText;

    private TextField revenueText;

    private TextField saleText;

    private ListView <Product> popular;

    private Label cart;

    private ListView <Product> stockList;
    private ListView <Product> currentCart;

    private Button add;
    private Button remove;
    private Button complete;

    ElectronicStore model;

    ArrayList <Product> prodsInCart = new ArrayList();

    int numOfSales = 0;
    double totalRevenue = 0.00;
    double avgSale = 0.00;
    double totalValueInCart = 0.00;
    NumberFormat nf = NumberFormat.getNumberInstance();


    // ElectronicStoreView constructor

    public ElectronicStoreView(ElectronicStore initModel) {
        FlowPane mainPane;
        Pane col1;
        Pane col2;
        Pane col3;
        Label storeSummary, salesNum, revenue, sale, pop, stock;

        // stack the three columns in Flow pane mainPane
        mainPane = new FlowPane();

        // set orientation to vertical ; allows the layout of columns

        mainPane.setOrientation(Orientation.VERTICAL);

        col1 = new Pane();
        col2 = new Pane();
        col3 = new Pane();

        // split columns in window

        col1.setMaxSize(200, 400);

        col2.setMaxSize(300, 400);

        col3.setMaxSize(300, 400);


        // First Column Set Up

        // Store summary label
        storeSummary = new Label("Store Summary");
        storeSummary.setStyle("-fx-font: 10 arial");
        storeSummary.relocate(90, 25);


        // # Sales label
        salesNum = new Label("# Sales:");
        salesNum.setStyle("-fx-font: 10 arial");
        salesNum.setAlignment(Pos.CENTER_RIGHT);
        salesNum.relocate(40, 50);

        // # Sales text box
        salesNumText = new TextField();
        salesNumText.setMaxSize(100, 5);
        salesNumText.relocate(80, 50);
        salesNumText.setStyle("-fx-font-alignment: center; -fx-font: 10 arial");

        // revenue label
        revenue = new Label("Revenue: ");
        revenue.setStyle("-fx-font: 10 arial");
        revenue.relocate(35, 75);

        // revenue text box
        revenueText = new TextField();
        revenueText.setMaxSize(100, 5);
        revenueText.relocate(80, 75);
        revenueText.setStyle("-fx-font-alignment: center; -fx-font: 10 arial");

        // $/Sale label
        sale = new Label("$/Sale:");
        sale.setStyle(" -fx-font: 10 arial");
        sale.relocate(45, 100);

        // $/Sale text box

        saleText = new TextField();
        saleText.setMaxSize(100, 5);
        saleText.relocate(80, 100);
        saleText.setStyle("-fx-font-alignment: center; -fx-font: 10 arial");

        // popular items label
        pop = new Label("Most Popular Items:");
        pop.setStyle("-fx-font-alignment: center; -fx-font: 10 arial");
        pop.relocate(85, 130);


        // popular items list view

        popular = new ListView();
        popular.relocate(20, 145);
        popular.setMaxSize(200, 150);
        popular.setStyle("-fx-font-alignment: center; -fx-font: 10 arial");


        // reset store button
        resetStore = new Button("Reset Store");
        resetStore.setAlignment(Pos.CENTER);
        resetStore.setDisable(false);
        resetStore.setWrapText(true);
        resetStore.setStyle("-fx-font: 10 arial");
        resetStore.relocate(80, 350);


        col1.getChildren().addAll(storeSummary, salesNum, salesNumText, revenue, revenueText, sale, saleText, pop, popular, resetStore);

        // Second Column Set Up

        // StoreStock label
        stock = new Label("Store Stock:");
        stock.setStyle("-fx-font: 10 arial");
        stock.relocate(125, 25);

        // stock list
        stockList = new ListView();
        stockList.relocate(40, 50);
        stockList.setMaxSize(250, 245);
        stockList.setStyle("-fx-font-alignment: center; -fx-font: 10 arial");

        // add to cart button

        add = new Button("Add to Cart");
        add.setAlignment(Pos.CENTER);
        add.setDisable(false);
        add.setWrapText(true);
        add.setStyle("-fx-font: 10 arial");
        add.relocate(125, 350);

        col2.getChildren().addAll(stock, stockList, add);



        // Third Column Set Up

        // CurrentCart label
        cart = new Label("Current Cart:");
        cart.setStyle("-fx-font: 10 arial");
        cart.relocate(120, 25);

        // stock list
        currentCart = new ListView();
        currentCart.relocate(30, 50);
        currentCart.setMaxSize(250, 245);
        currentCart.setStyle("-fx-font-alignment: center; -fx-font: 10 arial");


        // remove from cart button
        remove = new Button("Remove from Cart");
        remove.setAlignment(Pos.CENTER);
        // set button disabled as initial view
        remove.setDisable(false);
        remove.setWrapText(true);
        remove.setStyle("-fx-font: 10 arial");
        remove.relocate(65, 350);

        //complete sale button
        complete = new Button("Complete Sale");
        complete.setAlignment(Pos.CENTER);
        complete.setDisable(false);
        complete.setWrapText(true);
        complete.setStyle("-fx-font: 10 arial");
        complete.relocate(165, 350);


        col3.getChildren().addAll(cart, currentCart, remove, complete);


        // Main Pane Set Up
        mainPane.getChildren().addAll(col1, col2, col3);

        getChildren().add(mainPane);

        reset(initModel);

    }

    // getter methods for all private variables

    public Button getResetStore(){
        return resetStore;
    }

    public Button getAdd(){
        return add;
    }

    public Button getRemove(){
        return remove;
    }

    public Button getComplete(){
        return complete;
    }


    public TextField getRevenueText() {
        return revenueText;
    }

    public TextField getSalesNumText(){
        return salesNumText;
    }

    public TextField getSaleText(){
        return saleText;
    }

    public ListView getPopular(){
        return popular;
    }


    public ListView <Product> getStockList(){
        return stockList;
    }

    public ListView <Product> getCurrentCart(){
        return currentCart;
    }

    // initial display of the electronic store app view
    public void initDisplay() {
        resetStore.setDisable(false);
        add.setDisable(true);
        remove.setDisable(true);
        complete.setDisable(true);
        salesNumText.setText(String.valueOf(numOfSales));
        revenueText.setText(String.valueOf(totalRevenue));
        saleText.setText("n/a");

        // populate listView stock list
        refreshStockList();

        // most popular items listView
        ObservableList<Product> pops = FXCollections.observableArrayList(model.getInitPopItems());
        popular.setItems(pops);

    }

    // method to move selected item to cart
    public void moveToCart(){

        // get index of the selected item from user selection
        int selection = stockList.getSelectionModel().getSelectedIndex();

        // if selection does not exist, the add to cart button is still disabled
        if (selection == -1){
            add.setDisable(true);
        }

        else{
            // if the selection exists , use getSelectedItem method to get the item selected by user
            Product selectedProd = stockList.getSelectionModel().getSelectedItem();

            // add the selected item to the cart
            prodsInCart.add(selectedProd);

            // total value of cart is equal to total value of the cart plus the selected product's price
            totalValueInCart += selectedProd.getPrice();

            // set the digits of numbers to 2 because that's the standard
            nf.setMaximumFractionDigits(2);

            // set the label current cart with the value in cart
            cart.setText("Current Cart ($"+ nf.format(totalValueInCart) + ") :");

            // set items in the current cart list view to prodsInCart
            currentCart.setItems(FXCollections.observableArrayList(prodsInCart));

            remove.setDisable(false);
            complete.setDisable(false);

            // all products in cart should decrease everytime it is added to cart
            selectedProd.setStockQuantity(selectedProd.getStockQuantity() - 1);

            // refresh stock list
            refreshStockList();

        }

    }

    public void moveFromCart(){

        // get selected index of item selected in cart
        int selection = currentCart.getSelectionModel().getSelectedIndex();

        // if no item is selected, remove item button is disabled
        if (selection == -1){
            remove.setDisable(true);
        }

        // else remove from cart and add 1 to stock of selected item
        else{

            // get selected product
            Product selectedProd = prodsInCart.get(selection);

            // remove selection from from prodsInCart
            prodsInCart.remove(selection);

            // subtract price of selected product from total value in cart
            totalValueInCart -= selectedProd.getPrice();

            // format number to 2 digits
            nf.setMaximumFractionDigits(2);

            // reset text of cart label
            cart.setText("Current Cart ($"+ nf.format(totalValueInCart) + ") :");

            // remove selected item from current cart (the official cart)
            currentCart.getItems().remove(selection);

            // if there are no items in currentCart list, disable remove item and complete sale buttons
            if (currentCart.getItems().size() == 0) {
                remove.setDisable(true);
                complete.setDisable(true);
            }

            // the stock of removed product will be +1 as it is going back in stock
            selectedProd.setStockQuantity(selectedProd.getStockQuantity() + 1);

            refreshStockList();

        }

    }

    // complete sale method
    public void completeSale(){

        Product selectedProd;

        // items in cart are sold
        // for every item in prodsInCart, add one to sold stock for the product

        for (Product product : prodsInCart) {
            selectedProd = product;
            selectedProd.setSoldQuantity(selectedProd.getSoldQuantity() + 1);
        }

        //Update the sales numbers

        // add one to the number of sales
        numOfSales ++;

        // total revenue is equal to total revenue plus the total value in the cart
        totalRevenue += totalValueInCart;

        // calculate average revenue per sale
        avgSale = totalRevenue / numOfSales;

        // processes electronicStore's private revenue variable
        model.setRevenue(model.getRevenue() + totalRevenue);

        //Clear shopping cart
        prodsInCart.clear();
        totalValueInCart = 0.00;
        currentCart.getItems().clear();

        remove.setDisable(true);
        complete.setDisable(true);

        //Refresh stock list
        stockList.refresh();

        //Update text fields in view
        nf.setMaximumFractionDigits(2);
        salesNumText.setText(String.valueOf(numOfSales));
        revenueText.setText(nf.format(totalRevenue));
        saleText.setText(nf.format(avgSale));
        cart.setText("Current Cart ($" + nf.format(totalValueInCart) + ") :");

        //Update the most popular items by what has been sold
        popular.setItems(FXCollections.observableArrayList(model.getPopItemsBySold()));

    }

    public void refreshStockList() {

        // updates stock list in view
        // this ensures that there is the correct number of stock available for purchase to add to cart (between adding to cart and removing)

        ObservableList <Product> stocks = FXCollections.observableArrayList(model.getProducts());
        //Remove null objects
        while (stocks.remove(null));

        stockList.setItems(stocks);

        //Remove products that have 0 stock from view
        for (int i = stocks.size() - 1; i >= 0; i--) {
            if (stocks.get(i).getStockQuantity() == 0) {
                stockList.getItems().remove(i);
            }
        }

    }

    // reset the view to initial state
    public void reset(ElectronicStore resetModel) {
        model = resetModel;

        stockList.getItems().clear();
        prodsInCart.clear();
        numOfSales = 0;
        totalValueInCart = 0.00;
        totalRevenue = 0.00;

        currentCart.getItems().clear();

    }



}