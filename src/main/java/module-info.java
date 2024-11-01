module org.example.databaselocalizationdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.databaselocalizationdemo to javafx.fxml;
    exports org.example.databaselocalizationdemo;
}