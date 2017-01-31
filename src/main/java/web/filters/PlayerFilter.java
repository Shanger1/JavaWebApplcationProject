package web.filters;

import model.Player;
import web.SessionKey;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/addStatistics.html","/AddStatisticsServlet","/AddPlayerServlet","/dbServlet","/final.jsp"})
public class PlayerFilter implements Filter {

    public PlayerFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        Player player = (Player) session.getAttribute(SessionKey.player);
        if(player==null){
            ((HttpServletResponse) response).sendRedirect("/WhoIsTheBestOfficial/addPlayer.html");
        }
        else{
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
