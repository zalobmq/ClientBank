package ConexionSocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import com.ProyectoBank.ClienteBank.App;
import com.ProyectoBank.ClienteBank.ModeloController;

import javafx.scene.control.Dialog;
import javafx.stage.Stage;
import modelos.Admin;
import modelos.Cuenta;
import modelos.Usuario;
import paquetes.PaqueteEnv;

public class Connection {

	public static void main(String[] args) {
		Connection.connectToServer();
		Admin a = new Admin(23, 24);
		try {
			Connection.sendDataToServer(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Connection.readServerInputs(server);
	}

	private static Socket server;

	public static void connectToServer() {
		try {
			server = new Socket("localhost", 1995);
			readServerInputs(server);
		} catch (IOException e) {
			System.out.println("Error, Conexión rechazada, Revise que el servidor está online");
		}
	}

	public static void readServerInputs(Socket server2) {
		new Thread(() -> {
			System.out.println("Cliente");
			try {
				while (true) {
					listenToServerActions(server2);
				}

			} catch (Exception e) {

				closeServer(server2, true);
			}

		}).start();

	}

	private static void listenToServerActions(Socket server2) {
		try {
			ObjectInputStream dataInputStream = new ObjectInputStream(server2.getInputStream());
			try {

				PaqueteEnv objeto = (PaqueteEnv) dataInputStream.readObject();
				Usuario nuevoUsuario;
				Cuenta nuevaCuenta;
				switch (objeto.getOpcion()) {
				case 3:
					if (objeto.isComprobante()) {
						nuevoUsuario = (Usuario) objeto.getObjeto1();
						ModeloController.usuario = nuevoUsuario;
						nuevaCuenta = (Cuenta) objeto.getObjeto2();
						ModeloController.cuenta = nuevaCuenta;										
						try {
							App.loadScene(new Stage(), "VentanaPrincipal", "Login de la app");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					break;

				case 4:
					if (objeto.isComprobante()) {
						nuevoUsuario = (Usuario) objeto.getObjeto1();
						nuevaCuenta = (Cuenta) objeto.getObjeto2();

						ModeloController.usuario = nuevoUsuario;
						ModeloController.cuenta=nuevaCuenta;

						try {
							App.loadScene(new Stage(), "VentanaPrincipal", "Login de la app");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Socket getConnectionToServer() {
		return server;
	}

	public static void sendDataToServer(Object o) throws IOException {
		if (server != null && !server.isClosed()) {
			ObjectOutputStream objectOutputStream = null;
			try {
				objectOutputStream = new ObjectOutputStream(server.getOutputStream());
				objectOutputStream.writeObject(o);
				objectOutputStream.flush();
			} catch (EOFException e) {
				if (objectOutputStream != null)
					objectOutputStream.close();
				throw new SocketException("El servidor me ha desconectado");
			}
		}
	}

	private static void closeServer(Socket server, boolean isFromException) {
		try {
			server.getOutputStream().close();
			server.close();
		} catch (IOException e) {

		}
	}

}
