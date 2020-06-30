package com.company.core.approximation;

import com.company.core.Function;

public class QuadraticApproximation extends Function {
    private double a;
    private double b;
    private double c;


    public QuadraticApproximation(double[] x, double[] y){
        setCoefficient(setMatrix(x,y));
    }
    @Override
    public double get(double x) {
        return a*x*x+b*x+c;
    }
    private double[][] setMatrix(double[] x, double[] y){
        double[][] matrix = new double[3][4];
        int n = x.length;
        matrix[0][0] = sum4(x,x,x,x);
        matrix[0][1] = sum3(x,x,x);
        matrix[0][2] = sum2(x,x);
        matrix[0][3] = sum3(x,x,y);

        matrix[1][0] = sum3(x,x,x);
        matrix[1][1] = sum2(x,x);
        matrix[1][2] = sum1(x);
        matrix[1][3] = sum2(x,y);

        matrix[2][0] = sum2(x,x);
        matrix[2][1] = sum1(x);
        matrix[2][2] = n;
        matrix[2][3] = sum1(y);

        return matrix;
    }

    private void setCoefficient(double[][] matrix){
        for (int i = 3; i>-1; i--){
            matrix[1][i] = matrix[1][i]/matrix[1][0]*matrix[0][0] - matrix[0][i];
            matrix[2][i] = matrix[2][i]/matrix[2][0]*matrix[0][0] - matrix[0][i];
        }
        for (int i = 3; i>0; i--){
            matrix[2][i] = matrix[2][i]/matrix[2][1]*matrix[1][1] - matrix[1][i];
        }

        setC(matrix[2][3]/matrix[2][2]);
        setB((matrix[1][3] - matrix[1][2]*getC())/matrix[1][1]);
        setA((matrix[0][3] - matrix[0][2]*getC() - matrix[0][1]*getB())/matrix[0][0]);
    }

    public void setA(double a) {
        this.a = a;
    }
    public double getA() {
        return a;
    }

    public void setB(double b) {
        this.b = b;
    }
    public double getB() {
        return b;
    }

    public void setC(double c) {
        this.c = c;
    }
    public double getC() {
        return c;
    }

    @Override
    public String coef() {
        return "a=" + a + "\n"+
                "b=" + b + "\n"+
                "c=" + c;
    }
}
