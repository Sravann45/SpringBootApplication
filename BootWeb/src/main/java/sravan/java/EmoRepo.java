package sravan.java;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmoRepo extends JpaRepository<Emp, Integer> {
	List<Emp> findByEname(String ename);
	
	
	List<Emp> findBySalaryGreaterThan(long salary);
	
	@Query(value = "SELECT min(salary) FROM Emp")
	public BigDecimal min();
	
	@Query(value = "SELECT max(salary) FROM Emp")
	public BigDecimal max();
	
	@Query(value = "FROM Emp e1 WHERE 4-1 = (SELECT COUNT(DISTINCT salary) FROM Emp e2\r\n"
			+ "WHERE e2.salary > e1.salary)")
	public List<Emp> thirdMaxSalary();
	
//	List<Emp> findBySalaryOrderByEname();

}
