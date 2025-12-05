package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {
	private final ToDoService toDoService1;
	
	// 依存性の注入（DI）を行う（コンストラクタインジェクション）
	public ToDoController(ToDoService todoService) {
		this.toDoService1 = todoService;
	}
	
	@GetMapping("/todo")
	public String toDo(Model model) {
		// 最新のユーザーリストを取得
		List<ToDo> todos = toDoService1.getAllTitles();
		
		// ビューにユーザーリストを渡す
		model.addAttribute("todosHtml", todos);
		
		return "todoView";
	}

}
