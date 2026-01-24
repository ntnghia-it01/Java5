package com.fpoly.java5demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.java5demo.beans.CategoryFormBean;
import com.fpoly.java5demo.entities.Category;
import com.fpoly.java5demo.services.CategoryServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class CategoryController {

	@Autowired
	CategoryServices categoryServices;

	@GetMapping("/category-form")
	public String categoryAdd(Model model) {

		model.addAttribute("bean", new CategoryFormBean());

		return "admin/category-form";
	}

	@GetMapping("/category-form/{id}")
	public String categoryUpdate(Model model, @PathVariable(name = "id") int id) {

		Category category = categoryServices.getById(id);

		if (category == null) {
			return "redirect:/admin/category-form";
		}

//		Convert entity to beans
		CategoryFormBean bean = new CategoryFormBean();
		bean.setName(category.getName());
		bean.setId(Optional.of(id));

		model.addAttribute("bean", bean);

		return "admin/category-form";
	}

	@PostMapping("/category-form")
	public String categorySave(@Valid @ModelAttribute("bean") CategoryFormBean bean, Errors errors) {

		if (!errors.hasErrors()) {
			String error = categoryServices.addCategory(bean.convertBeanToEntity());

			if (error == null) {
				System.out.println("Success");
			} else {
				System.out.println("Fail");
			}
		}

		return "admin/category-form";
	}
}
