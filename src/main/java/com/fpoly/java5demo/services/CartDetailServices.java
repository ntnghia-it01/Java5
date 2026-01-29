package com.fpoly.java5demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.java5demo.entities.CartDetail;
import com.fpoly.java5demo.jpas.CartDetailJPA;

import jakarta.servlet.http.HttpSession;

@Service
public class CartDetailServices {

	@Autowired
	CartDetailJPA cartDetailJPA;

	@Autowired
	HttpSession session;

//	Cách 1: Lấy thông tin user bằng serJPTA => user.getCartDetails()
//	Cách 2: Viết thêm script sql ở cartDetailJPA
// 	Dùng để lấy danh sách sản phẩm ở DB lưu vào Session khi khởi tạo
	public List<CartDetail> getCartsByUserId(int id) {
		List<CartDetail> cartDetails = new ArrayList<CartDetail>();
		try {
			cartDetails = cartDetailJPA.findByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartDetails;
	}

//	Hàm đồng bộ dữ liệu từ Session qua CartDetail ở DB
	public boolean syncSessionCartToDatabase(List<CartDetail> cartDetails) {
		try {
//			Xoá tất cả các cartDetail của user
			cartDetailJPA.deleteByUserId(cartDetails.get(0).getUser().getId());
//			Thêm lại danh sách cartDetail được gửi qua ở Session
			cartDetailJPA.saveAll(cartDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addToCart(int prodId) {
		return false;
	}

	public boolean updateQuantity(int prodId, int quantity) {
		return false;
	}

	public boolean removeCart(int prodId) {
		return false;
	}
}
