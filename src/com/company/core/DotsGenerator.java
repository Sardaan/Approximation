package com.company.core;

import com.company.core.approximation.ApproximationType;

public class DotsGenerator {
    private double a;
    private double b;
    private double c;
    ApproximationType type;

    public DotsGenerator(ApproximationType type){
        this.type = type;
        switch (type){
            case LINEAR:
                a = Math.random()-0.5;
                b = Math.random()*5;
                break;
            case QUADRATIC:
                a = Math.random()*0.1-0.05;
                b = Math.random()*3;
                c = Math.random()*5;
                break;
            default:
                a = Math.random()*0.3;
                b = Math.random()*0.3;
                break;
        }
    }

    public Dot generateDot() {
        double y;
        double x;
        double precision = Math.random()*2-1;
        switch (type){
            case LINEAR:
                x = Math.random()*60-10;
                y = a*x+b;
                break;
            case QUADRATIC:
                x = Math.random()*20;
                y = a*x*x+b*x+c;
                break;
            default:
                x = Math.random()*50 - 20;
                y = a*Math.pow(Math.E, b*x);
                break;
        }
        return new Dot(x,y+(y*precision));
    }
    @Override
    public String toString(){
        return "a: "+a+" b: "+b+" c: "+c;
    }
}
