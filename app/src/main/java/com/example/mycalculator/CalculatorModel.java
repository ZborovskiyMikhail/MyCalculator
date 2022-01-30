package com.example.mycalculator;

import org.mariuszgromada.math.mxparser.Expression;

public class CalculatorModel {
    private StringBuilder expressionBuffer = new StringBuilder();
    private StringBuilder resultBuffer = new StringBuilder();


    public void buttonPressed(int buttonId) {
        String buffer = expressionBuffer.toString();
        resultBuffer.setLength(0);
        switch (buttonId) {
            case R.id.button_0:
                expressionBuffer.append("0");
                break;
            case R.id.button_1:
                expressionBuffer.append("1");
                break;
            case R.id.button_2:
                expressionBuffer.append("2");
                break;
            case R.id.button_3:
                expressionBuffer.append("3");
                break;
            case R.id.button_4:
                expressionBuffer.append("4");
                break;
            case R.id.button_5:
                expressionBuffer.append("5");
                break;
            case R.id.button_6:
                expressionBuffer.append("6");
                break;
            case R.id.button_7:
                expressionBuffer.append("7");
                break;
            case R.id.button_8:
                expressionBuffer.append("8");
                break;
            case R.id.button_9:
                expressionBuffer.append("9");
                break;
            case R.id.button_lBracket:
                expressionBuffer.append("(");
                break;
            case R.id.button_rBracket:
                expressionBuffer.append(")");
                break;
            case R.id.button_dot:
                expressionBuffer.append(".");
                break;
            case R.id.button_plus:
                expressionBuffer.append("+");
                break;
            case R.id.button_minus:
                expressionBuffer.append("-");
                break;
            case R.id.button_div:
                expressionBuffer.append("/");
                break;
            case R.id.button_multiply:
                expressionBuffer.append("*");
                break;
            case R.id.button_clear:
                expressionBuffer.setLength(0);
                resultBuffer.setLength(0);
                break;
            case R.id.button_del:
                if(expressionBuffer.length()>0) {
                    expressionBuffer.deleteCharAt(expressionBuffer.length()-1);
                }
                break;
            case R.id.button_equal:
                buffer = buffer.replaceAll("÷","/");
                buffer = buffer.replaceAll("×","*");
                Expression exp = new Expression(buffer);
                String res = String.valueOf(exp.calculate());
                resultBuffer.append(res);
                break;
            case R.id.button_sqr:
                buffer = buffer.replaceAll("÷","/");
                buffer = buffer.replaceAll("×","*");
                Expression exp1 = new Expression("("+buffer+")^2");
                String res1 = String.valueOf(exp1.calculate());
                resultBuffer.append(res1);
                break;
            case R.id.button_cube:
                buffer = buffer.replaceAll("÷","/");
                buffer = buffer.replaceAll("×","*");
                Expression exp2 = new Expression("("+buffer+")^3");
                String res2 = String.valueOf(exp2.calculate());
                resultBuffer.append(res2);
                break;
        }
    }

    public String getExpression(){
        return expressionBuffer.toString();
    }
    public String getResult(){
        return resultBuffer.toString();
    }
}
