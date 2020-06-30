//package com.yy.filter;
//
//import com.yy.entity.UserBean;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
//
//public class PowerFilter implements Filter {
//    Set<String> onf= new HashSet<String>();
//    public void init(FilterConfig filterConfig) throws ServletException {
//        String notCheckUrl = filterConfig.getInitParameter("notCheckUrl");
//        for(String sb:notCheckUrl.split(",")){
//            onf.add(sb);
//        }
//
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req =  (HttpServletRequest)request;
//        String requestURI = req.getRequestURI();
//        System.out.println(requestURI+"666666");
//        if(onf.contains(requestURI)){
//                chain.doFilter(request, response);
//        }else{
//            UserBean ub = (UserBean)((HttpServletRequest) request).getSession().getAttribute("ub");
//                if (ub!=null){
//                    chain.doFilter(request, response);
//                }else{
//                    req.setAttribute("msg", "请先去登录！！！！");
//                    request.getRequestDispatcher("index.jsp").forward(req, response);
//                }
//        }
//    }
//
//    public void destroy() {
//
//    }
//}
