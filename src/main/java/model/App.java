package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import model.Player;
import model.Statistics;
import model.Team;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import dao.uow.UnitOfWork;

public class App 
{

	public static final String CONNECTION_STRING="jdbc:hsqldb:hsql://localhost/workdb";

    public static void main( String[] args )
    {
/*    	String url = "jdbc:hsqldb:hsql://localhost/workdb";
    	try {
			Connection connection = DriverManager.getConnection(url);
			IRepositoryCatalog catalog = new RepositoryCatalog(new UnitOfWork(connection), connection);

			
			Statistics stats = new Statistics();
			stats.setKills(21);
			stats.setDeaths(10);
			stats.getKdRatio();

			catalog.statistics().add(stats);
			
			catalog.save();
			
	        System.out.println( "Zapisuje statsy" );

			
			Statistics stats1 = new Statistics();
			stats1.setKills(50);
			stats1.setDeaths(10);
			stats1.getKdRatio();

			catalog.statistics().add(stats1);
			
			catalog.save();
			
	        System.out.println( "Zapisuje statsy1" );
			

			Team frag = new Team();
			frag.setName("FragNation");
			frag.setCountry("Poland");

			catalog.team().add(frag);
			
			catalog.save();
			
	        System.out.println( "Zapisuje team" );
	        
	        
			Player shanger = new Player();
			shanger.setName("Shanger");
			shanger.setAge(20);
			shanger.setCountry("Poland");
			shanger.setTeam("FragNation");
			shanger.setExperience(5);
            shanger.setPlayerStatistics(catalog.statistics().get(0).getId());
            shanger.setTeamId(catalog.team().get(0).getId());
			catalog.player().add(shanger);
			
			catalog.save();
			
			System.out.println( "Zapisuje Shangera" );
			
			
			Player lockjaw = new Player();
			lockjaw.setName("Lockjaw");
			lockjaw.setAge(24);
			lockjaw.setCountry("Poland");
			lockjaw.setTeam("FragNation");
			lockjaw.setExperience(3);
            lockjaw.setPlayerStatistics(catalog.statistics().get(1).getId());
            lockjaw.setTeamId(catalog.team().get(0).getId());

			catalog.player().add(lockjaw);
			
	        System.out.println( "Zapisuje Lockjawa" );


			 catalog.saveAndClose();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
        System.out.println( "Koniec" );
      */
    }
}
