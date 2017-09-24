package com.arkansascodingacademy;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PCalculator
{
    private ArrayList<String> equation = new ArrayList<>();
    private ArrayList<Operator> operators = new ArrayList<>();
    private Operator operator;


    public String run(ArrayList <String> pArray)
    {
        equation = pArray;
        equation.remove(0);
        equation.remove(equation.size()-1);

        createArrayOfOperators(pArray);

        while (operators.size() > 1)
        {
            ArrayList<String> array = scanArrayOfOperators(operators);

            calculate(array);

            createArrayOfOperators(equation);
        }

        ArrayList<String> array = scanArrayOfOperators(operators);

        calculate(array);

        return equation.get(0);
    }

    public ArrayList<String> createPArray()
    {
        ArrayList<Operator> pArray = new ArrayList<>();

        for (int i = 0; i < operators.size(); i++)
        {
            if (operators.get(i).getOperator().equals("("))
            {
                pArray.add(operators.remove(i));
            }
        }

        ArrayList<String> pToCalculate = new ArrayList<>();

        boolean foundNextP = false;

        int x = pArray.get(pArray.size() - 1).getIndex();

        while (!foundNextP)
        {
            if (equation.get(x).equals(")"))
            {
                foundNextP = true;
            }

            pToCalculate.add(equation.remove(x));
        }

        return pToCalculate;
    }

    public void calculate(ArrayList<String> array)
    {
        BigDecimal secondNumber = new BigDecimal(array.get(0));
        String operator = array.get(1);
        BigDecimal firstNumber = new BigDecimal(array.get(2));
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
                result = firstNumber.divide(secondNumber, 2, BigDecimal.ROUND_HALF_UP);
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

        equation.add((Integer.parseInt(indexOfEquation) - 1), result.toString());
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

                case "-":
                    return createArray(i);
            }
        }
        return null;
    }

    public void createArrayOfOperators(ArrayList<String> equation)
    {
        operators.clear();

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