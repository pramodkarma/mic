package server.inspiratti.auth.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
public class Users implements UserDetails {

	@Id
	@Column(name = "id",nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "userguid", columnDefinition = "TEXT")
	private String userGuid;

	@NotBlank
	@Column(name = "username", length = 225, nullable = false, unique = true)
	private String userName;

	@NotBlank
	@Column(name = "email", length = 255)
	private String email;

	@NotBlank
	@Column(name = "mobile", length = 12)
	private String mobile;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "genderid", nullable = false)
	private Gender gender;

	@Column(name = "emailtorevalidate", length = 500)
	private String emailToRevalidate;

	@Column(name = "admincomment", length = 500)
	private String adminComment;

	@Column(name = "requirerelogin", columnDefinition = "BOOLEAN")
	private boolean requireReLogin;

	@Column(name = "failedloginattempts")
	private int failedLoginAttempts;

	@NotBlank
	@Column(name = "cannotloginuntildateutc")
	private Date cannotLoginUntilDateUtc;

	@NotBlank
	@Column(name = "isactive", columnDefinition = "BOOLEAN")
	private boolean isActive;

	@NotBlank
	@Column(name = "deleted", columnDefinition = "BOOLEAN")
	private boolean deleted;

	@NotBlank
	@Column(name = "issystemaccount", columnDefinition = "BOOLEAN")
	private boolean isSystemAccount;

	@NotBlank
	@Column(name = "systemname", length = 500)
	private String systemName;

	@NotBlank
	@Column(name = "lastipaddress", length = 50)
	private String lastIpAddress;

	@NotBlank
	@Column(name = "createdonutc")
	private Date createdOnUtc;

	@NotBlank
	@Column(name = "lastlogindateutc")
	private Date lastLoginDateUtc;

	@NotBlank
	@Column(name = "lastactivitydateutc")
	private Date lastActivityDateUtc;

	@NotBlank
	@Column(name = "emailVerified", columnDefinition = "BOOLEAN")
	private boolean emailVerified;

	@NotBlank
	@Column(name = "mobileverified", columnDefinition = "BOOLEAN")
	private boolean mobileVerified;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "userid") }, inverseJoinColumns = {
			@JoinColumn(name = "roleid") })
	private Set<Role> role = new HashSet<>();
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")
	private UserPassword userPassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(String userGuid) {
		this.userGuid = userGuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmailToRevalidate() {
		return emailToRevalidate;
	}

	public void setEmailToRevalidate(String emailToRevalidate) {
		this.emailToRevalidate = emailToRevalidate;
	}

	public String getAdminComment() {
		return adminComment;
	}

	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}

	public boolean isRequireReLogin() {
		return requireReLogin;
	}

	public void setRequireReLogin(boolean requireReLogin) {
		this.requireReLogin = requireReLogin;
	}

	public int getFailedLoginAttempts() {
		return failedLoginAttempts;
	}

	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}

	public Date getCannotLoginUntilDateUtc() {
		return cannotLoginUntilDateUtc;
	}

	public void setCannotLoginUntilDateUtc(Date cannotLoginUntilDateUtc) {
		this.cannotLoginUntilDateUtc = cannotLoginUntilDateUtc;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isSystemAccount() {
		return isSystemAccount;
	}

	public void setSystemAccount(boolean isSystemAccount) {
		this.isSystemAccount = isSystemAccount;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getLastIpAddress() {
		return lastIpAddress;
	}

	public void setLastIpAddress(String lastIpAddress) {
		this.lastIpAddress = lastIpAddress;
	}

	public Date getCreatedOnUtc() {
		return createdOnUtc;
	}

	public void setCreatedOnUtc(Date createdOnUtc) {
		this.createdOnUtc = createdOnUtc;
	}

	public Date getLastLoginDateUtc() {
		return lastLoginDateUtc;
	}

	public void setLastLoginDateUtc(Date lastLoginDateUtc) {
		this.lastLoginDateUtc = lastLoginDateUtc;
	}

	public Date getLastActivityDateUtc() {
		return lastActivityDateUtc;
	}

	public void setLastActivityDateUtc(Date lastActivityDateUtc) {
		this.lastActivityDateUtc = lastActivityDateUtc;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public boolean isMobileVerified() {
		return mobileVerified;
	}

	public void setMobileVerified(boolean mobileVerified) {
		this.mobileVerified = mobileVerified;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public UserPassword getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(UserPassword userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return userPassword.getPassword();
	}

	@Override
	public String getUsername() {
		
		return userName; 
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return isActive;
	}

}
