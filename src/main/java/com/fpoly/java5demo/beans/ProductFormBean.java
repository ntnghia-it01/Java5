package com.fpoly.java5demo.beans;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
	private List<MultipartFile> images;
	private int status;
}
