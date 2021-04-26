package hh.swd20.organizer.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Box")
public class Box {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long boxId;

	private String bName;

	private String bDesc;

	private String bLocation;

	@JsonManagedReference(value = "box")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "box")
	private List<Item> items;

	@JsonBackReference(value = "user")
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Box(Long boxId, String bName, String bDesc, String bLocation, User user) {
		super();
		this.boxId = boxId;
		this.bName = bName;
		this.bDesc = bDesc;
		this.bLocation = bLocation;
		this.user = user;
	}

	public Box(String bName, String bDesc, String bLocation, User user) {
		super();
		this.bName = bName;
		this.bDesc = bDesc;
		this.bLocation = bLocation;
		this.user = user;
	}

	public Box(String bName, String bDesc, String bLocation) {
		super();
		this.bName = bName;
		this.bDesc = bDesc;
		this.bLocation = bLocation;
	}

	public Box() {
		super();
		this.boxId = null;
		this.bName = null;
		this.bDesc = null;
		this.bLocation = null;
	}

	public Long getBoxId() {
		return boxId;
	}

	public void setBoxId(Long boxId) {
		this.boxId = boxId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbDesc() {
		return bDesc;
	}

	public void setbDesc(String bDesc) {
		this.bDesc = bDesc;
	}

	public String getbLocation() {
		return bLocation;
	}

	public void setbLocation(String bLocation) {
		this.bLocation = bLocation;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Box [boxId=" + boxId + ", bName=" + bName + ", bDesc=" + bDesc + ", bLocation=" + bLocation + ", user="
				+ this.getUser() + "]";
	}

}
