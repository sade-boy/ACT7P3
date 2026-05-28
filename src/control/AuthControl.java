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

    public void showRegister() {
        vista.registerView();
    }
}
