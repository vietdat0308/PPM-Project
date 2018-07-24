package com.csc.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csc.dao.TreatmentDao;
import com.csc.model.Medicine;
import com.csc.model.Patient;
import com.csc.model.Treatment;
import com.csc.model.User;

public class TreatmentDaoImpl implements TreatmentDao{
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Treatment> findPatientTreatment(int id) {
		List<Treatment> treatmentlst=null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String sql = "FROM Treatment WHERE patientid= :id ";
			Query query = session.createQuery(sql);
			query.setParameter("id",id);
			treatmentlst =  (List<Treatment>) query.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return treatmentlst;
	}

	public Treatment getTreatment(int id) {
		
		return null;
	}

	public void createTreatment(Treatment treatment) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(treatment);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	public void updateTreatment(Treatment treatment) {
		// TODO Auto-generated method stub
		
	}

	public void deleteTreatment(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<Medicine> getmedicinelst(int id) {
		List<Medicine> medicinelst=null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String sql = "FROM medicine_treatment WHERE treatmentid= :id ";
			Query query = session.createQuery(sql);
			query.setParameter("id",id);
			medicinelst =  (List<Medicine>) query.list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return medicinelst;
	}

}
