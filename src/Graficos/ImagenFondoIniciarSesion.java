package Graficos;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public class ImagenFondoIniciarSesion extends JPanel
{
    private Image imagen;
    
    public ImagenFondoIniciarSesion()
    {
        imagen = new ImageIcon(getClass().getResource("/Imagenes/Imagen_Iniciar_Sesion.png")).getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
