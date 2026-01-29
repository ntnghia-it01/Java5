package com.fpoly.java5demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.java5demo.beans.ProductFormBean;
import com.fpoly.java5demo.entities.Category;
import com.fpoly.java5demo.services.CategoryServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired
	CategoryServices categoryServices;

	@GetMapping("/product-form")
	public String productForm(Model model) {

		model.addAttribute("bean", new ProductFormBean());

		return "admin/product-form";
	}

	@PostMapping("/product-form")
	public String productSave(@Valid @ModelAttribute("bean") ProductFormBean bean, Errors errors) {

		if (!errors.hasErrors()) {

		}

//		5 Ảnh
//		Cách 1:
//		- Lưu tất cả các ảnh vào project => Danh sách tên
//		- Lưu tất cả tên vào DB 

//		Cách 2:
//		- Lưu lần lượt 1 ảnh vảo project => Thành công => Lưu tên vào DB
//		- Ngược lại ngưng lưu ??

		return "admin/product-form";
	}

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryServices.getList();
	}
}
