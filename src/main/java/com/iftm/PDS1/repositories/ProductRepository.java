package com.iftm.PDS1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.PDS1.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
