package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Calculator
{
    public void run()
    {
        UserInput userInput = new UserInput();
        userInput.scan();

        BigDecimal firstNumber = userInput.getFirstNumber();
        BigDecimal secondNumber = userInput.getSecondNumber();
        String operator = userInput.getOperator();

        BigDecimal result = null;

        switch(operator)
        {
            case "+":
            case "plus":
                System.out.println("Adding " + firstNumber + " to " + secondNumber);
                result = firstNumber.add(secondNumber);
                break;
            case "-":
                System.out.println("Subtracting " + secondNumber + " from " + firstNumber);
                //TODO Code the subtract
                break;
            //TODO CODE multiply
            //TODO CODE divide

            default:
                System.out.println("You are confusing me");
                result = new BigDecimal("0");
        }

        System.out.println("The answer is: " + result);

    }
}
