package com.BankManag.util;



import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.BankManag.entity.Admin;
import com.BankManag.Model.AdminDTO;

@Component
public class AdminConverter {

	public Admin convertToEntity(AdminDTO adminDTO) {

		Admin admin = new Admin();
		if (adminDTO != null) {
			BeanUtils.copyProperties(adminDTO, admin);
		}

		return admin;
	}

	public AdminDTO convertToAdminDTO(Admin admin) {

		AdminDTO adminDTO = new AdminDTO();
		if (admin != null) {
			BeanUtils.copyProperties(admin, adminDTO);
		}

		return adminDTO;
	}
}