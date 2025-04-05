module com.example.cepjavafxapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.apache.httpcomponents.client5.httpclient5;
    requires org.apache.httpcomponents.core5.httpcore5;

    requires com.fasterxml.jackson.databind;
    requires java.desktop;

    opens com.example.cepjavafxapp to javafx.fxml, com.fasterxml.jackson.databind;
    exports com.example.cepjavafxapp;

    opens com.example.cepjavafxapp.ui to javafx.fxml, javafx.graphics;
    exports com.example.cepjavafxapp.ui;
}

