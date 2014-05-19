package pl.agh.toik.security;

public class Controller {
	
	@Secured
    public void doIt(int i) {
        System.out.println("controller");
    }
}
