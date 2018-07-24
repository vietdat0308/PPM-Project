package com.csc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {
	@Id
	@GeneratedValue
	private Integer medicineid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany(mappedBy = "medicines")
	private Collection<Treatment> treatments;

	public Collection<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(Collection<Treatment> treatments) {
		this.treatments = treatments;
	}

	public Integer getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(Integer medicineid) {
		this.medicineid = medicineid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
