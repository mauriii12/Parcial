public class Materia {
     private String nombre;
     private String codigo;
     private int creditos;
     private double nota;
    private Profesor profesor;

   public Materia(String nombre,String codigo,int creditos,Profesor profesor){

    this.nombre = nombre;
    this.codigo = codigo;
    this.creditos = creditos;
    this.profesor = profesor;    
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
   public double getNota(){
      return nota;
   }
   public void setNota(double nota){
      this.nota = nota;
   }

   public void setCodigo(String codigo){
    this.codigo = codigo;
   }

   public int getCreditos(){
    return creditos;
   }

   public void setCreditos(int creditos){
    this.creditos = creditos;
   }
   public Profesor getProfesor(){
    return profesor;
   }
   public void setProfesor(Profesor profesor){
    this.profesor = profesor;
 }
 public String mostrarDatos(String materia,String codigo,int creditos,Profesor profesor){
    return "Nombre de la materia:" + materia +
    "Codigo:" + codigo +
    "Creditos:" + creditos + 
    "Profesor de la materia:"  + profesor;
 }

 
}


