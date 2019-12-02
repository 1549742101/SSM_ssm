package cn.com.guilongkeji.ssm.controller;

import cn.com.guilongkeji.ssm.entity.User;
import cn.com.guilongkeji.ssm.service.IRegister;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/2
 * Time: 9:36
 * To change this template use File | Settings | File Templates.
 **/
@Controller
public class RegisterController {
    @Resource(name="register")
    IRegister register;
    @RequestMapping("/reg")
    public String registerUser(@Valid User user, Errors errors) {
        if (errors.getErrorCount()>0) {
            for(FieldError error:errors.getFieldErrors()){
                System.out.println(error.getField() + ":" + error.getDefaultMessage());//调试信息，可看到错误信息
            }
            return "forward:/register.jsp";
        } else {
            if (register.insert(user)){
                return "register_succ";
            }
            return "forward:/register.jsp";
        }
    }
}
