package pl.agh.toik.security.examples;

import pl.agh.toik.security.PermissionRequired;
import pl.agh.toik.security.Secured;

public class Controller {

    @Secured
    public void doIt(int i) {
        System.out.println("controller");
    }

    @PermissionRequired("write")
    public void write() {
        System.out.println("I'm writing something");
    }
}
