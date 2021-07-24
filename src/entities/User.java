package entities;


public class User {
	private int id;
	private String fName;
	private String lName;
	private String username;
	private String password;
	private String email;
	
	public User(int id, String fName, String lName, String email, String username, String password) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	//get methods
	public int getID() {
		return this.id;
	}
	public String getName() {
		return(fName + " " + lName);
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getMaskedPassword() {
		int length = this.password.length();
		String maskedPassword = "";
		for(int i = 0; i < length; i++) {
			maskedPassword+= "*";
		}
		return maskedPassword;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	
	//set methods
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
