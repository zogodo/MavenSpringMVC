package me.zogodo.ssh.sql;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;

/**
 * Created by zogod on 2017/1/25.
 */
public class SqlTransact
{
    protected String url = SqlHelper.url;
    protected String jar = SqlHelper.jar;
    protected String username = SqlHelper.username;
    protected String password = SqlHelper.password;

    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rset;
    protected CachedRowSetImpl crs;

    public SqlTransact()
    {
        try
        {
            Class.forName(jar);
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);//设置为手动提交事务
        }
        catch (Exception e)
        {
            try{ CloseTran(); }
            catch (Exception e2) { }
        }
    }
    public int TranUpdate(String sql, Object... parameters)
    {
        try
        {
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < parameters.length; i++)
            {
                pstmt.setObject(i + 1, parameters[i]);
            }
            int re = pstmt.executeUpdate();
            return re;
        }
        catch (SQLException e)
        {
            try{ CloseTran(); }
            catch (Exception e2) { }
            return -1;
        }
    }
    public CachedRowSetImpl TranQuery(String sql, Object... parameters)
    {
        try
        {
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < parameters.length; i++)
            {
                pstmt.setObject(i + 1, parameters[i]);
            }
            rset = pstmt.executeQuery();
            crs = new CachedRowSetImpl();
            crs.populate(rset);
            return crs;
        }
        catch (SQLException e)
        {
            try{ CloseTran(); }
            catch (Exception e2) { }
            return null;
        }
    }
    public void CommitAndClose()
    {
        try
        {
            conn.commit(); //如果所有sql语句成功，则提交事务
            conn.close();
        }
        catch (SQLException e)
        {
            try{ CloseTran(); }
            catch (Exception e2) { }
        }
    }
    public void CloseTran() throws SQLException
    {
        if (conn != null)
        {
            conn.rollback(); // 只要有一个sql语句出现错误，则将事务回滚
            conn.close();
        }
        if (pstmt != null) pstmt.close();
        if (rset != null) rset.close();
    }
}
