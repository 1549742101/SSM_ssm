package cn.com.guilongkeji.ssm.service;

import cn.com.guilongkeji.ssm.entity.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/1
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 **/
public class Login implements ILogin{
    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    private SqlSessionTemplate sqlSession;

    @Override
    public boolean execute(User user) {
        boolean ret=false;
        //进行数据库编程处理
        // 1.得到数据库连接
        //InputStream inputStream = null;
       // try {//加载mybatis框架
            //inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 2.得到执行sql的对象
            //SqlSession sqlSession = sqlSessionFactory.openSession();
            // 3.执行sql语句
            User userResult = sqlSession.selectOne("login",user);
            // 4.输出结果
            if (userResult!=null) {
                ret=true;
            }
            // 5.关闭数据库
            //sqlSession.close();
       /* } catch (IOException e) {
            e.printStackTrace();
        }*/
        return ret;
    }
}
