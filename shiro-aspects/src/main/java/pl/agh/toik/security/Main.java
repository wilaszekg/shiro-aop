package pl.agh.toik.security;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        
       
        Controller cont = new Controller();
        
        
        main.doIt(1); //-
        cont.unsecuredAction(); //+
        cont.securedAction(); //-
        
        
        cont.LogIn("test", "123");//role = USER, permission = MID
        System.out.println("Logged in!");
        
        cont.securedAction();//+
        cont.securedForAdminAction(); //-
        cont.securedForUserAction(); //+
        
        cont.maxPermissionRequired();//-
        cont.midPermissionRequired(); //+
        
        cont.LogOut();
        System.out.println("Logged out!");

        cont.securedAction();//-
        
    }
    


    @Secured
    public void doIt(int i) {
        System.out.println("--- in body");
    }
}
