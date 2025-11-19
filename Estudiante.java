

public class Estudiante extends Persona implements MiembroUniversidad {

    private double promedio;
  
    private ListaEnlazada carreras; 
    private ListaEnlazada materias; 

  

    public Estudiante(String nombre, String apellido, int edad, String dni, double promedio) {
   
        super(nombre, apellido, edad, dni);
        this.promedio = promedio;
       
        carreras = new ListaEnlazada(); 
        materias = new ListaEnlazada(); 
    }

 
    public boolean agregarCarrera(Carrera c) {
        carreras.agregar(c);
        return true; 
    }

 
    public void agregarMateria(Materia m) { 
        materias.agregar(m);
    }


    public static double calcularPromedioRecursivo(Nodo actual, int contador, double suma) {

        if (actual == null) {
            return contador == 0 ? 0 : suma;
        }

        Materia materia = (Materia) actual.dato; 
        
      
        return calcularPromedioRecursivo(actual.siguiente, contador + 1, suma + materia.getNota());
    }

    public double promedioRecursivo() {
        if (materias.estaVacia())
            return 0;

        double suma = calcularPromedioRecursivo(materias.getPrimero(), 0, 0);
        return suma / materias.getTamanio();
    }

    public double promedioIterativo() {
        if (materias.estaVacia())
            return 0;

        double suma = 0;
        Nodo actual = materias.getPrimero();

        while(actual != null) {
            Materia m = (Materia) actual.dato; 
            suma += m.getNota();
            actual = actual.siguiente;
        }

        return suma / materias.getTamanio();
    }
    

    @Override
    public String obtenerInformacionCompleta() {

        String materiasTexto = " ";
        Nodo actualMateria = materias.getPrimero();
        while(actualMateria != null) {
            Materia m = (Materia) actualMateria.dato;
            materiasTexto += m.getNombre() + " ";
            actualMateria = actualMateria.siguiente;
        }
        
        String carrerasTexto = " ";
        Nodo actualCarrera = carreras.getPrimero();
        while(actualCarrera != null) {
            Carrera c = (Carrera) actualCarrera.dato;
            carrerasTexto += c.getNombre() + " ";
            actualCarrera = actualCarrera.siguiente;
        }
        
        return super.mostrarDatos() +
                " Promedio:" + promedio +
                " Carrera:" + carrerasTexto +
                " Materias:" + materiasTexto;
    }

    
    public ListaEnlazada getCarreras() {
        return carreras;
    }

    @Override
    public String obtenerRol() {
      System.out.println("Estudiante");
      return null;
      
    }

 
}