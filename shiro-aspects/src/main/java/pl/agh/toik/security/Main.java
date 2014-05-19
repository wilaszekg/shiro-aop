package pl.agh.toik.security;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.doIt(1);
        //main.doIt(2);
        new Controller().doIt(3);
    }
    
    public void LogIn(String userName, String password){
    	UserContext.getInstance().LogIn(userName, password);
    }

    @Secured
    public void doIt(int i) {
        System.out.println("--- in body");
    }
}
