import java.awt.Color;

public class BlueSquare extends Square {
    public BlueSquare(int sz, double dir, int panelWidth, int panelHeight) {
        super( sz, dir, Color.BLUE, 6, panelWidth, panelHeight );

    }

    public int getTopLeftX() {
        return xTopLeft;

    }

    public int getTopLeftY() {
        return yTopLeft;

    }
}
