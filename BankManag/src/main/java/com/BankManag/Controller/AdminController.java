package com.BankManag.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.BankManag.Model.AdminDTO;
import com.BankManag.service.AdminService;
import com.BankManag.util.AdminConverter;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminConverter adminConverter;
  
    public String showAdminHome() {
        return "adminHome";
    }
    //http://localhost:8080/addAdmin
    @PostMapping("/addAdmin")
    public String addAdmin(@RequestParam String userName, @RequestParam String password, @RequestParam String newUserName,
                           @RequestParam String newPassword, Model model) {
        AdminDTO newAdminDTO = new AdminDTO();
        newAdminDTO.setUserName(newUserName);
        newAdminDTO.setPassword(newPassword);

        String result = adminService.addNewAdmin(userName, password, adminConverter.convertToEntity(newAdminDTO));
        model.addAttribute("message", result);
        return "result";
    }
    //http://localhost:8080/updatePassword
    @PostMapping("/updatePassword")
    public String updatePassword(@RequestParam String userName, @RequestParam String oldPassword, 
                                 @RequestParam String newPassword, Model model) {
        String result = adminService.updatePassword(userName, oldPassword, newPassword);
        model.addAttribute("message", result);
        return "result";
    }
    //http://localhost:8080/deleteAdmin
    @PostMapping("/deleteAdmin")
    public String deleteAdmin(@RequestParam String userName, @RequestParam String password, Model model) {
        String result = adminService.deleteAdmin(userName, password);
        model.addAttribute("message", result);
        return "result";
    }
}
