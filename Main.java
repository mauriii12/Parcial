public class Main {
    
    public static void main(String[] args) {
        
    
        Estudiante estudiante1 = new Estudiante("Mauricio", "Perez", 18, "47592154", 9.09);
        Estudiante estudiante2 = new Estudiante("Mariano", "Lopez", 22, "42334502", 10);
        
        
        Universidad universidad = new Universidad("UNVIME", "Barrio Los Poetas");
        
        Profesor profesor1 = new Profesor("German", "Benavidez", 42, "32192012", "Contador", "2015");
        Profesor profesor2 = new Profesor("Ileana", "Gutierrez", 38, "32910201", "Ingles y Frances", "2021");
        
    
        Carrera programacion = new Carrera("Programacion", "Progr");
        
        Materia matematicas = new Materia("Matematicas", "MAT", 3, profesor1);
        Materia ingles = new Materia("Ingles", "ING", 5, profesor2);
        
        Personal limpieza = new Personal("Leonidas", "Buszo", 34, "34592010", "smase", "Limpieza", "2024");
        
        matematicas.setNota(9);
        ingles.setNota(8);


        profesor1.agregarCarrera(matematicas); 
        profesor2.agregarCarrera(ingles);

        universidad.agregarMiembro(limpieza);
        universidad.agregarMiembro(profesor1);
        universidad.agregarMiembro(profesor2);
        universidad.agregarMiembro(estudiante1);
        universidad.agregarMiembro(estudiante2);

        estudiante1.agregarCarrera(programacion);
        programacion.agregarEstudiante(estudiante1);

        estudiante2.agregarCarrera(programacion);
        programacion.agregarEstudiante(estudiante2);

        programacion.agregarMateria(matematicas);
        programacion.agregarMateria(ingles);

      
        estudiante1.agregarMateria(matematicas); 
        estudiante2.agregarMateria(ingles);

        System.out.println("----UNIVERSIDAD----");    
        universidad.mostrarDatos();  
  

        System.out.println("Lista de miembros de la Universidad");
        universidad.listarMiembros();
        
        System.out.println("\n--- CONTAR ESTUDIANTES EN PROGRAMACION ---");
       
        System.out.println("Recursivo: " +
                universidad.contarEstudiantesRecursivo("Programacion")); 
        System.out.println("Iterativo: " +
                universidad.contarEstudiantesIterativo("Programacion"));

       
        System.out.println("PROMEDIO RECURSIVO: " + estudiante1.promedioRecursivo());
        System.out.println("PROMEDIO ITERATIVO: " + estudiante1.promedioIterativo());
        

        Estudiante encontrado = universidad.buscarEstudianteRecursivo("47592154"); 

        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.obtenerInformacionCompleta());
        } else {
            System.out.println("No existe el estudiante");
        }

    }
}