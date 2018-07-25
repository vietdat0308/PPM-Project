package com.csc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.dao.PatientDao;
import com.csc.dao.TreatmentDao;
import com.csc.model.Patient;
import com.csc.model.Treatment;
import com.csc.utils.CreatePdf;
import com.csc.utils.DownloadPdf;

@Controller
public class DownloadController {
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private TreatmentDao treatmentDao;

	@RequestMapping(value="/download/{id}", method = RequestMethod.GET)
	public void downloadPdf(@PathVariable int id, HttpServletResponse response) throws IOException {
		Patient patient = patientDao.getPatient(id);
		List<Treatment> lstTreatment = treatmentDao.findPatientTreatment(id);
		CreatePdf.create(patient, lstTreatment);
		DownloadPdf.download(response);
	}

	public PatientDao getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	public TreatmentDao getTreatmentDao() {
		return treatmentDao;
	}

	public void setTreatmentDao(TreatmentDao treatmentDao) {
		this.treatmentDao = treatmentDao;
	}
}
