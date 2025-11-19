
public class Profesor extends Persona implements MiembroUniversidad {

    private String especialidad;
  
    private ListaEnlazada materiasAsignadas; 
    private String anoIngreso;
   

    public Profesor(String nombre, String apellido, int edad, String dni, String especialidad, String anoIngreso) {
       
        super(nombre, apellido, edad, dni);
        this.especialidad = especialidad;
        
        materiasAsignadas = new ListaEnlazada(); 
        this.anoIngreso = anoIngreso;
    }

   
    public boolean agregarCarrera(Materia m) {
        materiasAsignadas.agregar(m);
        return true;
    }

    @Override
    public String obtenerRol() {
        return "Profesor";
    }


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