package modelo;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return nombre + "(" + edad + ")";
    }

    @Override
    public int compareTo(Persona otra) {
        return this.nombre.compareTo(otra.nombre); // ordenar por nombre
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return nombre.equals(persona.nombre); // asumimos nombre único
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
