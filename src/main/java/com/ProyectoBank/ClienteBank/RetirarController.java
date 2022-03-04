package com.ProyectoBank.ClienteBank;

import java.io.IOException;

import ConexionSocket.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RetirarController {
	
	@FXML
	private TextField importe;
	
	@FXML
	protected void initialize() {
		
	}
	
	public void ingresar() {
		float f = Float.parseFloat(importe.getText());
		
		//Object o = ModeloController.cuenta;

		paquetes.PaqueteEnv ingreso=new paquetes.PaqueteEnv(6, ModeloController.cuenta, false, f);
		try {
			Connection.sendDataToServer(ingreso);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void retirar() {
		
	}

}
