package com.csc.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="treatment")
public class Treatment {
	@Id
	@GeneratedValue
	private Integer treatmentid;
	
	@Column(name="historyofdiseases")
	private String historyofdiseases;
	
	@Column(name="prescription")
	private String prescription;
	
	@Column(name="medicineused")
	private String medicineused;
	
	@Column(name="medicaltestresult")
	private String medicaltestresult;
	
	@ManyToOne
	@JoinColumn(name="patientid")
	private Patient Patient;
	
	@ManyToOne
	@JoinColumn(name="doctorid")
	private User user;
	
	@ManyToMany
	@JoinTable(name = "medicine_treatment",
    joinColumns = @JoinColumn(name = "treatmentid"),
    inverseJoinColumns = @JoinColumn(name = "medicineid"))
	private Collection<Medicine> medicines;

	public Patient getPatient() {
		return Patient;
	}

	public void setPatient(Patient patient) {
		Patient = patient;
	}

	public Integer getTreatmentid() {
		return treatmentid;
	}

	public void setTreatmentid(Integer treatmentid) {
		this.treatmentid = treatmentid;
	}

	

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getMedicineused() {
		return medicineused;
	}

	public void setMedicineused(String medicineused) {
		this.medicineused = medicineused;
	}

	public String getHistoryofdiseases() {
		return historyofdiseases;
	}

	public void setHistoryofdiseases(String historyofdiseases) {
		this.historyofdiseases = historyofdiseases;
	}

	public String getMedicaltestresult() {
		return medicaltestresult;
	}

	public void setMedicaltestresult(String medicaltestresult) {
		this.medicaltestresult = medicaltestresult;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(Collection<Medicine> medicines) {
		this.medicines = medicines;
	}
}
