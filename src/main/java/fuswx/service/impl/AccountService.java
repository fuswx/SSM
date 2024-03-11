package fuswx.service.impl;

import fuswx.dao.IAccountDao;
import fuswx.domain.Account;
import fuswx.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//service实现类
@Service("accountService")
public class AccountService implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public List<Account> findAll() {
        System.out.println("业务层查询所有的账户信息");
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层保存账户信息");
        accountDao.saveAccount(account);
    }

    @Override
    public Account findById(Integer id) {
        return null;
    }
}
