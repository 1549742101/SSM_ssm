package cn.com.guilongkeji.ssm.controller;

import cn.com.guilongkeji.ssm.entity.User;
import cn.com.guilongkeji.ssm.service.ILogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/1
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 **/
@Controller
public class LoginController {
    @Resource(name="login")
    ILogin login;
    @RequestMapping("/login1")//完成登录后台处理
    public String checkUser(User user) {
        // 使用spring框架加载配置文件
        //ApplicationContext act = new ClassPathXmlApplicationContext("spring.xml");
        //ILogin login = (ILogin) act.getBean("login");
        if (login.execute(user)) {
            return "login_succ";
        }else{
            return "login_err";
        }
    }
}
