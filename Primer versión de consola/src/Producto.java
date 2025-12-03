public class Producto {
    
    private static int contadorId = 1;
    private int idProducto;
    private String nombre;
    private Double precio;
    private int stock;    

    public Producto(){  
        idProducto = contadorId; //Asigno el id
        contadorId++;    
    }
    public Producto(String nombre, Double precio, int stock) {
        idProducto = contadorId; //Asigno el id
        contadorId++;       //Incremento el id para asignárselo a la siguiente instancia 
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    public int getIdProducto() {
        /*Solo defino un getter para el id 
        y no un método setter porque no 
        deseo que se pueda modificar este atributo
        */
        return idProducto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    @Override
    public String toString() {
        return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock
                + "]";
    }
    
}
