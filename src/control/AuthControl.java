package control;

import views.AuthView;

public class AuthControl {

    private AuthView vista;

    public AuthControl() {
        vista = new AuthView();
    }

    public void showLogin() {
        vista.loginView();
    }
<<<<<<< HEAD
}
=======

    public void showRegister() {
        vista.registerView();
    }

    public void showUsers() {
        vista.usersView();
    }
}
>>>>>>> 809b7a8bf1381304f58afe62c4a7e01f2dc14182
