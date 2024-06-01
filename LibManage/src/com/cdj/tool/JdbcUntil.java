package com.cdj.tool;

import com.cdj.model.AdminInfo;
import com.cdj.model.TeamInfo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUntil {
    /**
     * 获取连接的方法
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    // 获取连接
    public Connection getConn() throws IOException, ClassNotFoundException, SQLException {
        InputStream is = ClassLoader.getSystemResourceAsStream("com/cdj/tool/jdbc.properties");
        Properties pp = new Properties();
        pp.load(is);
        Class.forName(pp.getProperty("jdbc.driver"));
        return DriverManager.getConnection(pp.getProperty("jdbc.url"),
                pp.getProperty("jdbc.username"), pp.getProperty("jdbc.password"));

    }
    // 公共查询

    /**
     * 用于登录的查询方法
     * Admin 用于管理员用户登录
     * @param conn
     * @param sql
     * @param param
     * @return
     * @throws SQLException
     */
    public ResultSet executeQuery(Connection conn, String sql, Object[] param) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        // 使用参数数组中的参数值替换sql语句中的?（占位符）
        if (param != null) {
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i + 1, param[i]);
            }
        }
        return ps.executeQuery();
        // PreparedStatement 将在 try-with-resources 块结束时自动关闭
    }

    public void insertAdmin(Connection conn, String sql,
                           AdminInfo adminInfo) throws SQLException {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, adminInfo.getUsername());
        st.setString(2, adminInfo.getPassword());
        st.executeUpdate();

    }

    /**
     * 对team数据的全部输出
     * @param conn
     * @param sql
     */
    public ResultSet teamAll(Connection conn,String sql) throws SQLException {
        PreparedStatement st = conn.prepareStatement(sql);
        return st.executeQuery();
    }

    /**
     * 2对数据区分（社团）输出
     * @throws Exception
     */
    public ResultSet teamSomeTeam(Connection conn, String sql, TeamInfo teamInfo) throws SQLException{
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1,teamInfo.getSociety());
        return st.executeQuery();
    }

    /**
     * 3,新增社员
     * @throws Exception
     */
    public void insertTeam(Connection conn, String sql,
                            TeamInfo teamInfo) throws SQLException {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, teamInfo.getName());
        st.setString(2, teamInfo.getMclass());
        st.setInt(3, teamInfo.getAge());
        st.setString(4, teamInfo.getSociety());
        st.setString(5, teamInfo.getNote());
        st.executeUpdate();
    }

    /**
     * ID删除社员
     * @param conn
     * @param sql
     * @param teamInfo
     * @throws SQLException
     */

    public void delTeam(Connection conn,String sql,
                        TeamInfo teamInfo) throws SQLException {
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1,teamInfo.getId());
        st.executeUpdate();
    }

    public void updateTeam(Connection connection,String sql,
                           TeamInfo teamInfo) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, teamInfo.getName());
        statement.setString(2, teamInfo.getMclass());
        statement.setInt(3, teamInfo.getAge());
        statement.setString(4, teamInfo.getSociety());
        statement.setString(5, teamInfo.getNote());
        statement.setInt(6,teamInfo.getId());
        statement.executeUpdate();
    }

// 释放资源

    public void closeConn() throws Exception {
        getConn().close();
    }

}