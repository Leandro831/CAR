package Persistencia;

import Dominio.GestorInventario;
import Dominio.GestorUsuarios;
import Dominio.Producto;
import Dominio.Usuario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class EscrituraDatos 
{
    protected static void escribirProductos()
    {
        BufferedWriter escritura = null;
        try
        {
            escritura = new BufferedWriter(new FileWriter(new File("ArchivosPersistencia/inventario.txt")));
            for(Producto producto: GestorInventario.getProductos())
            {
                escritura.write(producto.toString());
            }
        }
        catch(Exception error)
        {
            System.out.println("Error: " + error.getMessage());
        }
        finally
        {
            try
            {
                escritura.close();
            }
            catch(Exception error)
            {
                System.out.println("Error: " + error.getMessage());
            }
        }
    }
    
    protected static void escribirUsuarios()
    {
        BufferedWriter escritura = null;
        try
        {
            escritura = new BufferedWriter(new FileWriter(new File("ArchivosPersistencia/usuarios.txt")));
            for(Usuario usuario: GestorUsuarios.getUsuarios())
            {
                escritura.write(usuario.toString());
            }
        }
        catch(Exception error)
        {
            System.out.println("Error: " + error.getMessage());
        }
        finally
        {
            try
            {
                escritura.close();
            }
            catch(Exception error)
            {
                System.out.println("Error: " + error.getMessage());
            }
        }
    }
}
