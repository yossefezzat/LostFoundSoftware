package database;

import java.util.ArrayList;

public class User extends Item {

	private Integer id;
	private String Password;
	private String FirstName;
	private String LastName;
	private String Email;

	User() {

	}

	User(Integer id, String d, String f, String l, String e) {

		this.id = id;
		this.Password = d;
		this.FirstName = f;
		this.LastName = l;
		this.Email = e;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
