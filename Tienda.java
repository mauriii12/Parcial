import java.util.Set;

public class Tienda {

    private String nombre;
    private Producto[] inventario;
    private int cantidadProductos;

    public int getCantidadProductos() {

        return cantidadProductos;
    }

    public void setCantidadProductos() {

        this.cantidadProductos = cantidadProductos;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public Producto[] getInvetario() {

        return inventario;
    }

    public void setInventario(Producto[] inventario) {

        this.inventario = inventario;
    }

    public Tienda(String nombre, Producto[] inventario) {

        this.nombre = nombre;
        this.inventario = inventario;
    }

    public void agregarProducto(Producto P) {
        if (cantidadProductos < inventario.length) {
            inventario[cantidadProductos] = P;
            cantidadProductos++;

        }
    }

    public void mostrarInventario(Producto[] inventario) {

        System.out.println("nombre" + nombre);
        for (int i = 0; i < inventario.length; i++) {
            System.out.println(inventario[i]);

        }
    }

    public int calularPrecioTotal() {
        int total = 0;
        for (int i = 0; i < cantidadProductos; i++) {
            total += inventario[i].getPrecio();
        }
        return total;
    }

   public void ordenarPorPrecio(){

    for(int i = 0; i < cantidadProductos;i++){
        int indiceMax = i;
        for(int j = i + 1; j < cantidadProductos; j++ ){
            if(inventario[j].getCantidadProductos()  > inventario[indiceMax].getCantidadProductos()){
                indiceMax = j;
            }
            Producto producto = inventario[i];
            inventario[i] = inventario[indiceMax];
            inventario[indiceMax] = producto;
            
        
      
   }  public void buscarPorTipo(String tipo) {
        System.out.println("Productos de tipo:"  + tipo);
        for (int i = 0; i < cantidadProductos ; i++) {
            if (inventario[i].getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                System.out.println(" - " + inventario[i].mostrarDatos());
            }
        }

}
}


