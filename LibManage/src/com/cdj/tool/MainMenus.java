package com.cdj.tool;

import com.cdj.service.AdminService;
import com.cdj.service.TeamService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenus {
    public static void MainMenus() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n");
        System.out.println("************社团管理系统***************");
        System.out.println("************1、登陆***************");
        System.out.println("************2、注册***************");
        System.out.println("************3、退出***************");
        System.out.print("请选择对应功能数字:");
        Scanner sc = new Scanner(System.in);
        int s = 0;
        try {
            s = sc.nextInt();
        } catch (Exception e) {
            System.out.println("您输入的不是数字");
        }
        switch (s){
            case 1:
//                登陆
                AdminService adminService = new AdminService();
                adminService.adminLogin();
                break;
            case 2:
//                注册
                AdminService adminService1 = new AdminService();
                adminService1.insertAdmin();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("输入有误");
        }
    }
    public static void MainMenus_T() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("\n");
        System.out.println("************社团管理系统-管理员***************");
        System.out.println("************1、查看全部社员******************");
        System.out.println("************2、查看每个社社员****************");
        System.out.println("************3、新增社员*********************");
        System.out.println("************4、删除社员*********************");
        System.out.println("************5、修改社员*********************");
        System.out.println("************6、退出登录*********************");
        System.out.print("请选择对应功能数字:");
        Scanner sc = new Scanner(System.in);
        int s = 0;
        try {
            s = sc.nextInt();
        } catch (Exception e) {
            System.out.println("您输入的不是数字");
            MainMenus_T();
        }

        switch (s){
            case 1:
                /**
                 * 查询全部team people
                 */
//                System.out.println(s);
                TeamService teamService = new TeamService();
                teamService.allTeam();
                MainMenus_T();
                break;
            case 2:
                /**
                 * 查询每个社团人
                 */
//                System.out.println(s);
                TeamService teamService1 = new TeamService();
                teamService1.teamSome();
                MainMenus_T();
                break;
            case 3:
                /**
                 * 插入社团成员
                 */
//                System.out.println(s);
                TeamService teamService2 = new TeamService();
                teamService2.insertTeam();
                MainMenus_T();
                break;
            case 4:
                /**
                 * 删除要删除的数据
                 */
                TeamService teamService3 = new TeamService();
                teamService3.delTeam();
                System.out.println(s);
                MainMenus_T();
                break;
            case 5:
                /**
                 * 更新社员数据
                 */
                TeamService teamService4 = new TeamService();
                teamService4.updateTeam();
                MainMenus_T();
                break;
            case 6:
                MainMenus();
                break;
            default:
                System.out.println("输入有误");
                MainMenus_T();
        }

    }
}
