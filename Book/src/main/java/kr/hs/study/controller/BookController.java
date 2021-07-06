package kr.hs.study.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.hs.study.model.dto.BookDTO;

@Controller
public class BookController {
	
	@Autowired
	SqlSessionTemplate sqlsessiontemplate;
	
	@GetMapping("/add")
	public String add_form() {
		return "add";
	}
	/*DTO�� ����*/
	@PostMapping("/add")
	public String add_re(BookDTO dto) {
		/*
		 * 1) BookDTO�� ��ü�� ����( ���������� new�����ڸ� �̿��ؼ� ) 
		 * 2) ����ڰ� �Է��� ���� �ڵ����� book ��ü�� DI��Ŵ
		 */
		sqlsessiontemplate.insert("book.add", dto);
		return "result";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam String title) {//title:music
		sqlsessiontemplate.delete("book.delete", title);
		return "result";
		
	}
	@GetMapping("/list")
	public String list(Model model) {
		List<BookDTO> list=sqlsessiontemplate.selectList("book.list");
		model.addAttribute("list", list);
		return "result2";
	}
	@GetMapping("/update")
	public String update_form(@RequestParam String title, Model model) {
		BookDTO dto=sqlsessiontemplate.selectOne("book.selectOne",title);
		model.addAttribute("dto", dto);
		return "result3";
	}
	@PostMapping("update")
	public String update(BookDTO dto) {
		sqlsessiontemplate.update("book.update",dto);
		
		System.out.println("dto"+dto.getAuthor());
		return "result";
	}

}






