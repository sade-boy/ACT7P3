package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


import models.AuthModel;

public class AuthView {

	private AuthModel model;
	
	
	public AuthView() {
		
		model = new AuthModel();

	}
	
	public void loginView()
	{
		
		JFrame ventana = new JFrame();
		ventana.setSize(1000, 640);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setMinimumSize(new Dimension(200,200));
		ventana.setMaximumSize(new Dimension(1200,800));
		ventana.setTitle("Hola"); 
		ventana.getContentPane().setBackground(Color.decode("#C8DEBD"));
		ventana.setLayout(null);
		
		JTextField textField;
		JPasswordField passwordField;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255)); 
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setSize(1000, 600); 
		
		JLabel lblNewLabel = new JLabel("UABCS - DASC\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Kefa", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 35, 210, 26);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(36, 186, 353, 81);
		lblNewLabel_8.setBorder(BorderFactory.createTitledBorder("Correo electrónico"));
		panel.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBackground(new Color(218, 230, 225));
		textField.setBounds(49, 211, 328, 42);
		panel.add(textField);
		textField.setBorder(new LineBorder(new Color(91, 253, 255), 1, true));
		textField.setBorder(null);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(218, 230, 225));
		passwordField.setBounds(49, 300, 295, 42);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setOpaque(true);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String passText = new String(passwordField.getPassword());
				Boolean flag1 = false, flag2 = false;
				
				
				if( passText.equals("") ) {
					
					passwordField.setBorder(BorderFactory.createLineBorder(Color.red,2));
					
				}else {
					
					passwordField.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag1 = true;
				}
				
				
				if(textField.getText().equals("")) {
					textField.setBorder(BorderFactory.createLineBorder(Color.red,2));
				}else {
					
					textField.setBorder(BorderFactory.createLineBorder(Color.green,2));
					flag2 = true;
				}
				
				if(flag1 && flag2) { 
					
					 if(model.access(textField.getText(), passText) ) {
						 JOptionPane.showMessageDialog(null, "Bienvenido.");
						 
						 ventana.dispose();
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Error al acceder","verifique su información",JOptionPane.WARNING_MESSAGE);
					} 
					
					
				}
				
			}
		});
		btnNewButton.setBounds(36, 413, 341, 37);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Sabiduría como meta, patria como destino ");
		lblNewLabel_1.setBounds(69, 73, 308, 16);
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		
		
		JLabel lblNewLabel_2_1 = new JLabel("Ingresa al panel administrador");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblNewLabel_2_1.setBounds(49, 109, 340, 39);
		lblNewLabel_2_1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setBorder(BorderFactory.createTitledBorder("Contraseña"));
		lblNewLabel_8_1.setBounds(36, 279, 353, 81);
		panel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recordar contraseña");
		chckbxNewCheckBox.setBounds(36, 372, 180, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_3 = new JLabel("¿Aún no tienes cuenta?");
		lblNewLabel_3.setBounds(225, 462, 152, 16);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton2 = new JButton("Crea una aquí");
		btnNewButton2.setBackground(new Color(0, 0, 0));
		btnNewButton2.setOpaque(true);
		btnNewButton2.setForeground(new Color(0, 0, 0));
		btnNewButton2.setBounds(205, 490, 200, 20);
		btnNewButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ventana.dispose(); 
		    	registerView();
			}});
		
		panel.add(btnNewButton2);
		
		ventana.add(panel);
		ventana.setVisible(true);
	}
	
	public void registerView()
	{
		JFrame ventana = new JFrame();
		ventana.setSize(1000, 640);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setMinimumSize(new Dimension(200,200));
		ventana.setMaximumSize(new Dimension(1200,800));
		ventana.setTitle("Hola"); 
		ventana.getContentPane().setBackground(Color.decode("#C8DEBD"));
		ventana.setLayout(null); 

	    JPanel panel = new JPanel();
	    panel.setBackground(Color.WHITE);
	    panel.setLayout(null);
	    panel.setBounds(0, 0, 1000, 600);

	    // Título principal
	    JLabel titulo = new JLabel("UABCS – DASC");
	    titulo.setForeground(Color.BLACK);
	    titulo.setFont(new Font("Kefa", Font.PLAIN, 24));
	    titulo.setHorizontalAlignment(SwingConstants.CENTER);
	    titulo.setBounds(110, 30, 260, 35);
	    panel.add(titulo);

	    JLabel subtitulo = new JLabel("Crea tu cuenta de usuario");
	    subtitulo.setForeground(Color.BLACK);
	    subtitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
	    subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    subtitulo.setBounds(75, 90, 340, 35);
	    panel.add(subtitulo);

	    JLabel lema = new JLabel("Sabiduría como meta, patria como destino");
	    lema.setHorizontalAlignment(SwingConstants.CENTER);
	    lema.setBounds(70, 65, 340, 20);
	    panel.add(lema);

	    // ---------- Campo Nombre ----------
	    JPanel nombrePanel = new JPanel(null);
	    nombrePanel.setBackground(Color.WHITE);
	    nombrePanel.setBorder(BorderFactory.createTitledBorder("Nombre completo"));
	    nombrePanel.setBounds(45, 145, 360, 75);

	    JTextField nombreField = new JTextField();
	    nombreField.setBounds(18, 28, 325, 35);
	    nombreField.setBackground(new Color(218, 230, 225));
	    nombreField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
	    nombrePanel.add(nombreField);

	    panel.add(nombrePanel);

	    // ---------- Campo Correo ----------
	    JPanel correoPanel = new JPanel(null);
	    correoPanel.setBackground(Color.WHITE);
	    correoPanel.setBorder(BorderFactory.createTitledBorder("Correo electrónico"));
	    correoPanel.setBounds(45, 230, 360, 75);

	    JTextField correoField = new JTextField();
	    correoField.setBounds(18, 28, 325, 35);
	    correoField.setBackground(new Color(218, 230, 225));
	    correoField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
	    correoPanel.add(correoField);

	    panel.add(correoPanel);

	    // ---------- Campo Contraseña ----------
	    JPanel passPanel = new JPanel(null);
	    passPanel.setBackground(Color.WHITE);
	    passPanel.setBorder(BorderFactory.createTitledBorder("Contraseña"));
	    passPanel.setBounds(45, 315, 360, 75);

	    JPasswordField passwordField = new JPasswordField();
	    passwordField.setBounds(18, 28, 290, 35);
	    passwordField.setBackground(new Color(218, 230, 225));
	    passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
	    passPanel.add(passwordField);

	    JLabel iconoOjo = new JLabel();
	    iconoOjo.setBounds(318, 36, 20, 20);
	    try {
	        iconoOjo.setIcon(new ImageIcon(this.getClass().getResource("/img/hidden.png")));
	    } catch (Exception ex) {
	        iconoOjo.setText("👁");
	    }
	    passPanel.add(iconoOjo);

	    panel.add(passPanel);

	    // ---------- Campo Biografía ----------
	    JPanel bioPanel = new JPanel(null);
	    bioPanel.setBackground(Color.WHITE);
	    bioPanel.setBorder(BorderFactory.createTitledBorder("Biografía"));
	    bioPanel.setBounds(45, 400, 360, 90);

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

}






