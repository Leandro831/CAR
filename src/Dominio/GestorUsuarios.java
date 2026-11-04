package Dominio;

import java.util.LinkedList;

public class GestorUsuarios 
{
    private static LinkedList <Usuario> usuarios = new LinkedList();
    public static int intentos = 0;
    public static Usuario usuarioIngresado = null;
    
    public static void anadirUsuario(Usuario usuario)
    {
        usuarios.add(usuario);
    }
    
    public static void eliminarUsuario(Usuario usuario)
    {
        usuarios.remove(usuario);
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
}
