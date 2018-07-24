package com.csc.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csc.dao.PatientDao;
import com.csc.model.Patient;

public class PatientDaoImpl implements PatientDao{
	private SessionFactory sessionFactory;
	public List<Patient> findAllPatient() {
		// TODO Auto-generated method stub
		List<Patient> patientlst=null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String sql = "FROM Patient";
			Query query = session.createQuery(sql);
			patientlst = query.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return patientlst;
	}

	public Patient getPatient(int id) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Patient patient = null;
		try {
			patient = (Patient) session.get(Patient.class, id);
			session.saveOrUpdate(patient);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return patient;
	}

	public void createPatient(Patient patient) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(patient);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	public void updatePatient(Patient patient) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(patient);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
