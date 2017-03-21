import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;


public class NewGame extends JFrame
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
	JLabel displayScore =  new JLabel();

		// set up score frame 
	 
      
      

	public NewGame() {
		
		Racer r = new Racer();
		r.start();
        arena = new GameArena(SCREEN_WIDTH, SCREEN_HEIGHT, false);

		
		JFrame window = new JFrame();
		window.setTitle("Racer");
        window.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		window.setContentPane(r.getPanel());
		window.setVisible(true);
		
		FlowLayout l = new FlowLayout();
		setLayout(l);
		
		scorePanel.add(displayScore);
		scorePanel.add(r.getPanel());
		displayScore.setVisible(true);
		scorePanel.setVisible(true);
		    
        
		
        

        while(r.isPlaying()) {
            r.update();
			displayScore.setText("user scpre" + r.getScore());
		
			
		}
	}
	
	
	

	
	// set up buttons
	JPanel buttons = new JPanel();
	JButton stop = new JButton("stop");
	JButton play = new JButton("play");
	
	
	
	
    {
    }
			
		
			}
    

	

		