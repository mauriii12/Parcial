public class ListaEnlazada {
    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;

    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    // --- Métodos de Gestión ---

    /**
     * Agrega un objeto al final de la lista.
     * @param dato El objeto a agregar.
     */
    public void agregar(Object dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
            nuevoNodo.anterior = ultimo;
            ultimo = nuevoNodo;
        }
        tamanio++;
    }
    
    // Método auxiliar para la eliminación, no necesario para las adaptaciones del TP
    // public void eliminar(int indice) { /* ... implementación ... */ }

    public boolean estaVacia() {
        return primero == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public Nodo getPrimero() {
        return primero;
    }
    
    // --- Métodos para Conversión (Requeridos para Ordenar y Buscar Binaria) ---

    /**
     * Convierte la lista enlazada a un array de objetos.
     * @return Array de Object con los elementos de la lista.
     */
    public Object[] convertirAArray() {
        Object[] array = new Object[tamanio];
        Nodo actual = primero;
        int indice = 0;
        
        while (actual != null) {
            array[indice++] = actual.dato;
            actual = actual.siguiente;
        }
        return array;
    }

    /**
     * Convierte un array de objetos a una nueva Lista Enlazada.
     * @param array Array de Object a convertir.
     * @return Nueva ListaEnlazada con los elementos del array.
     */
    public static ListaEnlazada convertirArrayALista(Object[] array) {
        ListaEnlazada nuevaLista = new ListaEnlazada();
        for (Object dato : array) {
            nuevaLista.agregar(dato);
        }
        return nuevaLista;
    }
    
    // --- Método para Iteración y Mostrar (Añadido para simplicidad) ---
    
    @Override
    public String toString() {
        if (estaVacia()) return "[]";
        StringBuilder sb = new StringBuilder();
        Nodo actual = primero;
        sb.append("[");
        while (actual != null) {
            sb.append(actual.dato.toString());
            if (actual.siguiente != null) {
                sb.append(",\n ");
            }
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}