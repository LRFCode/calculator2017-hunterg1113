package com.arkansascodingacademy;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInput
{
    public BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private String operator;

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

        firstNumber = new BigDecimal(input[0]);
        operator = input[1];
        secondNumber = new BigDecimal(input[2]);
    }

    public String newCalculation()
    {
        System.out.println("Another calculation? Y/N");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

}
