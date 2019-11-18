package main;

public class Main {
    //  eps
    public final static double EPS = 1e-9;

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        MyArr myArr = tabToArrays(0, 5, 0.2);
        double[] x = myArr.getX();
        double[] y = myArr.getY();
        int numMax = numMax(y);
        System.out.println("yMax = " + y[numMax]);
        System.out.println("for x = " + x[numMax]);
    }

    private int numMax(double[] y) {
        int res = 0;
        for (int i = 1; i < y.length; i++) {
            if (y[i]>y[res]) {
                res = i;
            }
        }
        return res;
    }

    private double f(double x) {
        return Math.sin(x);
    }

    void tabWithWhile(double start, double finish, double step) {
        double x = start;
        while (x < finish+EPS) {
            double y = f(x);
            System.out.printf("x=%3.1f y=%6.3f\n", x, y);
            x+=step;
        }
    }

    void tabWithDoWhile(double start, double finish, double step) {
        double x = start;
        do {
            double y = f(x);
            System.out.printf("x=%3.1f y=%6.3f\n", x, y);
            x+=step;
        } while (x < finish+EPS);
    }

    void tabWithFor(double start, double finish, double step) {
        int nSteps = (int) Math.round((finish-start)/step + 1);
        for (int i=0; i<nSteps; i++) {
            double x = start + step*i;
            double y = f(x);
            System.out.printf("x=%3.1f y=%6.3f\n", x, y);
        }
    }

    MyArr tabToArrays(double start, double finish, double step) {
        int nSteps = (int) Math.round((finish-start)/step + 1);
        double[] x = new double[nSteps];
        double[] y = new double[nSteps];
        for (int i=0; i<nSteps; i++) {
            x[i] = start + step*i;
            y[i] = f(x[i]);
        }
        return new MyArr(x,y);
    }
}
