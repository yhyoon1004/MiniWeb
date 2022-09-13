package MiniWeb.mini.controller;

import MiniWeb.mini.domain.User;
import MiniWeb.mini.service.UserEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserEnrollController {
	@RequestMapping("/enroll")
	public String moveForm(){
		return "enrollForm";
	}
}
