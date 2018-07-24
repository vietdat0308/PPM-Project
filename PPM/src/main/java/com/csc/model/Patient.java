package com.csc.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;  
@Entity
@Table(name="patient")
public class Patient implements Serializable{
	@Id
	@GeneratedValue
	private int patientid;
	
	@Column(name="fullname")
	private String fullname;
	
	@Column(name="address")
	private String address;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="dateofbirth")
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;
	
	@Column(name="placeofbirth")
	private String placeofbirth;
	
	@Column(nullable=true,name="treatmentid")
	private Integer treatmentid;
	
	@Column(nullable=true,name="allergic")
	private String allergic;
	
	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getPlaceofbirth() {
		return placeofbirth;
	}

	public void setPlaceofbirth(String placeofbirth) {
		this.placeofbirth = placeofbirth;
	}

	

	public Integer getTreatmentid() {
		return treatmentid;
	}

	public void setTreatmentid(Integer treatmentid) {
		this.treatmentid = treatmentid;
	}

	public String getAllergic() {
		return allergic;
	}

	public void setAllergic(String allergic) {
		this.allergic = allergic;
	}
}
