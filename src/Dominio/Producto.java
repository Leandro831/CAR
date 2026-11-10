package Dominio;

public class Producto 
{
    private long id;
    private String nombre;
    private int cantidad;
    private float precio;
    private String proveedor;
    private String categoria;

    public Producto(long id, String nombre, int cantidad, float precio, String proveedor, String categoria) 
    {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.proveedor = proveedor;
        this.categoria = categoria;
    }
    
    public void actualizar(String nombre, float precio, String proveedor, String categoria)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
        this.categoria = categoria;
    }

    public long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public float getPrecio() {
        return this.precio;
    }

    public String getProveedor() {
        return this.proveedor;
    }

    public String getCategoria() {
        return this.categoria;
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
    
    @Override
    public String toString()
    {
        return this.id + ";" + this.nombre + ";" + this.cantidad + ";" + this.precio + ";" + this.proveedor + ";"+ this.categoria;
    }
}
