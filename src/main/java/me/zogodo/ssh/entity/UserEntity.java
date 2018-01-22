package me.zogodo.ssh.entity;

import javax.persistence.*;

/**
 * Created by zogodo on 17-12-31.
 */
@Entity
@Table(name = "user", schema = "test2", catalog = "")
public class UserEntity
{
    private int id;
    private String usr;
    private String pwd;

    @Id
    @Column(name = "id")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "usr")
    public String getUsr()
    {
        return usr;
    }

    public void setUsr(String usr)
    {
        this.usr = usr;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        UserEntity that = (UserEntity) o;

        if (id != that.id)
        {
            return false;
        }
        if (usr != null ? !usr.equals(that.usr) : that.usr != null)
        {
            return false;
        }
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (usr != null ? usr.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }
}
