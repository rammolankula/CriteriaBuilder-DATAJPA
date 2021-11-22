package Criteriabuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Criteriabuilder.domain.Student;

public interface Studentrepository extends JpaRepository<Student,Integer> {
	
	//List<Student> findStudentNameAndStdFee(String studentName,Double stdFee);

	//STORED PROCEDURE CONCEPT
	@Query(value= "Call getAllStds()",nativeQuery=true)
	List<Student> getMyData();
	
	@Query(value= "Call getAllEmpsByStdName(: studentName)",nativeQuery=true)
	List<Student> getMyDataByStudentName(String studentName);
	
	@Query(value= "Call getAllEmpsByStdNameCount(: studentName)",nativeQuery=true)
	int getMyDataByStudentNameCount(String studentName);
	
	@Query(value= "Call getAllStudentInfo()",nativeQuery=true)
	List<Object[]> getAllStudentInfo();
	
	
}
