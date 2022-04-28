package com.sainnt.gb.homework7springdata.repository;

import com.sainnt.gb.homework7springdata.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThan(long min);

    List<Product> findAllByPriceBetween(long min, long max);

    List<Product> findAllByPriceLessThan(long max);
}
