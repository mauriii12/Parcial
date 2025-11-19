public class Persona{
    
   private String nombre;
   private String apellido;
   private int edad;
   private String dni;


public String getNombre(){

   return nombre;
}
public void setNombre(String nombre){

    this.nombre = nombre;
 
}

public String getApellido(){
    return this.apellido;
}
public void setApellido(String apellido){
  this.apellido = apellido;


}

public int getEdad(){

    return edad;
}


  public void setEdad(int edad) {
        if (edad < 16) {
            System.out.println("Edad inválida, debe ser mayor a 16 años.");
        }
        this.edad = edad;
    }


public String getDni(){

    return dni;
}
public void setDni(String dni){
   this.dni = dni;
  
}


public Persona(String nombre,String apellido,int edad,String dni){

     this.nombre = nombre;
     this.apellido = apellido;
     this.edad = edad;
     this.dni = dni;
}


public String mostrarDatos(){
    return " Nombre:" + nombre 
    + " Apellido:" + apellido
    + " Edad:" + edad
    + " DNI:" + dni;
}

 @Override
    public String toString() {
        return mostrarDatos();
    }


}
