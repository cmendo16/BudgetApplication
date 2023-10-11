// this class represents a user
public class User {
	private String username; 
	private String password; 
	
	/*
	 * no-arg constructor
	 */
	public User() {
		
	}
	
	/*
	 * constructor that accepts arguments 
	 */
	public User(String username, String password) { 
		this.username = username; 
		this.password = password;
		
	}
	
	// setter and getter methods for each user and password
	public void setUsername(String username) { 
		this.username = username; 
	}
	
	public void setPassowrd(String password) { 
		this.password = password;
	}
	
	public String getUsername() { 
		return username; 
	}
	
	public String getPassword() { 
		return password; 
	}
}
