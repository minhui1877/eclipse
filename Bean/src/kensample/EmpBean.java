package kensample;

import java.io.Serializable;

public class EmpBean implements Serializable {

	private int id;
	private String name;
	private String address;
	private int age;
	private String mail;
	
	public EmpBean() {
		id = 0;
		name = "";
		address = "";
		age = 0;
		mail = "";
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
