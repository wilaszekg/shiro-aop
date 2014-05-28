package pl.agh.toik.samples.examples;

import pl.agh.toik.security.AuthException;

public class PermissionsExample extends Main {
    public static void main(String[] args) {
        setupSecurityManager();

        Controller controller = new Controller();
        login("root", "root");
        controller.write();

        login("guest", "guest");

        try {
            controller.write();
        } catch (AuthException e) {
            System.out.println("Guest shouldn't be permitted to write");
        }
    }
}
