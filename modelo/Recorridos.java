package modelo;

import java.util.*;

import interfaces.INodo;

public class Recorridos<T> {
    private Map<T, Nodo<T>> nodos;

    // Constructor que recibe el mapa de nodos del grafo
    public Recorridos(Map<T, Nodo<T>> nodos) {
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
                dfsRec((Nodo<T>) vecino, visitados); // Cast necesario si INodo<T> es superclase de Nodo<T>
            }
        }
    }

    // Recorrido en amplitud (Breadth First Search)
    public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        Queue<Nodo<T>> cola = new LinkedList<>();

        cola.add(nodos.get(inicio));
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Nodo<T> actual = cola.poll();
            System.out.print(actual.getValor() + " ");

            for (INodo<T> vecino : actual.getVecinos()) {
                if (!visitados.contains(vecino.getValor())) {
                    visitados.add(vecino.getValor());
                    cola.add((Nodo<T>) vecino); // Cast correcto de INodo<T> a Nodo<T>
                }
            }
        }
        System.out.println();
    }
}
