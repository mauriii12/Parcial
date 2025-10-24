public class productoTecnologico extends Producto {
    
    private int garantiaMeses;


   public int getGarantiaMeses(){

    return garantiaMeses;
   }

   public void setGarantiaMeses(int garantiaMeses){

    this.garantiaMeses = garantiaMeses;
   }

   public productoTecnologico(String codigo,String descripcion,double precio,int garantiaMeses){

       super(codigo, descripcion, precio);
       this.garantiaMeses = garantiaMeses;

   }

   
   public String mostrarDatos(String codigo, String descripcion, double precio) {
       
       return "codigo:" + getCodigo() + "Descripcion:" + getDescripcion() + "Precio :" + getPrecio();
   }

}
