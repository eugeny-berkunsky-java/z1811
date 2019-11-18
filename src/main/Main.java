package main;

import java.util.Arrays;

public class Main {
    //  eps
    public final static double EPS = 1e-9;

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        String s = "123";
        String s1 = "123";
        String s2 = new String("123");
        System.out.println(s1==s2);
        System.out.println(s1.intern() == s2.intern());
        String s3 = String.join(",", "a", "b", "c");
        System.out.println(s3);

    }

    private void run2() {
        int[] a = {1,5,2,3};
        int[] b;
        b = new int[]{1,5,2,3};

        int[][] twoDim = new int[4][];
        twoDim[0] = new int[]{5, 6};
        twoDim[1] = new int[]{0, 5, 4, 3};
        twoDim[2] = new int[0];
        twoDim[3] = new int[]{7,1,2};

        for (int[] row : twoDim) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }


    }

    private void run1() {
        MyArr myArr = tabToArrays(0, 5, 0.2);
        double[] x = myArr.getX();
        double[] y = myArr.getY();
        int numMax = numMax(y);
        System.out.println("yMax = " + y[numMax]);
        System.out.println("for x = " + x[numMax]);
    }

    public int numMax(double[] y) {
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

    public int numMin(double[] a) {
        int res = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i]<a[res]) {
                res = i;
            }
        }
        return res;
    }

    public double sum(double[] a) {
        double s = Arrays.stream(a).sum();
        return s;
    }
}
