module csci2020u {
    requires javafx.controls;
    requires javafx.fxml;


    opens csci2020u.lab11 to javafx.fxml;
    exports csci2020u.lab11;
}