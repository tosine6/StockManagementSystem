package com.activeedge.stockmanagementsystem.requestDTO;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class StockRequestDTO {

    @NotNull
    private String name;
    @NotNull
    private BigDecimal currentPrice;

}
