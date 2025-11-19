
public class Universidad  {
    private String nombre;
    private String direccion;
   
    private ListaEnlazada miembros;
    
    

    public Universidad(String nombre,String direccion){
       
        this.nombre = nombre;
        this.direccion = direccion;
     
        miembros = new ListaEnlazada();
    }
    
 
      public void agregarMiembro(MiembroUniversidad m) {
        miembros.agregar(m);
    }

    
    public void listarMiembros(){
        System.out.println(miembros.toString()); 
    }
    

    public MiembroUniversidad buscarPorRol(String rol) {
        System.out.println("Buscando miembros con el rol: " + rol);
        boolean encontrado = false;
        Nodo actual = miembros.getPrimero();

        while(actual != null) {
            MiembroUniversidad m = (MiembroUniversidad) actual.dato;
            if (m.obtenerRol().equalsIgnoreCase(rol)) {
                System.out.println(m.obtenerInformacionCompleta());
                encontrado = true;
            }
            actual = actual.siguiente;
        }

        if (!encontrado) {
            System.out.println("No se encontraron miembros con el rol: " + rol);
        }

        return null; 
    }
    
  
    public Estudiante[] obtenerEstudiantes() {
        
        ListaEnlazada estudiantesLista = new ListaEnlazada();
        Nodo actual = miembros.getPrimero();
        
        while (actual != null) {
            if (actual.dato instanceof Estudiante)
                estudiantesLista.agregar(actual.dato);
            actual = actual.siguiente;
        }


        return (Estudiante[]) estudiantesLista.convertirAArray();
    }


    public static int contarEstudiantesRecursivo(Nodo actual, String carrera) {

        if (actual == null) {
            return 0;
        }

        int suma = 0;
        Estudiante e = (Estudiante) actual.dato;

        if (e != null) {
            Nodo actualCarrera = e.getCarreras().getPrimero();
            while(actualCarrera != null) {
                Carrera c = (Carrera) actualCarrera.dato;
                if (c.getNombre().equalsIgnoreCase(carrera)) {
                    suma = 1;
                    break;
                }
                actualCarrera = actualCarrera.siguiente;
            }
        }
        
        return suma + contarEstudiantesRecursivo(actual.siguiente, carrera);
    }
    

    public int contarEstudiantesRecursivo(String carrera) {
  
        ListaEnlazada estudiantesLista = new ListaEnlazada();
        Nodo actual = miembros.getPrimero();
        while (actual != null) {
            if (actual.dato instanceof Estudiante) {
                estudiantesLista.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        
        return contarEstudiantesRecursivo(estudiantesLista.getPrimero(), carrera);
    }


    public int contarEstudiantesIterativo(String carrera) {
        int contador = 0;
        

        Nodo actualMiembro = miembros.getPrimero();
        while (actualMiembro != null) {
            if (actualMiembro.dato instanceof Estudiante) {
                Estudiante e = (Estudiante) actualMiembro.dato;
                
          
                Nodo actualCarrera = e.getCarreras().getPrimero();
                while(actualCarrera != null) {
                    Carrera c = (Carrera) actualCarrera.dato;
                    if (c.getNombre().equalsIgnoreCase(carrera)) {
                        contador++;
                        break;
                    }
                    actualCarrera = actualCarrera.siguiente;
                }
            }
            actualMiembro = actualMiembro.siguiente;
        }
        return contador;
    }
    

    public static Estudiante buscarEstudianteRecursivo(Nodo actual, String documento) {

        if (actual == null) {
            return null;
        }

        Estudiante e = (Estudiante) actual.dato;
        
        if (e != null && e.getDni().equals(documento)) {
            return e;
        }

        return buscarEstudianteRecursivo(actual.siguiente, documento);
    }


    public Estudiante buscarEstudianteRecursivo(String dni) {
        

        ListaEnlazada estudiantesLista = new ListaEnlazada();
        Nodo actual = miembros.getPrimero();
        while (actual != null) {
            if (actual.dato instanceof Estudiante) {
                estudiantesLista.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        
        return buscarEstudianteRecursivo(estudiantesLista.getPrimero(), dni);
    }

   
    public Estudiante buscarEstudianteIterativo(String dni) {
        
        Nodo actual = miembros.getPrimero();

        while (actual != null) {
            if (actual.dato instanceof Estudiante) {
                Estudiante e = (Estudiante) actual.dato;
                if (e.getDni().equals(dni)) {
                    return e;
                }
            }
            actual = actual.siguiente;
        }
        return null;
    }
    
    public String mostrarDatos(){
        return "Nombre: " + nombre + "Direccion: " + direccion;
    }
    

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
           
        this.nombre = nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }


}