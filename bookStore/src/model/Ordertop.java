package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ORDERTOP database table.
 * 
 */
@Entity
@NamedQuery(name="Ordertop.findAll", query="SELECT o FROM Ordertop o")
public class Ordertop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date orderDate;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="email")
	private Account account;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="ordertop")
	private List<OrderDetail> orderDetails;

	public Ordertop() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setOrdertop(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setOrdertop(null);

		return orderDetail;
	}

}