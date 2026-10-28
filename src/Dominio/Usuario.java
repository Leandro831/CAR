package Dominio;

public class Usuario 
{
    private long id;
    private String nombre;
    private String nombreUsuario;
    private String contraseña;
    private boolean activo;

    public Usuario(long id, String nombre, String nombreUsuario, String contraseña, boolean activo) 
    {
        this.id = id;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.activo = activo;
    }

    public long getId() 
    {
        return id;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public String getNombreUsuario() 
    {
        return nombreUsuario;
    }

    public String getContraseña() 
    {
        return contraseña;
    }

    public boolean isActivo() 
    {
        return activo;
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
