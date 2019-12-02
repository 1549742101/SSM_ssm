package cn.com.guilongkeji.ssm.service;

import cn.com.guilongkeji.ssm.entity.User;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/2
 * Time: 0:11
 * To change this template use File | Settings | File Templates.
 **/
public class Register implements IRegister{
    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    private SqlSessionTemplate sqlSession;
    @Override
    public boolean insert(User user) {
        int result = sqlSession.insert("register",user);
        return result>0;
    }
}
