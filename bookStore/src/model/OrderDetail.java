package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ORDER_DETAIL database table.
 * 
 */
@Entity
@Table(name="ORDER_DETAIL")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailPK id;

	private double salesprice;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="isbn")
	private Book book;

	//bi-directional many-to-one association to Ordertop
	@ManyToOne
	@JoinColumn(name="order_id")
	private Ordertop ordertop;

	public OrderDetail() {
	}

	public OrderDetailPK getId() {
		return this.id;
	}

	public void setId(OrderDetailPK id) {
		this.id = id;
	}

	public double getSalesprice() {
		return this.salesprice;
	}

	public void setSalesprice(double salesprice) {
		this.salesprice = salesprice;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Ordertop getOrdertop() {
		return this.ordertop;
	}

	public void setOrdertop(Ordertop ordertop) {
		this.ordertop = ordertop;
	}

}