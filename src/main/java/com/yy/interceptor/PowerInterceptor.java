//package com.yy.interceptor;
//
//import com.yy.entity.PowerBean;
//import com.yy.entity.UserBean;
//import jdk.nashorn.internal.ir.RuntimeNode;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class PowerInterceptor implements HandlerInterceptor {
//    private List<String> exceptUrls;
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        String requestURI = request.getRequestURI();
//        if(exceptUrls.contains(requestURI)){
//            return true;
//        }else{
//            UserBean ub = (UserBean) request.getSession().getAttribute("ub");
//            if(ub!=null){
//                Set<String> urls = (Set<String>)request.getSession().getAttribute("urls");
//                if(urls!=null){
//
//                    if(urls.contains(requestURI)){
//                        return true;
//                    }else{
//                        request.setAttribute("msg", "非法访问，哥们你越权了！！！！");
//                        request.getRequestDispatcher("index.jsp").forward(request, response);
//                        return false;
//                    }
//
//                }
//                return true;
//            }else{
//                request.setAttribute("msg", "请先去登录！！！！");
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//                return false;
//            }
//        }
//    }
//
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//
//    }
//
//    public List<String> getExceptUrls() {
//        return exceptUrls;
//    }
//
//    public void setExceptUrls(List<String> exceptUrls) {
//        this.exceptUrls = exceptUrls;
//    }
//}
