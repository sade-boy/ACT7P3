package models;

public class User {

    private int id;
    private String username;
<<<<<<< HEAD
    private String password;

    public User() {

    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
=======
    private String nombreCompleto;

    public User(int id, String username, String nombreCompleto) {
        this.id = id;
        this.username = username;
        this.nombreCompleto = nombreCompleto;
>>>>>>> 809b7a8bf1381304f58afe62c4a7e01f2dc14182
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

<<<<<<< HEAD
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
=======
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
>>>>>>> 809b7a8bf1381304f58afe62c4a7e01f2dc14182
