package com.example.demo.Security;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=45, nullable = false)
	@NotBlank
//	@Size(min =3, message="Firstname must be at least 3 characters")
	private String firstName;
	
	@Column(length=45, nullable = false)
//	@NotBlank
//	@Size(min =3, message="LastName must be at least 3 characters")
	private String lastName;
	
	@Column(length=45, nullable = false, unique = true)
//	@NotBlank
//	@Email(message = "Please enter a valid email")
	private String email;
	
	
	@Column(length=45, nullable = false, unique = true)
//	@Size(min =3, message="Username must at be least 3 characters")
//	@NotBlank
	private String username;
	
//	@NotBlank
//	@Size(min =8, max = 20, message="Password must be between 3 and 20 character")
	@Column(nullable = false)
	private String password;
	

//	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob;
	
//	@NotBlank
	private String gender;
	
	
	

	public User() {
		super();
	}
	
	

public User(Integer id, String firstName, String lastName, String email, String username,
			 String password, Date dob, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
	}



//	public User(@NotBlank @Size(min = 3, max = 20) String firstName, @NotBlank @Size(min = 3, max = 20) String lastName,
//			@NotBlank @Email(message = "Please enter a valid email") String email,
//			@NotBlank @Size(min = 3, max = 20) String username, @NotBlank @Size(min = 8, max = 20) String password,
//			@NotBlank Date dob, @NotBlank String gender) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.username = username;
//		this.password = password;
//		this.dob = dob;
//		this.gender = gender;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

	
}
