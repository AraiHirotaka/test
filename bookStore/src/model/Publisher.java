package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PUBLISHER database table.
 * 
 */
@Entity
@NamedQuery(name="Publisher.findAll", query="SELECT p FROM Publisher p")
public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="publish_name")
	private String publishName;

	//bi-directional many-to-one association to Book
	@OneToMany(mappedBy="publisher")
	private List<Book> books;

	public Publisher() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublishName() {
		return this.publishName;
	}

	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book addBook(Book book) {
		getBooks().add(book);
		book.setPublisher(this);

		return book;
	}

	public Book removeBook(Book book) {
		getBooks().remove(book);
		book.setPublisher(null);

		return book;
	}

}