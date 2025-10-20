import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Definición de variables
        ArrayList<Producto> productos = new ArrayList<Producto>();
        int opcionUsuario;        
        Scanner entrada = new Scanner(System.in);
        //Inicio del loop
        while(true){        
            mostrarMenu();
            opcionUsuario = entrada.nextInt();
            switch (opcionUsuario) {
                case 0 -> { 
                    System.out.println(Colores.VERDE+"Salió correctamente."+Colores.RESET);
                    break;
                } 
                case 1 -> agregarProducto(entrada, productos);  
                case 2 -> editarProducto(entrada, productos);     
                case 3 -> listarProductos(productos);    
                case 4 -> eliminarProducto(entrada, productos);
                default -> System.out.println(Colores.ROJO+"La opción ingresada no es válida."+Colores.RESET);                    
            }
        }    
    }

    public static void mostrarMenu(){
        System.out.println(Colores.VERDE_CLARO+"-----------------------------------------------------"+Colores.RESET);
        System.out.println(Colores.CYAN + "Aplicación de compras" + Colores.RESET);
        System.out.println(Colores.VERDE_CLARO+"-----------------------------------------------------"+Colores.RESET);
        System.out.println("Elija una opción:");
        System.out.println("-----------------------------------------------------");
        System.out.println("0 - Salir");
        System.out.println(Colores.VERDE + "1 - Cargar producto" + Colores.RESET);
        System.out.println(Colores.AMARILLO + "2 - Editar producto" + Colores.RESET);
        System.out.println(Colores.AZUL + "3 - Listar productos" + Colores.RESET);
        System.out.println(Colores.ROJO + "4 - Eliminar producto" + Colores.RESET);
        System.out.println("-----------------------------------------------------");
    }
    public static void agregarProducto(Scanner entrada, ArrayList<Producto> productos){
        Producto prod = crearProducto(entrada);
        if(prod != null){
            productos.add(prod);
        }
    }
    public static Producto crearProducto(Scanner entrada){
        Producto prod = new Producto();
        boolean exito = false; /*El objetivo de esta variable es funcionar como corte de 
        control cuando se ingrese una opción válida */
        entrada.nextLine();
        while (!exito){      
            try {                                 
                System.out.println("Ingrese el nombre del producto:");
                prod.setNombre(entrada.nextLine());
                System.out.println("Ingrese el precio del producto:");
                prod.setPrecio(Double.parseDouble(entrada.nextLine()));
                System.out.println("Ingrese el stock del producto:");
                prod.setStock(Integer.parseInt(entrada.nextLine()));
                exito = true;
                System.out.println("-----------------------------------------------------");
                System.out.println(Colores.VERDE+"Se creó el producto "+prod.getNombre()+"."+Colores.RESET);            
            } catch (NumberFormatException e) {
                System.out.println(Colores.ROJO+"Error: El valor ingresado no es válido."+Colores.RESET);
                prod = null;
            }
        }
        return prod;
    }
    public static void listarProductos(ArrayList<Producto> productos){
        for(Producto p: productos){
            System.out.println(Colores.AZUL+p+Colores.RESET);
        }
    }
    public static void eliminarProducto(Scanner entrada, ArrayList<Producto> productos){
        int idProducto;
        System.out.println("Ingrese el id del producto que desea eliminar (0 para cancelar):");
        idProducto = entrada.nextInt();
        if(idProducto != 0){
            boolean resultado = productos.removeIf(p -> p.getIdProducto() == idProducto);
            if(resultado){
                System.out.println("-----------------------------------------------------");
                System.out.println(Colores.VERDE+"Se eleminó el producto correctamente."+Colores.RESET);
            } else {
                System.out.println("No se encontró el producto.");
            }
        }
    }
    public static Producto buscarProductoPorId(int idProducto, ArrayList<Producto> productos){
        Producto ret = null;
        for(Producto prod: productos){
            if(prod.getIdProducto() == idProducto){
                ret = prod;
                break;
            }
        }
        return ret;
    }
    public static void editarProducto(Scanner entrada, ArrayList<Producto> productos){
        int idProducto;
        int opcionElegida;
        Producto prod;
        boolean exito = false; /*El objetivo de esta variable es funcionar como corte de 
        control cuando se ingrese una opción válida */
        System.out.println("Ingrese el id del producto que desea editar (0 para cancelar):");
        idProducto = entrada.nextInt();
        if(idProducto != 0){
            prod = buscarProductoPorId(idProducto, productos);
            if(prod != null){
                System.out.println("""
                    ¿Qué campo desea editar?
                    1 - Nombre
                    2 - Precio
                    3 - Stock
                    4 - Todos
                    5 - Cancelar
                    """);
                    opcionElegida = entrada.nextInt();
                    entrada.nextLine();
                    switch (opcionElegida) {
                        case 0 :
                            System.out.println("Se canceló la edición.");
                            break;                        
                        case 1 :
                            System.out.println("Elegiste la opción EDITAR NOMBRE");
                            System.out.println("El nombre actual es: "+prod.getNombre());
                            System.out.println("Ingrese el nuevo nombre: ");
                            prod.setNombre(entrada.nextLine());
                            System.out.println("-----------------------------------------------------");
                            System.out.println(Colores.VERDE+"Se editó el nombre correctamente."+Colores.RESET);
                            break;
                        case 2 :
                            while(!exito){                            
                                try { 
                                    System.out.println("Elegiste la opción EDITAR PRECIO");
                                    System.out.println("El precio actual es: "+prod.getPrecio());
                                    System.out.println("Ingrese el nuevo precio: ");
                                    prod.setPrecio(Double.parseDouble(entrada.nextLine()));
                                    exito = true;
                                    System.out.println("-----------------------------------------------------");
                                    System.out.println(Colores.VERDE+"Se editó el precio correctamente."+Colores.RESET);
                                } catch (NumberFormatException e) {
                                    System.out.println(Colores.ROJO+"Error: El precio ingresado no es válido." + Colores.RESET);
                                }
                            } 
                            exito = false;
                            break;
                        case 3 :
                            while(!exito){   
                                try { 
                                    System.out.println("Elegiste la opción EDITAR STOCK");
                                    System.out.println("El stock actual es: "+prod.getStock());
                                    System.out.println("Ingrese el nuevo stock: ");
                                    prod.setStock(Integer.parseInt(entrada.nextLine()));
                                    exito = true;
                                    System.out.println("-----------------------------------------------------");
                                    System.out.println(Colores.VERDE+"Se editó el stock correctamente."+Colores.RESET);
                                } catch (NumberFormatException e) {
                                    System.out.println(Colores.ROJO+"Error: El stock ingresado no es válido."+Colores.RESET);
                                }
                            }
                            exito = false;
                            break;
                        case 4 :
                            while(!exito){   
                                try { 
                                    System.out.println("Elegiste la opción EDITAR TODOS");
                                    System.out.println("Nombre actual: " + prod.getNombre());
                                    System.out.println("Ingrese el nombre del producto:");
                                    prod.setNombre(entrada.nextLine());
                                    System.out.println("Precio actual: " + prod.getPrecio());
                                    System.out.println("Ingrese el precio del producto:");
                                    prod.setPrecio(Double.parseDouble(entrada.nextLine()));
                                    System.out.println("Stock actual: " + prod.getStock());
                                    System.out.println("Ingrese el stock del producto:");
                                    prod.setStock(Integer.parseInt(entrada.nextLine()));
                                    exito = true;
                                    System.out.println("-----------------------------------------------------");
                                    System.out.println(Colores.VERDE+"Se editó el producto correctamente."+Colores.RESET);
                                } catch (NumberFormatException e) {
                                    System.out.println(Colores.ROJO+"Error: El valor ingresado no es válido."+Colores.RESET);
                                }
                            } 
                            exito = false;
                            break;
                        case 5:
                            System.out.println("-----------------------------------------------------");
                            System.out.println(Colores.AMARILLO+"Se canceló la edición."+Colores.RESET);
                        default : 
                            System.out.println("-----------------------------------------------------");
                            System.out.println("La opción ingresada no es válida.");   
                    }

            } else {
                System.out.println("No se encontró el producto con el id "+idProducto+".");
            }
        }
    }
}
 