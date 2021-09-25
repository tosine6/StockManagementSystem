package com.activeedge.stockmanagementsystem.service;


import com.activeedge.stockmanagementsystem.requestDTO.StockRequestDTO;
import com.activeedge.stockmanagementsystem.responseDTO.StockResponseDTO;

import java.util.List;

public interface StockService {

    StockResponseDTO getStock(long stockId);
    List<StockResponseDTO> fetchAllStocks();
    StockResponseDTO updateStock(StockRequestDTO stockRequestDTO, Long stockId);
    StockResponseDTO createStock(StockRequestDTO stockRequestDTO);
}
