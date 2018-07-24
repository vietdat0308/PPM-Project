package com.csc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csc.dao.UserDao;
import com.csc.model.User;
import com.csc.utils.CreatePdf;
import com.csc.utils.DownloadPdf;

@Controller
public class DownloadController {
	@Autowired
	private UserDao userDao;

	@RequestMapping(value="/download/{id}", method = RequestMethod.GET)
	public void downloadPdf(@PathVariable int id, HttpServletResponse response) throws IOException {
		User user = userDao.getUser(id);
		CreatePdf.create(user);
		DownloadPdf.download(response);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
}
