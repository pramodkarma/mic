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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "isactive", columnDefinition = "BOOLEAN")
	private boolean isActive;

	@Column(name = "issystemrole", columnDefinition = "BOOLEAN")
	private boolean isSystemRole;

	@Column(name = "systemname")
	private String systemName;

	@Column(name = "enablepasswordlifetime", columnDefinition = "BOOLEAN")
	private boolean EnablePasswordLifetime;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "role")
	private Set<Users> users = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "role")
	private Set<PermissionRecord> permissionRecords = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isSystemRole() {
		return isSystemRole;
	}

	public void setSystemRole(boolean isSystemRole) {
		this.isSystemRole = isSystemRole;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public boolean isEnablePasswordLifetime() {
		return EnablePasswordLifetime;
	}

	public void setEnablePasswordLifetime(boolean enablePasswordLifetime) {
		EnablePasswordLifetime = enablePasswordLifetime;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<PermissionRecord> getPermissionRecords() {
		return permissionRecords;
	}

	public void setPermissionRecords(Set<PermissionRecord> permissionRecords) {
		this.permissionRecords = permissionRecords;
	}
	
}
