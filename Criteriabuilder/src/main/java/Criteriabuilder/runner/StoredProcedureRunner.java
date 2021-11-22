package Criteriabuilder.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import Criteriabuilder.repository.Studentrepository;

public class StoredProcedureRunner implements CommandLineRunner {

	@Autowired
	Studentrepository stdrepo;
	
	@Override
	public void run(String... args) throws Exception {

		/*
		 *For operating the criteria Query we need to insert the sample data
		 *we doing Fetching the data by using criteria query operation
		 *Updating the data by using CriteriaQueryUpdate operation
		 *Deletinng the data by using CriteriaQueryDelete operation */
		
		stdrepo.getMyData().forEach(System.out::println);
		stdrepo.getMyDataByStudentName("Ram").forEach(System.out::println);
		int count=stdrepo.getMyDataByStudentNameCount("Ram");
		System.out.println(count);
		stdrepo.getAllStudentInfo()
		.stream()
		.map(ob->ob[0]+"-"+ob[1])
		.forEach(System.out::println);
	}

}
