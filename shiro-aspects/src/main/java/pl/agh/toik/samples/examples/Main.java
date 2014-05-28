package pl.agh.toik.samples.examples;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import pl.agh.toik.security.AuthException;
import pl.agh.toik.security.Secured;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        setupSecurityManager();

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("root", "root");
        token.setRememberMe(true);
        subject.login(token);

        main.doIt(1);

        subject.logout();
        try {
            new Controller().doIt(3);
        } catch (AuthException e) {
            System.out.println("Cought expected exception");
        }
    }

    @Secured
    public void doIt(int i) {
        System.out.println("--- in body");
    }

    protected static void setupSecurityManager() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
    }
    
    protected static void login(String login, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(login, password);
        token.setRememberMe(true);
        subject.login(token);
    }
}
