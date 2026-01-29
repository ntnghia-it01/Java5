package com.fpoly.java5demo.jpas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fpoly.java5demo.entities.CartDetail;

public interface CartDetailJPA extends JpaRepository<CartDetail, Integer> {

	@Query(value = "SELECT * FROM cart_details WHERE user_id=?1", nativeQuery = true)
	public List<CartDetail> findByUserId(int id);

	@Query(value = "DELETE FROM cart_details WHERE user_id=?1", nativeQuery = true)
	public void deleteByUserId(int id);
}
