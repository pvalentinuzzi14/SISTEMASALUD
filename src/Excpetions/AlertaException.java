package Excpetions;

import clases.EntryRegistro;
import clases.Persona;

public class AlertaException extends Exception {
private EntryRegistro p;
private int clave;
	
	public AlertaException(String msg,EntryRegistro P,int K) {
		super(msg);
		this.p=P;
		clave=K;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage() + "Numero de test: " + clave + " Barrio: "+p.getBarrio();
	}
	
}
