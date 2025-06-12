package modelo;

import java.util.*;
import interfaces.INodo;

public class Recorrido_DFS<T> {
    private Map<T, Nodo<T>> nodos;

    // Constructor que recibe el mapa de nodos del grafo
    public Recorrido_DFS(Map<T, Nodo<T>> nodos) {
        this.nodos = nodos;
    }

    // Recorrido en profundidad (Depth First Search)
    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) return; // Precondición
        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }

    // Función recursiva auxiliar para DFS
    private void dfsRec(Nodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getValor());
        System.out.print(actual.getValor() + " ");

        List<INodo<T>> vecinos = actual.getVecinos();
        for (int i = vecinos.size() - 1; i >= 0; i--) { // Inverso si querés controlar el orden
            INodo<T> vecino = vecinos.get(i);
            if (!visitados.contains(vecino.getValor())) {
                dfsRec((Nodo<T>) vecino, visitados);
            }
        }
    }
}
