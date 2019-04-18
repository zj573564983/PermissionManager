package com.zhangjie.common;

import com.zhangjie.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/***
 * @author zhangjie
 * @date 2019/4/11 9:15
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final String START_TIME="requestStartTime";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURI();
        Map parameterMap = request.getParameterMap();
        log.info("request start. url:{}, params:{}", url, JsonMapper.obj2String(parameterMap));
        long start=System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        String url=request.getRequestURI();
//        long start=(long)request.getAttribute(START_TIME);
//        long end=System.currentTimeMillis();
//        //Map parameterMap = request.getParameterMap();
//        log.info("request finished. url:{}, params:{}", url, end-start);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url=request.getRequestURI();
        long start=(long)request.getAttribute(START_TIME);
        long end=System.currentTimeMillis();
        //Map parameterMap = request.getParameterMap();
        log.info("request completed. url:{}, params:{}", url, end-start);
        removeThreadLocalInfo();
    }

    public void removeThreadLocalInfo(){
        RequestHolder.remove();
    }
}
