package com.fpoly.java5demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProductController {

	@GetMapping("/product-form")
	public String productForm() {
		return "admin/product-form";
	}
}
