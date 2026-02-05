package com.yasin.paperlock.model.dto.bill;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BillRequestDTO {

    private String storeName;
    private String productName;
    private BigDecimal productCost;
    private LocalDate startDate;
    private LocalDate expiredDate;
    private String billStatus;
    private String billImageUrl;
    private Integer personId;
}
