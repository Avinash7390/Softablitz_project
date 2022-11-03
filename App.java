

package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader(App.class.getResource("../view/view1.fxml"));
        Scene scene=new Scene(loader.load(),300,400);
        stage.setScene(scene);
        stage.setTitle("basic calculator");
        stage.show();
    }
//
//    public static void main(String[] args) {
//
//        launch(args);
//    }

}
