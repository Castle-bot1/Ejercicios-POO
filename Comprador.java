public class Comprador {
    private String nombre;
    private String email;
    
    
    public Comprador() {
        this.nombre = null;
        this.email = null;
    }
    
    
    public Comprador(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    
    public String getNombre() {
        return nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}