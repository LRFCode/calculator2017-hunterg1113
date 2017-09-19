package com.arkansascodingacademy;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CalculatorPEMDAS
{
    private UserInputPEMDAS userInput = new UserInputPEMDAS();
    private ArrayList<String> equation = new ArrayList<>();
    private ArrayList<Operator> operators = new ArrayList<>();
    private Operator operator;

    public void run()
    {
        userInput.createArrayFromEquation();

        equation = userInput.getEquation();

        createArrayOfOperators(equation);

        while (operators.size() > 1)
        {
            ArrayList<String> array = scanArrayOfOperators(operators);

            calculate(array);
        }

        ArrayList<String> array = scanArrayOfOperators(operators);

        calculate(array);

        System.out.println("Result: " + equation.get(0));
    }

    public void calculate(ArrayList<String> array)
    {
        BigDecimal firstNumber = new BigDecimal(array.get(0));
        String operator = array.get(1);
        BigDecimal secondNumber = new BigDecimal(array.get(2));
        String indexOfEquation = array.get(3);

        BigDecimal result = null;

        switch (operator)
        {
            case "+":
                System.out.println("Adding " + firstNumber + " to " + secondNumber);
                result = firstNumber.add(secondNumber);
                break;

            case "-":
                System.out.println("Subtracting " + secondNumber + " from " + firstNumber);
                result = firstNumber.subtract(secondNumber);
                break;

            case "*":
                System.out.println("Multiplying " + firstNumber + " by " + secondNumber);
                result = firstNumber.multiply(secondNumber);
                break;

            case "/":
                System.out.println("Dividing " + firstNumber + " by " + secondNumber);
                result = firstNumber.divide(secondNumber);
                break;

            case "^":
                System.out.println(firstNumber + " to the power of " + secondNumber);
                int x = secondNumber.intValue();
                result = firstNumber.pow(x);
                break;

            default:
                System.out.println("You are confusing me");
                result = new BigDecimal("0");
        }

        equation.add(Integer.parseInt(indexOfEquation), result.toString());
    }

    public ArrayList<String> scanArrayOfOperators(ArrayList<Operator> operators)
    {
        for (int i = 0; i < operators.size(); i++)
        {
            switch (operators.get(i).getOperator())
            {
                case "^":
                    return createArray(i);
            }
        }

        for (int i = 0; i < operators.size(); i++)
        {
            switch (operators.get(i).getOperator())
            {
                case "*":
                    return createArray(i);
            }
        }

        for (int i = 0; i < operators.size(); i++)
        {
            switch (operators.get(i).getOperator())
            {
                case "/":
                    return createArray(i);
            }
        }

        for (int i = 0; i < operators.size(); i++)
        {
            switch (operators.get(i).getOperator())
            {
                case "+":
                    return createArray(i);
            }
        }

        for (int i = 0; i < operators.size(); i++)
        {
            switch (operators.get(i).getOperator())
            {
                case "-":
                    return createArray(i);
            }
        }
        return null;
    }

    public void createArrayOfOperators(ArrayList<String> equation)
    {
        for (int i = 0; i < equation.size(); i++)
        {
            if (equation.get(i).equals("+") || equation.get(i).equals("-") || equation.get(i).equals("*") ||
                    equation.get(i).equals("/") || equation.get(i).equals("^"))
            {
                operator = new Operator(i, equation.get(i));
                operators.add(operator);
            }
        }
    }

    public ArrayList<String> createArray(int i)
    {
        ArrayList<String> array = new ArrayList<>();

        int x = operators.get(i).getIndex();

        array.add(equation.remove(x + 1));
        array.add(equation.remove(x));
        array.add(equation.remove(x - 1));
        array.add("" + x);

        operators.remove(i);

        return array;
    }
}