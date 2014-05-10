package pl.agh.toik.security;

@Secured
public class Controller {
    public void doIt(int i) {
        System.out.println("controller");
    }
}
