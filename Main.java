import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Comprador comprador = new Comprador();
        Localidad localidad1 = new Localidad(1, 100.0); 
        Localidad localidad5 = new Localidad(5, 500.0);
        Localidad localidad10 = new Localidad(10, 1000.0); 

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        
        System.out.println("=== BIENVENIDO AL ERAS TOUR - SISTEMA DE BOLETOS ===");
        
        // Menú principal
        while (opcion != 6) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = entrada.nextInt();
            entrada.nextLine(); 
            
            if (opcion == 1) {
                
                System.out.println("\n--- NUEVO COMPRADOR ---");
                System.out.print("Ingrese su nombre: ");
                String nombre = entrada.nextLine();
                
                System.out.print("Ingrese su email: ");
                String email = entrada.nextLine();
                
                
                comprador = new Comprador(nombre, email);
                System.out.println("Comprador registrado exitosamente!");
                
            } else if (opcion == 2) {
                
                if (comprador.getNombre() == null) {
                    System.out.println("Error: Debe registrar un comprador primero (opción 1)");
                } else {
                    System.out.println("\n--- NUEVA SOLICITUD DE BOLETOS ---");
                    System.out.println("Comprador actual: " + comprador.getNombre());
                    
                    System.out.print("Cantidad de boletos que quiere comprar: ");
                    int cantidadDeseada = entrada.nextInt();
                    
                    System.out.print("Presupuesto máximo por boleto: $");
                    double presupuesto = entrada.nextDouble();
                    
                    // Crear solicitud de compra
                    Compra compra = new Compra(comprador, cantidadDeseada, presupuesto);
                    
                    
                    if (compra.esAptoParaCompra()) {
                        System.out.println("¡Su ticket es apto para compra!");
                        
                        
                        int localidadAsignada = compra.asignarLocalidadAleatoria();
                        
                        if (localidadAsignada == 1) {
                            compra.procesarCompra(localidad1);
                        } else if (localidadAsignada == 5) {
                            compra.procesarCompra(localidad5);
                        } else {
                            compra.procesarCompra(localidad10);
                        }
                    } else {
                        System.out.println("Lo sentimos, su ticket no fue seleccionado para esta ronda.");
                    }
                }
                
            } else if (opcion == 3) {
                
                System.out.println("\n--- DISPONIBILIDAD TOTAL ---");
                System.out.println("Localidad 1 ($100): " + localidad1.getBoletosVendidos() + " vendidos, " + 
                                localidad1.getBoletosDisponibles() + " disponibles");
                System.out.println("Localidad 5 ($500): " + localidad5.getBoletosVendidos() + " vendidos, " + 
                                localidad5.getBoletosDisponibles() + " disponibles");
                System.out.println("Localidad 10 ($1000): " + localidad10.getBoletosVendidos() + " vendidos, " + 
                                localidad10.getBoletosDisponibles() + " disponibles");
                
                int totalVendidos = localidad1.getBoletosVendidos() + localidad5.getBoletosVendidos() + localidad10.getBoletosVendidos();
                int totalDisponibles = localidad1.getBoletosDisponibles() + localidad5.getBoletosDisponibles() + localidad10.getBoletosDisponibles();
                System.out.println("TOTAL: " + totalVendidos + " vendidos, " + totalDisponibles + " disponibles");
                
            } else if (opcion == 4) {
                
                System.out.println("\n--- DISPONIBILIDAD INDIVIDUAL ---");
                System.out.println("Seleccione la localidad:");
                System.out.println("1. Localidad 1 ($100)");
                System.out.println("2. Localidad 5 ($500)");
                System.out.println("3. Localidad 10 ($1000)");
                System.out.print("Opción: ");
                
                int localidadConsulta = entrada.nextInt();
                
                if (localidadConsulta == 1) {
                    System.out.println("Localidad 1: " + localidad1.getBoletosVendidos() + " vendidos, " + 
                                    localidad1.getBoletosDisponibles() + " disponibles");
                } else if (localidadConsulta == 2) {
                    System.out.println("Localidad 5: " + localidad5.getBoletosVendidos() + " vendidos, " + 
                                    localidad5.getBoletosDisponibles() + " disponibles");
                } else if (localidadConsulta == 3) {
                    System.out.println("Localidad 10: " + localidad10.getBoletosVendidos() + " vendidos, " + 
                                    localidad10.getBoletosDisponibles() + " disponibles");
                } else {
                    System.out.println("Opción incorrecta");
                }
                
            } else if (opcion == 5) {
                
                System.out.println("\n--- REPORTE DE CAJA ---");
                double totalLocalidad1 = localidad1.getDineroGenerado();
                double totalLocalidad5 = localidad5.getDineroGenerado();
                double totalLocalidad10 = localidad10.getDineroGenerado();
                double totalGeneral = totalLocalidad1 + totalLocalidad5 + totalLocalidad10;
                
                System.out.println("Localidad 1: $" + totalLocalidad1);
                System.out.println("Localidad 5: $" + totalLocalidad5);
                System.out.println("Localidad 10: $" + totalLocalidad10);
                System.out.println("TOTAL GENERADO: $" + totalGeneral);
                
            } else if (opcion == 6) {
                System.out.println("¡Gracias por usar el sistema!");
                
            } else {
                System.out.println("Opción incorrecta. Intente de nuevo.");
            }
        }
        
        entrada.close();
    }
}