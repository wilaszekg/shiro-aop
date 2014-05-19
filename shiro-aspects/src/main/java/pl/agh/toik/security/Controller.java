package pl.agh.toik.security;

import pl.agh.toik.security.enums.Permission;
import pl.agh.toik.security.enums.Role;

public class Controller {
	
    public void LogIn(String userName, String password){
    	UserContext.getInstance().LogIn(userName, password);
    }
	
    public void unsecuredAction() {
    	System.out.println("unsecured Action");
    }
    
	@Secured
    public void securedAction() {
        System.out.println("secured Action");
    }
	
	@RoleRequired(role = Role.USER)
    public void securedForUserAction() {
    	System.out.println("user action");
    }
    
	@RoleRequired(role = Role.ADMIN)
    public void securedForAdminAction() {
        System.out.println("admin action");
    }
	
	@PermissionRequired(permission = Permission.MAX)
	public void maxPermissionRequired() {
		System.out.println("max permission action");
	}
	
	@PermissionRequired(permission = Permission.MID)
	public void midPermissionRequired() {
		System.out.println("MID permission action");
	}
	
	public void LogOut(){
		UserContext.getInstance().LogOut();
	}
}
