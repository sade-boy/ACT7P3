package views;

import java.awt.Color;
import java.awt.Font;
<<<<<<< HEAD
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.User;

>>>>>>> 809b7a8bf1381304f58afe62c4a7e01f2dc14182

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.AuthModel;

public class AuthView {

    private AuthModel model;

    public AuthView() {
        model = new AuthModel();
    }

    public void loginView() {

        JFrame ventana = new JFrame();

        ventana.setTitle("Login");
        ventana.setSize(500, 400);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 500, 400);

        JLabel titulo = new JLabel("Iniciar sesión");
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        titulo.setBounds(140, 30, 250, 30);

        panel.add(titulo);

        JLabel userLabel = new JLabel("Usuario");
        userLabel.setBounds(60, 90, 100, 30);
        panel.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(60, 120, 340, 35);
        panel.add(userField);

        JLabel passLabel = new JLabel("Contraseña");
        passLabel.setBounds(60, 180, 100, 30);
        panel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(60, 210, 340, 35);
        panel.add(passField);

        JButton login = new JButton("Entrar");
        login.setBounds(60, 280, 340, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);

        panel.add(login);

        ventana.add(panel);

        login.addActionListener(e -> {

            String username = userField.getText();
            String password = new String(passField.getPassword());

            boolean acceso = model.access(username, password);

<<<<<<< HEAD
            if (acceso) {
=======
	    JTextArea bio = new JTextArea();
	    bio.setLineWrap(true);
	    bio.setWrapStyleWord(true);
	    bio.setBackground(new Color(218, 230, 225));
	    bio.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));

	    JScrollPane bioScroll = new JScrollPane(bio);
	    bioScroll.setBounds(18, 25, 325, 50);
	    bioPanel.add(bioScroll);

	    panel.add(bioPanel);

	    // ---------- Panel derecho ----------
	    JPanel registerContainer = new JPanel();
	    registerContainer.setLayout(null);
	    registerContainer.setBounds(500, 60, 410, 470);
	    registerContainer.setBackground(new Color(245, 247, 250));
	    registerContainer.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true));
	    panel.add(registerContainer);

	    JLabel infoRegistro = new JLabel("Completa tu registro");
	    infoRegistro.setFont(new Font("Lucida Grande", Font.BOLD, 22));
	    infoRegistro.setHorizontalAlignment(SwingConstants.CENTER);
	    infoRegistro.setBounds(70, 25, 270, 30);
	    registerContainer.add(infoRegistro);

	    // Preferencias
	    JLabel preferenciasLabel = new JLabel("Preferencias alimenticias");
	    preferenciasLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    preferenciasLabel.setBounds(35, 80, 220, 20);
	    registerContainer.add(preferenciasLabel);

	    JCheckBox sweetOption = new JCheckBox("Dulce");
	    sweetOption.setBounds(35, 110, 100, 25);
	    sweetOption.setBackground(registerContainer.getBackground());
	    sweetOption.setFocusPainted(false);
	    registerContainer.add(sweetOption);

	    JCheckBox saltyOption = new JCheckBox("Salado");
	    saltyOption.setBounds(150, 110, 100, 25);
	    saltyOption.setBackground(registerContainer.getBackground());
	    saltyOption.setFocusPainted(false);
	    registerContainer.add(saltyOption);

	    JCheckBox healthyOption = new JCheckBox("Saludable");
	    healthyOption.setBounds(265, 110, 110, 25);
	    healthyOption.setBackground(registerContainer.getBackground());
	    healthyOption.setFocusPainted(false);
	    registerContainer.add(healthyOption);

	    // Términos
	    JLabel terminosLabel = new JLabel("Términos y condiciones");
	    terminosLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    terminosLabel.setBounds(35, 160, 220, 20);
	    registerContainer.add(terminosLabel);

	    JRadioButton acceptTerms = new JRadioButton("Acepto los términos");
	    acceptTerms.setBounds(35, 190, 160, 25);
	    acceptTerms.setBackground(registerContainer.getBackground());
	    acceptTerms.setFocusPainted(false);
	    registerContainer.add(acceptTerms);

	    JRadioButton rejectTerms = new JRadioButton("Rechazo los términos");
	    rejectTerms.setBounds(210, 190, 170, 25);
	    rejectTerms.setBackground(registerContainer.getBackground());
	    rejectTerms.setFocusPainted(false);
	    registerContainer.add(rejectTerms);

	    ButtonGroup terms = new ButtonGroup();
	    terms.add(acceptTerms);
	    terms.add(rejectTerms);

	    // ComboBox colonia
	    JLabel coloniaLabel = new JLabel("Colonia");
	    coloniaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
	    coloniaLabel.setBounds(35, 240, 100, 20);
	    registerContainer.add(coloniaLabel);

	    String[] colonias = {"Camino Real", "La Fuente", "Villas del Encanto"};
	    JComboBox<String> list = new JComboBox<>(colonias);
	    list.setBounds(35, 270, 340, 35);
	    list.setBackground(Color.WHITE);
	    registerContainer.add(list);

	    // Botón registrar
	    JButton crearCuenta = new JButton("Crear cuenta");
	    crearCuenta.setBounds(35, 335, 340, 42);
	    crearCuenta.setBackground(Color.BLACK);
	    crearCuenta.setForeground(Color.WHITE);
	    crearCuenta.setFocusPainted(false);
	    crearCuenta.setOpaque(true);
	    crearCuenta.setBorderPainted(false);
	    registerContainer.add(crearCuenta);

	    // Botón volver
	    JButton volverLogin = new JButton("Ya tengo cuenta");
	    volverLogin.setBounds(35, 390, 340, 42);
	    volverLogin.setBackground(new Color(230, 230, 230));
	    volverLogin.setForeground(Color.BLACK);
	    volverLogin.setFocusPainted(false);
	    volverLogin.setOpaque(true);
	    volverLogin.setBorderPainted(false);
	    registerContainer.add(volverLogin);

	    // Acción registrar
	    crearCuenta.addActionListener(e -> {
	        boolean valido = true;

	        String nombre = nombreField.getText().trim();
	        String correo = correoField.getText().trim();
	        String password = new String(passwordField.getPassword()).trim();
	        String biografia = bio.getText().trim();

	        if (nombre.isEmpty()) {
	            nombreField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	            valido = false;
	        } else {
	            nombreField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
	        }

	        if (correo.isEmpty() || !correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
	            correoField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	            valido = false;
	        } else {
	            correoField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
	        }

	        if (password.isEmpty() || password.length() < 5) {
	            passwordField.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	            valido = false;
	        } else {
	            passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
	        }

	        if (biografia.isEmpty()) {
	            bio.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
	            valido = false;
	        } else {
	            bio.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
	        }

	        if (!acceptTerms.isSelected()) {
	            JOptionPane.showMessageDialog(
	                null,
	                "Debes aceptar los términos y condiciones.",
	                "Aviso",
	                JOptionPane.WARNING_MESSAGE
	            );
	            valido = false;
	        }

	        if (valido) {
	            String coloniaSeleccionada = (String) list.getSelectedItem();

	            StringBuilder preferencias = new StringBuilder();
	            if (sweetOption.isSelected()) preferencias.append("Dulce, ");
	            if (saltyOption.isSelected()) preferencias.append("Salado, ");
	            if (healthyOption.isSelected()) preferencias.append("Saludable, ");

	            if (preferencias.length() > 0) {
	                preferencias.setLength(preferencias.length() - 2);
	            } else {
	                preferencias.append("Ninguna");
	            }

	            JOptionPane.showMessageDialog(
	                null,
	                "Registro exitoso\n\n" +
	                "Nombre: " + nombre + "\n" +
	                "Correo: " + correo + "\n" +
	                "Colonia: " + coloniaSeleccionada + "\n" +
	                "Preferencias: " + preferencias,
	                "Éxito",
	                JOptionPane.INFORMATION_MESSAGE
	            );

	            //router("login");
	            ventana.dispose();
		    	loginView();
	        }
	    });

	    // Acción volver
	    volverLogin.addActionListener(e -> {
	        //router("login");
	    	ventana.dispose();
	    	loginView();
	    });

	    ventana.add(panel); 
	    ventana.setVisible(true);
	}

