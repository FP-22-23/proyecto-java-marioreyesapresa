package fp.starbucks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.Genero;
import fp.common.Ocupacion;



/**
 * @author marreyapr
 *
 */ 

public class FactoriaStarbucks {
	
	/**
	 * @param rutaFichero Nombre del fichero con datos de starbucks.
	 * Devuelve una LISTA de objetos de tipo Starbucks con los datos del fichero.
	 */
	 public static List<Starbucks> leeListaStarbucks(String rutaFichero){
		 
		 // 1. Crear una List<Starbucks> vacía para añadir los datos
		List<Starbucks> res=new ArrayList<Starbucks>();
		
		try {
			// 2. Leer los datos y guardarlos en una List<Starbucks>
			
			List<String> lineas = Files.readAllLines(Paths.get(rutaFichero));
			
			for(String linea:lineas.subList(1, lineas.size())) {
				
				res.add(parsearStarbucks(linea));
				
			}
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		return res;
	 }
	




	/**
	 * @param rutaFichero Nombre del fichero con datos de starbucks.
	 * Devuelve un OBJETO de tipo Starbucks con los datos del fichero.
	 */
	public static ListaStarbucks leerStarbucks(String rutaFichero) {
		ListaStarbucks res=null;
		try {
			List<Starbucks> lineas=
					Files.lines(Paths.get(rutaFichero))
					.skip(1)
					.map(FactoriaStarbucks::parsearStarbucks)
					.collect(Collectors.toList());
			res = new ListaStarbucks(lineas);
		}catch(IOException e) {
			System.out.println("No se ha encontrado el fichero" + rutaFichero);
			e.printStackTrace();
		}
		return res;

	}
	
	
	
private static Starbucks parsearStarbucks(String linea) {
		String[] trozos=linea.split(";");
		if(trozos.length!=10) {
		throw new IllegalArgumentException("Formato: LocalDateTime fechaHora,Genero genero,Integer edad,Ocupacion ocupacion,String servicio,Integer duracion,Double valoracion,List<String> pedido,String conocidoPor,Boolean satisfecho,Integer idCliente");
		}
		LocalDateTime fechaHora = LocalDateTime.parse(trozos[0].trim(),
				DateTimeFormatter.ofPattern("d/MM/yy HH:mm")) ;
		Genero genero= Genero.valueOf(trozos[1].trim().toUpperCase());
		Integer edad=Integer.valueOf(trozos[2].trim());
		Ocupacion ocupacion= Ocupacion.valueOf(trozos[3].trim().toUpperCase());
		String servicio=trozos[4].trim(); 
		Integer duracion=Integer.valueOf(trozos[5].trim());
		Double valoracion=Double.valueOf(trozos[6].trim());
		List<String> pedido = parseaPedidos(trozos[7].trim()); 
		Boolean satisfecho= parseaBooleano(trozos[8].trim());
		Integer idCliente=Integer.valueOf(trozos[9].trim());

		return new Starbucks( fechaHora, genero, edad, ocupacion, servicio, duracion, valoracion,pedido, satisfecho, idCliente);
	}
	
	private static List<String> parseaPedidos(String s) {
		String[] linea = s.trim().split(",");
		List<String> res = new ArrayList<>();
		for (String st : linea) {
			res.add(st);
		}
		return res;
			
	}


	private static Boolean parseaBooleano(String cadena) {
		Boolean res = null;
		if (cadena.equals("Yes")) {
			res = true;
		}else {
			res = false;
		}
		return res;
	}
	
	
//ENTREGA 3
	// método que recibe como parámetro una cadena que contiene el nombre y 
		//ruta del fichero CSV, y devuelve un objeto del tipo contenedor creado mediante el constructor anterior.
		
		/**
		 * @param rutaFichero Nombre del fichero con datos starbucks
		 * devuelve un OBJETO del tipo contenedor creado mediante el constructor 
		 */
		public static ListaStarbucks leerStarbucks2(String rutaFichero) {
			ListaStarbucks res = null;
			try {
				// 1. Leer los datos y guardarlos en un Stream<Starbucks>
				Stream<Starbucks> s =
						Files.lines(Paths.get(rutaFichero))
						.skip(1)
						.map(FactoriaStarbucks::parsearStarbucks);
				// 2. Crear un objeto de tipo Starbucks mediante el constructor a partir de Stream<Starbucks>
				res = new ListaStarbucks(s);
			} 
			catch(IOException e) {
				System.out.println("No se ha encontrado el fichero." + rutaFichero);
			}
			
			return res;
		}
	
	
	
	
}
