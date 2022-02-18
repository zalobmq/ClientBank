module com.ProyectoBank.ClienteBank {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ProyectoBank.ClienteBank to javafx.fxml;
    exports com.ProyectoBank.ClienteBank;
}
