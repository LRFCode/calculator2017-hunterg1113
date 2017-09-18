package com.arkansascodingacademy;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInput
{
    public BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private String operator;
    private BigDecimal prev;

    public BigDecimal getFirstNumber()
    {
        return firstNumber;
    }

    public BigDecimal getSecondNumber()
    {
        return secondNumber;
    }

    public String getOperator()
    {
        return operator;
    }

    public void scan()
    {
        System.out.println("Please enter your calculation:");
        Scanner scanner = new Scanner(System.in);

        String input[] = scanner.nextLine().split(" ");

        if (input.length == 3)
        {
            if (input[0].trim().toLowerCase().equals("prev"))
            {
                firstNumber = prev;
                operator = input[1];
                secondNumber = new BigDecimal(input[2]);
            }
            else if (input[2].trim().toLowerCase().equals("prev"))
            {
                firstNumber = new BigDecimal(input[0]);
                operator = input[1];
                secondNumber = prev;
            }
            else
            {
                firstNumber = new BigDecimal(input[0]);
                operator = input[1];
                secondNumber = new BigDecimal(input[2]);
            }
        }

        if (input.length == 2)
        {
            firstNumber = new BigDecimal(input[0]);
            operator = input[1];
        }
    }

    public void setPrev(BigDecimal x)
    {
        prev = x;
    }

    public String newCalculation()
    {
        System.out.println("Another calculation? Y/N");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public BigDecimal getPrev()
    {
        return prev;
    }

}
