package server.inspiratti.auth.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "permissionrecord")
public class PermissionRecord {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", length = 500)
	private String name;
	
	@Column(name = "systemname", length = 500)
	private String systemName;
	
	@Column(name = "category", length = 500)
	private String category;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "permissionrecordrolemapping", joinColumns = { @JoinColumn(name = "permissionrecordid") }, inverseJoinColumns = {
			@JoinColumn(name = "roleid") })
	private Set<Role> role = new HashSet<>();

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSystemName() {
		return systemName;
	}

	public String getCategory() {
		return category;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
}
