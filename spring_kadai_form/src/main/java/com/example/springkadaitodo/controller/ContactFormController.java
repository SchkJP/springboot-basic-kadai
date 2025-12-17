package com.example.springkadaitodo.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaitodo.form.ContactForm;

@Controller
public class ContactFormController {
	
	@GetMapping("/form")
	public String contactForm(Model model) {
		
		if(!model.containsAttribute("contactForm")) {
			model.addAttribute("contactForm", new ContactForm());
		}
		
		return "contactFormView";
		
	}
	
	@PostMapping("/confirm")
	public String confirmForm(RedirectAttributes redirectAttributes, 
			@Validated ContactForm form, BindingResult result) {
		// バリデーションエラー
		if(result.hasErrors()) {
			// フォームクラスをビューに受け渡す
			redirectAttributes.addFlashAttribute("contactForm", form);
			// バリデーション結果をビューに受け渡す
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + 
					Conventions.getVariableName(form), result);
			
			return "redirect:/form";
		} else {
			
			
		
			return "confirmView";
		}
	}

}
