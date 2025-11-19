public class ListaEnlazada {
    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;

    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

   
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

    public boolean estaVacia() {
        return primero == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public Nodo getPrimero() {
        return primero;
    }
    
   
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



    public static ListaEnlazada convertirArrayALista(Object[] array) {
        ListaEnlazada nuevaLista = new ListaEnlazada();
        for (Object dato : array) {
            nuevaLista.agregar(dato);
        }
        return nuevaLista;
    }
    
 
    
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