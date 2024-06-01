package com.cdj.mapper;

import com.cdj.model.TeamInfo;
import com.cdj.tool.JdbcUntil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamMapper {
    /**
     * 1.输出全部的社团的数据
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void allTable() throws SQLException, IOException, ClassNotFoundException {
        JdbcUntil jdbcUntil = new JdbcUntil();
        Connection conn = jdbcUntil.getConn();
        String sql = "SELECT * FROM DM_TEAM";
        ResultSet rs =  jdbcUntil.teamAll(conn,sql);


        if (rs!=null){
            System.out.println("++++++++++ 全部社团成员 ++++++++++");
            System.out.println("ID :  姓名  :  班级  :  年龄  :  社团  :  注释  ::");
            while (rs.next()) {
                System.out.print(rs.getInt("ID") + "  :  "); // 假设第一列是ID
                // 使用索引访问其他列（注意索引从1开始）
                System.out.print(rs.getString(2) + "  :  ");
                System.out.print(rs.getString(3) + "  :  ");
                System.out.print(rs.getInt(4) + "  :  ");
                System.out.print(rs.getString(5) + "  :  ");
                System.out.println(rs.getString(6) + "::"); // 最后一列后面加上换行符
            }
        }else {
            System.out.println("***** 没有成员 *****");
        }

        rs.close();
    }

    public void teamSomeTeam(TeamInfo teamInfo) throws SQLException, IOException, ClassNotFoundException {
        JdbcUntil jdbcUntil = new JdbcUntil();
        Connection conn = jdbcUntil.getConn();
        String sql = "SELECT * FROM DM_TEAM WHERE SOCIETY = ?";
        ResultSet rs = jdbcUntil.teamSomeTeam(conn,sql,teamInfo);

        if (rs!=null){
            System.out.println("++++++++++ 社团成员 ++++++++++");
            System.out.println("ID :  姓名  :  班级  :  年龄  :  社团  :  注释  ::");
            while (rs.next()) {
                System.out.print(rs.getInt("ID") + "  :  "); // 假设第一列是ID
                // 使用索引访问其他列（注意索引从1开始）
                System.out.print(rs.getString(2) + "  :  ");
                System.out.print(rs.getString(3) + "  :  ");
                System.out.print(rs.getInt(4) + "  :  ");
                System.out.print(rs.getString(5) + "  :  ");
                System.out.println(rs.getString(6) + "::"); // 最后一列后面加上换行符
            }
        }else {
            System.out.println("***** 没有成员 *****");
        }

        rs.close();
    }

    /**
     * 添加社团成员
     */
    public void insertTeam(TeamInfo teamInfo){
        JdbcUntil ju = new JdbcUntil();
        try {
            Connection conn = ju.getConn();
            String sql = "INSERT INTO DM_TEAM(name,mclass,age,society,note) VALUES (?,?,?,?,?)";
            ju.insertTeam(conn,sql,teamInfo);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * delete 社团成员
     */
    public void delTeam(TeamInfo teamInfo) throws SQLException, IOException, ClassNotFoundException {
        JdbcUntil jdbcUntil = new JdbcUntil();
        Connection conn = jdbcUntil.getConn();
        String sql = "DELETE FROM DM_TEAM WHERE ID = ?";
        jdbcUntil.delTeam(conn,sql,teamInfo);
    }

    /**
     * update 社团成员
     */
    public void updateTeam(TeamInfo teamInfo) throws SQLException, IOException, ClassNotFoundException {
        JdbcUntil jdbcUntil = new JdbcUntil();
        Connection conn = jdbcUntil.getConn();
        String sql = "UPDATE DM_TEAM SET NAME=?,mclass=?,age=?,society=?,note=? WHERE ID=?";
        jdbcUntil.updateTeam(conn,sql,teamInfo);
    }
}
