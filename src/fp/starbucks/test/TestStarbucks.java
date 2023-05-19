package fp.starbucks.test;


import java.time.LocalDateTime;
import java.util.List;

import fp.starbucks.Starbucks;
import fp.common.Cliente;
import fp.common.Genero;
import fp.common.Ocupacion;

public class TestStarbucks {
	
	public static void mostrarStarbucks(Starbucks s) {
		System.out.println("fechaHora: " + s.getFechaHora());
		System.out.println("genero: " + s.getGenero());
		System.out.println("edad: " + s.getEdad());
		System.out.println("ocupacion: " + s.getOcupacion());
		System.out.println("servicio: " + s.getServicio());
		System.out.println("duracion: " + s.getDuracion());
		System.out.println("valoracion: " + s.getValoracion());
		System.out.println("pedido: " + s.getPedido());
		System.out.println("satisfecho: " + s.getSatisfecho());
		System.out.println("idCliente: " + s.getIdCliente());
		System.out.println(s);
	}
	
	
	//hago esto para poder capturar la excepcion y probar las restricciones del objeto 1
	public static void testConstructor1(LocalDateTime fechaHora, Genero genero, Integer edad, Ocupacion ocupacion, String servicio,
			Integer duracion, Double valoracion, List<String> pedido,  Boolean satisfecho, Integer idCliente) {
		
		try {
			Starbucks s = new Starbucks(fechaHora, genero, edad, ocupacion, servicio,
					 duracion,  valoracion, pedido,  satisfecho,  idCliente);	
			mostrarStarbucks(s);
		} catch(IllegalArgumentException e) {
			System.out.println("Excepción capturada:\n   " + e);	
		} catch (Exception e) {
			System.out.println("Excepci�n inesperada:\n   " + e);
		}

	}

	//hago esto para poder capturar la excepcion y probar las restricciones del objeto 2
	public static void testConstructor2(LocalDateTime fechaHora, String servicio,
			 Double valoracion, List<String> pedido,Integer idCliente) {
		
		try { 
			Starbucks s = new Starbucks(fechaHora, servicio,
					   valoracion, pedido,   idCliente);	
			mostrarStarbucks(s);
		} catch(IllegalArgumentException e) {
			System.out.println("Excepción capturada:\n   " + e);	
		} catch (Exception e) {
			System.out.println("Excepci�n inesperada:\n   " + e);
		}

	}
	
	
	public static void main(String[] args) {
		
		System.out.println("####################    ENTREGA 1    ####################\n");
		System.out.println("\n~~~~~~~~~~~~~~~~~~~    OBJETO 1 (CONSTRUCTOR 1)    ~~~~~~~~~~~~~~~~~~~\n");
		
		List<String> pedido = List.of("Cold drinks","Pastries");
		
		Starbucks a1= new Starbucks(LocalDateTime.now(), Genero.FEMALE, 12, Ocupacion.EMPLOYED, "Take away", 13, 2.5,pedido , true,1);
		mostrarStarbucks(a1);
		
		
		//Caso de prueba con valoración >5.0
		System.out.println("====================================");
		System.out.println("Constructor 1 - Caso de prueba con valoración >5.0 ");
		testConstructor1(LocalDateTime.now(), Genero.FEMALE, 12, Ocupacion.EMPLOYED, "Take away", 13, 5.5,pedido , true,1);
		
		//Caso de prueba fecha mayor que la actual
		System.out.println("====================================");
		System.out.println("Constructor 1 - Caso de prueba fecha mayor que la actual ");
		testConstructor1(LocalDateTime.of(2024,12,3,12,43), Genero.FEMALE, 12, Ocupacion.EMPLOYED, "Take away", 13, 5.0,pedido , true,1);
		
		//Caso de prueba con duracion>60
		System.out.println("====================================");
		System.out.println("Constructor 1 - Caso de prueba con duracion>60 ");
		testConstructor1(LocalDateTime.now(), Genero.FEMALE, 12, Ocupacion.EMPLOYED, "Take away", 113, 4.5,pedido , true,1);
		
		
		System.out.println("================================================================================");
		System.out.println("\n~~~~~~~~~~~~~~~~~~~    OBJETO 2 (CONSTRUCTOR 2)    ~~~~~~~~~~~~~~~~~~~\n");
		
		List<String> pedido2 = List.of("Cold drinks");
		Starbucks a2 = new Starbucks(LocalDateTime.of(2018,11,5,12,32), "Take away",1.1,pedido2 ,2);
		mostrarStarbucks(a2);
		
		//Caso de prueba fecha mayor que la actual
		System.out.println("====================================");
		System.out.println("Constructor 2 - Caso de prueba fecha mayor que la actual ");
		testConstructor1(LocalDateTime.of(2023,11,3,12,43), Genero.FEMALE, 12, Ocupacion.EMPLOYED, "Take away", 13, 5.0,pedido , true,1);
		

		System.out.println("================================================================================");
		System.out.println("\n________  PROPIEDAD DERIVADA: pedidoCliente ________\n");
		
		System.out.println("Objeto 1: " + a1.pedidoCliente() );
		System.out.println("Objeto 2: " + a2.pedidoCliente() );
		
		System.out.println("\n________  PROPIEDAD DERIVADA: añoNacimiento ________\n");
		Cliente c = new Cliente(LocalDateTime.now(), 14);
		System.out.println("El cliente nació en el año "+c.getAñoNacimiento(c));


		System.out.println("================================================================================");
		System.out.println("\n________  TO STRING  ________\n");
		
		System.out.println("Objeto 1: " + a1.toString() );
		System.out.println("Objeto 2: " + a2.toString() );
		
		

		System.out.println("================================================================================");
		System.out.println("\n________  PROPIEDAD DERIVADA ________\n");
		System.out.println("¿Son los objetos iguales? " + a1.equals(a2));
		
		

		System.out.println("================================================================================");
		System.out.println("\n________  PROPIEDAD DERIVADA ________\n");
		
		if (a1.compareTo(a2) == 0 ) {
			System.out.println("Ambos objetos son iguales.");
			
		}else if (a1.compareTo(a2) < 0 ) {
			System.out.println("El objeto 2 es mas grande que el objeto 1.");
			
		}else {
			System.out.println("El objeto 1 es más grande que el objeto 2.");
		}
		
		

	
	}

}
