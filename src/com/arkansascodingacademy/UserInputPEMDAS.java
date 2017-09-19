package com.arkansascodingacademy;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInputPEMDAS
{
    private ArrayList<String> equation = new ArrayList<>();

    public void createArrayFromEquation()
    {
        System.out.println("Please enter your calculation:");
        Scanner scanner = new Scanner(System.in);

        String input[] = scanner.nextLine().split(" ");

        for (String string : input)
        {
            equation.add(string);
        }
    }

    public ArrayList<String> getEquation()
    {
        return equation;
    }
}