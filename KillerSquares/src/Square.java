import java.awt.Color;
import java.awt.Graphics;

public class Square {
    protected int xTopLeft;
    protected int yTopLeft;
    protected int size;
    private int speed;
    private double direction;
    private Color color;
    private int xMax;
    private int yMax;

    public Square(int sz, double dir, Color clr, int spd, int panelWidth, int panelHeight) {
        size = sz;
        direction = dir;
        color = clr;
        speed = spd;
        xMax = panelWidth;
        yMax = panelHeight;
        xTopLeft = (int)(Math.random() * xMax);
        yTopLeft = (int)(Math.random() * yMax);

    }

    public void draw(Graphics pen) {
        Color original = pen.getColor();
        pen.setColor( color);
        pen.fillRect(xTopLeft, yTopLeft, size, size);
        pen.setColor( original );

        //The first and last lines keep the color of the
        //Graphics object invariant ( i.e. whatever 
        //color it was when it was passed to this method the
        //methods makes sure that when it is through with it
        //the original color is restored.

    }

    public void move() {
        xTopLeft = xTopLeft + (int)(Math.cos(direction) * speed);
        yTopLeft = yTopLeft + (int)(Math.sin(direction) * speed);

        if( xTopLeft < -size ) { xTopLeft = xMax; }

        if( yTopLeft < -size ) { yTopLeft = yMax; }

        if (xTopLeft > xMax ) { xTopLeft = -size; }

        if( yTopLeft > yMax ) { yTopLeft = -size; }

    }
}

