package com.activeedge.stockmanagementsystem.responseDTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StockResponseDTO {

    private String name;
    private String currentPrice;
    private LocalDateTime createDate;
    private LocalDateTime lastDate;
}
