package Persistencia;

import Dominio.GestorInventario;
import Dominio.GestorUsuarios;
import Dominio.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LecturaDatos 
{
    protected static void leerProductos()
    {
        BufferedReader lectura = null;
        try
        {
            lectura = new BufferedReader(new FileReader(new File("ArchivosPersistencia/inventario.txt")));
            String linea = lectura.readLine();
            while(!linea.equals(""))
            {
                String[] producto = linea.split(";");
                GestorInventario.registrarProducto(Long.parseLong(producto[0]), producto[1], Integer.parseInt(producto[2]), Float.parseFloat(producto[3]), producto[4], producto[5]);
                linea = lectura.readLine();
            }
        }
        catch(Exception error)
        {
            System.out.println("Error en lectura de productos: " + error.getMessage());
        }
        finally
        {
            try
            {
                lectura.close();
            }
            catch(Exception error)
            {
                System.out.println("Error: " + error.getMessage());
            }
        }
    }
    
    protected static void leerUsuarios()
    {
        BufferedReader lectura = null;
        try
        {
            lectura = new BufferedReader(new FileReader(new File("ArchivosPersistencia/usuarios.txt")));
            String linea = lectura.readLine();
            while(linea != null)
            {
                String[] producto = linea.split(";");
                GestorUsuarios.anadirUsuario(new Usuario(Long.parseLong(producto[0]), producto[1], producto[2], producto[3], Boolean.parseBoolean(producto[4]), Boolean.parseBoolean(producto[5])));
                linea = lectura.readLine();
            }
        }
        catch(Exception error)
        {
            System.out.println("Error en lectura de usuarios: " + error.getMessage());
        }
        finally
        {
            try
            {
                lectura.close();
            }
            catch(Exception error)
            {
                System.out.println("Error: " + error.getMessage());
            }
        }
    }
}
