package com.hzero.demo.ssm;

import com.hzero.demo.ssm.pojo.User;
import com.hzero.demo.ssm.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {

        UserServiceImpl userService = (UserServiceImpl) new ClassPathXmlApplicationContext("ApplicationContext.xml")
                .getBean("userService");

        User user = new User();
        user.setUserName("Aesop");
        user.setPassword("123456");
        user.setRoleName("admin");

        userService.insertUser(user);

        System.out.println("查询插入的数据:");
        System.out.println(toString(user));

        user.setId(user.getId());
        user.setUserName("Aesop 1");
        user.setPassword("54321");
        user.setRoleName("worker");

        userService.updateUser(user);

        System.out.println("查询更新的数据:");
        System.out.println(toString(user));

        System.out.println("删除前的数据:");
        for (User userCase : userService.findAllUser()) {
            System.out.println(toString(userCase));
        }

        //删除本次插入的数据
        userService.deleteUserById(user.getId());

        System.out.println("删除后的数据:");
        for (User userCase : userService.findAllUser()) {
            System.out.println(toString(userCase));
        }


    }


    public static String toString(User user) {
        return "id: " + user.getId() + " " +
                "name: " + user.getUserName() + " " +
                "password: " + user.getPassword() + " " +
                "role: " + user.getRoleName();
    }

}
