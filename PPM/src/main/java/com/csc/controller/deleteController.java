package com.csc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.dao.PatientDao;
import com.csc.dao.UserDao;
import com.csc.model.User;

@Controller
public class deleteController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PatientDao patientDao;

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String viewUpdate(HttpServletRequest request, Model model) {
		String stt = request.getParameter("userid");
		userDao.deleteUser(Integer.parseInt(stt));
		return "redirect:adminUserPage";
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
