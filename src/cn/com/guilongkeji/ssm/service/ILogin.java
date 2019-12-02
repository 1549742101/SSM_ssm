package cn.com.guilongkeji.ssm.service;

import cn.com.guilongkeji.ssm.entity.User;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/1
 * Time: 22:14
 * To change this template use File | Settings | File Templates.
 **/
public interface ILogin {
    public boolean execute(User user);
}
