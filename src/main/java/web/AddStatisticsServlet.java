package web;

import model.Statistics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addStatisticsServlet")
public class AddStatisticsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String kills = request.getParameter("kills");
        String deaths = request.getParameter("deaths");
        HttpSession session = request.getSession();



        Statistics statistics = new Statistics();
        statistics.setKills(Integer.parseInt(kills));
        statistics.setDeaths(Integer.parseInt(deaths));
        statistics.getKdRatio();
        session.setAttribute(SessionKey.statistics, statistics);
        response.sendRedirect("final.jsp");

    }
}