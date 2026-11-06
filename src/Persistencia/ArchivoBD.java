package Persistencia;

public class ArchivoBD 
{
    public static void cargarDatos()
    {
        LecturaDatos.leerProductos();
        LecturaDatos.leerUsuarios();
    }
    
    public static void guardarDatos()
    {
        EscrituraDatos.escribirProductos();
        EscrituraDatos.escribirUsuarios();
    }
}
