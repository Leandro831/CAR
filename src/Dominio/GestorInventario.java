package Dominio;

import java.util.LinkedList;
import java.util.ArrayList;

public class GestorInventario 
{
    private static LinkedList <Producto> productos = new LinkedList();
    private static ArrayList <String> listaCategorias = new ArrayList();
    
    public static void registrarProducto(long id, String nombre, int cantidad, float precio, String proveedor, String categoria)
    {
        if(!listaCategorias.contains(categoria))
        {
            listaCategorias.add(categoria);
        }
        productos.add(new Producto(id, nombre, cantidad, precio, proveedor, categoria));
    }
    
    public static void registrarEntrada(int indice, int cantidad)
    {
        productos.get(indice).aumentarStock(cantidad);
    }
    
    public static boolean registrarSalida(int indice, int cantidad)
    {
        return productos.get(indice).reducirStock(cantidad);
    }
    
    public static void actualizarProducto(int indice, String nombre, float precio, String proveedor, String categoria)
    {
        productos.get(indice).actualizar(nombre, precio, proveedor, categoria);
    }

    public static LinkedList<Producto> getProductos() 
    {
        return productos;
    }
}
