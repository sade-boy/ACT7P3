package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.User;
import models.UserModel;

public class UsersView extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;
    private JButton nuevoRegistro;

    private UserModel userModel;

    public UsersView() {

        userModel = new UserModel();

        this.setTitle("Usuarios registrados");
        this.setSize(700, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setBackground(Color.WHITE);

        nuevoRegistro = new JButton("Nuevo Registro");
        nuevoRegistro.setFont(new Font("Arial", Font.BOLD, 15));

        top.add(nuevoRegistro);

        this.add(top, BorderLayout.NORTH);

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("USERNAME");
        modelo.addColumn("PASSWORD");

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);

        this.add(scroll, BorderLayout.CENTER);

        cargarTabla();

        nuevoRegistro.addActionListener(e -> {

            RegisterView rv = new RegisterView(this);

            rv.setVisible(true);

            this.setVisible(false);
        });
    }

    public void cargarTabla() {

        modelo.setRowCount(0);

        ArrayList<User> lista = userModel.obtenerUsuarios();

        for (User u : lista) {

            Object fila[] = {
                    u.getId(),
                    u.getUsername(),
                    u.getPassword()
            };

            modelo.addRow(fila);
        }
    }
}