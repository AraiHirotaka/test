package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String email;

	private String password;

	//bi-directional many-to-many association to Book
	@ManyToMany(mappedBy="accounts")
	private List<Book> books;

	//bi-directional many-to-one association to Ordertop
	@OneToMany(mappedBy="account")
	private List<Ordertop> ordertops;

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

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Ordertop> getOrdertops() {
		return this.ordertops;
	}

	public void setOrdertops(List<Ordertop> ordertops) {
		this.ordertops = ordertops;
	}

	public Ordertop addOrdertop(Ordertop ordertop) {
		getOrdertops().add(ordertop);
		ordertop.setAccount(this);

		return ordertop;
	}

	public Ordertop removeOrdertop(Ordertop ordertop) {
		getOrdertops().remove(ordertop);
		ordertop.setAccount(null);

		return ordertop;
	}

}