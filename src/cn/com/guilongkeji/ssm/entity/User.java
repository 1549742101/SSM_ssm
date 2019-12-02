package cn.com.guilongkeji.ssm.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: xgl
 * Date: 2019/12/1
 * Time: 22:10
 * To change this template use File | Settings | File Templates.
 **/
public class User {
    private int id;
    @NotNull(message = "用户名不能为空")
    private String username;
    @Length(min = 8,max = 16,message = "密码长度在8-16之间")
    private String password;
    private String password2;
    private int sex;
    private int work;
    private String favorite;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getWork() {
        return work;
    }

    public void setWork(int work) {
        this.work = work;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    @AssertTrue(message="两次密码输入不一致")
    public boolean isSamePassword() {
        if (password!=null&&password.equals(password2)) {return true;} else {return false;}
    }
    @AssertTrue(message="用户名和密码不能相同")
    public boolean isSameNameAndPassword() {
        if (username!=null&&password.equals(username)) {return false;} else {return true;}
    }
}
