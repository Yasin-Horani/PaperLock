package com.yasin.paperlock.model.dto.bill;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BillResponseDTO(
        String storeName,
        String productName,
        BigDecimal productCost,
        LocalDate startDate,
        LocalDate expiredDate,
        String billStatus,
        String billImageUrl,
        Integer personId
) {
}
