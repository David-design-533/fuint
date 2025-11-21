package com.fuint.utils;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ArithmeticCalculator工具类单元测试
 */
public class ArithmeticCalculatorTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testSimpleAddition() {
        assertEquals(5.0, ArithmeticCalculator.calculate("2 + 3"), DELTA);
        assertEquals(10.0, ArithmeticCalculator.calculate("4+6"), DELTA);
    }

    @Test
    public void testSimpleSubtraction() {
        assertEquals(1.0, ArithmeticCalculator.calculate("3 - 2"), DELTA);
        assertEquals(-2.0, ArithmeticCalculator.calculate("3-5"), DELTA);
    }

    @Test
    public void testSimpleMultiplication() {
        assertEquals(6.0, ArithmeticCalculator.calculate("2 * 3"), DELTA);
        assertEquals(20.0, ArithmeticCalculator.calculate("4*5"), DELTA);
    }

    @Test
    public void testSimpleDivision() {
        assertEquals(2.0, ArithmeticCalculator.calculate("6 / 3"), DELTA);
        assertEquals(2.5, ArithmeticCalculator.calculate("5/2"), DELTA);
    }

    @Test
    public void testOperatorPrecedence() {
        assertEquals(7.0, ArithmeticCalculator.calculate("1 + 2 * 3"), DELTA);
        assertEquals(14.0, ArithmeticCalculator.calculate("2 * 3 + 8"), DELTA);
        assertEquals(10.0, ArithmeticCalculator.calculate("20 / 2 - 0"), DELTA);
    }

    @Test
    public void testParentheses() {
        assertEquals(9.0, ArithmeticCalculator.calculate("(1 + 2) * 3"), DELTA);
        assertEquals(1.0, ArithmeticCalculator.calculate("(5 - 3) / 2"), DELTA);
        assertEquals(10.0, ArithmeticCalculator.calculate("((2 + 3) * 2)"), DELTA);
    }

    @Test
    public void testComplexExpression() {
        assertEquals(21.0, ArithmeticCalculator.calculate("1 + 2 * 3 + 4 * 5 - 6"), DELTA);
        assertEquals(11.0, ArithmeticCalculator.calculate("(1 + 2) * (3 + 4) - 10"), DELTA);
    }

    @Test
    public void testDecimalNumbers() {
        assertEquals(3.5, ArithmeticCalculator.calculate("1.5 + 2.0"), DELTA);
        assertEquals(7.5, ArithmeticCalculator.calculate("2.5 * 3"), DELTA);
        assertEquals(1.5, ArithmeticCalculator.calculate("4.5 / 3"), DELTA);
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(-5.0, ArithmeticCalculator.calculate("-2 - 3"), DELTA);
        assertEquals(-6.0, ArithmeticCalculator.calculate("-2 * 3"), DELTA);
        assertEquals(1.0, ArithmeticCalculator.calculate("-3 + 4"), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionByZero() {
        ArithmeticCalculator.calculate("5 / 0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyExpression() {
        ArithmeticCalculator.calculate("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullExpression() {
        ArithmeticCalculator.calculate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidExpression() {
        ArithmeticCalculator.calculate("2 + + 3");
    }

    // 测试单独的操作方法
    @Test
    public void testAddMethod() {
        assertEquals(5.0, ArithmeticCalculator.add(2, 3), DELTA);
        assertEquals(0.0, ArithmeticCalculator.add(-2, 2), DELTA);
    }

    @Test
    public void testSubtractMethod() {
        assertEquals(1.0, ArithmeticCalculator.subtract(3, 2), DELTA);
        assertEquals(-4.0, ArithmeticCalculator.subtract(1, 5), DELTA);
    }

    @Test
    public void testMultiplyMethod() {
        assertEquals(6.0, ArithmeticCalculator.multiply(2, 3), DELTA);
        assertEquals(-10.0, ArithmeticCalculator.multiply(2, -5), DELTA);
    }

    @Test
    public void testDivideMethod() {
        assertEquals(2.0, ArithmeticCalculator.divide(6, 3), DELTA);
        assertEquals(2.5, ArithmeticCalculator.divide(5, 2), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideMethodByZero() {
        ArithmeticCalculator.divide(5, 0);
    }

    @Test
    public void testWhitespaceHandling() {
        assertEquals(5.0, ArithmeticCalculator.calculate("  2  +  3  "), DELTA);
        assertEquals(6.0, ArithmeticCalculator.calculate("2*3"), DELTA);
    }

    @Test
    public void testLargeNumbers() {
        assertEquals(1000.0, ArithmeticCalculator.calculate("100 * 10"), DELTA);
        assertEquals(10000.0, ArithmeticCalculator.calculate("(50 + 50) * 100"), DELTA);
    }
}
