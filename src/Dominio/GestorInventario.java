package Dominio;

import java.util.LinkedList;

public class GestorInventario 
{
    private static LinkedList <Producto> productos = new LinkedList();
    
    public static void registrarProducto(int id, String nombre, int cantidad, float precio, String proveedor, String categoria)
    {
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
    
    public static void actualizarProducto(int indice, int id, String nombre, int cantidad, float precio, String proveedor, String categoria)
    {
        productos.get(indice).actualizar(id, nombre, cantidad, precio, proveedor, categoria);
    }
}
