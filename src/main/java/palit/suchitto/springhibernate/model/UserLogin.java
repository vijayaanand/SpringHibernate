package palit.suchitto.springhibernate.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserLogin {

	@NotEmpty
	@Size(min=4, max=20)
	private String uName;
		
	@NotEmpty
	@Size(min=8, max=15)
	private String password;

	public String getPassword() {
		return password;
	}

	public String getUName() {
		return uName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUName(String userName) {
		this.uName = userName;
	}	
}
