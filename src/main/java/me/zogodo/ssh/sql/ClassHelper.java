package me.zogodo.ssh.sql;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Created by zogodo on 17-12-28.
 */
public class ClassHelper
{
    public static Object handle(Class clazz, ResultSet rs)
    {
        Object ob = null;
        try
        {
            if (rs.next())
            {
                ob = clazz.newInstance();                      //通过class类创建对象
                ResultSetMetaData metadata = rs.getMetaData(); //获取结果集的元数据对象
                int count = metadata.getColumnCount();         //获取列的数量
                for (int i = 1; i <= count; i++)
                {
                    String fieldName = metadata.getColumnLabel(i);  //列名
                    Field field = null;
                    try
                    {
                        field = clazz.getDeclaredField(fieldName);  //通过列名获取对象属性
                    }
                    catch (Exception e)
                    {
                        continue;
                    }
                    field.setAccessible(true);                      //暴力反射
                    field.set(ob, rs.getObject(i));                 //设置对象的属性值
                }
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return ob;
    }
}
