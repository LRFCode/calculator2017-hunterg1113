package com.arkansascodingacademy;

public class Operator
{
    String operator = null;
    int index = 0;

    public Operator (int index, String operator)
    {
        this.index = index;
        this.operator = operator;
    }

    public String getOperator()
    {
        return operator;
    }

    public int getIndex()
    {
        return index;
    }
}
