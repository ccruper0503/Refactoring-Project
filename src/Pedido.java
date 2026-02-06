import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    public static double TASA_IVA = 0.21; //IVA
    public static double DESCUENTO = 0.95; //DESCUENTO



    private ArrayList<Producto> listaProductos = new ArrayList<>();

    public Pedido (Cliente cliente){
        this.cliente = cliente;
    }

    public void agregarProducto (Producto producto){
        listaProductos.add(producto);
    }

    public ArrayList<Producto> getListaProductos(){
        return listaProductos;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public double calcularSubtotal(){

        double subtotal = 0;
        for (Producto producto : listaProductos) {
            subtotal = subtotal + producto.getPrecio();
        }
        
        return subtotal;
    }
    
    public double calcularDescuento(){
        double subtotal = calcularSubtotal();
        
        subtotal = subtotal * DESCUENTO;
        return subtotal;

    }

    public boolean comprobarDescuento(){
        double subtotal = calcularSubtotal();        
        if(subtotal > 3000){
            return true;
        }else{
            return false;
        }

    }


    public double calcularSubtotalConIVA(){
        double subtotal = calcularSubtotal();

        subtotal = subtotal + (subtotal * TASA_IVA);
        
        return subtotal;  
    }
                 
}