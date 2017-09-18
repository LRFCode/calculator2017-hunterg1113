package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Calculator
{
    public void run()
    {
        boolean calculating = true;

        while (calculating)
        {
            UserInput userInput = new UserInput();
            userInput.scan();

            BigDecimal firstNumber = userInput.getFirstNumber();
            BigDecimal secondNumber = userInput.getSecondNumber();
            String operator = userInput.getOperator();

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

            System.out.println("The answer is: " + result);
            System.out.println();

            if (userInput.newCalculation().trim().toLowerCase().equals("n"))
            {
                calculating = false;
            }
        }
    }
}
