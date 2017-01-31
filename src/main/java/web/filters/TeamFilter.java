package web.filters;

import model.Team;
import web.SessionKey;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/addPlayer.html","/AddPlayerServlet","/addStatistics.html","/AddStatisticsServlet","/AddTeamServlet","/dbServlet","/final.jsp"})
public class TeamFilter implements Filter {

    public TeamFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();
        Team team = (Team) session.getAttribute(SessionKey.team);
        if(team==null){
            ((HttpServletResponse) response).sendRedirect("/WhoIsTheBestOfficial/addTeam.html");
        }
        else{
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
