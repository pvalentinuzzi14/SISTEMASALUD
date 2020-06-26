package clases;

import org.json.JSONException;
import org.json.JSONObject;

public class Persona {
	private String nombreYapellido;
	private int edad;
	private String barrio;
	private String dni;
	private String ocupacion;
	private int temperatura;
	private KitReactivo kit;
	
	public Persona() {
		this.nombreYapellido = "";
		this.edad = 0;
		this.barrio = "";
		this.dni = "";
		this.ocupacion = "";
		temperatura = 0;
		kit = new KitReactivo();
	}
	
	
	public Persona(String nombreYapellido, int edad, String barrio, String dni, String ocupacion) {
		super();
		this.nombreYapellido = nombreYapellido;
		this.edad = edad;
		this.barrio = barrio;
		this.dni = dni;
		this.ocupacion = ocupacion;
		temperatura = 0;
		kit = new KitReactivo();
	}
	public String getNombreYapellido() {
		return nombreYapellido;
	}
	public void setNombreYapellido(String nombreYapellido) {
		this.nombreYapellido = nombreYapellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	
	public int getTemperatura() {
		return temperatura;
	}


	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	
	public KitReactivo getKit() {
		return kit;
	}


	public void setKit(KitReactivo kit) {
		this.kit = kit;
	}


	@Override
	public String toString() {
		return "Persona =" + nombreYapellido + ", edad=" + edad + ", barrio=" + barrio + ", dni=" + dni
				+ ", ocupacion=" + ocupacion + "]";
	}


	@Override
	public int hashCode() {
		
		return 1;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona objet = (Persona) obj;
		if (this.dni.equals(objet.getDni()))
		{
			return true;
		}else
		{
			return false;
		}
			
	}
	
	
	public JSONObject toJSON() {
		JSONObject JSONob = new JSONObject();
		try {
			JSONob.put("nombre", getNombreYapellido());
			JSONob.put("edad", getEdad());
			JSONob.put("barrio", getBarrio());
			JSONob.put("dni", getDni());
			JSONob.put("ocupacion", getOcupacion());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return JSONob;
	}
	
	
	
}
