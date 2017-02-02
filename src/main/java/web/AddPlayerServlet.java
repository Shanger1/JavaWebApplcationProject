package web;

import model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addPlayerServlet")
public class AddPlayerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String age = request.getParameter("age");
        String experience = request.getParameter("experience");
        HttpSession session = request.getSession();



        Player player = new Player();
        player.setName(request.getParameter("name"));
        player.setAge(Integer.parseInt(age));
        player.setCountry(request.getParameter("country"));
        player.setTeam(request.getParameter("team"));
        player.setExperience(Integer.parseInt(experience));
        player.setPlayerStatistics(1);
        player.setTeamId(1);
        session.setAttribute(SessionKey.player, player);
        response.sendRedirect("addStatistics.html");

    }
}
