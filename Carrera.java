public class Carrera {
    
    private String nombre;
    private String codigo;
    private ListaEnlazada materias;
    private ListaEnlazada estudiantes;
  

     public Carrera(String nombre,String codigo){ 
        this.nombre = nombre;
        this.codigo = codigo;
       
        materias = new ListaEnlazada();
        estudiantes = new ListaEnlazada();
     }
     
  
     public void agregarMateria(Materia m){
        materias.agregar(m);
     }

    
     public void agregarEstudiante(Estudiante s){
        estudiantes.agregar(s);
     }

   
    public ListaEnlazada getEstudiantes() {
        return estudiantes;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
}