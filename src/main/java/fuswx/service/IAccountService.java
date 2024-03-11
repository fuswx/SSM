package fuswx.service;

import fuswx.domain.Account;

import java.util.List;

//service接口
public interface IAccountService {

    //查询所有用户信息
    public List<Account> findAll();

    //保存账户信息
    public void saveAccount(Account account);

    public Account findById(Integer id);
}