>>>>>>> 809b7a8bf1381304f58afe62c4a7e01f2dc14182

                JOptionPane.showMessageDialog(
                        null,
                        "Bienvenido"
                );

<<<<<<< HEAD
                ventana.dispose();

                UsersView uv = new UsersView();
                uv.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Usuario o contraseña incorrectos"
                );
            }
        });

        ventana.setVisible(true);
    }
=======
    public void usersView() {

        JFrame ventana = new JFrame();

        ventana.setTitle("Visualización de Usuarios");
        ventana.setSize(700, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 700, 500);
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Lista de usuarios registrados");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBounds(160, 20, 400, 30);

        panel.add(titulo);

        JTable tablaUsuarios = new JTable();

        JScrollPane scroll = new JScrollPane(tablaUsuarios);
        scroll.setBounds(40, 80, 600, 300);

        panel.add(scroll);

        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("USERNAME");
        modeloTabla.addColumn("NOMBRE COMPLETO");

        tablaUsuarios.setModel(modeloTabla);

        ArrayList<User> listaUsuarios = model.obtenerUsuarios();

        for (User usuario : listaUsuarios) {

            modeloTabla.addRow(new Object[]{
                    usuario.getId(),
                    usuario.getUsername(),
                    usuario.getNombreCompleto()
            });
        }

        ventana.add(panel);

        ventana.setVisible(true);
    }

>>>>>>> 809b7a8bf1381304f58afe62c4a7e01f2dc14182
}