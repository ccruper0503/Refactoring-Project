import java.io.FileWriter;
import java.io.IOException;

public class App {   
    public static double TASA_IVA = 0.21; //IVA

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("TechSolutions SL", "B12345678", "Calle Industria 55");
        Pedido pedido1 = new Pedido(cliente1);
        pedido1.agregarProducto(new Producto("Servidor Dell", 2500.0));
        pedido1.agregarProducto(new Producto("Windows Server", 800.0));
       
        ProcesarPedido(pedido1);

        Cliente cliente2 = new Cliente("Libreria Moderna", "A98765432", "Av. Diagonal 200, Barcelona");
        Pedido pedido2 = new Pedido(cliente2);
        pedido2.agregarProducto(new Producto("Pack Libros Escolares", 1200.0));
        pedido1.agregarProducto(new Producto("Estantería Metálica", 300.00));
       
        ProcesarPedido(pedido1);
    }
    private static void ProcesarPedido(Pedido pedido){

        imprimirPedido(pedido);
        generarFicheroPedido(pedido);
                                
    }
    private static void generarFicheroPedido(Pedido pedido) {
        System.out.println(String.format("Procesando pedido para: %s", pedido.getCliente().getNombre()));
        System.out.println(String.format("ID Cliente: %s", pedido.getCliente().getId()));
        for(int i = 0;  i < pedido.getListaProductos().size(); i++){
            System.out.println(String.format("Item %d: %s - %2.f EUR" , (i+1) , pedido.getListaProductos().get(i).getNombre() , pedido.getListaProductos().get(i).getPrecio()));
        }
        if(pedido.comprobarDescuento()){
            System.out.println("Aplica descuento por gran volumen (5%)");
        }
        System.out.println("Total Neto: %.2f" + pedido.calcularSubtotal());
        System.out.println(String.format("Total con IVA (%2.f %): %.2f ", (TASA_IVA * 100) , pedido.calcularSubtotalConIVA()));
        System.out.println("--------------------------------------------------");

    }
    private static void imprimirPedido(Pedido pedido) {
       try {
            FileWriter myWriter = new FileWriter("pedido_" + idCliente2 + ".txt");
            myWriter.write("FACTURA\n");
            myWriter.write("Cliente: " + nombreCliente2 + "\n");
            myWriter.write("Direccion: " + direccionCliente2 + "\n");
            myWriter.write("Total a pagar: " + t2_iva + "\n");
            myWriter.close();
            System.out.println("Archivo guardado correctamente.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    } 
}
