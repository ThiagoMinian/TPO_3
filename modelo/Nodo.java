package modelo;

import java.util.ArrayList;
import java.util.List;

import interfaces.INodo;

public class Nodo<T> implements INodo<T> {
	
    private T valor; // Valor almacenado en el nodo; T <T>
    private List<INodo<T>> vecinos; // Lista de nodos vecinos (adyacentes)

    // Constructor
    public Nodo(T valor) {
        this.valor = valor;
        this.vecinos = new ArrayList<>();
    }

    // Getter del valor
    public T getValor() {
        return valor;
    }

    // Setter del valor
    public void setValor(T valor) {
        this.valor = valor;
    }

    // Agrega un nodo vecino a la lista de adyacencia
    public void agregarVecino(INodo<T> vecino) {
        if (!vecinos.contains(vecino)) {
            vecinos.add(vecino);
        }
    }

    // Devuelve la lista de vecinos
    public List<INodo<T>> getVecinos() {
        return vecinos;
    }
}