package pl.agh.toik.security.examples;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

    private static void login(String login, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(login, password);
        token.setRememberMe(true);
        subject.login(token);
    }
}
