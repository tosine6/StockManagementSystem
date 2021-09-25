package com.activeedge.stockmanagementsystem.requestDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockRequestDTO {

    private String name;
    private String currentPrice;

}
