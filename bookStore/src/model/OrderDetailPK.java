package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ORDER_DETAIL database table.
 * 
 */
@Embeddable
public class OrderDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="order_id", insertable=false, updatable=false)
	private int orderId;

	@Column(insertable=false, updatable=false)
	private String isbn;

	public OrderDetailPK() {
	}
	public int getOrderId() {
		return this.orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderDetailPK)) {
			return false;
		}
		OrderDetailPK castOther = (OrderDetailPK)other;
		return 
			(this.orderId == castOther.orderId)
			&& this.isbn.equals(castOther.isbn);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orderId;
		hash = hash * prime + this.isbn.hashCode();
		
		return hash;
	}
}