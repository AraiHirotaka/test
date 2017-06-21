package jp.co.comnic.javalesson.webapp.bookstore.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String password;

	public Account() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [email=" + email + "]";
	}
}