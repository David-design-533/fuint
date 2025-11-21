package com.fuint.utils;

import java.util.Stack;

/**
 * 简单算术计算器工具类
 * 支持基本的四则运算: +, -, *, /
 * 
 * @author fuint
 */
public class ArithmeticCalculator {

    /**
     * 计算算术表达式
     * 
     * @param expression 算术表达式，例如: "1 + 2 * 3"
     * @return 计算结果
     * @throws IllegalArgumentException 如果表达式无效
     */
    public static double calculate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("表达式不能为空");
        }

        expression = expression.replaceAll("\\s+", "");
        
        try {
            return evaluateExpression(expression);
        } catch (Exception e) {
            throw new IllegalArgumentException("无效的表达式: " + expression, e);
        }
    }

    /**
     * 使用双栈算法计算表达式
     * 一个栈存储数字，一个栈存储操作符
     */
    private static double evaluateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && 
                       (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                i--;
                numbers.push(Double.parseDouble(sb.toString()));
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                }
                if (!operators.isEmpty()) {
                    operators.pop();
                }
            } else if (isOperator(c)) {
                // 处理负号
                if (c == '-' && (i == 0 || expression.charAt(i - 1) == '(' || isOperator(expression.charAt(i - 1)))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append('-');
                    i++;
                    while (i < expression.length() && 
                           (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        sb.append(expression.charAt(i));
                        i++;
                    }
                    i--;
                    numbers.push(Double.parseDouble(sb.toString()));
                } else {
                    while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                        numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                    }
                    operators.push(c);
                }
            }
        }

        while (!operators.isEmpty()) {
            numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    /**
     * 判断是否为操作符
     */
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * 判断操作符优先级
     */
    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    /**
     * 执行基本运算
     */
    private static double applyOperation(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("除数不能为零");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("未知的操作符: " + operator);
        }
    }

    /**
     * 加法运算
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * 减法运算
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * 乘法运算
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * 除法运算
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return a / b;
    }
}
