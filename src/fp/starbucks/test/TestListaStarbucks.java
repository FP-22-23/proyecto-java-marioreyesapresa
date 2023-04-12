package fp.starbucks.test;

import fp.starbucks.ListaStarbucks;

public class TestListaStarbucks {
	
	
	public static void mostrarLista(ListaStarbucks Lista) {
		for(int i = 0; i < Lista.getLongitud(); i++) {
			System.out.println("\nEl order a" + i + " registrado en ListaStarbucks es:");
			System.out.println(Lista.getListas().get(i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
