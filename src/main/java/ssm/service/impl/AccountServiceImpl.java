package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.service.AccountService;


@Service("accountService")
public class AccountServiceImpl implements AccountService {

    public void findAll() {
        System.out.println("业务层：查询所有用户");
    }
}
