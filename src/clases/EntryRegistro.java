package clases;

import java.io.Serializable;

public class EntryRegistro implements Serializable {
	private String dni;
	private int temper;
	private String barrio;
	public EntryRegistro(String string, int temper,String barrio) {
		super();
		this.dni = string;
		this.temper = temper;
		this.barrio=barrio;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getTemper() {
		return temper;
	}
	public void setTemper(int temper) {
		this.temper = temper;
	}
	
	
	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	@Override
	public String toString() {
		return "EntryRegistro [dni=" + dni + ", temper=" + temper + "]";
	}
	
	
	
}
