package com.activeedge.stockmanagementsystem.responseDTO;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class StockResponseDTO {

    private long id;
    private String name;
    private BigDecimal currentPrice;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
}
