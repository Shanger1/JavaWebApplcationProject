package web;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import dao.uow.UnitOfWork;
import model.Player;
import model.Statistics;
import model.Team;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/dbServlet")
public class DbServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();


        try {
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
            IRepositoryCatalog catalog = new RepositoryCatalog(new UnitOfWork(connection), connection);
            Team team = (Team) session.getAttribute("team");
            Player player = (Player) session.getAttribute("player");
            Statistics statistics = (Statistics) session.getAttribute("statistics");
            catalog.team().add(team);
            catalog.save();
            catalog.player().add(player);
            catalog.save();
            catalog.statistics().add(statistics);
            catalog.saveAndClose();
            session.removeAttribute("team");
            session.removeAttribute("player");
            session.removeAttribute("statistics");
            response.sendRedirect("addTeam.html");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}