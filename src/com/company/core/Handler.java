package com.company.core;

import com.company.core.approximation.ApproximationType;
import com.company.core.approximation.ExponentialApproximation;
import com.company.core.approximation.LinearApproximation;
import com.company.core.approximation.QuadraticApproximation;

import java.util.ArrayList;

public class Handler {
    private static Handler handler;
    private ArrayList<Dot> dots;

    private Handler(ArrayList<Dot> dots){
        this.dots = dots;
    }

    public static Handler getHandler(){
        if(handler==null)
            handler = new Handler(new ArrayList<>());
        return handler;
    }


    public void addDot(Dot dot){
        dots.add(dot);
    }
    public void clearDotsList(){
        dots.clear();
    }
    public Dot deleteExtra(Function function){
        double maxDiff = -1;
        int maxIndex = 0;
        for(int i = 0; i<dots.size(); i++){
            double diff = Math.abs(dots.get(i).getY()-function.get(dots.get(i).getX()));
            if (diff>maxDiff){
                maxDiff = diff;
                maxIndex = i;
            }
        }
        Dot dot = dots.get(maxIndex);
        dots.remove(maxIndex);
        return dot;
    }


    public Function getFunction(ApproximationType type){
        double[] x = new double[dots.size()];
        double[] y = new double[dots.size()];
        for(int i = 0; i<dots.size(); i++){
            x[i] = dots.get(i).getX();
            y[i] = dots.get(i).getY();
        }
        switch (type){
            case LINEAR:
                return new LinearApproximation(x, y);
            case QUADRATIC:
                return new QuadraticApproximation(x, y);
            default:
                return new ExponentialApproximation(x, y);

        }

    }
}
