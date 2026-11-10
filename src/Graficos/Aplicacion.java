package Graficos;

import javax.swing.Timer;
import Dominio.GestorUsuarios;
import java.util.logging.Logger;
import Persistencia.LecturaDatos;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class Aplicacion extends javax.swing.JFrame 
{    
    private static final Logger logger = Logger.getLogger(Aplicacion.class.getName());
    
    public Aplicacion()
    {
        this.pantallaInicio = new PantallaPrincipal();
        this.pantallaCargando = new CuadroBlancoCargando(30);
        initComponents();
        this.setLocationRelativeTo(null);
        this.campoIngresarContraseña.setEchoChar((char) 0);
        this.pantallaInicio.menuPerfiles.botonCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cerrarSesionMousePressed(evt);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenFondoInicioSesion = new ImagenFondoIniciarSesion();
        cuadroBlancoInicioSesion = new PanelRedondeado(30);
        logoAppCarInicioSesion = new LogoCar();
        textoIngresarUsuario = new javax.swing.JLabel();
        campoIngresarUsuario = new javax.swing.JTextField();
        textoIngresarContraseña = new javax.swing.JLabel();
        campoIngresarContraseña = new javax.swing.JPasswordField();
        botonIniciarSesion = new BotonRedondeado(50);
        mensajeError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CAR");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        imagenFondoInicioSesion.setBackground(new java.awt.Color(102, 102, 102));
        imagenFondoInicioSesion.setForeground(new java.awt.Color(234, 234, 234));
        imagenFondoInicioSesion.setPreferredSize(new java.awt.Dimension(1280, 720));

        cuadroBlancoInicioSesion.setBackground(new java.awt.Color(234, 234, 234, 204));
        cuadroBlancoInicioSesion.setForeground(new java.awt.Color(0, 0, 153));
        cuadroBlancoInicioSesion.setOpaque(false);
        cuadroBlancoInicioSesion.setPreferredSize(new java.awt.Dimension(1000, 600));

        logoAppCarInicioSesion.setBackground(new java.awt.Color(255, 255, 255, 0));
        logoAppCarInicioSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logoAppCarInicioSesion.setPreferredSize(new java.awt.Dimension(768, 325));

        javax.swing.GroupLayout logoAppCarInicioSesionLayout = new javax.swing.GroupLayout(logoAppCarInicioSesion);
        logoAppCarInicioSesion.setLayout(logoAppCarInicioSesionLayout);
        logoAppCarInicioSesionLayout.setHorizontalGroup(
            logoAppCarInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        logoAppCarInicioSesionLayout.setVerticalGroup(
            logoAppCarInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        textoIngresarUsuario.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        textoIngresarUsuario.setText("Ingrese su usuario");
        textoIngresarUsuario.setName(""); // NOI18N
        textoIngresarUsuario.setPreferredSize(new java.awt.Dimension(94, 16));

        campoIngresarUsuario.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        campoIngresarUsuario.setForeground(new java.awt.Color(200, 200, 200));
        campoIngresarUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoIngresarUsuario.setText("Ej. UsernameExample67");
        campoIngresarUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));
        campoIngresarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        campoIngresarUsuario.setSelectionColor(new java.awt.Color(0, 102, 255));
        campoIngresarUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoIngresarUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoIngresarUsuarioFocusLost(evt);
            }
        });
        campoIngresarUsuario.addActionListener(this::campoIngresarUsuarioActionPerformed);

        textoIngresarContraseña.setFont(new java.awt.Font("Inter", 0, 24)); // NOI18N
        textoIngresarContraseña.setText("Ingrese su contraseña");

        campoIngresarContraseña.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        campoIngresarContraseña.setForeground(new java.awt.Color(200, 200, 200));
        campoIngresarContraseña.setText("Enter your password here");
        campoIngresarContraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));
        campoIngresarContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoIngresarContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoIngresarContraseñaFocusLost(evt);
            }
        });
        campoIngresarContraseña.addActionListener(this::campoIngresarContraseñaActionPerformed);

        botonIniciarSesion.setBackground(new java.awt.Color(200, 0, 0));
        botonIniciarSesion.setFont(new java.awt.Font("Inter", 1, 20)); // NOI18N
        botonIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        botonIniciarSesion.setText("Iniciar Sesión");
        botonIniciarSesion.setBorder(null);
        botonIniciarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonIniciarSesion.addActionListener(this::botonIniciarSesionActionPerformed);

        mensajeError.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        mensajeError.setForeground(new java.awt.Color(200, 0, 0));
        mensajeError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout cuadroBlancoInicioSesionLayout = new javax.swing.GroupLayout(cuadroBlancoInicioSesion);
        cuadroBlancoInicioSesion.setLayout(cuadroBlancoInicioSesionLayout);
        cuadroBlancoInicioSesionLayout.setHorizontalGroup(
            cuadroBlancoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cuadroBlancoInicioSesionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mensajeError, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
            .addGroup(cuadroBlancoInicioSesionLayout.createSequentialGroup()
                .addGroup(cuadroBlancoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cuadroBlancoInicioSesionLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(cuadroBlancoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoIngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoIngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoIngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoIngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cuadroBlancoInicioSesionLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(logoAppCarInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cuadroBlancoInicioSesionLayout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addComponent(botonIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cuadroBlancoInicioSesionLayout.setVerticalGroup(
            cuadroBlancoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuadroBlancoInicioSesionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(logoAppCarInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensajeError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoIngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoIngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoIngresarContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoIngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout imagenFondoInicioSesionLayout = new javax.swing.GroupLayout(imagenFondoInicioSesion);
        imagenFondoInicioSesion.setLayout(imagenFondoInicioSesionLayout);
        imagenFondoInicioSesionLayout.setHorizontalGroup(
            imagenFondoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenFondoInicioSesionLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(cuadroBlancoInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        imagenFondoInicioSesionLayout.setVerticalGroup(
            imagenFondoInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagenFondoInicioSesionLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(cuadroBlancoInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenFondoInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenFondoInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarSesionActionPerformed
        this.iniciarSesión();
    }//GEN-LAST:event_botonIniciarSesionActionPerformed

    private void campoIngresarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIngresarUsuarioActionPerformed
        this.iniciarSesión();
    }//GEN-LAST:event_campoIngresarUsuarioActionPerformed

    private void campoIngresarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoIngresarContraseñaActionPerformed
        this.iniciarSesión();
    }//GEN-LAST:event_campoIngresarContraseñaActionPerformed

    private void iniciarSesión()
    {
        this.pantallaCargando.setBounds(this.cuadroBlancoInicioSesion.getBounds());
        this.imagenFondoInicioSesion.remove(this.cuadroBlancoInicioSesion);
        this.imagenFondoInicioSesion.add(this.pantallaCargando);
        this.imagenFondoInicioSesion.revalidate();
        this.imagenFondoInicioSesion.repaint();
        Timer timer = new javax.swing.Timer(2000, (e) -> 
        {
            if(GestorUsuarios.validarUsuario(this.campoIngresarUsuario.getText(), String.valueOf(this.campoIngresarContraseña.getPassword())))
            {
                pantallaInicio.setBounds(this.imagenFondoInicioSesion.getBounds());
                this.remove(this.imagenFondoInicioSesion);
                this.pantallaInicio.setUsuario(GestorUsuarios.usuarioIngresado);
                this.add(pantallaInicio);
                this.revalidate();
                this.repaint();
            }
            else
            {
                this.imagenFondoInicioSesion.remove(this.pantallaCargando);
                if(GestorUsuarios.intentos >= 3)
                {
                    this.mensajeError.setText("<html><center>Ingresó el usuario o la contraseña incorrecta tres veces. Ahora<br>solo podrá ingresar mediante una cuenta de administrador"); 
                }
                else
                {
                    this.mensajeError.setText("El usuario o la contraseña es incorrecto. Intente de nuevo.");
                }
                this.imagenFondoInicioSesion.add(this.cuadroBlancoInicioSesion);
                this.campoIngresarUsuario.setText("Ej. UsernameExample67");
                this.campoIngresarUsuario.setForeground(new java.awt.Color(200, 200, 200));
                this.campoIngresarContraseña.setText("Enter your password here");
                this.campoIngresarContraseña.setForeground(new java.awt.Color(200, 200, 200));
                this.campoIngresarContraseña.setEchoChar((char) 0);
                this.imagenFondoInicioSesion.revalidate();
                this.imagenFondoInicioSesion.repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    private void cerrarSesionMousePressed(MouseEvent evt){
        this.pantallaInicio.panelOscuro.removeAll();
        this.pantallaInicio.panelOscuro.setVisible(false);
        this.remove(pantallaInicio);
        this.imagenFondoInicioSesion.remove(this.pantallaCargando);
        this.imagenFondoInicioSesion.add(this.cuadroBlancoInicioSesion);
        this.mensajeError.setText("");
        GestorUsuarios.intentos = 0;
        GestorUsuarios.usuarioIngresado = null;
        this.add(this.imagenFondoInicioSesion);
        this.campoIngresarUsuario.setText("Ej. UsernameExample67");
        this.campoIngresarUsuario.setForeground(new java.awt.Color(200, 200, 200));
        this.campoIngresarContraseña.setText("Enter your password here");
        this.campoIngresarContraseña.setForeground(new java.awt.Color(200, 200, 200));
        this.campoIngresarContraseña.setEchoChar((char) 0);
        this.imagenFondoInicioSesion.revalidate();
        this.imagenFondoInicioSesion.repaint();
    }
    
    private void campoIngresarUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoIngresarUsuarioFocusGained
        if(this.campoIngresarUsuario.getText().equals("Ej. UsernameExample67"))
        {
            this.campoIngresarUsuario.setText("");
            this.campoIngresarUsuario.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_campoIngresarUsuarioFocusGained

    private void campoIngresarUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoIngresarUsuarioFocusLost
        if(this.campoIngresarUsuario.getText().isEmpty())
        {
            this.campoIngresarUsuario.setText("Ej. UsernameExample67");
            this.campoIngresarUsuario.setForeground(new java.awt.Color(200, 200, 200));
        }
    }//GEN-LAST:event_campoIngresarUsuarioFocusLost

    private void campoIngresarContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoIngresarContraseñaFocusGained
        if(String.valueOf(this.campoIngresarContraseña.getPassword()).equals("Enter your password here"))
        {
            this.campoIngresarContraseña.setText("");
            this.campoIngresarContraseña.setForeground(new java.awt.Color(0, 0, 0));
            this.campoIngresarContraseña.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_campoIngresarContraseñaFocusGained

    private void campoIngresarContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoIngresarContraseñaFocusLost
        if(String.valueOf(this.campoIngresarContraseña.getPassword()).isEmpty())
        {
            this.campoIngresarContraseña.setText("Enter your password here");
            this.campoIngresarContraseña.setForeground(new java.awt.Color(200, 200, 200));
            this.campoIngresarContraseña.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_campoIngresarContraseñaFocusLost

    public static void main(String args[]) 
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        UIManager.put("nimbusSelection", new Color(200, 0, 0, 191));
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) 
        {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        LecturaDatos.leerProductos();
        LecturaDatos.leerUsuarios();
        java.awt.EventQueue.invokeLater(() -> new Aplicacion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciarSesion;
    private javax.swing.JPasswordField campoIngresarContraseña;
    private javax.swing.JTextField campoIngresarUsuario;
    private javax.swing.JPanel cuadroBlancoInicioSesion;
    private javax.swing.JPanel imagenFondoInicioSesion;
    private javax.swing.JPanel logoAppCarInicioSesion;
    private javax.swing.JLabel mensajeError;
    private javax.swing.JLabel textoIngresarContraseña;
    private javax.swing.JLabel textoIngresarUsuario;
    // End of variables declaration//GEN-END:variables
    private CuadroBlancoCargando pantallaCargando;
    PantallaPrincipal pantallaInicio;
}