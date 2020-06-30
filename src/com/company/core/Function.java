package com.company.core;

public abstract class Function {

    public double get(double x){
        return x;
    }
    public double sum1(double[] arg) {
        double sum = 0;
        for (double value : arg) {
            sum += value;
        }
        return sum;
    }

    public double sum2(double[] arg1, double[] arg2) {
        double sum = 0;
        for (int i = 0; i < arg1.length; i++) {
            sum += arg1[i] * arg2[i];
        }
        return sum;
    }

    public double sum3(double[] arg1, double[] arg2, double[] arg3) {
        double sum = 0;
        for (int i = 0; i < arg1.length; i++) {
            sum += arg1[i] * arg2[i] * arg3[i];
        }
        return sum;
    }

    public double sum4(double[] arg1, double[] arg2, double[] arg3, double[] arg4) {
        double sum = 0;
        for (int i = 0; i < arg1.length; i++) {
            sum += arg1[i] * arg2[i] * arg3[i] * arg4[i];
        }
        return sum;
    }

    public String coef() {
        return "Function";
    }
}
