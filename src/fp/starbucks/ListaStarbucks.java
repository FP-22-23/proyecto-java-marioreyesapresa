package fp.starbucks;
import java.util.List;
import java.util.Objects;
import java.util.Map;


import fp.utiles.Checkers;

import java.util.ArrayList;
import java.util.HashMap;


//Entrega 2
public class ListaStarbucks {
	
	private String orders;
	private List<Starbucks> listas;
	
	
	//Constructor 1: Constructor con todas las propiedades básicas (excepto la colección), que cree un objeto de tipo contenedor sin ningún elemento en la colección.
	public ListaStarbucks(String orders) {
		this.orders = orders;
		this.listas = new ArrayList<Starbucks>();
	}
	
	
	
	//Constructor 2: Constructor con todas las propiedades básicas y una colección de objetos del tipo base, que cree un objeto de tipo contenedor con todos los elementos de la colección.
	
	public ListaStarbucks(String orders, List<Starbucks> listas) {
		this.orders = orders;
		this.listas = new ArrayList <Starbucks>();
		this.listas.addAll(listas);
	}
	
	
	//criterio de igualdad y representación como cadena
	@Override // Esto no lo estas usando
	public String toString() {
		return orders + "\n" + listas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(listas, orders);
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
		return Objects.equals(listas, other.listas) && Objects.equals(orders, other.orders);
	}
	
	
	
//	Obtener el número de elementos.
	public Integer getLongitud() {
		return listas.size();
	}
//	Añadir un elemento.
	public void añade(Starbucks s) {
		this.listas.add(s);
	}
	
//	Añadir una colección de elementos.
	public void añade(ListaStarbucks l) {
		this.listas.addAll(l.getListas());
	}
	public void añade(List<Starbucks> l) {
		this.listas.addAll(l);
	}
	
//	Eliminar un elemento.
	public void eliminarPrimera(Starbucks b) {
		Checkers.check("El pedido está en la lista", listas.contains(b));
		this.listas.remove(b);
	}
	public void eliminarUltima(Starbucks b) {
		Checkers.check("El pedido no está en la lista", listas.contains(b));
		int idx = this.listas.lastIndexOf(b);
		this.listas.remove(idx);
	}

	//Getters y Setters
	public String getOrders() {
		return orders;
	}


	public void setOrders(String orders) {
		this.orders = orders;
	}


	public List<Starbucks> getListas() {
		return listas;
	}

	//TRATAMIENTOS SECUENCIALES
	//obtener si existe un orders
	public Boolean existeOrders(Starbucks a) {
		return this.listas.contains(a);
	}
	
	//Obtener el numero de pedidos realizados en un mes

	public Integer numeroDePedidos(Integer mes) {
		int cont = 0;
		for (Starbucks a : this.listas) {
			if (a.getFechaHora().getDayOfMonth() == mes) {
				cont ++;
			}
		}
		return cont;
	}
	
	//Dado una edad, devuelve los pedidos que han realizado personas de dicha edad.
	
	public List<Starbucks> filtroPorEdad(Integer edad ){
		
		List<Starbucks> res = new ArrayList<Starbucks>();
		
		for (Starbucks s : this.listas) {
			if (s.getEdad() == edad) {
				res.add(s);
			}
		}
		
		return res;
	}
	
	

	//Map donde asocia a cada ocupacion sus objetos Starbucks asociados en una lista.

	
	public Map<String, List<Starbucks>> agruparPorOcupacion(){
		
		Map<String, List<Starbucks>> res = new HashMap<>();
		
		for ( Starbucks s : this.listas) {
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
	
	//Map donde asocia a cada servicio el conteo de las veces que aparece.
	
	public Map<String, Integer> conteoDeServicio(){
		
		Map<String, Integer> res = new HashMap<>();
		
		
		for ( Starbucks s : this.listas) {
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
	
	
	
	
	
	
	
}
