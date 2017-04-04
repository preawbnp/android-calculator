package com.example.student.calculator.main;

import com.example.student.calculator.data.Calculator;

/**
 * Created by jittat on 29/3/2560.
 */

public class CalculatorPresenter {

    private CalculatorView view;
    private Calculator calculator;
    private int firstNumber, secondNumber, operation;
    private boolean isFirstNumber;

    public static final int OPERATOR_ADD = Calculator.OPERATOR_ADD;
    public static final int OPERATOR_SUB = Calculator.OPERATOR_SUB;
    public static final int OPERATOR_MUL = Calculator.OPERATOR_MUL;
    public static final int OPERATOR_DIV = Calculator.OPERATOR_DIV;
    public static final int OPERATOR_EQ = 5;

    public CalculatorPresenter(Calculator calculator, CalculatorView view) {
        this.calculator = calculator;
        this.view = view;
        this.firstNumber = 0;
        this.secondNumber = 0;
        this.operation = 0;
        this.isFirstNumber = true;
    }

    public void reset() {
        calculator.reset();
        view.setCalculatorResult(calculator.getResult());
        isFirstNumber = true;
        secondNumber = 0;
        operation = 0;
    }

    public void onNumberClick(int num) {
        if(isFirstNumber) {
            firstNumber = (calculator.getResult() * 10) + num;

            calculator.setResult(firstNumber);
            view.setCalculatorResult(firstNumber);
        } else {
            secondNumber = (secondNumber * 10) + num;
            view.setCalculatorResult(secondNumber);
        }

    }

    public void onOpClick(int op) {
        isFirstNumber = false;
        calculator.operate(operation, secondNumber);
        view.setCalculatorResult(calculator.getResult());
        operation = op;
        secondNumber = 0;
    }

    public void onResetClick() {
        reset();
    }

    public void onBackClick() {
        firstNumber = calculator.getResult()/10;

        calculator.setResult(firstNumber);
        view.setCalculatorResult(firstNumber);
    }



}
