package kr.hs.study.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.hs.study.model.dto.LoginDTO;

@Controller
public class TestController {

	@Autowired
	SqlSessionTemplate  sqlsessiontemplate;
	
	@GetMapping("/login")
	public String login() {
		return "login/login_form";
	}
	
	@PostMapping("/login")
	public String login2(LoginDTO dto) {
		System.out.println(dto.getId());
		System.out.println(dto.getPw());	
		sqlsessiontemplate.insert("login.insert", dto);
		return "result";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String id) {
		sqlsessiontemplate.delete("login.delete", id);
		return "result";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam String id) {
		sqlsessiontemplate.update("login.update", id);
		return "result";
	}
}
