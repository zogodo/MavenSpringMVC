package me.zogodo.ssh.sql;

import java.sql.*;
import com.sun.rowset.CachedRowSetImpl;

/**
 * Created by zogod on 2016/9/9.
 */
public class SqlHelper
{
    protected static String url = "jdbc:mysql://localhost:3306/test?allowMultiQueries=true";
    protected static String jar = "com.mysql.jdbc.Driver";
    protected static String username = "root";
    protected static String password = "123456";

    public static CachedRowSetImpl Select(String sql)
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        CachedRowSetImpl crs = null;
        try
        {
            Class.forName(jar);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
            crs = new CachedRowSetImpl();
            crs.populate(rset);
            conn.close();
            stmt.close();
            rset.close();
            return crs;
        }
        catch (Exception e1)
        {
            try
            {
                if (conn != null) conn.close();
                if (stmt != null) stmt.close();
                if (rset != null) rset.close();
                if (crs != null) crs.close();
            }
            catch (Exception e2) { }
            return null;
        }
    }

    public static CachedRowSetImpl Query(String sql, Object... parameters)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        CachedRowSetImpl crs = null;
        try
        {
            Class.forName(jar);
            conn = DriverManager.getConnection(url, username, password);
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < parameters.length; i++)
            {
                pstmt.setObject(i + 1, parameters[i]);
            }
            rset = pstmt.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(rset);
            conn.close();
            pstmt.close();
            rset.close();
            return crs;
        }
        catch (Exception e1)
        {
            try
            {
                if (conn != null) conn.close();
                if (pstmt != null) pstmt.close();
                if (rset != null) rset.close();
                if (crs != null) crs.close();
            }
            catch (Exception e2) { }
            return null;
        }
    }

    public static int NoneQuery(String sql, Object... parameters)
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
            Class.forName(jar);
            conn = DriverManager.getConnection(url, username, password);
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < parameters.length; i++)
            {
                pstmt.setObject(i + 1, parameters[i]);
            }
            int re = pstmt.executeUpdate();
            conn.close();
            return re;
        }
        catch (Exception e1)
        {
            try
            {
                if (conn != null) conn.close();
                if (pstmt != null) pstmt.close();
            }
            catch (Exception e2) { }
            return -1;
        }
    }

}
