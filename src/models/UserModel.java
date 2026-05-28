package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserModel {

    private final String URL = "jdbc:mysql://localhost:3306/login_app";
    private final String USER = "root";
    private final String PASSWORD = "";

    public Connection conectar() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public ArrayList<User> obtenerUsuarios() {

        ArrayList<User> lista = new ArrayList<>();

        String query = "SELECT * FROM usuarios";

        try {

            Connection conn = conectar();

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User u = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );

                lista.add(u);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean registrarUsuario(User u) {

        String query =
                "INSERT INTO usuarios(username, password) VALUES (?, ?)";

        try {

            Connection conn = conectar();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());

            int filas = ps.executeUpdate();

            ps.close();
            conn.close();

            return filas > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}