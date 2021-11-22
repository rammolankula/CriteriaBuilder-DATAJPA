package Criteriabuilder.runner;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Criteriabuilder.domain.Student;
import Criteriabuilder.repository.Studentrepository;
@Component
public class Fetchrunner implements CommandLineRunner {

	@Autowired
    Studentrepository stdrepo;
	
	@Autowired
	EntityManagerFactory emf;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		 *For operating the criteria Query we need to insert the sample data
		 *we doing Fetching the data by using criteria query operation
		 *Updating the data by using CriteriaQueryUpdate operation
		 *Deletinng the data by using CriteriaQueryDelete operation */
		//create the criteriaBuilder
		CriteriaBuilder cb=	emf.getCriteriaBuilder();
	    CriteriaQuery<Student> cq = cb.createQuery(Student.class);
	    
	  //implementing from operation using root
	    Root<Student> student = cq.from(Student.class);
	 
	    //select operation by CQ
	    cq.select(student.get("studentName"));
	     
	    //select operation by CQ
	   cq.where(cb.gt(student.get("studentFee"),2.2));

	   TypedQuery<Student> list=emf.createEntityManager().createQuery(cq);
	  
	 
	}
	}

