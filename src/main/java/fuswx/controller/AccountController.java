package fuswx.controller;

import fuswx.domain.Account;
import fuswx.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//账户web
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有的账户信息");
        //调用service方法
        List<Account> accounts=accountService.findAll();
        model.addAttribute("list",accounts);
        return "list";
    }

    @RequestMapping("save")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response){
        System.out.println("表现层：保存账户信息");
        accountService.saveAccount(account);
        try {
            response.sendRedirect(request.getContextPath()+"/account/findAll");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
}
