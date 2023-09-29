module com.example.dlldeque {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.airport.dlldeque to javafx.fxml;
    exports com.airport.dlldeque;
}