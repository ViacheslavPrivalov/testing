package com.example.testing.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {
    private final CalculatorService out = new CalculatorServiceImpl();

    @Test
    public void shouldReturnWelcome() {
        String result = out.welcome();
        assertEquals("Добро пожаловать в калькулятор", result);
        assertTrue(result.contains("Добро пожаловать в калькулятор"));
    }

    @Test
    public void plusMethodTest() {
        int a = 5;
        int b = 5;
        int expected = 10;
        int actual = out.plus(a, b);
        assertEquals(expected, actual);
        assertNotNull(expected);
    }

    @Test
    public void minusMethodTest() {
        int a = 5;
        int b = 5;
        int expected = 0;
        int actual = out.minus(a, b);
        assertEquals(expected, actual);
        assertNotNull(expected);
    }

    @Test
    public void multiplyMethodTest() {
        int a = 5;
        int b = 5;
        int expected = 25;
        int actual = out.multiply(a, b);
        assertEquals(expected, actual);
        assertNotNull(expected);
    }

    @Test
    public void divideMethodTest() {
        int a = 5;
        int b = 5;
        int expected = 1;
        int actual = out.divide(a, b);
        assertEquals(expected, actual);
        assertNotNull(expected);
        assertThrows(IllegalAccessError.class, () -> out.divide(a, 0));
    }

}
