public class Personal extends Persona implements MiembroUniversidad {
    
    private String departamento;
    private String puesto;
    private String anoIngreso;


public Personal(String nombre,String apellido,int edad,String dni,String departamento,String puesto,String anoIngreso){

    super(nombre, apellido, edad, dni);
    this.departamento = departamento;
    this.puesto = puesto;
    this.anoIngreso = anoIngreso;
}
public String getDepartamento(){
    return departamento;
}
public void setDepartamento(String departamento){
    this.departamento = departamento;
}
public String getPuesto(){
    return puesto;
}
public void setPuesto(String puesto){
    this.puesto = puesto;
}
public String getAnoIngreso(){
    return anoIngreso;
}
public void setAnoIngreso(String anoIngreso){
    this.anoIngreso = anoIngreso;
}
public String obtenerRol(){
    return " Personal";
}

public String obtenerInformacionCompleta(){
    return super.mostrarDatos()+
    " Departamento:" + departamento +
    " Puesto:" + puesto +
    " Ano Ingreso" + anoIngreso;
}

    @Override
    public String toString() {
        return obtenerInformacionCompleta();
    }



}