public class Nodo {
    public Object dato;
    public Nodo siguiente;
    public Nodo anterior; 

    public Nodo(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null; // Inicialmente nulo
    }

    public Nodo getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }

    public Nodo getAnterior(){
        return anterior;
    }
    public void setAnterior(Nodo anterior){
        this.anterior = anterior;
    }

    public Object getDato(){
        return dato;
    }
    public void setDato(Object dato){
        this.dato = dato;
    }
}