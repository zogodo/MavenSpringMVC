package me.zogodo.ssh.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Person
{
    private int id;
    private String name;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") //必须与前台提交的一致，否则 400
    // @JsonFormat(pattern="yyyy-MM-dd") //将Date转换成String
    private Date birthday;

    public Person()
    {
        super();
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

}
