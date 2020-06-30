package com.company.core.approximation;

import com.company.core.Function;

public class LinearApproximation extends Function {
    private double a;
    private double b;

    public LinearApproximation(double[] x, double[] y){

        a = (x.length*sum2(x, y)-sum1(x)*sum1(y))/
            (x.length*sum2(x, x)-sum1(x)*sum1(x));
        b = (sum1(y)*sum2(x, x)-sum1(x)*sum2(x,y))/
            (x.length*sum2(x, x)-sum1(x)*sum1(x));
    }
    @Override
    public double get(double x) {
        return a*x+b;
    }
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    @Override
    public String coef() {
        return "a=" + a + "\n"+
                "b=" + b;
    }
}

