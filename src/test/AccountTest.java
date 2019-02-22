import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.dao.AccountDao;
import ssm.domain.Account;
import ssm.service.AccountService;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class AccountTest {

    @Test
    public void test1(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.findAll();
    }

    @Test
    public void test2() throws IOException {
        InputStream rs = Resources.getResourceAsStream("SqlMapperConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(rs);
        SqlSession sqlSession = build.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }
}
