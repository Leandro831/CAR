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
    public static void escribirProductos()
    {
        try(BufferedWriter escritura = new BufferedWriter(new FileWriter(new File("ArchivosPersistencia/inventario.txt"))))
        {
            for(Producto producto: GestorInventario.getProductos())
            {
                escritura.write(producto.toString() + "\n");
            }
        }
        catch(Exception error)
        {
            System.out.println("Error: " + error.getMessage());
        }
    }
    
    public static void escribirUsuarios()
    {
        try(BufferedWriter escritura = new BufferedWriter(new FileWriter(new File("ArchivosPersistencia/usuarios.txt"))))
        {
            for(Usuario usuario: GestorUsuarios.getUsuarios())
            {
                escritura.write(usuario.toString() + "\n");
            }
        }
        catch(Exception error)
        {
            System.out.println("Error: " + error.getMessage());
        }
    }
}
