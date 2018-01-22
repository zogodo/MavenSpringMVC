package me.zogodo.ssh.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "person")
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

    @Id
    @Column(name = "id", nullable = false, unique = true)
    // @GenericGenerator(name = "generator", strategy = "uuid")
    // @GeneratedValue(generator = "generator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 32)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Column(name = "phone", length = 32)
    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Column(name = "birthday", length = 32)
    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    @Override
    public String toString()
    {
        return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", birthday="
                + birthday + "]";
    }

}
