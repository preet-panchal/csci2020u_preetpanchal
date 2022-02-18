package csci2020u.lab04;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.commons.validator.routines.EmailValidator;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application{
    @FXML private Label EmailError;
    @FXML private DatePicker DOB;
    @FXML private TextField UserName;
    @FXML private TextField FullName;
    @FXML private TextField Email;
    @FXML private TextField PhoneNumber;
    @FXML private PasswordField Password;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main.fxml")));

        //Setting the stage
        Scene scene = new Scene(root, 600, 300, Color.BEIGE);
        primaryStage.setTitle("Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void handleRegisterButtonAction(javafx.event.ActionEvent event) {
        System.out.println(UserName.getText());
        System.out.println(Password.getText());
        System.out.println(FullName.getText());
        EmailValidator validator = EmailValidator.getInstance();
        boolean valid = validator.isValid(Email.getText());
        if (valid) {
            System.out.println(Email.getText());
            EmailError.setText("");
        } else {
            EmailError.setText("Invalid E-Mail Address!");
            System.out.println("Invalid E-Mail Address!");
        }
        System.out.println(PhoneNumber.getText());
        System.out.println(DOB.getValue());
    }

    public static void main(String[]args){
        Application.launch(args);
    }
}
