package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthModel {

    private final String URL =
            "jdbc:mysql://localhost:3306/login_app";

    private final String USER = "root";

    private final String PASSWORD = "";

    public AuthModel() {

    }

    public boolean access(String username, String password) {

        String query =
                "SELECT * FROM usuarios "
              + "WHERE username = ? AND password = ?";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

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
}
