package fp.starbucks.test;




import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fp.common.Genero;
import fp.common.Ocupacion;
import fp.starbucks.FactoriaStarbucks;
import fp.starbucks.ListaStarbucks;
import fp.starbucks.Starbucks;


public class TestFactoriaStarbucks {
	
	public static void mostrarLista(ListaStarbucks Lista) {
		for(int i = 0; i < Lista.getLongitud(); i++) {
			System.out.println("\nEl pedido s" + i + " registrado en ListaStarbucks es:");
			System.out.println(Lista.getListas().get(i));
		}
	}

	public static void main(String[] args) {
		System.out.println("####################    ENTREGA 2    ####################\n");
		testLeerStarbucks("data/starbucks.csv");
		}

		private static void testLeerStarbucks(String fichero) {
			System.out.println("\n==========TestLeerStarbucks =============");
			ListaStarbucks starbucks = FactoriaStarbucks.leerStarbucks(fichero); 
			System.out.println("Lista de todos los pedidos realizados en Starbucks:");
			starbucks.getListas().stream().forEach(System.out::println);
	
		
		
			
			System.out.println("####################    Prueba de cada método    ####################\n");
			//1/10/19 12:38;Female;23;Student;Dine in;35;0.5;Coffee;Yes;1
			
			Starbucks s0 = new Starbucks(LocalDateTime.of(2019, 10, 3, 12,34), Genero.FEMALE, 34, Ocupacion.EMPLOYED, "Dine in", 40, 3.4,List.of("Cold drinks","Pastries"),true,50);
			Starbucks s1 = new Starbucks(LocalDateTime.of(2019, 10, 3, 13,14), Genero.MALE, 24, Ocupacion.STUDENT, "Take away", 18, 3.9,List.of("Cold drinks","Coffee"),true,51);
			Starbucks s2 = new Starbucks(LocalDateTime.of(2019, 10, 3, 13,32), Genero.FEMALE, 20, Ocupacion.STUDENT, "Dine in", 20, 4.4,List.of("Cold drinks","Pastries","Coffee"),true,52);
			Starbucks s3 = new Starbucks(LocalDateTime.of(2019, 10, 3, 13,52), Genero.FEMALE, 17, Ocupacion.STUDENT, "Dine in", 12, 4.8,List.of("Cold drinks","Pastries","Coffee"),true,53);
			

		
			System.out.println("\n~~~~~~~~~~~~~~~~~~~    ARRAYLIST INICIAL    ~~~~~~~~~~~~~~~~~~~");
			List<Starbucks> ListaStarbucksInicial = new ArrayList<Starbucks>();
			ListaStarbucksInicial.add(s0);
			ListaStarbucksInicial.add(s1);
			ListaStarbucksInicial.add(s2);
			ListaStarbucksInicial.add(s3);
			
			for(int i = 0; i < ListaStarbucksInicial.size(); i++) {
					System.out.println("\nEl objeto " + i + " registrado en ListaStarbucksInicial es:");
					System.out.println(ListaStarbucksInicial.get(i));
			}
			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~    CONSTRUCTOR ListaStarbucks     ~~~~~~~~~~~~~~~~~~~");
			
			ListaStarbucks ListaStarbucks = new ListaStarbucks("ListaStarbucks", ListaStarbucksInicial);
			mostrarLista(ListaStarbucks);
		
		
			System.out.println("\n--------- Incorporamos el objeto s4 a ListaStarbucks ---------");
			Starbucks s4 = new Starbucks(LocalDateTime.of(2019, 10, 3, 14,04), Genero.MALE, 19, Ocupacion.STUDENT, "Take Away", 3, 3.8,List.of("Coffee"),true,54);
			ListaStarbucks.añade(s4);;
			mostrarLista(ListaStarbucks);
			
			System.out.println("\n--------- Eliminamos el objeto s4 de ListaStarbucks ---------\n");
			ListaStarbucks.eliminarUltima(s4);
			mostrarLista(ListaStarbucks);
			
			System.out.println("\n--------- Método: getLongitud ---------");
			System.out.println("\nEn ListaStarbucks tenemos registrados finalmente " + ListaStarbucks.getLongitud() + " pedidos.");
			
			System.out.println("\n--------- Método: existeOrders ---------");
			System.out.println("\n¿Existe el pedido s3 en ListaStarbucks? --> " + ListaStarbucks.existeOrders(s3));
			
			System.out.println("\n--------- Método: numeroDePedidos ---------");
			System.out.println("\n¿Cuántas veces se registra un pedido en Enero en ListaStarbucks? --> " + ListaStarbucks.numeroDePedidos(1));
			
			System.out.println("\n--------- Método: filtroPorEdad ---------");
			System.out.println("\nFiltramos los registros por los clientes con 20 años --> \n" + ListaStarbucks.filtroPorEdad(20));
			
			System.out.println("\n--------- Método: agruparPorOcupacion ---------");
			System.out.println("\nObtenemos un map de ListaStarbucks donde asocia a cada Ocupacion sus registros asociados --> \n" + ListaStarbucks.agruparPorOcupacion());
			
			System.out.println("\n--------- Método: conteoDeServicio ---------");
			System.out.println("\nObtenemos un map de ListaStarbucks donde asocia a cada Servicio el conteo de las veces que aparece --> \n" + ListaStarbucks.conteoDeServicio());
			
			
			
			
			
		}

}
