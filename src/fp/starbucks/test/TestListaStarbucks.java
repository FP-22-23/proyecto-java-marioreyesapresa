package fp.starbucks.test;



import fp.common.Genero;

import fp.starbucks.FactoriaStarbucks;
import fp.starbucks.ListaStarbucks;


public class TestListaStarbucks {

	
	public static void main(String[] args) {
		ListaStarbucks starbucks = FactoriaStarbucks.leerStarbucks("data/starbucks.csv");
		
		System.out.println("####################    ENTREGA 2    ####################\n");
		
	
		System.out.println("####################    Prueba de cada método    ####################\n");
		
		System.out.println("\n--------- Método: getLongitud ---------");
		System.out.println("\nEn ListaStarbucks tenemos registrados  " + starbucks.getLongitud() + " pedidos.");
		

		System.out.println("\n--------- Método: existePedidoDadoId ---------");
		System.out.println("\n¿Existe algun pedido de un cliente determinado? --> " + starbucks.existePedidoDadoId(10));
		
		
		System.out.println("\n--------- Método: numeroDePedidosMes ---------");
		System.out.println("\n¿Cuántas veces se registra un pedido en Octubre? --> " + starbucks.numeroDePedidosMes(10));
		
		System.out.println("\n--------- Método: filtroPorEdad ---------");
		System.out.println("\nFiltramos los registros por los clientes con 20 años --> \n" + starbucks.filtroPorEdad(20));
		
		System.out.println("\n--------- Método: agruparPorOcupacion ---------");
		System.out.println("\nObtenemos un map de ListaStarbucks donde asocia a cada Ocupacion sus registros asociados --> \n" + starbucks.agruparPorOcupacion());
		
		System.out.println("\n--------- Método: conteoDeServicio ---------");
		System.out.println("\nObtenemos un map de ListaStarbucks donde asocia a cada Servicio el conteo de las veces que aparece --> \n" + starbucks.conteoDeServicio());
		
		
		System.out.println("####################    ENTREGA 3    ####################\n");
		System.out.println("\n--------- Método: existePedidoDadoIdStream ---------");
		System.out.println("\n¿Existe algun pedido de un cliente determinado? --> " + starbucks.existePedidoDadoIdStream(11));
		
		System.out.println("\n--------- Método: numeroDePedidosMesStream ---------");
		System.out.println("\n¿Cuántas veces se registra un pedido en Octubre? --> " + starbucks.numeroDePedidosMesStream(10));
		
		System.out.println("\n--------- Método: filtroPorEdadStream ---------");
		System.out.println("\nFiltramos los registros por los clientes con 20 años --> \n" + starbucks.filtroPorEdadStream(20));
		
		System.out.println("\n--------- Método: pedidoMayorValoracion ---------");
		System.out.println("\nFiltramos los registros por los pedidos realizados por mujeres y devolvemos el de mayor valoracion --> \n" + starbucks.pedidoMayorValoracion(Genero.FEMALE));
		
		
		System.out.println("\n--------- Método: pedidosSatisfechosValoracion ---------");
		System.out.println("\nFiltramos los registros satisfechos y los ordenamos por valoracion--> \n" + starbucks.pedidosSatisfechosValoracion());
		
		System.out.println("\n--------- Método: agruparPorOcupacionStream ---------");
		System.out.println("\nObtenemos un map de ListaStarbucks donde asocia a cada Ocupacion sus registros asociados --> \n" + starbucks.agruparPorOcupacionStream());
		
		System.out.println("\n--------- Método: agruparPorPedidoId ---------");
		System.out.println("\nObtenemos un map de ListaStarbucks donde asocia a cada mes los id de los clientes que han hecho un pedido --> \n" + starbucks.agruparPorPedidoId());
		
		System.out.println("\n--------- Método: pedidosPeoresValoraciones ---------");
		System.out.println("\nObtenemos un map de ListaStarbucks donde las claves son  pedidos y los valores las valoraciones mínimas de los pedidos filtrados por el dia parámetro --> \n" + starbucks.pedidosPeoresValoraciones(3));
		
		System.out.println("\n--------- Método: obtenerNPedidosMenorDuracionPorGenero ---------");
		System.out.println("\nObtenemos un SortedMap donde las claves son los generos y los valores los n pedidos con menor duracion --> \n" + starbucks.obtenerNPedidosMenorDuracionPorGenero(2));
		
		System.out.println("\n--------- Método: getOcupacionMayorEdad ---------");
		System.out.println("\nA partir de un Map, obtenemos la ocupacion con mayor edad --> \n" + starbucks.getOcupacionMayorEdad());
		

	}

}
