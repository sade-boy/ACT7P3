package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.User;
import models.UserModel;

public class RegisterView extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton guardar;
    private JButton cancelar;

    private UserModel model;

    private UsersView usersView;

    public RegisterView(UsersView usersView) {

        this.usersView = usersView;

        model = new UserModel();

        this.setTitle("Registro de usuario");
        this.setSize(450, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 450, 350);

        JLabel titulo = new JLabel("Nuevo Usuario");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(120, 20, 250, 30);

        panel.add(titulo);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(50, 80, 150, 30);
        panel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(50, 110, 320, 35);
        panel.add(usernameField);

        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(50, 160, 150, 30);
        panel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(50, 190, 320, 35);
        panel.add(passwordField);

        guardar = new JButton("Guardar");
        guardar.setBounds(50, 255, 140, 40);
        guardar.setBackground(Color.BLACK);
        guardar.setForeground(Color.WHITE);

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(230, 255, 140, 40);

        panel.add(guardar);
        panel.add(cancelar);

        this.add(panel);

        guardar.addActionListener(e -> {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("") || password.equals("")) {

                JOptionPane.showMessageDialog(
                        null,
                        "Completa todos los campos"
                );

            } else {

                User u = new User(username, password);

                boolean status = model.registrarUsuario(u);

                if (status) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Usuario registrado correctamente"
                    );

                    usersView.cargarTabla();

                    usersView.setVisible(true);

                    dispose();

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Error al registrar"
                    );
                }
            }
        });

        cancelar.addActionListener(e -> {

            usersView.setVisible(true);

            dispose();
        });
    }
}