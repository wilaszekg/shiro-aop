package pl.agh.toik.security;

import java.util.ArrayList;
import java.util.List;

import pl.agh.toik.security.enums.Permission;
import pl.agh.toik.security.enums.Role;

public final class UserContext {
	private static volatile UserContext instance = null;
	
	private UserContext(){	
		roles = new ArrayList<Role>();
		permissions = new ArrayList<Permission>();
		isAutenthicated = false;
	}
	
	public static UserContext getInstance(){
        if (instance == null) {
            synchronized (UserContext.class) {
                if (instance == null) {
                    instance = new UserContext();
                }
            }
        }
        return instance;
	}
	
	private boolean isAutenthicated = false;
	private List<Role> roles;
	private List<Permission> permissions;


	public boolean isAutenthicated() {
		return isAutenthicated;
	}

	
	public boolean LogIn(String userName, String password){
		//TODO check user
		if(userName.equals("test") && password.equals("123")){
			isAutenthicated = true;
			roles = FetchRolesForUser(userName);
			permissions = FetchPermissionsForUser(userName);
			return true;			
		}
		else {
			isAutenthicated = false;
			return false;
		}		
	}
	
	private List<Role> FetchRolesForUser(String userName){
		//TODO
		return new ArrayList<Role>();
	}
	
	private List<Permission> FetchPermissionsForUser(String userName){
		//TODO
		return new ArrayList<Permission>();
	}
	
	@Secured
	public void LogOut(){
		isAutenthicated = false;
		roles.clear();
		permissions.clear();
	}
		
	

}
