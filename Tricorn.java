import java.awt.geom.Rectangle2D;

public class Tricorn extends FractalGenerator{

    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2;
        range.width = 4;
        range.height = 4;
    }

    @Override
    public int numIterations(double x0, double y0) {
        int i = 0;          //z^2 = (x + y(i))^2 =
        double x = 0, y = 0; // = x^2 + 2xyi - y^2
        while (x * x + y * y <= 4 && i < MAX_ITERATIONS){
            y *= -1;
            double xtemp = x * x - y * y + x0;
            y = 2 * x * y + y0;
            x = xtemp;
            i++;
        }
        return i == MAX_ITERATIONS ? -1 : i;
    }

    @Override
    public String toString() {
        return "Tricorn";
    }
}
