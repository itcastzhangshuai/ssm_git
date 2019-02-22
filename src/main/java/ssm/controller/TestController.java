package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.dao.AccountDao;
import ssm.domain.Account;
import ssm.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class TestController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDao accountDao;

    @RequestMapping("/findAll")
    public String Run(Model model){
        System.out.println("表现层：查询所有用户");
        accountService.findAll();
        List<Account> all = accountDao.findAll();
        model.addAttribute("list",all);
        return "success";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountDao.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/user/findAll");
    }



}
