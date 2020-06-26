package Excpetions;

import clases.Persona;

public class ReactivosException extends Exception{
	private Persona p;
	
	public ReactivosException(String msg,Persona P) {
		super(msg);
		this.p=P;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "La persona con dni: " + p.getDni() +" no pudo ser testeada por "+super.getMessage();
	}

	public Persona getP() {
		return p;
	}

	public void setP(Persona p) {
		this.p = p;
	}
	
	

}
