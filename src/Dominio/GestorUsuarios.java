package Dominio;

import Persistencia.EscrituraDatos;
import java.util.LinkedList;

public class GestorUsuarios 
{
    private static LinkedList <Usuario> usuarios = new LinkedList();
    public static int intentos = 0;
    public static Usuario usuarioIngresado = null;
    
    public static boolean anadirUsuario(Usuario usuario)
    {
        boolean nuevo = true;
        for(Usuario user : usuarios)
        {
            if(user.getNombre().equals(usuario.getNombre()) || user.getId() == usuario.getId() || user.getNombreUsuario().equals(usuario.getNombreUsuario()))
            {
                nuevo = false;
                break;
            }
        }
        if(nuevo)
        {
            usuarios.add(usuario);
            EscrituraDatos.escribirUsuarios();
        }
        return nuevo;
    }
    
    public static void eliminarUsuario(Usuario usuario)
    {
        usuarios.remove(usuario);
        EscrituraDatos.escribirUsuarios();
    }
    
    public static boolean validarUsuario(String nombreUsuario, String contraseña)
    {
        for(Usuario usuario: usuarios)
        {
            if(usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña) && usuario.isActivo())
            {
                if(intentos >= 3)
                {
                    if(usuario.isAdmin())
                    {
                        intentos = 0;
                        usuarioIngresado = usuario;
                        return true;
                    }
                }
                else
                {
                    intentos = 0;
                    usuarioIngresado = usuario;
                    return true;
                }
            }
        }
        intentos += 1;
        return false;
    }

    public static LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }
}
