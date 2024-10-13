package com.BankManag.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.BankManag.entity.AccountDetail;
import com.BankManag.Model.AccountDetailDTO;

@Component
public class AccountDetailConverter {

    // Convert AccountDetailDTO to Entity (AccountDetail)
    public AccountDetail convertToEntity(AccountDetailDTO accountDetailDTO) {
        AccountDetail accountDetail = new AccountDetail(0, null, null, 0, null, 0);
        if (accountDetailDTO != null) {
            BeanUtils.copyProperties(accountDetailDTO, accountDetail);
        }
        return accountDetail;
    }

    // Convert AccountDetail to (AccountDetailDTO)
    public AccountDetailDTO convertToAccountDetailDTO(AccountDetail accountDetail) {
        AccountDetailDTO accountDetailDTO = new AccountDetailDTO();
        if (accountDetail != null) {
            BeanUtils.copyProperties(accountDetail, accountDetailDTO);
        }
        return accountDetailDTO;
    }
}
