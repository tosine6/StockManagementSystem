package com.activeedge.stockmanagementsystem.serviceImpl;

import com.activeedge.stockmanagementsystem.entity.StockEntity;
import com.activeedge.stockmanagementsystem.repository.StockRepository;
import com.activeedge.stockmanagementsystem.requestDTO.StockRequestDTO;
import com.activeedge.stockmanagementsystem.responseDTO.StockResponseDTO;
import com.activeedge.stockmanagementsystem.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;

    @Override
    public StockResponseDTO getStock(long stockId) {
        StockEntity stock= stockRepository.findById(stockId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock not found with id: "+ stockId));
        return mapStock(stock);
    }

    @Override
    public List<StockResponseDTO> fetchAllStocks() {
        List<StockEntity> stockList = stockRepository.findAll();
        return stockList.stream().map(stock -> mapStock(stock)).collect(Collectors.toList());
    }

    @Override
    public StockResponseDTO updateStock(StockRequestDTO stockRequestDTO, Long stockId) {
        StockEntity stock= stockRepository.findById(stockId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stock not found with id: "+ stockId));
        if(null != stockRequestDTO.getName()){
            stock.setName(stockRequestDTO.getName());
        }
        if(null != stockRequestDTO.getCurrentPrice()){
            stock.setCurrentPrice(stockRequestDTO.getCurrentPrice());
        }
        stockRepository.saveAndFlush(stock);
        return mapStock(stock);
    }

    @Override
    public StockResponseDTO createStock(StockRequestDTO stockRequestDTO) {
        StockEntity newStock= new StockEntity();
        newStock.setName(stockRequestDTO.getName());
        newStock.setCurrentPrice(stockRequestDTO.getCurrentPrice());
        stockRepository.save(newStock);
        return mapStock(newStock);
    }

    public StockResponseDTO mapStock(StockEntity stock) {
        return StockResponseDTO.builder().id(stock.getId()).name(stock.getName()).currentPrice(stock.getCurrentPrice()).createDate(stock.getCreateDate()).lastUpdate(stock.getLastUpdate()) .build();
    }
}
