package interfaces;

public interface IGrafo<T> {
	void agregarNodo(T valor);
	void agregarArista(T origen, T destino);
	void mostrarMatrizAdyacencia(); // Muestra la matriz de adyacencia
	void mostrarListaAdyacencia(); // Muestra la lista de adyacencia
}
