package particles;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Ball {
    private double px, py; // position coordinates
    private double vx, vy;
    private final double radius;

    public Ball(double px, double py, double radius) {
        this.px = px;
        this.py = py;
        this.radius = radius;
    }

    public Ball(double radius) {
        px = StdRandom.uniform(0.0, 1.0);
        py = StdRandom.uniform(0.0, 1.0);
        vx = 0.5;
        vy = 0.5;
        this.radius = radius;
    }

    public void move(double dt) {
        if ((px + vx*dt < radius) || (px + vx*dt > 1.0 - radius)) { vx = -vx; }
        if ((py + vy*dt < radius) || (py + vy*dt > 1.0 - radius)) { vy = -vy; }
        px = px + vx * dt;
        py = py + vy * dt;
    }

    public void draw() {
        StdDraw.filledCircle(px, py, radius);
    }
}
