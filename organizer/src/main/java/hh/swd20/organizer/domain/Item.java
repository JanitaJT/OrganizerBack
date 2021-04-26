package hh.swd20.organizer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;

	private String iName;

	@JsonBackReference(value="box")
	@ManyToOne
	@JoinColumn(name = "boxId")
	private Box box;

	@JsonBackReference(value="cate")
	@ManyToOne
	@JoinColumn(name = "cateId")
	private Category category;

	public Item(Long itemId, String iName, Box box, Category category) {
		super();
		this.itemId = itemId;
		this.iName = iName;
		this.box = box;
		this.category = category;
	}

	public Item(String iName, Box box, Category category) {
		super();
		this.iName = iName;
		this.box = box;
		this.category = category;
	}
	public Item(Long itemId, String iName) {
		super();
		this.itemId = itemId;
		this.iName = iName;
	}

	public Item() {
		super();
		this.itemId = null;
		this.iName = null;

	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {

		return "Item [itemId=" + itemId + ", iName=" + iName + "box=" + this.getBox() + "category=" + this.getCategory()
				+ "]";
	}

}
