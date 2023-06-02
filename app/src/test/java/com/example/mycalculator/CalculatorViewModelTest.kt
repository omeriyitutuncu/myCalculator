package com.example.mycalculator

import org.junit.Assert
import org.junit.Test

internal class CalculatorViewModelTest {
    private val calculatorViewModel = CalculatorViewModel()

    @Test
    fun test_addition() {

        calculatorViewModel.onAction(CalculatorAction.Number(2))
        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Calculate)

        Assert.assertEquals(calculatorViewModel.state.number1, "56.0")

    }

    @Test
    fun test_subtraction() {

        calculatorViewModel.onAction(CalculatorAction.Number(4))
        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Calculate)

        Assert.assertEquals(calculatorViewModel.state.number1, "10.0")
    }

    @Test
    fun test_multiplication() {

        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
        calculatorViewModel.onAction(CalculatorAction.Number(4))
        calculatorViewModel.onAction(CalculatorAction.Calculate)

        Assert.assertEquals(calculatorViewModel.state.number1, "12.0")
    }


    @Test
    fun test_division() {

        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
        calculatorViewModel.onAction(CalculatorAction.Number(4))
        calculatorViewModel.onAction(CalculatorAction.Calculate)

        Assert.assertEquals(calculatorViewModel.state.number1, "0.75")
    }

    @Test
    fun test_clear() {

        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Number(4))
        calculatorViewModel.onAction(CalculatorAction.Clear)

        Assert.assertEquals(calculatorViewModel.state.number1, "")
    }


    @Test
    fun test_decimal_FirstDigit() {

        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Decimal)
        calculatorViewModel.onAction(CalculatorAction.Number(4))

        Assert.assertEquals(calculatorViewModel.state.number1, "3.4")
    }

    @Test
    fun test_decimal_SecondDigit() {

        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Number(4))
        calculatorViewModel.onAction(CalculatorAction.Decimal)
        calculatorViewModel.onAction(CalculatorAction.Number(4))

        Assert.assertEquals(calculatorViewModel.state.number1, "34.4")
    }
    @Test
    fun test_decimal_FirstDigit_TwoDecimal() {

        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Number(4))
        calculatorViewModel.onAction(CalculatorAction.Decimal)
        calculatorViewModel.onAction(CalculatorAction.Decimal)
        calculatorViewModel.onAction(CalculatorAction.Number(4))

        Assert.assertEquals(calculatorViewModel.state.number1, "34.4")
    }

    @Test
    fun test_decimal_SecondDigit_TwoDecimal() {

        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
        calculatorViewModel.onAction(CalculatorAction.Number(4))
        calculatorViewModel.onAction(CalculatorAction.Decimal)
        calculatorViewModel.onAction(CalculatorAction.Decimal)
        calculatorViewModel.onAction(CalculatorAction.Number(4))

        Assert.assertEquals(calculatorViewModel.state.number2, "4.4")
    }

    @Test
    fun test_delete_FirstDigit() {

        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Number(4))
        calculatorViewModel.onAction(CalculatorAction.Number(5))
        calculatorViewModel.onAction(CalculatorAction.Delete)

        Assert.assertEquals(calculatorViewModel.state.number1, "34")
    }

    @Test
    fun test_delete_SecondDigit() {

        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Number(4))
        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))

        calculatorViewModel.onAction(CalculatorAction.Number(5))
        calculatorViewModel.onAction(CalculatorAction.Number(6))
        calculatorViewModel.onAction(CalculatorAction.Delete)

        Assert.assertEquals(calculatorViewModel.state.number2, "5")
    }

    @Test
    fun test_delete_Operation() {

        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Number(4))
        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
        calculatorViewModel.onAction(CalculatorAction.Delete)

        Assert.assertNull(calculatorViewModel.state.operation)
    }

    @Test
    fun test_operationNull() {

        calculatorViewModel.onAction(CalculatorAction.Number(3))
        calculatorViewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
        calculatorViewModel.onAction(CalculatorAction.Number(4))

        Assert.assertEquals(calculatorViewModel.state.number1,"3" )
        Assert.assertEquals(calculatorViewModel.state.number2,"4" )
    }

}