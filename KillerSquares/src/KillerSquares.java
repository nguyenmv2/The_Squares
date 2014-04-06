
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JButton;
import java.awt.event.ActionEvent;


public class KillerSquares extends JFrame {
    private JPanel jPanel;
    private JButton jButton;
    private JButton jButton2;
    private RedSquare[] redSquares;
    private BlueSquare[] blueSquares;

    //entry into the application
    public static void main(String[] args) {
        JFrame frame = new KillerSquares();
        frame.setVisible(true);

    }

    public KillerSquares() {
        /* GUI Initialization */
        super("KillerSquares");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        java.awt.Container contents = getContentPane();
        contents.setLayout(null);

        /* Initializing Variables */
        jButton2 = new JButton();
        jPanel = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                KillerSquares.this.paintSquares(g);
            }
        };
        jButton = new JButton();

        /* Adding variables */
        contents.add(jButton2);
        contents.add(jPanel);
        contents.add(jButton);

        /* Setting jButton2 */
        jButton2.setSize(89,23);
        jButton2.setLocation(160,360);
        jButton2.setText("reset");
        jButton2.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                KillerSquares.this.reset(e);
            }
        }//end of inner class
        ); //end of the addActionListener call


        /* Setting jPanel */
        jPanel.setSize(308,268);
        jPanel.setLocation(50,20);
        jPanel.setBackground(new java.awt.Color(255,255,255));


        /* Setting jButton */
        jButton.setSize(168,28);
        jButton.setLocation(120,310);
        jButton.setText("Move Squares");
        jButton.addActionListener( new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                KillerSquares.this.moveSquares(e);
            }
        } );

        //get the game ready
        initialize();

    }

    public void paintSquares(Graphics g) {
        for( int idx = 0; idx < 5; idx++ ) {
           if( redSquares[ idx ] != null ) {
              redSquares[ idx ].draw(g);
           }
        }
        for( int idx = 0; idx < 2; idx++ ) {
           if( blueSquares[ idx ] != null ) {
              blueSquares[ idx ].draw(g);
           }
        }

    }

    public void resetSquares() {
        int width = jPanel.getWidth();
        int height = jPanel.getHeight();

        for( int idx = 0; idx < 5; idx++ )
        {
            redSquares[ idx ] = new RedSquare( 25, Math.PI/4, width, height );
            if( idx < 2 ) {
               blueSquares[ idx ] = new BlueSquare( 25, 3*Math.PI/4, width, height );
           }
        }

    }

    public void moveSquares(ActionEvent ae) {
        checkForIntersection();

        for( int idx = 0; idx < 5; idx++ ) {
           if( redSquares[ idx ] != null ) {
              redSquares[ idx ].move();
           }
        }
        for( int idx = 0; idx < 2; idx++ ) {
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
        redSquares = new RedSquare[ 5 ];
        blueSquares = new BlueSquare[ 2 ];
        resetSquares();

    }

    public void checkForIntersection() {
        for( int idx = 0; idx < 5; idx++ ) {
            if( redSquares[ idx ] != null ) {
                if( redSquares[ idx ].intersects( blueSquares ) ) {
                    redSquares[ idx ] = null;
                }
            }
        }

    }
}

