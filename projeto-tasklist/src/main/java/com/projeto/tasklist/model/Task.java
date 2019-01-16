package com.projeto.tasklist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "task_table", schema = "public")
public class Task {
	@Id 
	@Column(name="task_id")
	@GeneratedValue( strategy =  GenerationType.AUTO)
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date date_created;
	
	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public Date getDateCreated() {
		return date_created;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void setDate(Date date) {
		date_created = date;		
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Task)) { 
            return false; 
        } 
		
		Task taskObject = (Task) object;
		
		if(this.description.equals(taskObject.getDescription()))
			return true;
		
		return false;
	}

}
