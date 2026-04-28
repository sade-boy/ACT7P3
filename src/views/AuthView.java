package views;

import control.AuthControl;

import java.awt.*;
import javax.swing.*;

public class AuthView {

    public AuthView() {}
    public void registroView() {
        JFrame frame = new JFrame("Registro");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Pantalla de Registro"));

        frame.add(panel);
        frame.setVisible(true);
    }
    public void loginView() {

        JFrame loginFrame = new JFrame("login");
        loginFrame.setSize(500, 500);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color backgroundColor = new Color(20, 60, 20);
        Color cardColor = new Color(40, 120, 40);
        Color accentColor = new Color(255, 220, 0);
        Color textColor = Color.BLACK;

        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        backgroundPanel.setBackground(backgroundColor);
        loginFrame.add(backgroundPanel);

        JPanel loginCard = new JPanel(new GridBagLayout());
        loginCard.setBackground(cardColor);
        loginCard.setPreferredSize(new Dimension(350, 380));
        loginCard.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Iniciar Sesión", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(accentColor);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        loginCard.add(titleLabel, constraints);

        constraints.gridwidth = 1;
        constraints.gridy++;

        JLabel idLabel = new JLabel("ID:");
        idLabel.setForeground(textColor);
        loginCard.add(idLabel, constraints);

        constraints.gridx = 1;
        JTextField idField = new JTextField();
        idField.setBackground(new Color(200, 255, 200));
        idField.setForeground(Color.BLACK);
        loginCard.add(idField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(textColor);
        loginCard.add(passwordLabel, constraints);

        constraints.gridx = 1;
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(new Color(200, 255, 200));
        passwordField.setForeground(Color.BLACK);
        loginCard.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 2;

        JCheckBox rememberCheckBox = new JCheckBox("Recordarme");
        rememberCheckBox.setBackground(cardColor);
        rememberCheckBox.setForeground(textColor);
        loginCard.add(rememberCheckBox, constraints);

        constraints.gridy++;
        JButton loginButton = new JButton("Acceder");
        loginButton.setBackground(accentColor);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginCard.add(loginButton, constraints);

        constraints.gridy++;
        JButton registerButton = new JButton("Registrarse");
        registerButton.setBackground(new Color(180, 255, 100));
        registerButton.setForeground(Color.BLACK);
        loginCard.add(registerButton, constraints);

        backgroundPanel.add(loginCard);

        loginButton.addActionListener(e -> {
        });

        registerButton.addActionListener(e -> {
            AuthControl authController = new AuthControl();
            loginFrame.dispose();
            authController.showRegister();
        });

        loginFrame.setVisible(true);
    }

}