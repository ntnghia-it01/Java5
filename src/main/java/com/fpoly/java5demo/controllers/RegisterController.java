package com.fpoly.java5demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.java5demo.beans.RegisterBean;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@GetMapping("")
	public String registerUI(Model model) {
		model.addAttribute("bean", new RegisterBean());
		return "register";
	}

	@PostMapping("")
	public String register(@Valid @ModelAttribute("bean") RegisterBean registerBean, Errors errors, Model model) {
//		System.out.println("Register successfully!");
//		model.addAttribute("bean", registerBean);
		if (!errors.hasErrors()) {
//			TODO 
		}
		return "register";
	}
}
