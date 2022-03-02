package modelos;

import java.time.LocalDate;

public class Transaccion {

	protected int id;
	protected float importe;
	protected boolean tipo;
	protected LocalDate fecha;
	protected Cuenta id_cuenta;

	public Transaccion() {
		super();
	}

	public Transaccion(int id, float importe, boolean tipo, LocalDate fecha) {
		super();
		this.id = id;
		this.importe = importe;
		this.tipo = tipo;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	

	public Cuenta getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Cuenta id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaccion other = (Transaccion) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", importe=" + importe + ", tipo=" + tipo + ", fecha=" + fecha + ", id_cuenta="
				+ id_cuenta + "]";
	}

	

}
