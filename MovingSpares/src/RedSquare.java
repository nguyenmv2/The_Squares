import java.awt.Color;


public class RedSquare extends Square {
    public RedSquare(int sz, double dir, int panelWidth, int panelHeight) {
        super( sz, dir, Color.RED, 4, panelWidth, panelHeight ); 

    }
    
    public void move() {
        xTopLeft = xTopLeft + (int)(Math.cos(direction) * speed);
        yTopLeft = yTopLeft + (int)(Math.sin(direction) * speed);

        if( xTopLeft < 0 ) { xTopLeft = xMax; }

        if( yTopLeft < 0 ) { yTopLeft = yMax; }

        if (xTopLeft > xMax - size ) { xTopLeft = 0; }

        if( yTopLeft > yMax- size ) { yTopLeft = 0; }

    }
}