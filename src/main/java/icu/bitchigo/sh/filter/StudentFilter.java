package icu.bitchigo.sh.filter;




import icu.bitchigo.sh.Utils.JwtUtil;
import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter(urlPatterns = {"/student/*"})
public class StudentFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res =(HttpServletResponse)servletResponse;
        String token = req.getHeader("token");
        if (token==null||token.isEmpty()) {
            res.sendError(403,"没有token");
            return;
        }
        if (JwtUtil.verify(token)==null){
            res.sendError(403,"token无效");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
