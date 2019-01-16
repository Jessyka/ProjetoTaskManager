package com.projeto.tasklist.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.projeto.tasklist.persistencia.DaoInterface;

import com.projeto.tasklist.model.Task;

public class TaskDao implements DaoInterface<Task, String> {
	
	private Session currentSession;
	private Transaction currentTransaction;
	private static SessionFactory sessionFactory;
	
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}
	
	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}	
			     
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {		
		if(sessionFactory == null)
			sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}
	
	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}
	
	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}
	
	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	public void persist(Task entity) {
		getCurrentSession().save(entity);
	}
	
	public void update(Task entity) {
		getCurrentSession().update(entity);
	}
	
	public Task getById(long id) {
		Task task = (Task) getCurrentSession().get(Task.class, id);
		return task;
	}
	
	public List<Task> getAll() {
		List<Task> tasklist = getCurrentSession().createQuery("select a from Task a").getResultList();
		return tasklist;
	}
	
	public void delete(long id) {
		Query query = getCurrentSession().createQuery("delete from Task a where a.id = :taskid ");
	    query.setParameter("taskid", id);
	    query.executeUpdate();
		
	}

}
