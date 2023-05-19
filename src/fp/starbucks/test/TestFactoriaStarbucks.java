package fp.starbucks.test;




import fp.starbucks.FactoriaStarbucks;
import fp.starbucks.ListaStarbucks;



public class TestFactoriaStarbucks {
	
	public static void main(String[] args) {
		testLeerStarbucks("data/starbucks.csv");
		}

		private static void testLeerStarbucks(String fichero) {
			System.out.println("\n==========TestLeerStarbucks =============");
			ListaStarbucks starbucks = FactoriaStarbucks.leerStarbucks(fichero); 
			System.out.println("Lista de todos los pedidos realizados en Starbucks:");
			starbucks.getListas().stream().forEach(System.out::println);
		}
	
		 



}
