package com.cdj.mapper;

import com.cdj.model.AdminInfo;
import com.cdj.tool.JdbcUntil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper {
    public AdminInfo login(String adminUsername){
        JdbcUntil ju = new JdbcUntil();
        AdminInfo admin = new AdminInfo();
        try {
            Connection conn = ju.getConn();
            String sql = "select * from DM_ADMIN where username=?";
            Object[] param = {adminUsername};
            ResultSet rs = ju.executeQuery(conn,sql,param);

            while (rs.next()){
                admin.setUsername(rs.getString(2));
                admin.setPassword(rs.getString(3));
            }
            rs.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return admin;

    }

    public void insert(AdminInfo adminInfo){
        JdbcUntil ju = new JdbcUntil();
        try {
            Connection conn = ju.getConn();
            String sql = "INSERT INTO DM_ADMIN(username,password) VALUES (?,?)";
            ju.insertAdmin(conn,sql,adminInfo);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
