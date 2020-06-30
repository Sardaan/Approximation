package com.company.core.approximation;

import com.company.core.Function;

public class ExponentialApproximation extends Function {

    double a;
    double b;

    public ExponentialApproximation(double[] x, double[] y){
        for(int i = 0; i<y.length; i++){
            y[i] = Math.log(y[i]);
        }
        b = (x.length*sum2(x, y)-sum1(x)*sum1(y))/
                (x.length*sum2(x, x)-sum1(x)*sum1(x));
        a = (sum1(y)*sum2(x, x)-sum1(x)*sum2(x,y))/
                (x.length*sum2(x, x)-sum1(x)*sum1(x));

    }
    @Override
    public double get(double x) {
        return Math.pow(Math.E, a)*Math.pow(Math.E,b*x);
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
