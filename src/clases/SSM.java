package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import Archivos.Binarios;
import Archivos.Utiles;

import java.util.Scanner;
import java.util.Set;

import Excpetions.AlertaException;
import Excpetions.ReactivosException;

public class SSM {
	
	private int cantidadTest;
	private ArrayList<Persona> listado;
	private HashMap<Integer,EntryRegistro> registros;
	
	
	private static int numeroKit = 0;
	
	public SSM() {
		cantidadTest=0;
		listado=new ArrayList<Persona>();
		registros = new HashMap<Integer,EntryRegistro>();
	}


	public SSM(int cantidadTest) {
		this.cantidadTest = cantidadTest;
		listado=new ArrayList<Persona>();
		registros = new HashMap<Integer,EntryRegistro>();
	}


	public int getCantidadTest() {
		return cantidadTest;
	}


	public void setCantidadTest(int cantidadTest) {
		this.cantidadTest = cantidadTest;
	}


	public ArrayList<Persona> getListado() {
		return listado;
	}


	public void setListado(Persona p) {
		listado.add(p);
	}
	
	
	
	public HashMap<Integer, EntryRegistro> getRegistros() {
		return registros;
	}


	public void setRegistros(HashMap<Integer, EntryRegistro> registros) {
		this.registros = registros;
	}

	public int obtenerTemperatura()
	{
		int M = 36;
		int N=39;
		int valorEntero = (int) Math.floor(Math.random()*(N-M+1)+M);  // Valor entre M y N, ambos incluidos.
		 
		 return valorEntero;
	}
	
	public void asignarKit(Persona p) throws ReactivosException
	{
		if((controlarDni(p)==true))
		{
			throw new ReactivosException("Persona ya testeada", p);
			
		}
		if(numeroKit==getCantidadTest())
		{
			throw new ReactivosException("Cantidad de test superada", p);
		
		}else
		{
			numeroKit++;
			int numKit = numeroKit;
			KitReactivo kit = new KitReactivo(numKit);
			p.setKit(kit);
		}
	}
	
	
	public void BucleAsignamiento(Scanner scan,int inicio)
	{
		String opcion="x";
		try {
				
				while(inicio<getListado().size())
				{
					asignarKit(listado.get(inicio));
					inicio++;
				}
			} catch (ReactivosException e) {
				System.out.println(e.getMessage());
				System.out.println("Desea ingresar mas KITS REACTIVOS AL STOCK ? Ingrese S para confirmar, otro caracter para finalizar la entrega");
				opcion = scan.nextLine();
				if(opcion.equalsIgnoreCase("s"))
				{
					System.out.println("Ingrese la cantidad de nuevos reactivos: ");
					int nuevos = scan.nextInt();
					nuevos=nuevos+getCantidadTest();
					setCantidadTest(nuevos);
				}
				System.out.println("STOCK DE REACTIVOS RENOVADO.");
				BucleAsignamiento(scan,inicio);
			}
	}

	public void testear(Persona p)  
	{
		int temperatura = obtenerTemperatura();
		
		KitReactivo kit = p.getKit();
		p.setTemperatura(temperatura);
		registros.put(p.getKit().getNumeroKit(), new EntryRegistro(p.getDni(), p.getTemperatura(),p.getBarrio()));
		
		
	}
	
	public void BucleTesteos()
	{
		int i=0;
		
			while((i<listado.size())&&(listado.get(i).getKit().getNumeroKit()!=(-1)))
			{
				System.out.println("entra");
				testear(listado.get(i));
				i++;
			}
		}
			
	
	
	public void buscarCasos() throws AlertaException
	{
		Set<Entry<Integer,EntryRegistro>> set = registros.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext())
		{
			Entry<Integer,EntryRegistro> entry = (Entry<Integer,EntryRegistro>)it.next();
			EntryRegistro p = entry.getValue();
			
			if(p.getTemper()>37)
			{
				throw new AlertaException("ALERTA! POSIBLE CASO DETECTADO ->", p,entry.getKey());
			}
			
		}
		
		
		
	}
	
	
	public boolean controlarDni(Persona p)
	{
		boolean testeado = false;
		for(int i =0;i<listado.size();i++)
		{
			if(p.getDni().equals(listado.get(i)))
			{
				testeado=true;
			}
		}
		
		return testeado;
	}
	
	
	
}
