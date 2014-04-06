import java.awt.Color;

public class RedSquare extends Square {
    public RedSquare(int sz, double dir, int panelWidth, int panelHeight) {
        super( sz, dir, Color.RED, 4, panelWidth, panelHeight );

    }

    public boolean intersects(BlueSquare[] killers) {
        int numKillers = killers.length;

        for( int idx = 0; idx < numKillers; idx++ ) {
            if( Math.abs( killers[ idx ].getTopLeftX() -  xTopLeft ) < size  &&  Math.abs( killers[ idx ].getTopLeftY() -  yTopLeft ) < size ) { return true; }
        }

        return false;
                

    }
}