package com.fpoly.java5demo.jpas;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpoly.java5demo.entities.Product;

public interface ProductJPA extends JpaRepository<Product, Integer> {

}
