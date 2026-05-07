package views;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.awt.*;
import javax.swing.*;

public class AuthView {

    public AuthView() {}
    public void registroView() {

        JFrame frame = new JFrame("Registro");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4,2,10,10));

        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();

        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = new JTextField();

        JButton registerButton = new JButton("Registrar");

        panel.add(userLabel);
        panel.add(userField);

        panel.add(passLabel);
        panel.add(passField);

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(new JLabel());
        panel.add(registerButton);

        frame.add(panel);

        registerButton.addActionListener(e -> {

            String username = userField.getText();
            String password = String.valueOf(passField.getPassword());
            String nombre = nameField.getText();

            try {

                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/base1",
                        "root",
                        "password"
                );

                String sql = "INSERT INTO usuarios (username, password, nombre_completo) VALUES (?, ?, ?)";

                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, nombre);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(frame, "Registro exitoso");

                userField.setText("");
                passField.setText("");
                nameField.setText("");

                conn.close();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(frame,
                        "Error: el usuario ya existe o falló la conexión");

            }

        });

        frame.setVisible(true);
    }
}