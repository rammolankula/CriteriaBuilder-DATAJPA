package Criteriabuilder.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Criteriabuilder.domain.Student;
import Criteriabuilder.repository.Studentrepository;
@Component
public class Studentrunner implements CommandLineRunner {

	@Autowired
	private Studentrepository stdrepo;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		 *For operating the criteria Query we need to insert the sample data
		 *we doing Fetching the data by using criteria query operation
		 *Updating the data by using CriteriaQueryUpdate operation
		 *Deletinng the data by using CriteriaQueryDelete operation */
		stdrepo.save(new Student(1,"Ram","23",2.2));
		stdrepo.save(new Student(2,"Ram","23",2.2));
		stdrepo.save(new Student(3,"Ram","23",3.2));
	}

}
