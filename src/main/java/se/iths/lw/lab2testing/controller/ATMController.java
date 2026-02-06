package se.iths.lw.lab2testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.iths.lw.lab2testing.component.AccountComponent;
import se.iths.lw.lab2testing.service.ATMService;

@Controller
@RequestMapping("/")
public class ATMController {
    private final ATMService atmService;

    public ATMController() {
        AccountComponent accountComponent = new AccountComponent(1000000,1L);
        this.atmService= new ATMService(accountComponent);
    }

    @GetMapping("/balance")
    public String showBalance(Model model){
        model.addAttribute("balance", atmService.showBalance() );
        return "balance";
    }
}
