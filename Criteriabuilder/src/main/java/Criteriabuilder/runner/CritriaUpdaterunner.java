package Criteriabuilder.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import Criteriabuilder.domain.Student;
import Criteriabuilder.repository.Studentrepository;

public class CritriaUpdaterunner implements CommandLineRunner {
	
	@Autowired
	EntityManagerFactory emf;

	@Autowired
	Studentrepository stdrepo;
	
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
		
		CriteriaUpdate<Student> update=builder.createCriteriaUpdate(Student.class);
		
		Root<Student>  root=update.from(Student.class);
		
		update.set("studentName","Ram");
		update.set("studentFee",3.2);
		
		update.where(builder.gt(root.get("stdId"),3));

		int count=em.createQuery(update).executeUpdate();
		
		et.commit();
		
		System.out.println(count);
		
	}

}
