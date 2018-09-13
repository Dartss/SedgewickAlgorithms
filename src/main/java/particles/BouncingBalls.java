package particles;

import edu.princeton.cs.algs4.StdDraw;

public class BouncingBalls {
    static final double RADIUS = 0.005;
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        Ball[] balls = new Ball[N];
        for (int i = 0; i < N; i++) balls[i] = new Ball(RADIUS);

        while (true) {
            StdDraw.clear();
            for (int i = 0; i < N; i++) {
                balls[i].move(0.01);
                balls[i].draw();
            }
            StdDraw.show(50);
        }
    }
}
