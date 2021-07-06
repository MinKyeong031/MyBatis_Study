package kr.hs.study.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.hs.study.model.dto.LoginDTO;

@Controller
public class TestController {
	@Autowired
	SqlSessionTemplate  sessionTemplate;
	
	@GetMapping("/login")
	public String login() {
		return "login/login_form";
	}
	
	@PostMapping("/login")
	public String login_re(@ModelAttribute LoginDTO dto) {	//@ModelAttribute 생략 가능
		//LoginDTO 객체 만들고, setter() 이용해서 값을 DI 한다.
		System.out.println(dto.getUser_id());
		System.out.println(dto.getUser_pass());
		sessionTemplate.insert("test_db.insert_data", dto);
		return "result";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String user_id) {
		//user_id: kim
		sessionTemplate.delete("test_db.delete_data", user_id);
		return "result";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam String user_id) {
		sessionTemplate.update("test_db.update_data", user_id);
		return "result";
	}
}