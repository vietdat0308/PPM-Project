package com.csc.dao;

import java.util.List;

import com.csc.model.Patient;

public interface PatientDao {
	List<Patient> findAllPatient();
	Patient getPatient(int id);
	void createPatient(Patient patient);
	void updatePatient(Patient patient);
}
