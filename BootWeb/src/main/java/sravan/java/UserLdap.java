package sravan.java;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
public class UserLdap {
	@Id
	@GeneratedValue
	private Integer userID;
	private String username;
	/* @NotEmpty */
	private String password;

}
