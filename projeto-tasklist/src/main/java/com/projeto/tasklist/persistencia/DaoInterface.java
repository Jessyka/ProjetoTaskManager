package com.projeto.tasklist.persistencia;

import java.io.Serializable;
import java.util.List;

public interface DaoInterface<T, Id extends Serializable> {
	public void persist(T entity);
	public void update(T entity);
	public T getById(long id);
	public List<T> getAll();
	public void delete(long id);;
	
}
