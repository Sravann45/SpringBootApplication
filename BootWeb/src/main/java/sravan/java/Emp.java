package sravan.java;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Component
@Data
public class Emp {
	@Id
@GeneratedValue
	private int eid;
	private String ename;
	private long salary;
	
	
}
