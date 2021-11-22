package Criteriabuilder.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Student {
	@Id
	private Integer stdId;
	private String studentName;
	private String studentAge;
	private Double studentFee;
}
