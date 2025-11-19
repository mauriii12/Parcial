// ...
public class Profesor extends Persona implements MiembroUniversidad {

    private String especialidad;
    // C A M B I O: Usar ListaEnlazada
    private ListaEnlazada materiasAsignadas; 
    private String anoIngreso;
    // int cantidadM se elimina

    public Profesor(String nombre, String apellido, int edad, String dni, String especialidad, String anoIngreso) {
        // Se simplifica el constructor eliminando el parámetro de capacidad
        super(nombre, apellido, edad, dni);
        this.especialidad = especialidad;
        // Inicializar la lista
        materiasAsignadas = new ListaEnlazada(); 
        this.anoIngreso = anoIngreso;
    }

    // ... getters y setters ...

    // C A M B I O: Adaptación del método para agregar materia
    public boolean agregarCarrera(Materia m) { // El nombre del método es confuso, pero se mantiene.
        materiasAsignadas.agregar(m);
        return true;
    }

    @Override
    public String obtenerRol() {
        return "Profesor";
    }

    // Se elimina el método obtenerInformacionCompleta(int i) ya que no tiene sentido.
    
    // C A M B I O: Adaptación de toString()
    @Override
    public String toString() {
        String asignadasTexto = "";
        Nodo actual = materiasAsignadas.getPrimero();
        
        while(actual != null) {
            Materia m = (Materia) actual.dato;
            asignadasTexto += m.getNombre() + ", ";
            actual = actual.siguiente;
        }
        
        return super.mostrarDatos() +
            " Especialidad:" + especialidad +
            " Materias Asignadas:" + asignadasTexto.trim() + 
            " Año ingreso:" + anoIngreso; 
    }

    @Override
    public String obtenerInformacionCompleta() {
       return toString();
    }
}