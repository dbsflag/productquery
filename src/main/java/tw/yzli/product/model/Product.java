package tw.yzli.product.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
@Component
public class Product {
	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@Column(name = "PNAME")
	private String pname;
	@Column(name = "QUANTITY")
	private int quantity;
	@Column(name = "PRICE")
	private int price;

	@Column(name = "PDATE")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTF+8")
	private Date pdate;
	@Column(name = "NOTE")
	private String note;

	//getter&setter方法
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pDate) {
		this.pdate = pDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	//tostring
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", quantity=" + quantity + ", price=" + price + ", pdate="
				+ pdate + ", note=" + note + "]";
	}

}
