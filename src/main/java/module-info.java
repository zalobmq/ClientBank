module com.ProyectoBank.ClienteBank {
    requires javafx.controls;
    requires javafx.fxml;
	requires jdk.jdi;
	requires java.sql;
	requires jakarta.xml.bind;

    opens com.ProyectoBank.ClienteBank to javafx.fxml;
    exports com.ProyectoBank.ClienteBank;
}
