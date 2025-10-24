public class productoOficina extends Producto {
    private String proveedor;

   public String getProveedor(){
    return proveedor;
}

  public void setProveedor(){

    this.proveedor = proveedor;
  }

  public productoOficina(String codigo,String descripcion,double precio,String proveedor){

    super(codigo, descripcion, precio);
    this.proveedor = proveedor;
  }

  public String mostrarDatos(String codigo,String descripcion,double precio,String proveedor){

    return "Codigo: " + getCodigo() + "Descripcion " + getDescripcion() + "Precio: " + getPrecio() + "Proveedor" + getProveedor();
  }

}
