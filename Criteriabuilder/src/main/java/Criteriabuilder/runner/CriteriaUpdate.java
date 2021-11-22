package Criteriabuilder.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import Criteriabuilder.domain.Student;

public class CriteriaUpdate implements CommandLineRunner {

	@Autowired
	EntityManagerFactory emf;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		/*
		 *For operating the criteria Query we need to insert the sample data
		 *we doing Fetching the data by using criteria query operation
		 *Updating the data by using CriteriaQueryUpdate operation
		 *Deletinng the data by using CriteriaQueryDelete operation */
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		CriteriaBuilder builder=em.getCriteriaBuilder();
		CriteriaDelete<Student> delete=builder.createCriteriaDelete(Student.class);
		
		Root<Student> root=delete.from(Student.class);
		
		delete.where(
				builder.or(
						builder.gt(root.get("stdId"),2)),
				        builder.like(root.get("studentName"),"%ram%")
				);
		
		
	}

}
