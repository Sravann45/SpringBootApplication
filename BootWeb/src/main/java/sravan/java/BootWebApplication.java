package sravan.java;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@SpringBootApplication
@RestController
public class BootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootWebApplication.class, args);
	}

	@Autowired
	UserRepo user;
	@Autowired
	UserLdap ldap;

	@Autowired
	EmoRepo empRepo;

	@RequestMapping("/")
	public ModelAndView getHome() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("searchByEmpId");

		return mv;
	}

	@RequestMapping("addEmp")
	public ModelAndView addEmp(Emp emp) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("EmpSuccess");
		mv.addObject("emp", emp.getEname() + " " + emp.getSalary());
		empRepo.save(emp);
		return mv;
	}

	@RequestMapping("/emp")
	public ModelAndView getEmp(@RequestParam("eid") int eid) {
		ModelAndView mv = new ModelAndView();
		System.out.println("**** " + eid);
		Optional<Emp> ldap = empRepo.findById(eid);
		if (ldap.equals(Optional.empty())) {
			mv.setViewName("success");
			return mv;
		} else {
			mv.setViewName("ShowEmp");
			mv.addObject("details", ldap.get().getEid() + " " + ldap.get().getEname() + " " + ldap.get().getSalary());
			System.out.println("Hello min salary is "+empRepo.min());
			System.out.println("Hello max salary is "+empRepo.max());
			System.out.println("Fourth Highest salary is "+empRepo.thirdMaxSalary());
			//System.out.println(empRepo.findBySalaryOrderByEname());
			return mv;
		}
		
	}

	@RequestMapping("/add")
	public ModelAndView add(UserLdap ldap) {
		ModelAndView mv = new ModelAndView();
//		ldap.setUsername(u1);
//		ldap.setPassword(u2);
		mv.setViewName("success");
		mv.addObject("result", ldap.getUsername() + " : : " + ldap.getPassword());
		user.save(ldap);
		return mv;

	}

	@PostMapping("/{id}")
	public ModelAndView getDetail(@PathVariable(value = "id") int id) {
		System.out.println("enterd id is " + id);
		Optional<UserLdap> list = user.findById(id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("show_details");
		mv.addObject("user_details", list.get().getUsername() + list.get().getPassword());
		return mv;

	}
	
	@RequestMapping(path = "/ret",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<Emp> ret(Emp emp) {
		
		List <Emp> list= empRepo.findAll();
		
		return list;
	}

	/*@GetMapping("id")
	public ModelAndView getID(@RequestParam("id") int aid) {
		ModelAndView mv = new ModelAndView();
		Optional<UserLdap> ldap = user.findById(aid);
		if (ldap.equals(Optional.empty())) {
			mv.setViewName("success");
			return mv;
		} else {
			mv.addObject("name", "User id is " + ldap.get().getUserID() + " UserName is "
					+ ldap.get().getUsername().toUpperCase() + " & the pwd is " + ldap.get().getPassword());
			mv.setViewName("show_details");
			return mv;
		}*/

	}


