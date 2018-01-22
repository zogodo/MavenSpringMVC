package me.zogodo.ssh.interceptor;

/**
 * Created by zogodo on 17-12-25.
 */
public class LoginInfo
{
    public int userid;
    public String username;
    public int identity;

    public int getUserid()
    {
        return userid;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getIdentity()
    {
        return identity;
    }

    public void setIdentity(int identity)
    {
        this.identity = identity;
    }
}
