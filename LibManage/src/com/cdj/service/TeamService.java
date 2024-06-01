package com.cdj.service;

import com.cdj.mapper.TeamMapper;
import com.cdj.model.TeamInfo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class TeamService {

    public void allTeam() throws SQLException, IOException, ClassNotFoundException {
        TeamMapper teamMapper = new TeamMapper();
        teamMapper.allTable();
        System.out.println("查询结束");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void teamSome() throws SQLException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.printf("输入要查询的社团：");
        String team = sc.next();
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setSociety(team);
        TeamMapper teamMapper = new TeamMapper();
        teamMapper.teamSomeTeam(teamInfo);
        System.out.println("查询结束");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void insertTeam(){
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎创建新社团成员");
        System.out.print("请输入社员名：");
        String teamName = sc.next();
        System.out.print("请输入班级：");
        String teamClass = sc.next();
        System.out.print("请输入年龄：");
        int teamAge = sc.nextInt();
        System.out.print("请输入社团：");
        String teamSociety = sc.next();
        System.out.print("请输入备注：");
        String teamNote = sc.next();

        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setName(teamName);
        teamInfo.setMclass(teamClass);
        teamInfo.setAge(teamAge);
        teamInfo.setSociety(teamSociety);
        teamInfo.setNote(teamNote);
        TeamMapper teamMapper = new TeamMapper();
        teamMapper.insertTeam(teamInfo);
    }

    public void delTeam() throws SQLException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入要删除社员ID：");
        int delId = sc.nextInt();
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setId(delId);
        TeamMapper teamMapper = new TeamMapper();
        teamMapper.delTeam(teamInfo);
    }

    public void updateTeam() throws SQLException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.printf("请输入要更新社员ID：");
        int delId = sc.nextInt();
        System.out.print("请输入社员名：");
        String teamName = sc.next();
        System.out.print("请输入班级：");
        String teamClass = sc.next();
        System.out.print("请输入年龄：");
        int teamAge = sc.nextInt();
        System.out.print("请输入社团：");
        String teamSociety = sc.next();
        System.out.print("请输入备注：");
        String teamNote = sc.next();
        TeamInfo teamInfo = new TeamInfo();
        teamInfo.setId(delId);
        teamInfo.setName(teamName);
        teamInfo.setMclass(teamClass);
        teamInfo.setAge(teamAge);
        teamInfo.setSociety(teamSociety);
        teamInfo.setNote(teamNote);
        TeamMapper teamMapper = new TeamMapper();
        teamMapper.updateTeam(teamInfo);
    }
}
