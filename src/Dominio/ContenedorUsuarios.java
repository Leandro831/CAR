package Dominio;

import java.util.ArrayList;

public class ContenedorUsuarios 
{
    private ArrayList <Usuario> usuarios;
    
    public ContenedorUsuarios()
    {
        this.usuarios = new ArrayList();
        this.usuarios.add(new Usuario(1, "Admin1", "@Admin1.usuario.nombre", "contrasenaSuperSecreta88", true));
    }
    
    public void anadirUsuario(Usuario usuario)
    {
        this.usuarios.add(usuario);
    }
    
    public void eliminarUsuario(Usuario usuario)
    {
        this.usuarios.remove(usuario);
    }
    
    public boolean validarUsuario(String nombreUsuario, String contraseña)
    {
        for(Usuario usuario: this.usuarios)
        {
            if(usuario.getNombreUsuario().equals(nombreUsuario))
            {
                if(usuario.getContraseña().equals(contraseña))
                {
                    if(usuario.isActivo())
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
