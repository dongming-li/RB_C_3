package tests;

import client.ClientNetwork;
import client.ui.GameUI;
import client.ui.MainWindow;
import client.ui.TitleScreen;
import game.client.UnstartedGame;
import player.PlayerProfile;
import request.AccountTypeSetRequest;
import request.TestGameRequest;
import response.LoginResponse;
import response.TestGameResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class P1Test.
 */
public class P1Test {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		ClientNetwork.connect();
		new MainWindow();
		LoginResponse r = ClientNetwork.loginToServer("P1", "pass".toCharArray());

		PlayerProfile p = r.getP();
		

		TitleScreen.UserProfile = p;
		TitleScreen.UserID = p.getUserID();
		
		TestGameResponse gts = ClientNetwork.getTestGame(new TestGameRequest("p1"));
		UnstartedGame g = new UnstartedGame();
		g.setPlayers(gts.getPlayers());
		g.setGameID(gts.getGameId());
		
		GameUI.main(args,p, g.getPlayers(), g, p.getDecks().get(0));
	}

}
