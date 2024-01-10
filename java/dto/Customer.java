package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer
{
	@Id
	@SequenceGenerator(initialValue = 100000, allocationSize = 1, sequenceName = "custId", name = "custId")
	@GeneratedValue(generator = "custId")
	long custId;
	String name;
	String email;
	long mob;
	Date dob; 
	String gender;
	String pwd;
	//Every Customer can create multiple account Saving & Current
	@OneToMany
	List<Bankaccount> list;

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<Bankaccount> getList() {
		return list;
	}

	public void setList(List<Bankaccount> list) {
		this.list = list;
	}
	
}
