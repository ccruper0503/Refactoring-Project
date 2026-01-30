import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SistemaPedidos {

    // Variables globales mal ubicadas y poco descriptivas
    public static double TASA_IVA = 0.21; // Esto es el IVA
    public static String f = "reporte_pedidos.txt"; // Archivo de salida

    public static void main(String[] args) {
        System.out.println("INICIANDO SISTEMA DE PEDIDOS v1.0...");

        // --- CLIENTE 1: Datos dispersos ---
        String nombreCliente1 = "TechSolutions SL";
        String idCliente1 = "B12345678";
        String direccionCliente1 = "Calle Industria 55, Madrid";

        // --- CLIENTE 1: Lista de productos (Arrays paralelos, mala práctica) ---
        ArrayList<String> nombreProducto = new ArrayList<>(); // Nombres productos
        nombreProducto.add("Servidor Dell PowerEdge");
        nombreProducto.add("Licencia Windows Server");
        nombreProducto.add("Cableado Estructurado");

        ArrayList<Double> precioProducto = new ArrayList<>(); // Precios productos
        precioProducto.add(2500.00);
        precioProducto.add(800.00);
        precioProducto.add(250.50);

        // --- CLIENTE 1: CÁLCULOS (Mezclados con impresión) ---
        double total1 = 0; // total
        System.out.println("Procesando pedido para: " + nombreCliente1);
        System.out.println("ID Cliente: " + idCliente1);

        for (int i = 0; i < nombreProducto.size(); i++) {
            total1 = total1 + precioProducto.get(i);
            System.out.println("Item " + (i+1) + ": " + nombreProducto.get(i) + " - " + precioProducto.get(i) + " EUR");
        }

        // Lógica de descuento "hardcodeada"
        if (total1 > 3000) {
            System.out.println("Aplica descuento por gran volumen (5%)");
            total1 = total1 * 0.95;
        }

        double t1_iva = total1 + (total1 * TASA_IVA);

        System.out.println("Total Neto: " + total1);
        System.out.println("Total con IVA (" + (TASA_IVA*100) + "%): " + t1_iva);
        System.out.println("---");

        // --- CLIENTE 1: GUARDADO EN ARCHIVO (Responsabilidad mezclada) ---
        try {
            FileWriter myWriter = new FileWriter("pedido_" + idCliente1 + ".txt");
            myWriter.write("FACTURA\n");
            myWriter.write("Cliente: " + nombreCliente1 + "\n");
            myWriter.write("Direccion: " + direccionCliente1 + "\n");
            myWriter.write("Total a pagar: " + t1_iva + "\n");
            myWriter.close();
            System.out.println("Archivo guardado correctamente.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("\n\n"); // Espacios feos

        // --- CLIENTE 2: COPY-PASTE DEL CÓDIGO ANTERIOR (El horror) ---
        // ---

        String nombreCliente2 = "Libreria Moderna";
        String idCliente2 = "A98765432";
        String direccionCliente2 = "Av. Diagonal 200, Barcelona";

        ArrayList<String> p_n2 = new ArrayList<>();
        p_n2.add("Pack Libros Escolares");
        p_n2.add("Estantería Metálica");

        ArrayList<Double> p_p2 = new ArrayList<>();
        p_p2.add(1200.00);
        p_p2.add(300.00);

        double t2 = 0;
        System.out.println("Procesando pedido para: " + nombreCliente2);
        System.out.println("ID Cliente: " + idCliente2);

        for (int i = 0; i < p_n2.size(); i++) {
            t2 = t2 + p_p2.get(i);
            System.out.println("Item " + (i+1) + ": " + p_n2.get(i) + " - " + p_p2.get(i) + " EUR");
        }

        // Lógica de descuento repetida (y si cambiamos una, la otra se queda desactualizada)
        if (t2 > 3000) {
            System.out.println("Aplica descuento por gran volumen (5%)");
            t2 = t2 * 0.95;
        }

        double t2_iva = t2 + (t2 * TASA_IVA);

        System.out.println("Total Neto: " + t2);
        System.out.println("Total con IVA (" + (TASA_IVA*100) + "%): " + t2_iva);
        System.out.println("---");

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