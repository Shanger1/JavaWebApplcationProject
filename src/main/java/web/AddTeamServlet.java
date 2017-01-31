package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Team;

@WebServlet("/addTeamServlet")
public class AddTeamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        Team team = new Team();
        team.setName(request.getParameter("name"));
        team.setCountry(request.getParameter("country"));
        HttpSession session = request.getSession();
        session.setAttribute(SessionKey.team, team);
        response.sendRedirect("addPlayer.html");

    }
}