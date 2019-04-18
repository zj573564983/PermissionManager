package com.zhangjie.filter;

import com.zhangjie.common.RequestHolder;
import com.zhangjie.model.SysUser;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 验证用户是否登录
 * @author zhangjie
 * @date 2019/4/17 9:13
 */
@Slf4j
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        String servletPath=request.getServletPath();

        SysUser sysUser=(SysUser)request.getSession().getAttribute("user");
        if(sysUser==null){
            String path="/signin.jsp";
            response.sendRedirect(path);
            return;
        }
        RequestHolder.add(sysUser);
        RequestHolder.add(request);
        filterChain.doFilter(servletRequest,servletResponse);
        return;
    }

    @Override
    public void destroy() {

    }
}
