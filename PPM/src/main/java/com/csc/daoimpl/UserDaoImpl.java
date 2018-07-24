package com.csc.daoimpl;





import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.csc.dao.UserDao;
import com.csc.model.User;

public class UserDaoImpl implements UserDao{

	private SessionFactory sessionFactory;
	
	public User checkLogin(String username, String password) {
		User user = null;
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String sql = "FROM User WHERE username= :username AND password= :password";
			Query query = session.createQuery(sql);
			query.setParameter("username", username);
			query.setParameter("password", password);
			user = (User) query.uniqueResult();
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}
	
	public List<User> findAllUser() {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<User> list = null;
		try {
			String sql = "FROM User";
			Query query = session.createQuery(sql);
			list = query.list();
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}

	public void createUser(User user) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(user);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void updateUser(User user) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(user);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	public void deleteUser(int id) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		User user = null;
		try {
			user = (User) session.get(User.class,(int)id);
			session.delete(user);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}	
	
	public User getUser(int id) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		User user = null;
		try {
			user = (User) session.get(User.class, id);
			session.saveOrUpdate(user);
			transaction.commit();
		}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		return user;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
