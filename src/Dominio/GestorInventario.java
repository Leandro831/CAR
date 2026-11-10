package Dominio;

import Persistencia.EscrituraDatos;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class GestorInventario 
{
    private static LinkedList<Producto> productos = new LinkedList();
    private static ArrayList <String> listaCategorias = new ArrayList();
    
    public static String registrarProducto(long id, String nombre, int cantidad, float precio, String proveedor, String categoria)
    {
        for(Producto producto: productos)
        {
            if(producto.getNombre().equals(nombre))
                return "Nombre igual";
            else if(producto.getId() == id)
                return "ID Igual";
        }
        cargarProducto(id, nombre, cantidad, precio, proveedor, categoria);
        EscrituraDatos.escribirProductos();
        return "valido";
    }
    
    public static void cargarProducto(long id, String nombre, int cantidad, float precio, String proveedor, String categoria)
    {
        if(!listaCategorias.contains(categoria))
        {
            listaCategorias.add(categoria);
            Collections.sort(listaCategorias);
        }
        productos.add(new Producto(id, nombre, cantidad, precio, proveedor, categoria));
    }
    
    public static void registrarEntrada(int indice, int cantidad)
    {
        productos.get(indice).aumentarStock(cantidad);
        EscrituraDatos.escribirProductos();
    }
    
    public static boolean registrarSalida(int indice, int cantidad)
    {
        boolean funciona = productos.get(indice).reducirStock(cantidad);
        EscrituraDatos.escribirProductos();
        return funciona;
    }
    
    public static boolean actualizarProducto(int indice, String nombre, float precio, String proveedor, String categoria)
    {
        if (indice < 0 || indice >= productos.size() || categoria == null || categoria.isBlank())
            return false;
        for (int i = 0; i < productos.size(); i++)
        {
            if (i != indice && productos.get(i).getNombre().equals(nombre))
                return false;
        }
        if(!listaCategorias.contains(categoria))
        {
            listaCategorias.add(categoria);
            Collections.sort(listaCategorias);
        }
        productos.get(indice).actualizar(nombre, precio, proveedor, categoria);
        EscrituraDatos.escribirProductos();
        return true;
    }

    public static LinkedList<Producto> getProductos() 
    {
        return productos;
    }

    public static ArrayList<String> getListaCategorias() 
    {
        return listaCategorias;
    }
    
    public static void eliminar(Producto producto)
    {
        if (producto != null && productos.remove(producto))
            EscrituraDatos.escribirProductos();
    }
    
    public static Producto buscarNombre(String nombre)
    {
        for(Producto producto: productos)
        {
            if(producto.getNombre().equals(nombre))
                return producto;
        }
        return null;
    }
    
    public static Producto buscarID(Long Id)
    {
        for(Producto producto: productos)
        {
            if(producto.getId() == Id)
                return producto;
        }
        return null;
    }
}
