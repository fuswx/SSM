package fuswx.test;


import fuswx.service.impl.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void run1(){
        //加载配置文件
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取对象
        AccountService accountService=applicationContext.getBean("accountService",AccountService.class);
        //调用方法
        accountService.findAll();

    }
}
