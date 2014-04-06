import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MovingSquares extends JFrame {  
	//MovingSquares is a "specialized" type of JFrame. The JFrame class is
	// a Window that offers a title string and menu bar on which you can add
	// a number of menus (i.e. the classical GUI window we are used to seeing).
    private JPanel jPanel;
    private JButton jButton;
    private JButton jButton2;
    private RedSquare[] redSquares;
    private BlueSquare[] blueSquares;

    //Here's the entry point to the whole application
    public static void main(String[] args) {
    	//get an instance of our specialized JFrame
        JFrame frame = new MovingSquares();
        //make the frame visible to the user (bit-blast it on the screen)
        //but just as important this starts the event loop for the frame
        frame.setVisible(true);
    }

    public MovingSquares() {
        /* GUI Initialization */
        super("MovingSquares");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        //We cannot put things directly on the JFrame, but rather we have to get its Content Pane
        java.awt.Container contents = getContentPane();
        //There are several semi-automated layout environments, but for now we are not going to use them
        contents.setLayout(null);

        /* Initializing Variables */
        jPanel = new JPanel(){ //setting up an anonymous inner class here that extends JPanel
        	//override the default paintComponent method with our own specialized one
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                //this anonymous class is embedded in a larger one, so we have to move out from this
                //class to the MovingSquares class to access paintSquares
                MovingSquares.this.paintSquares(g);
            }
        };
        jButton = new JButton();
        jButton2 = new JButton();

        /* Adding variables */
        contents.add(jPanel);
        contents.add(jButton);
        contents.add(jButton2);

        /* Setting jPanel */
        jPanel.setSize(508,468);
        jPanel.setLocation(50,20);
        jPanel.setBackground(Color.YELLOW);


        /* Setting jButton */
        jButton.setSize(200,40);
        jButton.setLocation(210,520);
        jButton.setText("Move Squares");
        jButton.addActionListener(new java.awt.event.ActionListener() { //another anonymous inner class that
        	                                                            //extends class/interface ActionListener
        	//overrides the default actionPerformed method
            public void actionPerformed(ActionEvent e) {
                MovingSquares.this.moveSquares(e);
            }
        }
        );  //strange syntax be careful here


        /* Setting jButton2 */
        jButton2.setSize(100,40);
        jButton2.setLocation(260,580);
        jButton2.setText("reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MovingSquares.this.reset(e);
            }
        });

        initialize();

    }
    //The Graphics object is kinda like a paint brush 
    public void paintSquares(Graphics g) {
        for( int idx = 0; idx < 3; idx++ ) {
           if( redSquares[ idx ] != null ) {
              redSquares[ idx ].draw(g);
           }
           if( blueSquares[ idx ] != null ) {
              blueSquares[ idx ].draw(g);
           }
        }

    }

    public void resetSquares() {
        int width = jPanel.getWidth();
        int height = jPanel.getHeight();

        for( int idx = 0; idx < 3; idx++ )
        {
            redSquares[ idx ] = new RedSquare( 40, Math.PI/4, width, height );
            blueSquares[ idx ] = new BlueSquare( 40, 3*Math.PI/4, width, height );
        }

    }

    public void moveSquares(ActionEvent arg0) {
        for( int idx = 0; idx < 3; idx++ ) {
           if( redSquares[ idx ] != null ) {
              redSquares[ idx ].move();
           }
           if( blueSquares[ idx ] != null ) {
              blueSquares[ idx ].move();
           }
        }
        jPanel.repaint();

    }

    public void reset(ActionEvent arg0) {
        resetSquares();
        jPanel.repaint();

    }

    public void initialize() {
        redSquares = new RedSquare[ 3 ];
        blueSquares = new BlueSquare[ 3 ];
        resetSquares();

    }
}






