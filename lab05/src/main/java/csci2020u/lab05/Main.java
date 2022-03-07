package csci2020u.lab05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        primaryStage.setTitle("Lab 05 Solutions");
        primaryStage.setScene(new Scene(root, 465, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
