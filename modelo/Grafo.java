package modelo;

import java.util.*;

import interfaces.IGrafo;
import interfaces.INodo;


public class Grafo<T extends Comparable<T>> implements IGrafo<T> {
	
	
	//(clave, valor)
	//Clave valor como diccionarios de python
	private Map<T, Nodo<T>> nodos = new HashMap<>(); // Mapa de valor -> Nodo
		
	public void agregarNodo(T valor) {
	     if (!nodos.containsKey(valor)) {
	         nodos.put(valor, new Nodo<T>(valor));
	     }
	 }
	
	 public void agregarArista(T origen, T destino) {
	     if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
	         Nodo<T> nodoOrigen = nodos.get(origen); //Agarro el nodo que tiene
	         //como clave al origen... get retorna el NODO
	         Nodo<T> nodoDestino = nodos.get(destino);
	         
	         nodoOrigen.agregarVecino(nodoDestino);
	         
	         nodoDestino.agregarVecino(nodoOrigen); // Grafo no dirigido
	     }
	 }
	
	
	
	 public void mostrarMatrizAdyacencia() {
	     System.out.println("Matriz de Adyacencia:");
	     List<T> claves = new ArrayList<>(nodos.keySet());
	     
	     Collections.sort(claves); // Ordenar nodos por valor

	     // Encabezado
	     System.out.print("   ");
	     for (T i : claves) System.out.print(i + " ");
	     System.out.println();

	     // Filas de la matriz
	     for (T i : claves) { /// 1--- 2  ---- 3 Columnas
	         System.out.print(i + ": ");
	         for (T j : claves) {  /// 1 , 2, 3 --- Filas
	             Nodo<T> nodoI = nodos.get(i);
	             Nodo<T> nodoJ = nodos.get(j);
	             System.out.print(nodoI.getVecinos().contains(nodoJ) ? "1 " : "0 ");
	         }
	         System.out.println();
	     }
	 }

	 // Muestra la lista de adyacencia del grafo
	 public void mostrarListaAdyacencia() {
	     System.out.println("Lista de Adyacencia:");
	     
	     for (Map.Entry<T, Nodo<T>> entrada : nodos.entrySet()) {
	    	 
	         System.out.print(entrada.getKey() + ": ");
	         List<INodo<T>> vecinos = entrada.getValue().getVecinos();
	         
	         for (INodo<T> vecino : vecinos) {
	             System.out.print(vecino.getValor() + " ");
	         }
	         System.out.println();
	     }
	 }
	 
	 public Map<T, Nodo<T>> getMapaNodos() {
		    return nodos;
		}

	 
	 
}
