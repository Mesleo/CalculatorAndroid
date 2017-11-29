package com.mapasgoogle.javi.calculator;

/**
 * Created by javi on 22/11/17.
 */
public class Operation {

    private double numberOne;
    private double numberTwo;
    private String operation1;

    public Operation(double numberOne, double numberTwo, String operation) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.operation1 = operation;
    }

    public Operation() {
    }

    public String getOperation1() {
        return operation1;
    }

    public void setOperation1(String operation1) {
        this.operation1 = operation1;
    }

    public double getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(double numberOne) {
        this.numberOne = numberOne;
    }

    public double getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(double numberTwo) {
        this.numberTwo = numberTwo;
    }

    double operationProduct(double n1, double n2){
        return n1*n2;
    }

    double operationSum(double n1, double n2){
        return n1+n2;
    }

    double operationDeduct(double n1, double n2){
        return n1-n2;
    }

    double operationDivision(double n1, double n2){
        return n1/n2;
    }

    double operationPorcentage(double n1, double n2){
        return (n1/100*n2);
    }

}
