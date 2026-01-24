package com.fpoly.java5demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class HomeController {
//	GET localhost:8080/products
//	Lấy danh sách sản phẩm 
	@GetMapping("/")
	public String productList() {
		return "products/list";
	}

//	GET localhost:8080/products/1234
//	Lấy chi tiết sản phẩm theo id
	@GetMapping("/{id}")
	public String productDetail(@PathVariable("id") int id) {
		return "products/list";
	}

//	POST localhost:8080/products/
	@PostMapping("/")
	public String productAdd() {
		return "products/list";
	}

//	DELETE localhost:8080/products/
	@DeleteMapping("/")
	public String productDelete() {
		return "products/list";
	}

//	// Chỉ mới khai báo request chưa có giá trị
//	@Autowired
////	Dùng để tiêm giá trị khi các func bên trong Controller thực thi 
////	Tự động tìm các giá trị phù hợp để gán vào 
//	private HttpServletRequest request;
//
//	@Autowired
//	private HttpServletResponse response;
//
//	@Autowired
//	private ServletContext context;
//
////	Đăng ký path truy cập cho tất cả phương thức 
////	tên path đăng ký phải khác toàn bộ trong cả project
////	@RequestMapping("/")
//	@GetMapping("/") // => GET
////	@PostMapping("/") // => POST
////	@PutMapping("/") // => PUT
////	@DeleteMapping("/") // => DELETE
//	public String home(Model model, @RequestParam(defaultValue = "empty") String title) {
////		model.addAttribute("message", request.getParameter("title"));
//		model.addAttribute("message", title);
//		return "home";
//	}
//
//	@PostMapping("/")
//	public String postHome() {
//
//		return "home.html";
//	}
//
////	Phương thức này sẽ được gọi trước mọi phương thức trong Controller
////	và giá trị trả về sẽ được gán vào model với key là message
//	@ModelAttribute("message")
//	public String getMessage() {
//		return "Message from @ModelAttribute";
//	}
}

// User -> Request -> Controller -> ModelAtribute -> Mapping -> View
