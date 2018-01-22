package me.zogodo.ssh.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zogodo on 18-1-19.
 */
public class LoginCheck
{
    public static Object Nologin(HttpServletRequest request, HttpServletResponse response)
    {
        Object ob = request.getSession().getAttribute("loginInfo");
        if (ob == null)
        {
            Cookie cookie = new Cookie("before_login_url", request.getServletPath());
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return ob;
    }

    public static boolean NologinStudent(HttpServletRequest request, HttpServletResponse response)
    {
        return Nologin(request, response) == null;
    }

    public static boolean NologinTeacher(HttpServletRequest request, HttpServletResponse response)
    {
        Object ob = Nologin(request, response);
        if (ob == null)
        {
            return true;
        }
        LoginInfo loginInfo = (LoginInfo)ob;
        return loginInfo.identity < 2;
    }

    public static boolean NologinAdmin(HttpServletRequest request, HttpServletResponse response)
    {
        Object ob = Nologin(request, response);
        if (ob == null)
        {
            return true;
        }
        LoginInfo loginInfo = (LoginInfo)ob;
        return loginInfo.identity < 3;
    }
}
