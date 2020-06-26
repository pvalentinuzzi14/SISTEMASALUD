package Archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;

public class Utiles {
	
	public Utiles() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void grabarJSON(JSONObject object,String ruta)  //PARA GUARDAR UN ARCHIVO EN FORMATO JSONObject
	{			
		try {
			FileWriter file = new FileWriter(ruta);  ///ACA DEFINIS LA RUTA DONDE GUARDAS EL ARCHIVO
			file.write(object.toString()); //EL OBJETO DDEL PARAMETRO SE GRABA EN EL FILE
			file.flush(); 
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String leerJSON(String ruta) throws JSONException
	{
		String contenido="";
		try {
			contenido = new String(Files.readAllBytes(Paths.get(ruta))); ///PASA TODOS LOS BYTES DE LA RUTA DEL ARCHIVO JSON A UN STRING
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contenido;
		
	}
}
