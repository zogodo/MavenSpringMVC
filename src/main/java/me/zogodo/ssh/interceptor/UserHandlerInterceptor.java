package me.zogodo.ssh.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by zogodo on 18-1-19.
 */
public class UserHandlerInterceptor implements HandlerInterceptor
{
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
    {
        // 有 @UserRequired 注解的 Controllor 方法，验证登录
        HandlerMethod handlerMethod = (HandlerMethod)o;
        Method method = handlerMethod.getMethod();

        UserRequired annotation = method.getAnnotation(UserRequired.class);
        if (annotation == null) // 判断是否有 @UserRequired 注解
        {
            return true;
        }

        if(annotation.roleId() == 1) //学生
        {
            if (LoginCheck.NologinStudent(httpServletRequest, httpServletResponse))
            {
                // MyTool.AlertAndBack("你还没有登录！\\n\\n请先登录！", httpServletRequest, httpServletResponse);
                return false;
            }
        }
        else if(annotation.roleId() == 2) //教师
        {
            if (LoginCheck.NologinTeacher(httpServletRequest, httpServletResponse))
            {
                // MyTool.AlertAndBack("你还没有登录！\\n\\n请先登录！", httpServletRequest, httpServletResponse);
                return false;
            }
        }
        else if(annotation.roleId() == 3) //管理员
        {
            if (LoginCheck.NologinAdmin(httpServletRequest, httpServletResponse))
            {
                // MyTool.AlertAndBack("你还没有登录！\\n\\n请先登录！", httpServletRequest, httpServletResponse);
                return false;
            }
        }

        return true;
    }

    //返回 jsp 之前执行
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception
    {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception
    {

    }
}
