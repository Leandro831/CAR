package Dominio;

public class Usuario 
{
    private long id;
    private String nombre;
    private String nombreUsuario;
    private String contraseña;
    private boolean activo;
    private boolean admin;

    public Usuario(long id, String nombre, String nombreUsuario, String contraseña, boolean activo, boolean admin) 
    {
        this.id = id;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.activo = activo;
        this.admin = admin;
    }

    public long getId() 
    {
        return this.id;
    }

    public String getNombre() 
    {
        return this.nombre;
    }

    public String getNombreUsuario() 
    {
        return this.nombreUsuario;
    }

    public String getContraseña() 
    {
        return this.contraseña;
    }

    public boolean isActivo() 
    {
        return this.activo;
    }
    
    public boolean isAdmin()
    {
        return this.admin;
    }
    
    public void actualizarUsuario(long id, String nombre, String nombreUsuario, String contraseña, boolean activo) 
    {
        this.id = id;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.activo = activo;
    }
}
