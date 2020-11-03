package sravan.java;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserLdap, Integer> {
	
}
