package com.ProyectoBank.ClienteBank;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modeloPaqueteEnvio.PaqueteEnv;

public class PrincipalController {
	
	@FXML
	private Label LNombre;
	
	@FXML
	private Label LID;
	
	@FXML
	protected void initialize() {
		LNombre.setText(ModeloController.usuario.getNombre());
		LNombre.setText(ModeloController.usuario.getId_card());
		
	}
	
	@FXML
	private void VerSaldo() {
		try {		
    		App.closeScene((Stage) LNombre.getScene().getWindow());
			App.loadScene(new Stage(), "VerSaldo", "Saldo de la cuenta");				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	
	@FXML
	private void Insertar() {
		try {
    		App.closeScene((Stage) LNombre.getScene().getWindow());
			App.loadScene(new Stage(), "InserRetir", "Insertar y retirar en nuestra cuenta");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void Historial() {
		
		try {
    		App.closeScene((Stage) LNombre.getScene().getWindow());
			App.loadScene(new Stage(), "Historial", "Historial de transacciones");			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}
