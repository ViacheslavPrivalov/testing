package com.example.testing.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceParameterizedTest {
    private final CalculatorService out = new CalculatorServiceImpl();
    private static final char sumSign = '+';
    private static final char minusSign = '-';
    private static final char multiplySign = '*';
    private static final char divideSign = '/';
    private static final int num1 = 5;
    private static final int num2 = 5;
    private static final int sumResult = 10;
    private static final int minusResult = 0;
    private static final int multiplyResult = 25;
    private static final int divideResult = 1;

    @Test
    public void shouldReturnWelcome() {
        String result = out.welcome();
        assertEquals("Добро пожаловать в калькулятор", result);
        assertTrue(result.contains("Добро пожаловать в калькулятор"));
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> out.divide(num1, 0));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldGenerateCorrectAnswers(char sign, int num1, int num2 , int expected) {
        int actual = 0;
        switch (sign) {
            case '+':
                actual = out.plus(num1, num2);
                break;
            case '-':
                actual = out.minus(num1, num2);
                break;
            case '*':
                actual = out.multiply(num1, num2);
                break;
            case '/':
                actual = out.divide(num1, num2);
                break;
        }
        assertEquals(expected, actual);
        assertNotNull(actual);
    }

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(sumSign, num1, num2, sumResult),
                Arguments.of(minusSign, num1, num2, minusResult),
                Arguments.of(multiplySign, num1, num2, multiplyResult),
                Arguments.of(divideSign, num1, num2, divideResult)
        );
    }

}
