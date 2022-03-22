package csci2020u.lab08;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        primaryStage.setTitle("Lab 08");
        primaryStage.setScene(new Scene(root, 700, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
