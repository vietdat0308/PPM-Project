package com.csc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.csc.dao.PatientDao;
import com.csc.dao.TreatmentDao;
import com.csc.dao.UserDao;
import com.csc.model.Patient;
import com.csc.model.Treatment;
import com.csc.model.User;

@Controller
public class AddController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private TreatmentDao treatmentDao;
	
	@RequestMapping(value = "/addorupdateUser", method = RequestMethod.POST)
	public String viewUser(@ModelAttribute("userForm")User user, Model model) {
		userDao.createUser(user);
		return "redirect:adminUserPage";
	}
	
	@RequestMapping(value = "/addorupdatePatient", method = RequestMethod.POST)
	public String viewPatient(@ModelAttribute("userForm")Patient patient, Model model) {
		patientDao.createPatient(patient);
		return "redirect:nursepage";
	}
	
	@RequestMapping(value = "/addorupdateTreatment", method = RequestMethod.POST)
	public String viewTreatment(@ModelAttribute("userForm")Treatment treatment, Model model) {
		treatmentDao.createTreatment(treatment);
		List<Treatment> list = treatmentDao.findPatientTreatment(treatment.getPatient().getPatientid()); 
		Treatment userForm = new Treatment();
		model.addAttribute("userForm", userForm);
		model.addAttribute("list", list);
		return "treatmentpage";
	}
	
	
	public PatientDao getPatientDao() {
		return patientDao;
	}
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public TreatmentDao getTreatmentDao() {
		return treatmentDao;
	}

	public void setTreatmentDao(TreatmentDao treatmentDao) {
		this.treatmentDao = treatmentDao;
	}
}
