import java.util.Random;

public class Compra {
    private Comprador comprador;
    private int cantidadBoletosDeseados;
    private double presupuestoMaximo;
    private int numeroTicket;
    
    
    public Compra(Comprador comprador, int cantidadBoletosDeseados, double presupuestoMaximo) {
        this.comprador = comprador;
        this.cantidadBoletosDeseados = cantidadBoletosDeseados;
        this.presupuestoMaximo = presupuestoMaximo;
        this.numeroTicket = generarNumeroTicket();
    }
    
    
    private int generarNumeroTicket() {
        Random random = new Random();
        return random.nextInt(15000) + 1;
    }
    
    
    public boolean esAptoParaCompra() {
        Random random = new Random();
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;
        
        
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        System.out.println("Su número de ticket: " + numeroTicket);
        System.out.println("Rango generado: " + a + " - " + b);
        
        
        if (numeroTicket >= a && numeroTicket <= b) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public int asignarLocalidadAleatoria() {
        Random random = new Random();
        int opcion = random.nextInt(3) + 1;
        
        if (opcion == 1) {
            return 1;
        } else if (opcion == 2) {
            return 5;
        } else {
            return 10;
        }
    }
    
    
    public void procesarCompra(Localidad localidad) {
        System.out.println("\n--- PROCESANDO COMPRA ---");
        System.out.println("Localidad asignada: Localidad " + localidad.getNumero() + " ($" + localidad.getPrecio() + ")");
        
        
        if (localidad.getBoletosDisponibles() == 0) {
            System.out.println("Lo sentimos, esta localidad está completamente vendida.");
            return;
        }
        
        
        if (presupuestoMaximo < localidad.getPrecio()) {
            System.out.println("Lo sentimos, su presupuesto ($" + presupuestoMaximo + ") es insuficiente para esta localidad ($" + localidad.getPrecio() + ").");
            return;
        }
        
        
        int cantidadAVender = cantidadBoletosDeseados;
        if (cantidadAVender > localidad.getBoletosDisponibles()) {
            cantidadAVender = localidad.getBoletosDisponibles();
            System.out.println("Solo podemos venderle " + cantidadAVender + " boletos (disponibilidad limitada).");
        }
        
        
        boolean ventaExitosa = localidad.venderBoletos(cantidadAVender);
        
        if (ventaExitosa) {
            double totalPagado = cantidadAVender * localidad.getPrecio();
            System.out.println("¡VENTA EXITOSA!");
            System.out.println("Comprador: " + comprador.getNombre());
            System.out.println("Boletos vendidos: " + cantidadAVender);
            System.out.println("Precio por boleto: $" + localidad.getPrecio());
            System.out.println("Total pagado: $" + totalPagado);
        } else {
            System.out.println("Error en la venta. Intente nuevamente.");
        }
    }
    
    
    public Comprador getComprador() {
        return comprador;
    }
    
    public int getCantidadBoletosDeseados() {
        return cantidadBoletosDeseados;
    }
    
    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }
    
    public int getNumeroTicket() {
        return numeroTicket;
    }
}