package web.filters;

import model.Statistics;
import web.SessionKey;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/AddStatisticsServlet","/dbServlet","/final.jsp"})
public class StatisticsFilter implements Filter {

    public StatisticsFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        Statistics statistics = (Statistics) session.getAttribute(SessionKey.statistics);
        if(statistics==null){
            ((HttpServletResponse) response).sendRedirect("/WhoIsTheBestOfficial/addStatistics.html");
        }
        else{
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
