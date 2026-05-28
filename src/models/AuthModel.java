package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AuthModel {

    private UserModel userModel;

    public AuthModel() {
        userModel = new UserModel();
    }

    public boolean access(String username, String password) {

        String query =
                "SELECT * FROM usuarios WHERE username = ? AND password = ?";

        try {

            Connection conn = userModel.conectar();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            boolean existe = rs.next();

            rs.close();
            ps.close();
            conn.close();

            return existe;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
<<<<<<< HEAD
}
=======

    public ArrayList<User> obtenerUsuarios() {

        ArrayList<User> listaUsuarios = new ArrayList<>();

        String query = "SELECT * FROM usuarios";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                int id = rs.getInt("id");
                String username = rs.getString("username");
                String nombreCompleto = rs.getString("nombreCompleto");

                User usuario = new User(id, username, nombreCompleto);

                listaUsuarios.add(usuario);
            }

            rs.close();
            st.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return listaUsuarios;
    }
}
>>>>>>> 809b7a8bf1381304f58afe62c4a7e01f2dc14182
