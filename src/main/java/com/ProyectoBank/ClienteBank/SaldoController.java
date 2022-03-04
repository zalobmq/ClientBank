package com.ProyectoBank.ClienteBank;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SaldoController {
	
	@FXML
	private Label Lid;
	
	@FXML
	private Label Saldo;
	

	@FXML
	protected void initialize() {
		Saldo.setText(ModeloController.cuenta.getSaldo()+"");
		Lid.setText(ModeloController.usuario.getId_card());
	}

}
