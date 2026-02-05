package com.yasin.paperlock.service;

import com.yasin.paperlock.model.dto.bill.BillRequestDTO;
import com.yasin.paperlock.model.dto.bill.BillResponseDTO;
import org.springframework.web.multipart.MultipartFile;

public interface BillService {
    BillResponseDTO createBill(BillRequestDTO dto, MultipartFile image);
}