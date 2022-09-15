package MiniWeb.mini.controller;

import MiniWeb.mini.domain.User;
import MiniWeb.mini.repository.JdbcUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserFindController {
	JdbcUserRepository jdbcUserRepository ;

	@Autowired
	public UserFindController(JdbcUserRepository jdbcUserRepository) {
		this.jdbcUserRepository = jdbcUserRepository;
	}

	@RequestMapping("/find")
	public String findUser(@RequestParam String userId, Model model){
		User finduser = jdbcUserRepository.selectUserOne(userId);
		model.addAttribute("user",finduser);
		return "searchedUser";
	}
}
