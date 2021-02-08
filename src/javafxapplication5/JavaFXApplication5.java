package javafxapplication5;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXApplication5 extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("TravelWarrantManager.fxml"));

            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setTitle("TravelWarrantManager");
            stage.show();
            stage.setOnCloseRequest((event) -> {System.exit(0);
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
