package pl.agh.toik.security;

public final class UserContext {
	private static volatile UserContext instance = null;
	
	private UserContext(){		
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

	public boolean isAutenthicated() {
		return isAutenthicated;
	}

	public void setAutenthicated(boolean isAutenthicated) {
		this.isAutenthicated = isAutenthicated;
	}
	
	

}
