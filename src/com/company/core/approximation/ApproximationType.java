package com.company.core.approximation;

public enum ApproximationType {
    LINEAR("Linear"),
    QUADRATIC("Quadratic"),
    EXPONENTIAL("Exponential");

    private String typeName;
    ApproximationType(String typeName){
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName ;
    }

}
