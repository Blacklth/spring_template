package com.blacklth.template;

import com.blacklth.template.entity.User;
import com.blacklth.template.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setPassword("1234453");
        user.setUserName("jjjj1");
        user.setPhone("123421552");
        userMapper.insert(user);
        User user1 = userMapper.selectUser(user.getUserId());
        if(user1 == null){
            System.out.println("未插入！");
        }else{
            Assert.assertEquals(user.getUserId(),user1.getUserId());
            System.out.println(user1);
        }
    }
    @Test
    public void testSelct()  {

        List<User> userList = userMapper.selectUsers();
        for(User x:userList){
            System.out.println(x);
        }


    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUserId(1000);
        user.setUserName("243141");
        user.setPassword("1231341");
        user.setPhone("1230949878172");
        System.out.println("更新前："+userMapper.selectUser(user.getUserId()));
        userMapper.updateUser(user);
        System.out.println("更新后："+userMapper.selectUser(user.getUserId()));
    }

    @Test
    public void testDelect(){
        int deleteId = 1001;
        System.out.println("删除前：");
        List<User> userList = userMapper.selectUsers();
        for(User x:userList){
            System.out.println(x);
        }
        userMapper.deleteUser(deleteId);
        System.out.println("删除后：");
        userList = userMapper.selectUsers();
        for(User x:userList){
            System.out.println(x);
        }


    }



}
