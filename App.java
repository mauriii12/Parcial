public class App {

public static void main(String[] args) {
    



    productoOficina  p1 = new productoOficina("HJA4", "Hojas A4",2000 , "BIC");
    productoTecnologico p2 = new productoTecnologico("IPHN", "Telefono Iphone 13", 1000000, 6);
    productoOficina p3 = new productoOficina("LPA", "Lapicera azul BIC", 200, "BIC");
    productoOficina p4 = new productoOficina("Ecr", "Escritorio de madera 30x40", 150000, "ALSESIN");


    
    add.Producto(p1);
    add.Producto(p2);
    add.Producto(p3);
    add.Producto(p4);

    System.out.println(Tienda.mostrarInventario());



}

}
