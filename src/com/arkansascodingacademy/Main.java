package com.arkansascodingacademy;

//TODONE BRONZE Add support for minus, times, and, divide
//TODONE SILVER Make calculator keep asking for new problems until user types 'exit'
//TODONE SILVER Make calculator solve x to power of y
//TODONE GOLD Make calculator sum series of numbers when user types 2 TO 10 or 10 TO 2
//TODONE GOLD Make calculator solve x factorial
//TODONE GOLD Make calculator be able to use previous calculated value using PREV in place of number
//TODO PLATINUM Make calculator take full equations and solve in correct order EX: (5 + 2) * 8

public class Main
{
    public static void main(String[] args)
    {
        CalculatorPEMDAS calculator = new CalculatorPEMDAS();
        calculator.run();
    }
}
