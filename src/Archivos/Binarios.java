package Archivos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Excpetions.AlertaException;

public class Binarios {
	public Binarios() {
		// TODO Auto-generated constructor stub
	}
	
	public void agregarArchivo(AlertaException e)
	{
		FileOutputStream file =  null;
		try
		{
			file=new FileOutputStream("urgente.dat");
			ObjectOutputStream object = new ObjectOutputStream(file);
			object.writeObject(e);
			object.close();
		}catch(IOException w)
		{
			w.printStackTrace();
		}
	}
}
