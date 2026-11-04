package Dominio;

public class Producto 
{
    private int id;
    private String nombre;
    private int cantidad;
    private float precio;
    private String proveedor;
    private String categoria;

    public Producto(int id, String nombre, int cantidad, float precio, String proveedor, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.proveedor = proveedor;
        this.categoria = categoria;
    }
    
    public void actualizar(int id, String nombre, int cantidad, float precio, String proveedor, String categoria)
    {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.proveedor = proveedor;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public void aumentarStock(int cantidad)
    {
        this.cantidad += cantidad;
    }
    
    public boolean reducirStock(int cantidad)
    {
        if(this.cantidad < cantidad)
        {
            return false;
        }
        else
        {
            this.cantidad -= cantidad;
            return true;
        }
    }
}
