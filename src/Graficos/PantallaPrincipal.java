package Graficos;

import Dominio.GestorInventario;
import Dominio.GestorUsuarios;
import Dominio.Producto;
import Dominio.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class PantallaPrincipal extends javax.swing.JPanel 
{
    public PantallaPrincipal() 
    {
        this.mensajeUsuario = new MensajeNuevoUsuario(30);
        this.ventanaNuevoUsuario = new PanelNuevoUsuario(30);
        this.ventanaUsuario = new InfoUsuario(30);
        this.menuConPerfiles = new MenuGestionarPerfiles(30);
        this.ventanaProducto = new InfoProducto(30);
        this.ventanaRegistro = new PanelRegistro(30);
        this.ventanaMensajeRegistro = new PanelMensajeRegistro(30);
        this.ventanaActualizar = new PanelActualizacion(30);
        this.ventanaMensajeActualizar = new PanelMensajeActualizacion(30);
        this.ventanaEntrada = new PanelEntrada(30);
        this.ventanaMensajeEntrada = new PanelMensajeEntrada(30);
        this.ventanaSalida = new PanelSalida(30);
        this.ventanaMensajeSalida = new PanelMensajeSalida(30);
        this.ventanaGenerarReporte = new PanelReporte(30);
        this.ventanaReporte = new PanelReporteGenerado(30);
        this.menuPerfiles = new MenuPerfiles(30);
        this.panelOscuro = new PanelOscuro();
        this.estado = null;
        this.iconoMenu = new ImageIcon(getClass().getResource("/Imagenes/logoMenu.png"));
        this.iconoPequeno = this.iconoMenu.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        this.iconoMenu = new ImageIcon(this.iconoPequeno);
        this.iconoPerfil = new ImageIcon(getClass().getResource("/Imagenes/logoPerfil.png"));
        this.iconoPequeno = this.iconoPerfil.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        this.iconoPerfil = new ImageIcon(this.iconoPequeno);
        this.initComponents();
        this.campoNombre.setBorder(BorderFactory.createCompoundBorder(this.campoNombre.getBorder(), BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        this.botonPerfil.setContentAreaFilled(false);
        this.botonPerfil.setBorderPainted(false);
        this.botonPerfil.setFocusPainted(false);
        this.botonMenu.setContentAreaFilled(false);
        this.botonMenu.setBorderPainted(false);
        this.botonMenu.setFocusPainted(false);
        this.campoPrecioMayor.setBorder(BorderFactory.createCompoundBorder(this.campoPrecioMayor.getBorder(), BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        this.campoPrecioMenor.setBorder(BorderFactory.createCompoundBorder(this.campoPrecioMenor.getBorder(), BorderFactory.createEmptyBorder(0, 12, 0, 12)));
        this.menuAdministrador.setBorder(BorderFactory.createLineBorder(new Color(202, 196, 208), 1));
        this.menuAdministrador.setLightWeightPopupEnabled(false);
        this.cargarCategorias();
        this.cargarProductos();
        for (Component componente: this.menuAdministrador.getComponents()) 
        {
            if (componente instanceof JMenuItem) 
            {
                JMenuItem item = (JMenuItem) componente;
                item.setBorder(BorderFactory.createEmptyBorder(20, 12, 20, 30));
            }
        }
        this.panelOscuro.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelOscuroMousePressed(evt);
            }
        });
        this.ventanaRegistro.botonCerrar.addActionListener(this::botonCerrarRegistroActionPerformed);
        this.menuCategoria.setUI(new UIModernaMenu());
        this.menuCategoria.setOpaque(false);
        this.menuCategoria.setBackground(new Color(255, 255, 255));
        this.menuCategoria.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.menuCategoria.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean hasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, hasFocus);
                label.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
                label.setOpaque(true);
                label.setBackground(isSelected ? new Color(200, 0, 0, 191) : new Color(255, 255, 255));
                label.setForeground(isSelected ? new Color(255, 255, 255) : new Color(40, 40, 40));
                return label;
            }
        });
        this.setLayout(null);
        this.setComponentZOrder(this.botonPerfil, 0);
        this.setComponentZOrder(this.botonMenu, 0);
        this.fondoScroll.setBounds(0, 0, 1280, 720);
        this.botonPerfil.setBounds(60, 550, 110, 110);
        this.botonMenu.setBounds(1110, 550, 110, 110);
        this.ventanaRegistro.botonRegistrar.addActionListener(this::botonRegistrarActionPerformed);
        this.ventanaMensajeRegistro.botonCerrar.addActionListener(this::botonCerrarMensajeRegistroActionPerformed);
        this.ventanaMensajeRegistro.botonVolver.addActionListener(this::botonVolverMensajeRegistroActionPerformed);
        this.ventanaMensajeRegistro.botonPrincipal.addActionListener(this::botonPrincipalMensajeRegistroActionPerformed);
        this.ventanaActualizar.botonCerrar.addActionListener(this::botonCerrarActualizarActionPerformed);
        this.ventanaActualizar.botonEliminar.addActionListener(this::botonEliminarActualizarActionPerformed);
        this.ventanaActualizar.botonActualizar.addActionListener(this::botonActualizarActualizarActionPerformed);
        this.ventanaMensajeActualizar.botonVolver.addActionListener(this::botonVolverMensajeActualizarActionPerformed);
        this.ventanaMensajeActualizar.botonCerrar.addActionListener(this::botonCerrarMensajeActualizarActionPerformed);
        this.ventanaMensajeActualizar.botonActualizar.addActionListener(this::botonActualizarMensajeActualizarActionPerformed);
        this.ventanaEntrada.botonCerrar.addActionListener(this::botonCerrarEntradaActionPerformed);
        this.ventanaEntrada.botonRegistrar.addActionListener(this::botonRegistrarEntradaActionPerformed);
        this.ventanaMensajeEntrada.botonCerrar.addActionListener(this::botonCerrarMensajeEntradaActionPerformed);
        this.ventanaMensajeEntrada.botonRegistrar.addActionListener(this::botonRegistrarMensajeEntradaActionPerformed);
        this.ventanaSalida.botonCerrar.addActionListener(this::botonCerrarSalidaActionPerformed);
        this.ventanaSalida.botonRegistrar.addActionListener(this::botonRegistrarSalidaActionPerformed);
        this.ventanaMensajeSalida.botonCerrar.addActionListener(this::botonCerrarMensajeSalidaActionPerformed);
        this.ventanaMensajeSalida.botonRegistrar.addActionListener(this::botonRegistrarMensajeSalidaActionPerformed);
        this.ventanaMensajeSalida.botonVolver.addActionListener(this::botonVolverMensajeSalidaActionPerformed);
        this.ventanaGenerarReporte.botonCerrar.addActionListener(this::botonCerrarGenerarReporteActionPerformed);
        this.ventanaGenerarReporte.botonGenerar.addActionListener(this::botonGenerarGenerarReporteActionPerformed);
        this.ventanaReporte.botonCerrar.addActionListener(this::botonCerrarReporteActionPerformed);
        this.ventanaReporte.botonGenerar.addActionListener(this::botonGenerarOtroReporteActionPerformed);
        this.ventanaReporte.botonGenerar.addActionListener(this::botonGenerarOtroReporteActionPerformed);
        this.fondoScroll.getVerticalScrollBar().setUI(new UIBarraScroll());
        this.fondoScroll.getVerticalScrollBar().setPreferredSize(new Dimension(10, 0));
        this.fondoScroll.getVerticalScrollBar().setOpaque(false);
        this.fondoScroll.getVerticalScrollBar().setUnitIncrement(16);
        this.jPanel1.removeAll();
        this.jPanel1.setLayout(new BorderLayout());
        this.jPanel1.add(this.panelArriba, BorderLayout.NORTH);
        this.jPanel1.add(this.panelProductos, BorderLayout.CENTER);
        this.ventanaProducto.xCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cerrarVentantaProductoMousePressed(evt);
            }
        });
        this.menuPerfiles.botonGestionar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonGestionarPerfilesMousePressed(evt);
            }
        });
        this.menuConPerfiles.chevronVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                volverChevronPerfilesMousePressed(evt);
            }
        });
        this.menuConPerfiles.setAlSeleccionarUsuario(usuario -> {
            this.ventanaUsuario.setUsuario(usuario);
            this.mostrarVentanaUsuario();
        });
        this.ventanaUsuario.botonEliminar.addActionListener(this::botonEliminarUsuarioActionPerformed);
        this.ventanaUsuario.chevronVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                volverChevronUsuarioMousePressed(evt);
            }
        });
        this.menuConPerfiles.panelNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonNuevoUsuarioMousePressed(evt);
            }
        });
        this.ventanaNuevoUsuario.chevronVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                volverNuevoUsuarioMousePressed(evt);
            }
        });
        this.ventanaNuevoUsuario.botonGuardar.addActionListener(this::botonGuardarUsuarioActionPerformed);
        this.mensajeUsuario.chevronVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                volverMensajeUsuarioMousePressed(evt);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuAdministrador = new javax.swing.JPopupMenu();
        opcionRegistrar = new javax.swing.JMenuItem();
        opcionActualizar = new javax.swing.JMenuItem();
        opcionEntrada = new javax.swing.JMenuItem();
        opcionSalida = new javax.swing.JMenuItem();
        opcionReporte = new javax.swing.JMenuItem();
        botonPerfil = new javax.swing.JButton(iconoPerfil);
        botonMenu = new javax.swing.JButton(iconoMenu);
        fondoScroll = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelArriba = new javax.swing.JPanel();
        bienvenido1 = new javax.swing.JLabel();
        bienvenido2 = new javax.swing.JLabel();
        logoApp = new LogoCar();
        textoFiltrarPor = new javax.swing.JLabel();
        textoNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        textoCategoria = new javax.swing.JLabel();
        menuCategoria = new javax.swing.JComboBox<>();
        textoPrecio = new javax.swing.JLabel();
        campoPrecioMenor = new javax.swing.JTextField();
        textoMenos = new javax.swing.JLabel();
        campoPrecioMayor = new javax.swing.JTextField();
        panelProductos = new javax.swing.JPanel();
        textoProductosNoEncontrados = new javax.swing.JLabel();

        menuAdministrador.setBackground(new java.awt.Color(202, 196, 208));
        menuAdministrador.setBorder(null);
        menuAdministrador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuAdministrador.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                menuAdministradorPopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                menuAdministradorPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        opcionRegistrar.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        opcionRegistrar.setText("Registrar Producto");
        opcionRegistrar.addActionListener(this::opcionRegistrarActionPerformed);
        menuAdministrador.add(opcionRegistrar);

        opcionActualizar.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        opcionActualizar.setText("Actualizar Producto");
        opcionActualizar.addActionListener(this::opcionActualizarActionPerformed);
        menuAdministrador.add(opcionActualizar);

        opcionEntrada.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        opcionEntrada.setText("Registrar Entrada");
        opcionEntrada.addActionListener(this::opcionEntradaActionPerformed);
        menuAdministrador.add(opcionEntrada);

        opcionSalida.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        opcionSalida.setText("Registrar Salida");
        opcionSalida.addActionListener(this::opcionSalidaActionPerformed);
        menuAdministrador.add(opcionSalida);

        opcionReporte.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        opcionReporte.setText("Generar Reporte");
        opcionReporte.addActionListener(this::opcionReporteActionPerformed);
        menuAdministrador.add(opcionReporte);

        setBackground(new java.awt.Color(217, 217, 217));
        setForeground(new java.awt.Color(179, 179, 179));
        setPreferredSize(new java.awt.Dimension(1340, 720));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        botonPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonPerfil.addActionListener(this::botonPerfilActionPerformed);

        botonMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMenu.addActionListener(this::botonMenuActionPerformed);

        fondoScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setPreferredSize(null);

        panelArriba.setBackground(new java.awt.Color(236, 230, 240));
        panelArriba.setPreferredSize(new java.awt.Dimension(1309, 477));

        bienvenido1.setFont(new java.awt.Font("Inter", 1, 80)); // NOI18N
        bienvenido1.setText("¡Bienvenido,");

        bienvenido2.setFont(new java.awt.Font("Inter", 1, 80)); // NOI18N
        bienvenido2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bienvenido2.setText("Administrador!");

        logoApp.setBackground(new Color(0, 0, 0, 0));

        javax.swing.GroupLayout logoAppLayout = new javax.swing.GroupLayout(logoApp);
        logoApp.setLayout(logoAppLayout);
        logoAppLayout.setHorizontalGroup(
            logoAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        logoAppLayout.setVerticalGroup(
            logoAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );

        textoFiltrarPor.setFont(new java.awt.Font("Inter", 0, 27)); // NOI18N
        textoFiltrarPor.setText("Filtrar por:");

        textoNombre.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        textoNombre.setText("Nombre:");

        campoNombre.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(200, 200, 200));
        campoNombre.setText("Ingrese el nombre");
        campoNombre.setBorder(null);
        campoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNombreFocusLost(evt);
            }
        });
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoNombreKeyReleased(evt);
            }
        });

        textoCategoria.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        textoCategoria.setText("Categoría:");

        menuCategoria.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        menuCategoria.setForeground(new java.awt.Color(200, 200, 200));
        menuCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elija la categoría" }));
        menuCategoria.setBorder(null);
        menuCategoria.addActionListener(this::menuCategoriaActionPerformed);

        textoPrecio.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        textoPrecio.setText("Precio: ");

        campoPrecioMenor.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        campoPrecioMenor.setForeground(new java.awt.Color(200, 200, 200));
        campoPrecioMenor.setText("Precio menor");
        campoPrecioMenor.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        campoPrecioMenor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPrecioMenorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoPrecioMenorFocusLost(evt);
            }
        });
        campoPrecioMenor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoPrecioMenorKeyReleased(evt);
            }
        });

        textoMenos.setFont(new java.awt.Font("Inter", 0, 20)); // NOI18N
        textoMenos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoMenos.setText("-");

        campoPrecioMayor.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        campoPrecioMayor.setForeground(new java.awt.Color(200, 200, 200));
        campoPrecioMayor.setText("Precio mayor");
        campoPrecioMayor.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 12, 8, 12));
        campoPrecioMayor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoPrecioMayorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoPrecioMayorFocusLost(evt);
            }
        });
        campoPrecioMayor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPrecioMayorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelArribaLayout = new javax.swing.GroupLayout(panelArriba);
        panelArriba.setLayout(panelArribaLayout);
        panelArribaLayout.setHorizontalGroup(
            panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArribaLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArribaLayout.createSequentialGroup()
                        .addGroup(panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bienvenido1)
                            .addComponent(bienvenido2))
                        .addGap(89, 89, 89)
                        .addComponent(logoApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelArribaLayout.createSequentialGroup()
                        .addGroup(panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoCategoria)
                            .addComponent(menuCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelArribaLayout.createSequentialGroup()
                                .addComponent(campoPrecioMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textoMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoPrecioMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textoPrecio)))
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoNombre)
                    .addComponent(textoFiltrarPor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelArribaLayout.setVerticalGroup(
            panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArribaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelArribaLayout.createSequentialGroup()
                        .addComponent(bienvenido1)
                        .addGap(18, 18, 18)
                        .addComponent(bienvenido2)))
                .addGap(18, 18, 18)
                .addComponent(textoFiltrarPor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoPrecio)
                    .addComponent(textoCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelArribaLayout.createSequentialGroup()
                        .addComponent(menuCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelArribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoPrecioMenor)
                        .addComponent(textoMenos)
                        .addComponent(campoPrecioMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        panelProductos.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 10, 40));
        panelProductos.setPreferredSize(null);

        textoProductosNoEncontrados.setFont(new java.awt.Font("Inter", 1, 40)); // NOI18N
        textoProductosNoEncontrados.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoProductosNoEncontrados.setText("<html><center>¡Vaya!, parece que no hay productos<br>  que coincidan con tu búsqueda");

        javax.swing.GroupLayout panelProductosLayout = new javax.swing.GroupLayout(panelProductos);
        panelProductos.setLayout(panelProductosLayout);
        panelProductosLayout.setHorizontalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(textoProductosNoEncontrados, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProductosLayout.setVerticalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(textoProductosNoEncontrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 1309, Short.MAX_VALUE)
                    .addComponent(panelArriba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(193, 193, 193))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelArriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fondoScroll.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondoScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(615, 615, 615)
                    .addComponent(botonPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(615, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(615, 615, 615)
                    .addComponent(botonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(615, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(305, 305, 305)
                    .addComponent(botonPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(305, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(305, 305, 305)
                    .addComponent(botonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(305, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
 
    private void mostrarVentanaUsuario()
    {
        JRootPane frame = SwingUtilities.getRootPane(this);
        this.panelOscuro.setVisible(true);
        this.panelOscuro.mostrarComponente(this.botonPerfil);
        Point punto = SwingUtilities.convertPoint(botonPerfil, 0, 0, panelOscuro);
        this.panelOscuro.setLayout(null);
        Dimension dimension = this.ventanaUsuario.getPreferredSize();
        int x = punto.x + botonPerfil.getWidth() + 10;
        int y = punto.y - dimension.height + botonPerfil.getHeight();
        x = Math.max(8, Math.min(x, frame.getWidth() - dimension.width - 8));
        y = Math.max(8, y);
        this.ventanaUsuario.setVisible(true);
        panelOscuro.mostrarEn(this.ventanaUsuario, x, y);
        panelOscuro.setVisible(true);
    }
    
    private void mostrarMensajeUsuario()
    {
        JRootPane frame = SwingUtilities.getRootPane(this);
        this.panelOscuro.setVisible(true);
        this.panelOscuro.mostrarComponente(this.botonPerfil);
        Point punto = SwingUtilities.convertPoint(botonPerfil, 0, 0, panelOscuro);
        this.panelOscuro.setLayout(null);
        Dimension dimension = this.mensajeUsuario.getPreferredSize();
        int x = punto.x + botonPerfil.getWidth() + 10;
        int y = punto.y - dimension.height + botonPerfil.getHeight();
        x = Math.max(8, Math.min(x, frame.getWidth() - dimension.width - 8));
        y = Math.max(8, y);
        this.mensajeUsuario.setVisible(true);
        panelOscuro.mostrarEn(this.mensajeUsuario, x, y);
        panelOscuro.setVisible(true);
    }
    
    private void mostrarMenuConPerfiles()
    {
        JRootPane frame = SwingUtilities.getRootPane(this);
        this.panelOscuro.setVisible(true);
        this.panelOscuro.mostrarComponente(this.botonPerfil);
        this.menuConPerfiles.cargarUsuarios(frame.getHeight());
        Point punto = SwingUtilities.convertPoint(botonPerfil, 0, 0, panelOscuro);
        this.panelOscuro.setLayout(null);
        Dimension dimension = this.menuConPerfiles.getPreferredSize();
        int x = punto.x + botonPerfil.getWidth() + 10;
        int y = punto.y - dimension.height + botonPerfil.getHeight();
        x = Math.max(8, Math.min(x, frame.getWidth() - dimension.width - 8));
        y = Math.max(8, y);
        this.menuConPerfiles.setVisible(true);
        panelOscuro.mostrarEn(this.menuConPerfiles, x, y);
        panelOscuro.setVisible(true);
    }
    
    private void mostrarVentanaNuevoUsuario()
    {
        JRootPane frame = SwingUtilities.getRootPane(this);
        this.panelOscuro.setVisible(true);
        this.panelOscuro.mostrarComponente(this.botonPerfil);
        Point punto = SwingUtilities.convertPoint(botonPerfil, 0, 0, panelOscuro);
        this.panelOscuro.setLayout(null);
        Dimension dimension = this.ventanaNuevoUsuario.getPreferredSize();
        int x = punto.x + botonPerfil.getWidth() + 10;
        int y = punto.y - dimension.height + botonPerfil.getHeight();
        x = Math.max(8, Math.min(x, frame.getWidth() - dimension.width - 8));
        y = Math.max(8, y);
        this.ventanaNuevoUsuario.setVisible(true);
        this.ventanaNuevoUsuario.limpiar();
        panelOscuro.mostrarEn(this.ventanaNuevoUsuario, x, y);
        panelOscuro.setVisible(true);
    }
    
    private void mostrarMenuPerfiles()
    {
        JRootPane frame = SwingUtilities.getRootPane(this);
        frame.setGlassPane(this.panelOscuro);
        this.panelOscuro.setSize(frame.getSize()); 
        this.panelOscuro.setVisible(true);
        this.panelOscuro.mostrarComponente(this.botonPerfil);
        Point punto = SwingUtilities.convertPoint(botonPerfil, 0, 0, panelOscuro);
        this.panelOscuro.setLayout(null);
        Dimension dimension = this.menuPerfiles.getPreferredSize();
        int x = punto.x + botonPerfil.getWidth() + 10;
        int y = punto.y - dimension.height + botonPerfil.getHeight();
        x = Math.max(8, Math.min(x, frame.getWidth() - dimension.width - 8));
        y = Math.max(8, y);
        this.menuPerfiles.setVisible(true);
        panelOscuro.mostrarEn(this.menuPerfiles, x, y);
        panelOscuro.setVisible(true);
    }
    
    private void botonEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                          
        GestorUsuarios.eliminarUsuario(this.ventanaUsuario.usuario);
        this.mostrarMenuConPerfiles();
    } 
    
    private void botonGuardarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        this.ventanaNuevoUsuario.guardarInfoUsuario();
        this.mensajeUsuario.setMensaje(GestorUsuarios.anadirUsuario(new Usuario(this.ventanaNuevoUsuario.id, this.ventanaNuevoUsuario.nombre, this.ventanaNuevoUsuario.username, this.ventanaNuevoUsuario.password, this.ventanaNuevoUsuario.activo, this.ventanaNuevoUsuario.admin)));
        this.mostrarMensajeUsuario();
    } 
    
    private void botonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPerfilActionPerformed
        this.mostrarMenuPerfiles();
    }//GEN-LAST:event_botonPerfilActionPerformed
   
    private void botonGestionarPerfilesMousePressed(java.awt.event.MouseEvent evt) {                                  
        this.mostrarMenuConPerfiles();
    } 
    
    private void volverNuevoUsuarioMousePressed(java.awt.event.MouseEvent evt) {                                  
        this.mostrarMenuConPerfiles();
    } 
    
    private void volverMensajeUsuarioMousePressed(java.awt.event.MouseEvent evt) {                                  
        this.mostrarMenuConPerfiles();
    } 
    
    private void botonNuevoUsuarioMousePressed(java.awt.event.MouseEvent evt) {                                  
        this.mostrarVentanaNuevoUsuario();
    } 
    
    private void volverChevronPerfilesMousePressed(java.awt.event.MouseEvent evt) {                                  
        this.mostrarMenuPerfiles();
    } 
    
    private void volverChevronUsuarioMousePressed(java.awt.event.MouseEvent evt) {                                  
        this.mostrarMenuConPerfiles();
    }  
    
    private void botonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuActionPerformed
        JRootPane frame = SwingUtilities.getRootPane(this);
        frame.setGlassPane(this.panelOscuro);
        this.panelOscuro.setSize(frame.getSize()); 
        this.panelOscuro.setLayout(new GridBagLayout());
        this.panelOscuro.setVisible(true);
        this.panelOscuro.mostrarComponente(this.botonMenu);
        this.menuAdministrador.show(this.botonMenu, this.botonMenu.getWidth() - this.menuAdministrador.getPreferredSize().width, -this.menuAdministrador.getPreferredSize().height);
    }//GEN-LAST:event_botonMenuActionPerformed

    private void menuAdministradorPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_menuAdministradorPopupMenuWillBecomeInvisible
        panelOscuro.setVisible(false);
    }//GEN-LAST:event_menuAdministradorPopupMenuWillBecomeInvisible

    private void menuAdministradorPopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_menuAdministradorPopupMenuCanceled
        panelOscuro.setVisible(false);
    }//GEN-LAST:event_menuAdministradorPopupMenuCanceled

    private void campoNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreFocusGained
        if(this.campoNombre.getText().equals("Ingrese el nombre"))
        {
            this.campoNombre.setText("");
            this.campoNombre.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_campoNombreFocusGained

    private void campoNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreFocusLost
        if(this.campoNombre.getText().isEmpty())
        {
            this.campoNombre.setText("Ingrese el nombre");
            this.campoNombre.setForeground(new Color(200, 200, 200));
        }
    }//GEN-LAST:event_campoNombreFocusLost

    private void campoPrecioMenorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPrecioMenorFocusGained
        if(this.campoPrecioMenor.getText().equals("Precio menor"))
        {
            this.campoPrecioMenor.setText("");
            this.campoPrecioMenor.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_campoPrecioMenorFocusGained

    private void campoPrecioMenorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPrecioMenorFocusLost
        if(this.campoPrecioMenor.getText().isEmpty())
        {
            this.campoPrecioMenor.setText("Precio menor");
            this.campoPrecioMenor.setForeground(new Color(200, 200, 200));
        }
    }//GEN-LAST:event_campoPrecioMenorFocusLost

    private void campoPrecioMayorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPrecioMayorFocusGained
        if(this.campoPrecioMayor.getText().equals("Precio mayor"))
        {
            this.campoPrecioMayor.setText("");
            this.campoPrecioMayor.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_campoPrecioMayorFocusGained

    private void campoPrecioMayorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoPrecioMayorFocusLost
        if(this.campoPrecioMayor.getText().isEmpty())
        {
            this.campoPrecioMayor.setText("Precio mayor");
            this.campoPrecioMayor.setForeground(new Color(200, 200, 200));
        }
    }//GEN-LAST:event_campoPrecioMayorFocusLost

    private void opcionRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionRegistrarActionPerformed
        this.panelOscuro.mostrarComponente(null);
        this.panelOscuro.setVisible(true);
        this.panelOscuro.mostrarCentrado(this.ventanaRegistro);
        this.ventanaRegistro.cargarCategorias();
        this.ventanaRegistro.validarCampos();
    }//GEN-LAST:event_opcionRegistrarActionPerformed

    private void opcionActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionActualizarActionPerformed
        this.panelOscuro.mostrarComponente(null);
        this.panelOscuro.setVisible(true);
        this.panelOscuro.mostrarCentrado(this.ventanaActualizar);
        this.ventanaActualizar.cargarCategorias();
        this.ventanaActualizar.cargarProductos();
        this.ventanaActualizar.validarSeleccion();
    }//GEN-LAST:event_opcionActualizarActionPerformed

    private void opcionEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionEntradaActionPerformed
        this.panelOscuro.mostrarComponente(null);
        this.panelOscuro.setVisible(true);
        this.panelOscuro.mostrarCentrado(this.ventanaEntrada);
        this.ventanaEntrada.cargarProductos();
        this.ventanaEntrada.validarCampo();
    }//GEN-LAST:event_opcionEntradaActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // no tiene nada es solo para que el panel cambie el focus de los campos
    }//GEN-LAST:event_formMousePressed

    private void opcionSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionSalidaActionPerformed
        this.panelOscuro.mostrarComponente(null);
        this.panelOscuro.setVisible(true);
        this.panelOscuro.mostrarCentrado(this.ventanaSalida);
        this.ventanaSalida.cargarProductos();
        this.ventanaSalida.validarCampo();
    }//GEN-LAST:event_opcionSalidaActionPerformed

    private void opcionReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionReporteActionPerformed
        this.panelOscuro.mostrarComponente(null);
        this.panelOscuro.setVisible(true);
        this.ventanaGenerarReporte.limpiar();
        this.panelOscuro.mostrarCentrado(this.ventanaGenerarReporte);
        this.ventanaGenerarReporte.validarCantidad();
    }//GEN-LAST:event_opcionReporteActionPerformed

    private void campoNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyReleased
        this.cargarProductos();
    }//GEN-LAST:event_campoNombreKeyReleased

    private void menuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCategoriaActionPerformed
        this.cargarProductos();
    }//GEN-LAST:event_menuCategoriaActionPerformed

    private void campoPrecioMenorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPrecioMenorKeyReleased
        this.cargarProductos();
    }//GEN-LAST:event_campoPrecioMenorKeyReleased

    private void campoPrecioMayorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPrecioMayorKeyTyped
        this.cargarProductos();
    }//GEN-LAST:event_campoPrecioMayorKeyTyped

    public void setUsuario(Usuario usuario)
    {
        this.menuPerfiles.setUsuario(usuario);
        this.bienvenido2.setText(GestorUsuarios.usuarioIngresado.getNombre() + "!");
        this.botonMenu.setVisible(usuario.isAdmin());
        this.menuPerfiles.botonGestionar.setVisible(usuario.isAdmin());
        
    }

    private void cerrarVentantaProductoMousePressed(MouseEvent evt) {
        this.panelOscuro.setVisible(false);
        this.panelOscuro.removeAll();
    }
    
    private void panelOscuroMousePressed(MouseEvent evt) {
        this.panelOscuro.setVisible(false);
        this.panelOscuro.removeAll();
    }
    
    private void botonCerrarRegistroActionPerformed(java.awt.event.ActionEvent evt) {
        this.panelOscuro.setVisible(false);
        this.ventanaRegistro.setVisible(false);
        this.ventanaRegistro.limpiar();
        this.cargarProductos();
    }
    
    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) { 
        this.ventanaRegistro.guardarInfoProducto();
        this.estado = GestorInventario.registrarProducto(this.ventanaRegistro.id, this.ventanaRegistro.nombre, this.ventanaRegistro.cantidad, this.ventanaRegistro.precio, this.ventanaRegistro.proveedor, this.ventanaRegistro.categoria);
        if(estado.equals("Nombre igual"))
        {
            this.ventanaMensajeRegistro.setMensaje("<html>Ya existe un producto<br>con ese nombre. Puede<br>registrar una entrada<br>de ese producto");
            this.ventanaMensajeRegistro.botonPrincipal.setText("Registrar una entrada");
            this.ventanaMensajeRegistro.botonVolver.setVisible(true);
        }
        else if(estado.equals("ID Igual"))
        {
            this.ventanaMensajeRegistro.setMensaje("<html>Ya existe un producto<br>con ese ID. Puede<br>registrar una entrada<br>de ese producto");
            this.ventanaMensajeRegistro.botonPrincipal.setText("Registrar una entrada");
            this.ventanaMensajeRegistro.botonVolver.setVisible(true);
        }
        else
        {
            this.ventanaMensajeRegistro.setMensaje("<html>El registro del producto<br>fue exitoso.");
            this.ventanaMensajeRegistro.botonVolver.setVisible(false);
            this.ventanaMensajeRegistro.botonPrincipal.setText("Registrar otro producto");
        }
        this.ventanaRegistro.setVisible(false);
        this.panelOscuro.mostrarCentrado(this.ventanaMensajeRegistro);
    }  
    
    private void botonCerrarMensajeRegistroActionPerformed(java.awt.event.ActionEvent evt) {
        this.panelOscuro.setVisible(false);
        this.ventanaRegistro.limpiar();
        this.ventanaMensajeRegistro.setVisible(false);
        this.cargarProductos();
    }
    
    private void botonVolverMensajeRegistroActionPerformed(java.awt.event.ActionEvent evt) {
        this.ventanaMensajeRegistro.setVisible(false);
        this.panelOscuro.mostrarCentrado(this.ventanaRegistro);
    }
    
    private void botonPrincipalMensajeRegistroActionPerformed(java.awt.event.ActionEvent evt) {
        if(this.ventanaMensajeRegistro.botonPrincipal.getText().equals("Registrar otro producto"))
        {
            this.ventanaMensajeRegistro.setVisible(false);
            this.ventanaRegistro.limpiar();
            this.ventanaRegistro.validarCampos();
            this.ventanaRegistro.cargarCategorias();
            this.panelOscuro.mostrarCentrado(this.ventanaRegistro);
        }
        else
        {
            this.ventanaMensajeRegistro.setVisible(false);
            this.ventanaEntrada.limpiar();
            this.ventanaEntrada.validarCampo();
            this.ventanaEntrada.cargarProductos();
            if(estado.equals("Nombre igual"))
                this.ventanaEntrada.setProducto(GestorInventario.buscarNombre(this.ventanaRegistro.nombre));
            else if(estado.equals("ID Igual"))
                this.ventanaEntrada.setProducto(GestorInventario.buscarID(this.ventanaRegistro.id));
            this.panelOscuro.mostrarCentrado(this.ventanaEntrada);
        }
    }
    
    private void botonCerrarActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        this.panelOscuro.setVisible(false);
        this.ventanaActualizar.limpiar();
        this.ventanaActualizar.setVisible(false);
        this.cargarProductos();
    }
    
    private void botonEliminarActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        GestorInventario.eliminar(this.ventanaActualizar.producto);
        this.ventanaActualizar.limpiar();
        this.ventanaActualizar.setVisible(false);
        this.panelOscuro.mostrarCentrado(this.ventanaMensajeActualizar);
        this.ventanaMensajeActualizar.setMensaje("<html>El producto fue<br>eliminado con<br>exito.");
        this.ventanaMensajeActualizar.botonVolver.setVisible(false);
    }
    
    private void botonActualizarActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        this.ventanaActualizar.setVisible(false);
        this.ventanaActualizar.guardarInfoProducto();
        this.panelOscuro.mostrarCentrado(this.ventanaMensajeActualizar);
        boolean valido = GestorInventario.actualizarProducto(this.ventanaActualizar.indice, this.ventanaActualizar.nombre, this.ventanaActualizar.precio, this.ventanaActualizar.proveedor, this.ventanaActualizar.categoria);
        if(valido)
        {
            this.ventanaMensajeActualizar.setMensaje("<html>La información del<br>producto fue actualizada<br>con exito.");
            this.ventanaMensajeActualizar.botonVolver.setVisible(false);
        }
        else
        {
            this.ventanaMensajeActualizar.setMensaje("<html>La información del<br>producto no pudo ser<br>actualizada porque hay<br>un producto con el<br>mismo nombre.");
            this.ventanaMensajeActualizar.botonVolver.setVisible(true);
        }
    }
    
    private void botonVolverMensajeActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        this.ventanaMensajeActualizar.setVisible(false);
        this.panelOscuro.mostrarCentrado(this.ventanaActualizar);
    }
    
    private void botonCerrarMensajeActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        this.ventanaMensajeActualizar.setVisible(false);
        this.ventanaActualizar.limpiar();
        this.panelOscuro.setVisible(false);
        this.cargarProductos();
    }
    
    private void botonActualizarMensajeActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        this.ventanaMensajeActualizar.setVisible(false);
        this.ventanaActualizar.limpiar();
        this.ventanaActualizar.validarSeleccion();
        this.ventanaActualizar.cargarProductos();
        this.ventanaActualizar.cargarCategorias();
        this.panelOscuro.mostrarCentrado(this.ventanaActualizar);
    }
    
    private void botonCerrarEntradaActionPerformed(java.awt.event.ActionEvent evt) {
        this.panelOscuro.setVisible(false);
        this.ventanaEntrada.limpiar();
        this.ventanaEntrada.setVisible(false);
        this.cargarProductos();
    }
    
    private void botonRegistrarEntradaActionPerformed(java.awt.event.ActionEvent evt) { 
        GestorInventario.registrarEntrada(this.ventanaEntrada.indice, this.ventanaEntrada.getCantidad());
        this.ventanaEntrada.setVisible(false);
        this.ventanaEntrada.limpiar();
        this.panelOscuro.mostrarCentrado(this.ventanaMensajeEntrada);
    } 
    
    private void botonCerrarMensajeEntradaActionPerformed(java.awt.event.ActionEvent evt) {
        this.panelOscuro.setVisible(false);
        this.ventanaEntrada.limpiar();
        this.ventanaMensajeEntrada.setVisible(false);
        this.cargarProductos();
    }
    
    private void botonRegistrarMensajeEntradaActionPerformed(java.awt.event.ActionEvent evt) {
        this.ventanaMensajeEntrada.setVisible(false);
        this.ventanaEntrada.limpiar();
        this.ventanaEntrada.validarCampo();
        this.ventanaEntrada.cargarProductos();
        this.panelOscuro.mostrarCentrado(this.ventanaEntrada);
    }
    
    private void botonCerrarSalidaActionPerformed(java.awt.event.ActionEvent evt) {
        this.panelOscuro.setVisible(false);
        this.ventanaSalida.limpiar();
        this.ventanaSalida.setVisible(false);
        this.cargarProductos();
    }
    
    private void botonRegistrarSalidaActionPerformed(java.awt.event.ActionEvent evt) { 
        valido = GestorInventario.registrarSalida(this.ventanaSalida.indice, this.ventanaSalida.getCantidad());
        this.ventanaSalida.setVisible(false);
        if(valido)
        {
            this.ventanaMensajeSalida.textoMensaje.setText("<html>La salida del producto<br>fue registrada<br>exitosamente.");
            this.ventanaMensajeSalida.textoMensaje.setFont(new Font("Inter", 1, 48));
            this.ventanaMensajeSalida.textoNombre.setText("");
            this.ventanaMensajeSalida.textoStock.setText("");
        }
        else
        {
            this.ventanaMensajeSalida.textoMensaje.setText("<html>La salida del producto no pudo ser<br>registrada porque excede<br>el stock disponible");
            this.ventanaMensajeSalida.textoMensaje.setFont(new Font("Inter", 1, 30));
            this.ventanaMensajeSalida.textoNombre.setText(GestorInventario.getProductos().get(this.ventanaSalida.indice).getNombre());
            this.ventanaMensajeSalida.textoStock.setText("Stock disponible: " + GestorInventario.getProductos().get(this.ventanaSalida.indice).getCantidad());
        }
        this.ventanaMensajeSalida.botonVolver.setVisible(!valido);
        this.panelOscuro.mostrarCentrado(this.ventanaMensajeSalida);
    } 
    
    private void botonCerrarMensajeSalidaActionPerformed(java.awt.event.ActionEvent evt) {
        this.panelOscuro.setVisible(false);
        this.ventanaSalida.limpiar();
        this.ventanaMensajeSalida.setVisible(false);
        this.cargarProductos();
    }
    
    private void botonRegistrarMensajeSalidaActionPerformed(java.awt.event.ActionEvent evt) {
        this.ventanaMensajeSalida.setVisible(false);
        this.ventanaSalida.limpiar();
        this.ventanaSalida.validarCampo();
        this.ventanaSalida.cargarProductos();
        this.panelOscuro.mostrarCentrado(this.ventanaSalida);
    }
    
    private void botonVolverMensajeSalidaActionPerformed(java.awt.event.ActionEvent evt) {
        this.ventanaMensajeSalida.setVisible(false);
        this.panelOscuro.mostrarCentrado(this.ventanaSalida);
    }
    
    private void botonCerrarGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {
        this.panelOscuro.setVisible(false);
        this.ventanaGenerarReporte.limpiar();
        this.ventanaGenerarReporte.setVisible(false);
    }
    
    private void botonGenerarGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {
        this.ventanaGenerarReporte.guardarUmbral();
        this.ventanaReporte.mostrarReporte(this.ventanaGenerarReporte.umbral);
        this.panelOscuro.mostrarCentrado(this.ventanaReporte);
    }
    
    private void botonCerrarReporteActionPerformed(java.awt.event.ActionEvent evt) {
        this.panelOscuro.setVisible(false);
        this.ventanaGenerarReporte.limpiar();
        this.ventanaReporte.setVisible(false);
    }
    
    private void botonGenerarOtroReporteActionPerformed(java.awt.event.ActionEvent evt) {
        this.ventanaReporte.setVisible(false);
        this.ventanaGenerarReporte.limpiar();
        this.panelOscuro.mostrarCentrado(this.ventanaGenerarReporte);
    }
    
    public void cargarProductos()
    {
        JPanel grid = new JPanel(new GridLayout(0, 3, 15, 15));
        grid.setBackground(new Color(236, 230, 240));
        grid.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        this.panelProductos.removeAll();
        this.panelProductos.setLayout(new BorderLayout());
        this.panelProductos.setBackground(new Color(236, 230, 240));
        boolean hay = false;
        for (Producto producto : GestorInventario.getProductos()) 
        {
            boolean coincideNombre = campoNombre.getText().isEmpty() || campoNombre.getText().equals("Ingrese el nombre") || producto.getNombre().contains(campoNombre.getText());
            boolean coincidePrecioMenor;
            boolean coincidePrecioMayor;
            try
            {
                coincidePrecioMenor = campoPrecioMenor.getText().isEmpty() || campoPrecioMenor.getText().equals("Precio menor") || producto.getPrecio() >= Float.parseFloat(campoPrecioMenor.getText());
                coincidePrecioMayor = campoPrecioMayor.getText().isEmpty() || campoPrecioMayor.getText().equals("Precio mayor") || producto.getPrecio() <= Float.parseFloat(campoPrecioMayor.getText());
            }
            catch(NumberFormatException error)
            {
                coincidePrecioMenor = false;
                coincidePrecioMayor = false;
            }
            boolean coincideCategoria = menuCategoria.getSelectedIndex() == 0 || producto.getCategoria().equals(menuCategoria.getSelectedItem());
            if(coincideNombre && coincidePrecioMenor && coincidePrecioMayor && coincideCategoria)
            {
                PreviewProducto preview = new PreviewProducto(30, producto);
                grid.add(preview);
                preview.agregarClick(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        PreviewMousePressed(evt, producto);
                    }
                });
                hay = true;
            }
        }
        if(hay)
        {
            this.panelProductos.add(grid, BorderLayout.NORTH);
        }
        else
        {
            this.textoProductosNoEncontrados.setHorizontalAlignment(SwingConstants.CENTER);
            this.panelProductos.add(this.textoProductosNoEncontrados, BorderLayout.CENTER);
        }  
        grid.revalidate();
        grid.repaint();
        int altoArriba = this.panelArriba.getPreferredSize().height;
        int altoProductos = this.panelProductos.getPreferredSize().height;
        this.jPanel1.setPreferredSize(new Dimension(this.jPanel1.getWidth(), altoArriba + altoProductos));
        this.panelProductos.revalidate();
        this.panelProductos.repaint();
        this.jPanel1.revalidate();
        this.fondoScroll.revalidate();
        this.fondoScroll.repaint();
    }
    
    public void cargarCategorias()
    {
        DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) this.menuCategoria.getModel();
        modelo.addAll(GestorInventario.getListaCategorias());
    }

    private void PreviewMousePressed(MouseEvent evt, Producto producto) 
    {
        JRootPane frame = SwingUtilities.getRootPane(this);
        frame.setGlassPane(this.panelOscuro);
        this.panelOscuro.mostrarComponente(null);
        this.panelOscuro.setSize(frame.getSize()); 
        this.ventanaProducto.establecerProducto(producto);
        this.panelOscuro.mostrarCentrado(this.ventanaProducto);
        this.panelOscuro.setVisible(true);
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bienvenido1;
    private javax.swing.JLabel bienvenido2;
    private javax.swing.JButton botonMenu;
    private javax.swing.JButton botonPerfil;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecioMayor;
    private javax.swing.JTextField campoPrecioMenor;
    private javax.swing.JScrollPane fondoScroll;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logoApp;
    private javax.swing.JPopupMenu menuAdministrador;
    private javax.swing.JComboBox<String> menuCategoria;
    private javax.swing.JMenuItem opcionActualizar;
    private javax.swing.JMenuItem opcionEntrada;
    private javax.swing.JMenuItem opcionRegistrar;
    private javax.swing.JMenuItem opcionReporte;
    private javax.swing.JMenuItem opcionSalida;
    private javax.swing.JPanel panelArriba;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JLabel textoCategoria;
    private javax.swing.JLabel textoFiltrarPor;
    private javax.swing.JLabel textoMenos;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel textoPrecio;
    private javax.swing.JLabel textoProductosNoEncontrados;
    // End of variables declaration//GEN-END:variables
    private ImageIcon iconoPerfil;
    private Image iconoPequeno;
    private ImageIcon iconoMenu;
    public PanelOscuro panelOscuro;
    private PanelRegistro ventanaRegistro;
    private PanelMensajeRegistro ventanaMensajeRegistro;
    private PanelActualizacion ventanaActualizar;
    private PanelMensajeActualizacion ventanaMensajeActualizar;
    private PanelEntrada ventanaEntrada;
    private PanelMensajeEntrada ventanaMensajeEntrada;
    private String estado;
    private PanelSalida ventanaSalida;
    private PanelMensajeSalida ventanaMensajeSalida;
    private boolean valido;
    private PanelReporte ventanaGenerarReporte;
    private PanelReporteGenerado ventanaReporte;
    public MenuPerfiles menuPerfiles;
    private InfoProducto ventanaProducto;
    private MenuGestionarPerfiles menuConPerfiles;
    private InfoUsuario ventanaUsuario;
    private PanelNuevoUsuario ventanaNuevoUsuario;
    private MensajeNuevoUsuario mensajeUsuario;
}
