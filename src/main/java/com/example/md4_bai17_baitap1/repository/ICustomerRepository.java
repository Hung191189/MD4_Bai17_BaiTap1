package com.example.md4_bai17_baitap1.repository;

import com.example.md4_bai17_baitap1.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customers, Long> {
}
