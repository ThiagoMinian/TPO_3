import interfaces.IGrafo;
import modelo.Grafo;
import modelo.Persona;

package test;

public class TestMatriz {

    public static void main(String[] args) {
        IGrafo<Persona> grafo = new Grafo<>();

        Persona ana = new Persona("Ana", 30);
        Persona bruno = new Persona("Bruno", 25);
        Persona carla = new Persona("Carla", 28);

        grafo.agregarNodo(ana);
        grafo.agregarNodo(bruno);
        grafo.agregarNodo(carla);

        grafo.agregarArista(ana, bruno);
        grafo.agregarArista(bruno, carla);

        grafo.mostrarMatrizAdyacencia();
    }
}
