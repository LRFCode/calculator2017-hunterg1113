package com.arkansascodingacademy;

import java.math.BigDecimal;

public class Calculator
{
    private BigDecimal prev = null;

    public void run()
    {
        boolean calculating = true;

        UserInput userInput = new UserInput();
        while (calculating)
        {

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

                case "TO":
                    System.out.println("Adding series of numbers between: " + firstNumber + " - " + secondNumber);
                    int y = firstNumber.intValue();
                    int z = secondNumber.intValue();

                    Integer answer = 0;

                    if (y > z)
                    {
                        for (int i = z; i <= y; i++)
                        {
                            answer += i;
                        }
                    }
                    else if (z > y)
                    {
                        for (int i = y; i <= z; i++)
                        {
                            answer += i;
                        }
                    }

                    result = new BigDecimal(answer.toString());
                    break;

                case "!":
                    System.out.println("Calculating factorial of " + firstNumber);
                    Integer factorial = 1;

                    for (int i = 2; i <= (firstNumber.intValue()); i++)
                    {
                        factorial *= i;
                    }

                    result = new BigDecimal(factorial.toString());
                    break;

                default:
                    System.out.println("You are confusing me");
                    result = new BigDecimal("0");
            }

            userInput.setPrev(result);

            System.out.println("The answer is: " + result);
            System.out.println();
            System.out.println("Previous set to: " + userInput.getPrev());

            if (userInput.newCalculation().trim().toLowerCase().equals("n"))
            {
                calculating = false;
            }
        }
    }
}
