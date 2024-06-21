package com.crud.model;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private String mail;
	private String mobileNumber;
	private String designation;
	private int salary;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}


	public Employee(int id, String name, String gender, String mail, String mobileNumber, String designation,
			int salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.mail = mail;
		this.mobileNumber = mobileNumber;
		this.designation = designation;
		this.salary = salary;
	}


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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", mail=" + mail + ", mobileNumber="
				+ mobileNumber + ", designation=" + designation + ", salary=" + salary + "]";
	}
	
	
}
	

