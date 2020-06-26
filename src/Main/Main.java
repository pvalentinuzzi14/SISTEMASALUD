package Main;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Archivos.Binarios;
import Archivos.Utiles;
import Excpetions.AlertaException;
import Excpetions.ReactivosException;
import clases.Persona;
import clases.SSM;

public class Main {

	public static void main(String[] args)  {
		SSM servicioSalud = new SSM(4);
		
		System.out.println(servicioSalud.getCantidadTest());
		Binarios archivos = new Binarios();
		Utiles json = new Utiles();
		Scanner scan = new Scanner(System.in);
		String opcion = "x";
		
		Persona persona1 = new Persona("Carlos Gutierrez", 25, "La Perla", "30258369", "Abogado");
		//Persona persona10 = new Persona("Juan Perez", 25, "Centro", "39762762", "Arquitecto");
		Persona persona2 = new Persona("Juan Perez", 25, "Centro", "39762762", "Arquitecto");
		Persona persona3 = new Persona("Jose Sosa", 25, "Constitucion", "21871389", "Grafico");
		Persona persona4 = new Persona("Lucia Valverde", 25, "Varese", "23555666", "Profesor");
		Persona persona5 = new Persona("Pilar Pidre", 25, "Guemes", "25689954", "Contador");
		Persona persona6 = new Persona("Delfina Lion", 25, "La Florida", "44336432", "Ingeniero");

		servicioSalud.setListado(persona1);
		//servicioSalud.setListado(persona10);

		servicioSalud.setListado(persona2);
		servicioSalud.setListado(persona3);
		servicioSalud.setListado(persona4);
		servicioSalud.setListado(persona5);
		servicioSalud.setListado(persona6);
		
		System.out.println("REGISTRO DE PERSONAS");
		System.out.println(servicioSalud.getListado().toString());
		
		servicioSalud.BucleAsignamiento(scan,0);
		System.out.println("listado size"+servicioSalud.getListado().size());
		servicioSalud.BucleTesteos();
		
		try {
			servicioSalud.buscarCasos();
		} catch (AlertaException e) {
			// TODO Auto-generated catch block
			archivos.agregarArchivo(e);
		}
		
		JSONArray sanos = new JSONArray();
		JSONArray aislados = new JSONArray();

		int x=0;
		while((x<servicioSalud.getListado().size()))
		{
			if(servicioSalud.getListado().get(x).getTemperatura()<38)
			{
				sanos.put(servicioSalud.getListado().get(x).toJSON());
			}
			else
			{
				JSONObject aux = new JSONObject();
				try {
					aux.put("kit",servicioSalud.getListado().get(x).getKit().getNumeroKit());
					aux.put("temperatura",servicioSalud.getListado().get(x).getTemperatura());
					aux.put("barrio",servicioSalud.getListado().get(x).getBarrio());
					aislados.put(aux);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			x++;
		}
		
		JSONObject objetoSanos = new JSONObject();
		JSONObject objetoAislados = new JSONObject();

		try {
			objetoSanos.put("sanos",sanos);
			objetoAislados.put("aislar", aislados);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(objetoSanos.toString());
		System.out.println(objetoAislados.toString());
		
		json.grabarJSON(objetoSanos,"sanos.json");
		
		
		
		
		
		
		

		
		
		System.out.println("REGISTRO DE CASOS POSIBLES");
		System.out.println(servicioSalud.getRegistros().toString());
	

	}

}
