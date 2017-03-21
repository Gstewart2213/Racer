import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.JFrame;


public class NewGame2 extends JFrame 
{	
    public static final double PLAYER_SPEED = 5;
    public static final int ROAD_SEGMENT_WIDTH = 160;
    public static final int ROAD_SEGMENT_HEIGHT= 10;
    public static final int ROAD_CURVE_SPEED = 5;
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
	private GameArena arena;
    private Car player;
	JFrame window = new JFrame();
    private RoadSegment[] road = new RoadSegment[SCREEN_HEIGHT / ROAD_SEGMENT_HEIGHT + 1];
	private double currentRoadX = SCREEN_WIDTH/2;
    private double speed = 2.0;
    private boolean playing = false;
    private int score = 0;
	JPanel scorePanel = new JPanel();
	
	JLabel displayScore =  new JLabel("score                              ");
	
	
	JButton start = new JButton("start");
	JButton stop = new JButton("stop");

	
	JFrame scoreTable = new JFrame("High scores");
	public static final int TABLE_WIDTH= 300;
	public static final int TABLE_HEIGHT=200;
	 
	String[] column = {"Name", "Score"};
	
	
  
      String[][] data = {{"name", "score"},
{"name 2", "score 2"},
	{"name", "score 3"}};
	JTable highScore = new JTable(data, column);
   JTextField name = new JTextField();
  

	public NewGame2() {
		
		Racer r = new Racer();
		r.start(); // starts the game
        arena = new GameArena(SCREEN_WIDTH, SCREEN_HEIGHT, false);

		
		scoreTable.setSize(TABLE_WIDTH, TABLE_HEIGHT);
		window.setTitle("Racer"); // sets window title
        window.setSize(SCREEN_WIDTH, SCREEN_HEIGHT); //sets height of window
		
		window.setContentPane(r.getPanel()); //gets the panel from gamearena to display game
		
		window.getContentPane().add(scorePanel); //adds panel to window pane
		highScore.add(name);
		scoreTable.add(highScore);
		JToolBar bar = new JToolBar(); //makes a new toolbar
		   //add Jbutton
		scorePanel.add(displayScore);   // adds label to panel
		scorePanel.add(bar); 			// adds buttons to panel
		add(bar, BorderLayout.SOUTH);   // states where the toolbar should be in regards to the page
		displayScore.setVisible(true); 	// says for the label to be visible
		scorePanel.setVisible(true);	// says for the panel to be visible
		window.setVisible(true);		// says for the window to be visible
		bar.setVisible(true);			// says for the toolbar to be visible
       
        name.setVisible(true);
bar.add(start);   //adds Jbuttons
		bar.add(stop); 
	   window.add(displayScore);		// adds label to the frame
		window.add(scorePanel);
		window.add(bar);
		scoreTable.setVisible(true);
		
		            
					
					
					
					
		if(!r.isPlaying()){
			highScore.setVisible(true);
		}			
					
					
					
        while(r.isPlaying()) {  
            r.update();   
			score++;
			
			displayScore.setText("                        score" + r.getScore()    );  // displays the text whilst the game is playing
		
		
		}
	}
}