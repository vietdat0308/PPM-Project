package com.csc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.dao.PatientDao;
import com.csc.dao.UserDao;
import com.csc.model.Patient;
import com.csc.model.User;

@Controller
public class UpdateController {
	@Autowired
	private UserDao userDao;

	@Autowired
	private PatientDao patientDao;

	@RequestMapping(value = "/updatePatient", method = RequestMethod.GET)
	public String viewPatientUpdate(HttpServletRequest request, Model model) {
		String stt = request.getParameter("patientid");
		Patient userForm = new Patient();
		userForm = patientDao.getPatient(Integer.parseInt(stt));
		model.addAttribute("userForm", userForm);
		return "updatePatient";
	}

	@RequestMapping(value = "/updatePatient", method = RequestMethod.POST)
	public String processUpadtePatient(@ModelAttribute("userForm")Patient patient, Model model) {
		patientDao.updatePatient(patient);
		return "redirect:updatepatientcomplete";
	}
	
	@RequestMapping(value = "/updatepatientcomplete",method = RequestMethod.GET)
	public String processNurse(Model model) {
		List<Patient> list = patientDao.findAllPatient();
		model.addAttribute("list", list);
		return "Patient_Nurse";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String viewUpdate(Model model, HttpServletRequest request) {
		String stt = request.getParameter("userid");
		User userForm = new User();
		userForm = userDao.getUser(Integer.parseInt(stt));
		model.addAttribute("userForm", userForm);
		return "update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processAddUser(@ModelAttribute("userForm")User user, Model model) {
		userDao.updateUser(user);
		return "redirect:updatecomplete";
	}
	
	@RequestMapping(value = "/updatecomplete",method = RequestMethod.GET)
	public String processRegister(Model model) {
		List<User> list = userDao.findAllUser();
		model.addAttribute("list", list);
		return "AdminPage";
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}	
	
	public PatientDao getPatientDao() {
		return patientDao;
	}

	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
	}
}
