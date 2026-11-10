package Graficos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.Timer;

public class SwitchBoton extends JComponent {

    private boolean activo = true;
    private float posicion = 1f;
    private Timer animacion;

    private Color colorActivo = new Color(204, 0, 0);
    private Color colorInactivo = new Color(180, 180, 180);
    private Color colorBola = Color.WHITE;

    private Runnable alCambiar;

    public SwitchBoton() {
        setPreferredSize(new Dimension(54, 28));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (isEnabled()) {
                    setActivo(!activo);
                    if (alCambiar != null) alCambiar.run();
                }
            }
        });
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean valor) {
        this.activo = valor;
        animar();
    }

    public void setAlCambiar(Runnable accion) {
        this.alCambiar = accion;
    }

    private void animar() {
        if (animacion != null && animacion.isRunning()) animacion.stop();
        final float destino = activo ? 1f : 0f;
        animacion = new Timer(10, e -> {
            float paso = 0.12f;
            if (posicion < destino) posicion = Math.min(posicion + paso, destino);
            else posicion = Math.max(posicion - paso, destino);

            repaint();
            if (posicion == destino) ((Timer) e.getSource()).stop();
        });
        animacion.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Fondo: mezcla entre gris y rojo según la posición
        g2.setColor(mezclar(colorInactivo, colorActivo, posicion));
        g2.fillRoundRect(0, 0, w, h, h, h);

        // Bolita
        int margen = 3;
        int diametro = h - margen * 2;
        int x = (int) (margen + (w - diametro - margen * 2) * posicion);
        g2.setColor(colorBola);
        g2.fillOval(x, margen, diametro, diametro);

        g2.dispose();
    }

    private Color mezclar(Color a, Color b, float t) {
        int r = (int) (a.getRed() + (b.getRed() - a.getRed()) * t);
        int gr = (int) (a.getGreen() + (b.getGreen() - a.getGreen()) * t);
        int bl = (int) (a.getBlue() + (b.getBlue() - a.getBlue()) * t);
        return new Color(r, gr, bl);
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setCursor(Cursor.getPredefinedCursor(
                enabled ? Cursor.HAND_CURSOR : Cursor.DEFAULT_CURSOR));
        repaint();
    }
}