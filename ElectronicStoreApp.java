import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ElectronicStoreApp extends Application {
    // set up model of electronic store
    ElectronicStore model =  ElectronicStore.createStore();
    ElectronicStoreView view = new ElectronicStoreView(model);

    public void start (Stage primaryStage){

        // initiate original display state
        view.initDisplay();

        //once mouse clicks and releases on an item in stockList, add button is enabled
        view.getStockList().setOnMouseReleased(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.getAdd().setDisable(false);
            }
        });

        // if add is clicked, call move to cart method
        // the method will move the item selected to cart and refresh the view, which also refreshes the stock
        view.getAdd().setOnAction(new EventHandler <ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                view.moveToCart();
            }
        });

        // if an item in cart is selected, remove button is enabled
        view.getCurrentCart().setOnMouseReleased(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.getRemove().setDisable(false);
            }
        });

        // if remove button is clicked, call move from cart method
        // this will remove selected item from cart and refresh the total stock of the items that were removed
        view.getRemove().setOnAction(new EventHandler <ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                view.moveFromCart();
            }
        });

        // if complete button is clicked, call completeSale method
        // this will update revenue, average revenue per sale, and number of sales, it should clear the current cart and update popular products list
        view.getComplete().setOnAction(new EventHandler <ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                view.completeSale();
            }
        });

        // if reset store button is clicked, call resetStore method which brings view to initial state
        view.getResetStore().setOnAction(new EventHandler <ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                resetStore();
            }
        });


        // set up for the window of ElectronicStoreApp
        primaryStage.setTitle(model.getName());

        // non resizable
        primaryStage.setResizable(false);

        // set dimension
        Scene scene = new Scene(view, 800, 400);

        primaryStage.setScene(scene);

        primaryStage.show();

    }


    public void resetStore() {
        model = ElectronicStore.createStore();
        view.reset(model);
        view.initDisplay();
    }

    // launch view
    public static void main(String[] args){
        launch(args);
    }

}



