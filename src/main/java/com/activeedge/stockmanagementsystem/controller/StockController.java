package com.activeedge.stockmanagementsystem.controller;

import com.activeedge.stockmanagementsystem.requestDTO.StockRequestDTO;
import com.activeedge.stockmanagementsystem.responseDTO.APIResponse;
import com.activeedge.stockmanagementsystem.responseDTO.StockResponseDTO;
import com.activeedge.stockmanagementsystem.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@AllArgsConstructor
public class StockController {

    private StockService stockService;

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<StockResponseDTO>> getStock(@PathVariable("id") Long stockId){
        APIResponse<StockResponseDTO> response = new APIResponse<>("Success", stockService.getStock(stockId));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<APIResponse<List<StockResponseDTO>>> fetchAllStock(){
        APIResponse<List<StockResponseDTO>> response = new APIResponse<>("Success", stockService.fetchAllStocks());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<StockResponseDTO>> updateStock(@PathVariable("id") Long stockId,  @RequestBody StockRequestDTO stockRequestDTO){
        APIResponse<StockResponseDTO> response = new APIResponse<>("Success", stockService.updateStock(stockRequestDTO, stockId));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    public ResponseEntity<APIResponse<StockResponseDTO>> createStock(@RequestBody StockRequestDTO stockRequestDTO){
        APIResponse<StockResponseDTO> response = new APIResponse<>("Success", stockService.createStock(stockRequestDTO));
        return ResponseEntity.ok(response);
    }

}
