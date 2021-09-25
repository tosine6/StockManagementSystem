package com.activeedge.stockmanagementsystem.repository;

import com.activeedge.stockmanagementsystem.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {
}
