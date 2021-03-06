package com.csc.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.dao.PatientDao;
import com.csc.dao.TreatmentDao;
import com.csc.dao.UserDao;
import com.csc.model.Medicine;
import com.csc.model.Patient;
import com.csc.model.Treatment;
import com.csc.model.User;

@Controller
public class RegisterController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private TreatmentDao treatmentDao;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String viewtrangchu() {
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String viewRegister(Model model) {
		User userForm = new User();
		model.addAttribute("userForm", userForm);
		return "Login";
	}
	

	public TreatmentDao getTreatmentDao() {
		return treatmentDao;
	}


	public void setTreatmentDao(TreatmentDao treatmentDao) {
		this.treatmentDao = treatmentDao;
	}

	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	public String processRegister(@ModelAttribute("userForm") User user, Model model, HttpServletRequest request){
		User userLogin = userDao.checkLogin(user.getUsername(), user.getPassword());
		if(userLogin != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(300);
			if(userLogin.getRole().getRoleid() == 1) {
				session.setAttribute("username", userLogin.getUsername());
				return "forward:/doctorpage";
			}else if(userLogin.getRole().getRoleid() == 2) {
				session.setAttribute("username", userLogin.getUsername());
				return "forward:/nursepage";
			}else {
				session.setAttribute("username", userLogin.getUsername());
				return "forward:/adminUserPage";
			}
		}
		model.addAttribute("message", "Username or password invalid");	
		return "Login";
	}
	
	
	@RequestMapping(value = "/adminUserPage",method = RequestMethod.POST)
	public String viewUserPost(Model model, HttpServletRequest request) {
			User userForm = new User();
			((Model) model).addAttribute("userForm", userForm);
			List<User> list = userDao.findAllUser();
			model.addAttribute("list", list);
			return "adminUserPage";
	}
	
	@RequestMapping(value = "/adminUserPage",method = RequestMethod.GET)
	public String viewUserGet(Model model, HttpServletRequest request) {
			HttpSession session = request.getSession();
			String username =  (String) session.getAttribute("username");
			if(username != null) {
			User userForm = new User();
			((Model) model).addAttribute("userForm", userForm);
			List<User> list = userDao.findAllUser();
			model.addAttribute("list", list);
			return "adminUserPage";
			}else {
				return "redirect:login";
			}
			
	}
	
	

	@RequestMapping(value = "/doctorpage", method = RequestMethod.POST)
	public String viewDoctorPagePost(Model model, HttpServletRequest request) {
		List<Patient> list = patientDao.findAllPatient();
		model.addAttribute("list", list);
		return "Patient_Doctor";
	}

	@RequestMapping(value = "/doctorpage", method = RequestMethod.GET)
	public String viewDoctorPageGet(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username =  (String) session.getAttribute("username");
		if (username != null) {
			List<Patient> list = patientDao.findAllPatient();
			model.addAttribute("list", list);
			return "Patient_Doctor";
		} else {
			return "redirect:login";
		}
	}

	@RequestMapping(value = "/nursepage", method = RequestMethod.POST)
	public String viewNursePagePost(Model model, HttpServletRequest request) {
		Patient userForm = new Patient();
		((Model) model).addAttribute("userForm", userForm);
		List<Patient> list = patientDao.findAllPatient();
		model.addAttribute("list", list);
		return "Patient_Nurse";
	}

	@RequestMapping(value = "/nursepage", method = RequestMethod.GET)
	public String viewNursePageGET(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username =  (String) session.getAttribute("username");
		if (username != null) {
			Patient userForm = new Patient();
			((Model) model).addAttribute("userForm", userForm);
			List<Patient> list = patientDao.findAllPatient();
			model.addAttribute("list", list);
			return "Patient_Nurse";
		} else {
			return "redirect:login";
		}
	}

	
	
	@RequestMapping(value = "/checktreatment",method = RequestMethod.GET)
	public String viewTreatmentPage(Model model, HttpServletRequest request) {
		String stt = request.getParameter("patientid");	
		List<Treatment> list = treatmentDao.findPatientTreatment(Integer.parseInt(stt)); 
		List<Medicine> medicinelst= treatmentDao.getmedicinelst(Integer.parseInt(stt));
		Treatment userForm = new Treatment();
		model.addAttribute("userForm", userForm);
		model.addAttribute("list", list);
		model.addAttribute("medicinelst",medicinelst);
		return "treatmentpage";
	}
	
	@RequestMapping(value = "/checktreatmentnow",method = RequestMethod.GET)
	public String viewTreatmentPage1(Model model,@ModelAttribute("userForm")Treatment treatment) {
		List<Treatment> list = treatmentDao.findPatientTreatment(treatment.getPatient().getPatientid()); 
		Treatment userForm = new Treatment();
		model.addAttribute("userForm", userForm);
		model.addAttribute("list", list);
		return "treatmentpage";
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
