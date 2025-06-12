package modelo;

import java.util.*;

import interfaces.INodo;

public class Recorrido_BFS<T> {

    private Map<T, Nodo<T>> nodos;

    public Recorrido_BFS(Map<T, Nodo<T>> nodos) {
        this.nodos = nodos;
    }

    @SuppressWarnings("unchecked")
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
                    cola.addAll((Collection<? extends Nodo<T>>) vecino);
                }
            }
        }
        System.out.println();
    }
}
