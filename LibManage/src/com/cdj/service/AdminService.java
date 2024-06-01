package com.cdj.service;

import com.cdj.mapper.AdminMapper;
import com.cdj.model.AdminInfo;
import com.cdj.tool.MainMenus;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminService {
    /**
     * 登陆成功显示主页面 登陆失败返回用户名或密码错误 跳转菜单页
     */
    public void adminLogin() throws SQLException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎登陆");
        System.out.print("请输入用户名：");
        String adminUsername = sc.next();
        System.out.print("请输入密码：");
        String pw = sc.next();
        AdminMapper adminMapper = new AdminMapper();
        AdminInfo login = adminMapper.login(adminUsername);
        if (login.getPassword().equals(pw)){
            //跳转登录页面
//            System.out.println("登陆成功");
            System.out.println("#####################");
            MainMenus.MainMenus_T();
        }else {
            //提示输入有误
            //跳转菜单
            System.out.println("用户名或密码错误");
            MainMenus.MainMenus();

        }
    }

    /**
     * 管理员注册
     */
    public void insertAdmin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎注册");
        System.out.print("请输入用户名：");
        String adminUsername = sc.next();
        System.out.print("请输入密码：");
        String adminPw = sc.next();
        /**
         * 将数据写入AdminInfo
         */
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setUsername(adminUsername);
        adminInfo.setPassword(adminPw);
        if (adminPw!=null && adminPw!=null){
            AdminMapper adminMapper = new AdminMapper();
            try {
                adminMapper.insert(adminInfo);
            }catch (Exception e) {
                System.out.println("创建违反了规则，请重试！");
                insertAdmin();
            }

        }


    }
}
