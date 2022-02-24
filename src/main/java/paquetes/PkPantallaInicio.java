package paquetes;

public class PkPantallaInicio {

	private int opcion;
	private String IdCard;
	private int pin;
	
	public PkPantallaInicio(int opcion, String idCard, int pin) {
		super();
		this.opcion = opcion;
		this.IdCard = idCard;
		this.pin = pin;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public String getIdCard() {
		return IdCard;
	}

	public void setIdCard(String idCard) {
		IdCard = idCard;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "PkPantallaInicio [opcion=" + opcion + ", IdCard=" + IdCard + ", pin=" + pin + "]";
	}
	
	
	
}
