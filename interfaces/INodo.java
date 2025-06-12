package interfaces;

import java.util.List;

public interface INodo<T> {
	
    T getValor(); // Devuelve el valor almacenado en el nodo
    void setValor(T valor); // Establece el valor del nodo
    void agregarVecino(INodo<T> vecino); // Agrega un nodo vecino a la lista de adyacencia interna
    List<INodo<T>> getVecinos(); // Obtiene la lista de vecinos del nodo
    
}