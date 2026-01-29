package com.fpoly.java5demo.beans;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fpoly.java5demo.validation.ValidImage;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductFormBean {
	private String name;
	private int price;
	private int quantity;
	private int category;
	private int status;

	@Size(min = 1, message = "Vui lòng chọn ít nhất 1 ảnh")
	@ValidImage(type = { "image/jpeg", "image/png", "image/gif" }, maxSize = "2MB", message = "Ảnh không hợp lệ")
	private List<MultipartFile> images;
}
