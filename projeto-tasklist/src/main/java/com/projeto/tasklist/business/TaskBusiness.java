package com.projeto.tasklist.business;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import com.projeto.tasklist.model.Task;
import com.projeto.tasklist.persistencia.TaskDao;


public class TaskBusiness {
	Task task;
	TaskDao taskdao;
	
	public TaskBusiness() {
		taskdao = new TaskDao();
	}
	
	public TaskBusiness(TaskDao taskdao) {
		this.taskdao = taskdao;
	}
	
	public Task createTask(String descricao) {
			
		task = new Task();
		task.setDescription(descricao);
		task.setDate(new Date());
		task.setStatus(false);
			
		try {
			
			taskdao.openCurrentSessionwithTransaction();
			taskdao.persist(task);
			taskdao.closeCurrentSessionwithTransaction();
		
			return task;
				
		}catch (Exception ex){
				
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<Task> getAll() {
			
		List<Task> tasklist;
			
		try {
			taskdao.openCurrentSession();
			tasklist = taskdao.getAll();
			taskdao.closeCurrentSession();
				
			return tasklist;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public Task getById(long id) {
		
		task = new Task();
			
		try {
			taskdao.openCurrentSession();
			task = taskdao.getById(id);
			taskdao.closeCurrentSession();
				
			return task;
		}catch (Exception ex){
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public Task UpdateTask(Task task) {
			
		try {
			
			taskdao.openCurrentSessionwithTransaction();
			taskdao.update(task);
			taskdao.closeCurrentSessionwithTransaction();
		
			return task;
				
		}catch (Exception ex){
				
			ex.printStackTrace();
			return null;
		}
	}
	
	public void delete(long id) {
		
		try {
			
			taskdao.openCurrentSessionwithTransaction();
			taskdao.delete(id);
			taskdao.closeCurrentSessionwithTransaction();
				
		}catch (Exception ex){
				
			ex.printStackTrace();
		}
	}

}
