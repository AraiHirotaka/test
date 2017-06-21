package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BOOKS database table.
 * 
 */
@Entity
@Table(name="BOOKS")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;

	@Column(name="book_name")
	private String bookName;

	private int page;

	private double price;

	@Temporal(TemporalType.DATE)
	@Column(name="release_date")
	private Date releaseDate;

	//bi-directional many-to-one association to Publisher
	@ManyToOne
	@JoinColumn(name="publish_id")
	private Publisher publisher;

	//bi-directional many-to-many association to Author
	@ManyToMany
	@JoinTable(
		name="BOOK_AUTHOR"
		, joinColumns={
			@JoinColumn(name="isbn")
			}
		, inverseJoinColumns={
			@JoinColumn(name="author_id")
			}
		)
	private List<Author> authors;

	//bi-directional many-to-many association to Account
	@ManyToMany
	@JoinTable(
		name="CART"
		, joinColumns={
			@JoinColumn(name="isbn")
			}
		, inverseJoinColumns={
			@JoinColumn(name="email")
			}
		)
	private List<Account> accounts;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="book")
	private List<OrderDetail> orderDetails;

	public Book() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setBook(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setBook(null);

		return orderDetail;
	}

}