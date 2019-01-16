package com.projeto.tasklist.controller;

import java.util.List;

import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute; 

import com.projeto.tasklist.business.TaskBusiness;
import com.projeto.tasklist.model.Task;

@Controller
public class HomeController {
	TaskBusiness taskbss;
	
	@RequestMapping(value="/home")
	public ModelAndView home() {
		taskbss = new TaskBusiness();
		List<Task> tasklist = taskbss.getAll();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("tasklist", tasklist);
		return mv;
	}
	
	@RequestMapping("/newtask")
	public String newTask() {
		return "newTask";
	}
	
	@RequestMapping("/newtaskpost")
	public String newTaskPost(Task task) {
		
		if(task.getDescription() == null  || task.getDescription().equals("")) {
			return "redirect:newtask";
		}
		
		taskbss = new TaskBusiness();
		taskbss.createTask(task.getDescription());
		
		return "redirect:home";
	}
	
	@RequestMapping("/removetask")
	public String removeTask(int id) {
		taskbss = new TaskBusiness();
		taskbss.delete(id);
		return "redirect:home";
	}
	
	@RequestMapping("/conclude")
	public String conclude(int id) {
		taskbss = new TaskBusiness();
		Task task = taskbss.getById(id);
		task.setStatus(true);
		taskbss.UpdateTask(task);
		return "redirect:home";
	}
	
	@RequestMapping("/edittask/{id}")
	public ModelAndView edit(@PathVariable int id) {
		taskbss = new TaskBusiness();
		Task task = taskbss.getById(id);
	
		ModelAndView mv = new ModelAndView("edittask");
		mv.addObject("task", task);
		return mv;
	}
	
	@RequestMapping(value="/editpost", method = RequestMethod.POST)
	public String editPost(Task task) {
		
		taskbss = new TaskBusiness();
		taskbss.UpdateTask(task);
		
		return "redirect:home";
		
	}
	
}
