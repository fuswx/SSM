package fuswx.test;

import fuswx.dao.IAccountDao;
import fuswx.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1(){
        try {
            //加载配置文件
            InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
            //创建一个sqlsessionfactory
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
            //创建sqlsession
            SqlSession sqlSession=factory.openSession();
            //获取到代理对象
            IAccountDao accountDao=sqlSession.getMapper(IAccountDao.class);

            //查询所有数据
            List<Account>accounts=accountDao.findAll();
            for (Account a : accounts) {
                System.out.println(a);
            }
            //关闭资源
            sqlSession.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void run2(){
        try {
            InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSession sqlSession=new SqlSessionFactoryBuilder().build(inputStream).openSession();
            IAccountDao accountDao=sqlSession.getMapper(IAccountDao.class);
            accountDao.saveAccount(new Account("张三",1000.0));
            //查询所有数据
            List<Account>accounts=accountDao.findAll();
            sqlSession.commit();
            for (Account a : accounts) {
                System.out.println(a);
            }
            //关闭资源
            sqlSession.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
