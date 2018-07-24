package com.csc.dao;

import java.util.List;

import com.csc.model.Medicine;
import com.csc.model.Patient;
import com.csc.model.Treatment;

public interface TreatmentDao {
	List<Treatment> findPatientTreatment(int id);
	Treatment getTreatment(int id);
	void createTreatment(Treatment treatment);
	void updateTreatment(Treatment treatment);
	void deleteTreatment(int id);
	List<Medicine> getmedicinelst(int id);
}
