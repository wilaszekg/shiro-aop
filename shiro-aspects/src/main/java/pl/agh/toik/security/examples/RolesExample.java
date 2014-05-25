package pl.agh.toik.security.examples;

import pl.agh.toik.security.AuthException;

public class RolesExample extends Main {
    public static void main(String[] args) {
        setupSecurityManager();

        Controller controller = new Controller();
        login("root", "root");
        controller.doItAdmin();

        login("guest", "guest");

        try {
            controller.doItAdmin();
        } catch (AuthException e) {
            System.out.println("Guest shouldn't be permitted to execute admin's functions");
        }
    }
}
