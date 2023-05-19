package fp.starbucks;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;


import fp.common.Genero;
import fp.common.Ocupacion;
import fp.utiles.Checkers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


	
public class ListaStarbucks {
	private List<Starbucks> listas;
	
	//Entrega 2
	//Constructor 1: Constructor con todas las propiedades básicas (excepto la colección), que cree un objeto de tipo contenedor sin ningún elemento en la colección.
	public ListaStarbucks() {
		this.listas = new ArrayList<Starbucks>();
	} 
	
	
	
	//Constructor 2: Constructor con todas las propiedades básicas y una colección de objetos del tipo base, que cree un objeto de tipo contenedor con todos los elementos de la colección.
	
	public ListaStarbucks( List<Starbucks> listas) {
		this.listas = new ArrayList <Starbucks>(listas);
	}
	
	//Constructor 3: constructor con todas las propiedades básicas (excepto la colección) 
	//y un stream de objetos del tipo base, que cree un objeto del tipo contenedor con todos los elementos del stream.)
	public ListaStarbucks(Stream<Starbucks> stream) {
		this.listas = stream.collect(Collectors.toList());
	}
	
	
	//criterio de igualdad y representación como cadena
	@Override
	public String toString() {
		return "ListaStarbucks [listas=" + listas + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(listas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaStarbucks other = (ListaStarbucks) obj;
		return Objects.equals(listas, other.listas);
	}



	
	/**
	 * @return número de elementos
	 */
	public Integer getLongitud() {
		return listas.size();
	}

	/**
	 * @param s objeto de tipo Starbucks
	 * añade un elemento
	 */
	public void añade(Starbucks s) {
		this.listas.add(s);
	}
	

	/**
	 * @param l lista de objetos Starbucks
	 * Añadir una colección de elementos.
	 */
	public void añade(List<Starbucks> l) {
		this.listas.addAll(l);
	}
	

	/**
	 * @param b objeto de tipo Starbucks
	 * Eliminar un elemento.
	 */
	public void eliminarPedido(Starbucks b) {
		Checkers.check("El pedido está en la lista", listas.contains(b));
		this.listas.remove(b);
	}

	//Getters y Setters

	public List<Starbucks> getListas() {
		return listas;
	}

	//TRATAMIENTOS SECUENCIALES CON BUCLES
	
	/**
	 * @param id , identificador del cliente
	 * @return existe pedido de un cliente determinado
	 */
	public Boolean existePedidoDadoId(Integer id) {
		Boolean res = false;
		for (Starbucks s:listas) {
			if (s.getIdCliente().equals(id)) {
				res = true;
			}
		}
		return res;
	}
	
	

	/**
	 * @param mes 
	 * @return Obtener el numero de pedidos realizados en un mes
	 */
	public Integer numeroDePedidosMes(Integer mes) {
		int cont = 0;
		for (Starbucks a : listas) {
			if (a.getFechaHora().getMonthValue() == mes) {
				cont ++;
			}
		}
		return cont;
	}
	
	
	/**
	 * @param edad
	 * @return Dado una edad, devuelve los pedidos que han realizado personas de dicha edad.
	 */
	public List<Starbucks> filtroPorEdad(Integer edad ){
		
		List<Starbucks> res = new ArrayList<Starbucks>();
		
		for (Starbucks s : listas) {
			if (s.getEdad() == edad) {
				res.add(s);
			}
		}
		
		return res;
	}
	
	

	
	
	/**
	 * @return Map donde asocia a cada ocupacion sus objetos Starbucks asociados en una lista.
	 */
	public Map<String, List<Starbucks>> agruparPorOcupacion(){
		
		Map<String, List<Starbucks>> res = new HashMap<>();
		
		for ( Starbucks s : listas) {
			String clave = s.getOcupacion().toString();
			if (res.containsKey(clave)) {
				
				res.get(clave).add(s);
				
			}else {
				List<Starbucks> lista = new ArrayList<Starbucks>();
				lista.add(s);
				res.put(clave, lista);
			}
		}
		return res;
	}
	
	
	
	/**
	 * @return Map donde asocia a cada servicio el conteo de las veces que aparece.
	 */
	public Map<String, Integer> conteoDeServicio(){
		
		Map<String, Integer> res = new HashMap<>();
		
		
		for ( Starbucks s : listas) {
			String clave=s.getServicio();
			if (res.containsKey(clave)) {
				
				int cont = res.get(clave);
				
				cont++;
				
				res.put(clave, cont);
				
			}else {
				
				res.put(clave, 1);
			}
		}
		return res;
		
	}
	
	//ENTREGA 3
	//TRATAMIENTOS SECUENCIALES CON STREAM
//	Bloque I: 
	/**
	 * @param id , identificador del cliente
	 * @return existe pedido de un cliente determinado
	 */
	public Boolean existePedidoDadoIdStream(Integer id) {
		return listas.stream()
				.anyMatch(x->x.getIdCliente().equals(id));

	}
	
	/**
	 * @param mes 
	 * @return Obtener el numero de pedidos realizados en un mes
	 */
	public Integer numeroDePedidosMesStream(Integer mes) {
		return (int)listas.stream()
				.filter(x->x.getFechaHora().getMonthValue()==mes)
				.count(); //count devuelve long, por eso ponemos (int)

	}
	

	
	/**
	 * @param edad
	 * @return Dado una edad, devuelve los pedidos que han realizado personas de dicha edad.
	 */
	public List<Starbucks> filtroPorEdadStream(Integer edad ){
		
		return listas.stream()
				.filter(x->x.getEdad().equals(edad))
				.toList();
	}
	
	
	
	/**
	 * @param genero 
	 * @return Devuelve el pedido con mayor valoracion hecho por un genero dado
	 */
	public Starbucks pedidoMayorValoracion(Genero genero) {
		return listas.stream()
				.filter(x->x.getGenero().equals(genero))
				.max(Comparator.comparing(Starbucks::getValoracion))
				.get();
	}
	
	
	/**
	 * @return Devuelve los pedidos satisfechos ordenados por mejor valoracion
	 */
	public List<Starbucks> pedidosSatisfechosValoracion() {
		return listas.stream()
				.filter(x->x.getSatisfecho().equals(true))
				.sorted(Comparator.comparing(Starbucks::getValoracion).reversed())
				.collect(Collectors.toList());		
	}
//	Bloque II: 
	
	
	/**
	 * @return Map donde asocia a cada ocupacion sus objetos Starbucks asociados en una lista.
	 */
	public Map<String, List<Starbucks>> agruparPorOcupacionStream(){
		return listas.stream()
				.collect(Collectors.groupingBy(x->x.getOcupacion().toString()));
	}
	

	/**
	 * @return Map donde asocia a cada mes el id del cliente que ha realizado un pedido.
	 */
	public Map<String, List<Integer>> agruparPorPedidoId(){
		return listas.stream()
				.collect(Collectors.groupingBy(x->x.getFechaHora().getMonth().toString(),
						Collectors.mapping(x->x.getIdCliente(), Collectors.toList())));
	}


	/**
	 * @param dia
	 * @return Map donde las claves son los diferentes pedidos y los valores son las valoraciones mínimas de los elementos con ese pedido y cuya fecha y hora tienen el mismo día que el valor del parámetro
	 */
	public Map<List<String> , Double> pedidosPeoresValoraciones(Integer dia) {
		return listas.stream()
				.filter(x->x.getFechaHora().getDayOfMonth()==dia)
				.collect(Collectors.groupingBy(Starbucks::getPedido,
						Collectors.collectingAndThen(
								Collectors.minBy(Comparator.comparing(Starbucks::getValoracion)),
								x->x.get().getValoracion()
								)));
	}	

	
	
    /**
     * @param n, numero de pedidos que queremos obtener
     * @return SortedMap donde las claves son los generos y los valores los n pedidos con menor duracion 
     */
    public SortedMap<Genero, List<Starbucks>> obtenerNPedidosMenorDuracionPorGenero(Integer n) {
        return listas.stream()
        		.collect(Collectors.groupingBy(x->x.getGenero(),
        				TreeMap::new,
        				Collectors.collectingAndThen(Collectors.toList(), 
        						x->auxiliar(x,n))));
    }
    private List<Starbucks> auxiliar(List<Starbucks> x, Integer n){
    	return x.stream()
    			.sorted(Comparator.comparing(Starbucks::getDuracion))
    			.limit(n)
    			.collect(Collectors.toList());
    }
    
  
	/**
	 * @return Crea un Map donde las claves son las ocupaciones y los valores las edades y devuelve la ocupacion(clave) con mayor edad(valor)
	 */
	public Ocupacion getOcupacionMayorEdad() {
        Map<Ocupacion, List<Integer>> s = listas.stream()
                .collect(Collectors.groupingBy(x->x.getOcupacion(),
                        Collectors.mapping(Starbucks::getEdad, Collectors.toList())));
        return s.entrySet()
                .stream()
                .max(Comparator.comparing(v-> Collections.min(v.getValue())))
                .map(Map.Entry::getKey)
                .orElseThrow();
	}
}
