// ...
public class Universidad  {
    private String nombre;
    private String direccion;
    // C A M B I O: Usar ListaEnlazada
    private ListaEnlazada miembros;
    // int cantidad se elimina
    

    public Universidad(String nombre,String direccion){
        // Se simplifica el constructor eliminando el parámetro de capacidad
        this.nombre = nombre;
        this.direccion = direccion;
        // Inicializar la lista
        miembros = new ListaEnlazada();
    }
    
    // ... getters y setters ...

    // Adaptación de agregarMiembro()
      public void agregarMiembro(MiembroUniversidad m) {
        miembros.agregar(m);
    }

    // Adaptación de listarMiembros()
    public void listarMiembros(){
        System.out.println(miembros.toString()); // Usar el toString de ListaEnlazada
    }
    
    // Adaptación de buscarPorRol()
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
    
    // Adaptación de obtenerEstudiantes()
    public Estudiante[] obtenerEstudiantes() {
        // Contar y obtener todos los estudiantes usando la lista
        ListaEnlazada estudiantesLista = new ListaEnlazada();
        Nodo actual = miembros.getPrimero();
        
        while (actual != null) {
            if (actual.dato instanceof Estudiante)
                estudiantesLista.agregar(actual.dato);
            actual = actual.siguiente;
        }

        // Convertir la lista temporal a array para usar los métodos de array
        return (Estudiante[]) estudiantesLista.convertirAArray();
    }

    // Se mantiene ordenarEstudiantesPorApellido() ya que usa el array devuelto por obtenerEstudiantes()
    
    // Adaptación de contarEstudiantesRecursivo() (se cambia para usar Nodos)
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
    
    // Método de soporte para llamar a contarEstudiantesRecursivo()
    public int contarEstudiantesRecursivo(String carrera) {
        // Primero convertimos la lista de miembros a una lista de *solo* estudiantes
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


    // Adaptación de contarEstudiantesIterativo() (se cambia para usar Nodos)
    public int contarEstudiantesIterativo(String carrera) {
        int contador = 0;
        
        // Primero, solo iteramos sobre los miembros que son estudiantes
        Nodo actualMiembro = miembros.getPrimero();
        while (actualMiembro != null) {
            if (actualMiembro.dato instanceof Estudiante) {
                Estudiante e = (Estudiante) actualMiembro.dato;
                
                // Iterar sobre las carreras del estudiante
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
    
    
    // Adaptación de buscarEstudianteRecursivo() (se cambia para usar Nodos)
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
        
        // Primero convertimos la lista de miembros a una lista de *solo* estudiantes
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

    // Adaptación de buscarEstudianteIterativo()
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