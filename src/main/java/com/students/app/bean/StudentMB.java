package com.students.app.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.students.app.dao.StudentDao;
import com.students.app.entity.Student;
import com.students.app.entity.Team;

@ManagedBean
@ViewScoped
public class StudentMB {

	private Student student;
	private StudentDao studentDao;
	private List<Student> students;
	
	private Team selectedTeam;

	@PostConstruct
	public void init() {
		student = new Student();
		studentDao = new StudentDao();
		students = studentDao.list();
	}

	public void addStudent() {
		studentDao.save(student);
		init();
	}
	
	public void deleteStudent() {
		studentDao.remove(student);
		init();
	}
	
	public void updateStudent() {
		studentDao.update(student);
		init();
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Mensagem", "Informações alteradas!");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		student = (Student) event.getObject();
		updateStudent();
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Mensagem", "Alteração cancelada!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Team getSelectedTeam() {
		return selectedTeam;
	}

	public void setSelectedTeam(Team selectedTeam) {
		this.selectedTeam = selectedTeam;
	}
}