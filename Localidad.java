public class Localidad {
    private int numero;              
    private double precio;           
    private int boletosDisponibles;  
    private int boletosVendidos;     
    private double dineroGenerado;   
    
    
    public Localidad(int numero, double precio) {
        this.numero = numero;
        this.precio = precio;
        this.boletosDisponibles = 20;  
        this.boletosVendidos = 0;
        this.dineroGenerado = 0.0;
    }
    
    
    public boolean venderBoletos(int cantidad) {
        if (cantidad <= 0) {
            return false;
        }
        
        if (cantidad > boletosDisponibles) {
            return false;
        }
        
        
        boletosDisponibles = boletosDisponibles - cantidad;
        boletosVendidos = boletosVendidos + cantidad;
        dineroGenerado = dineroGenerado + (cantidad * precio);
        
        return true;
    }
    
    
    public boolean hayDisponibilidad() {
        if (boletosDisponibles > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public boolean puedeComprar(int cantidad) {
        if (cantidad <= boletosDisponibles) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public int getNumero() {
        return numero;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public int getBoletosDisponibles() {
        return boletosDisponibles;
    }
    
    public int getBoletosVendidos() {
        return boletosVendidos;
    }
    
    public double getDineroGenerado() {
        return dineroGenerado;
    }
    
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void setBoletosDisponibles(int boletosDisponibles) {
        this.boletosDisponibles = boletosDisponibles;
    }
    
    public void setBoletosVendidos(int boletosVendidos) {
        this.boletosVendidos = boletosVendidos;
    }
    
    public void setDineroGenerado(double dineroGenerado) {
        this.dineroGenerado = dineroGenerado;
    }
}