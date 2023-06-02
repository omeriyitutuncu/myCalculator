package com.example.mycalculator

import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class CalculatorTest {
    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()


    private val buttonOne = hasText("1") and hasClickAction()
    private val buttonTwo = hasText("2") and hasClickAction()
    private val buttonThree = hasText("3") and hasClickAction()
    private val buttonFour = hasText("4") and hasClickAction()
    private val buttonFive = hasText("5") and hasClickAction()
    private val buttonSix = hasText("6") and hasClickAction()
    private val buttonSeven = hasText("7") and hasClickAction()
    private val buttonEight = hasText("8") and hasClickAction()
    private val buttonNine = hasText("9") and hasClickAction()
    private val buttonZero = hasText("0") and hasClickAction()

    private val buttonAc = hasText("AC") and hasClickAction()
    private val buttonDel = hasText("Del") and hasClickAction()
    private val buttonDivide = hasText("/") and hasClickAction()
    private val buttonMultiply = hasText("x") and hasClickAction()
    private val buttonSubs = hasText("-") and hasClickAction()
    private val buttonAdd = hasText("+") and hasClickAction()
    private val buttonEqual = hasText("=") and hasClickAction()
    private val buttonDecimal = hasText(".") and hasClickAction()


    @Test
    fun test_visibleAllButton() {
        // Check something
        rule.onNode(buttonOne).assertExists()
        rule.onNode(buttonTwo).assertExists()
        rule.onNode(buttonThree).assertExists()
        rule.onNode(buttonFour).assertExists()
        rule.onNode(buttonFive).assertExists()
        rule.onNode(buttonSix).assertExists()
        rule.onNode(buttonSeven).assertExists()
        rule.onNode(buttonEight).assertExists()
        rule.onNode(buttonNine).assertExists()
        rule.onNode(buttonZero).assertExists()

        rule.onNode(buttonAc).assertExists()
        rule.onNode(buttonDel).assertExists()

        rule.onNode(buttonDivide).assertExists()
        rule.onNode(buttonMultiply).assertExists()
        rule.onNode(buttonSubs).assertExists()
        rule.onNode(buttonAdd).assertExists()
        rule.onNode(buttonEqual).assertExists()

        rule.onNode(buttonDecimal).assertExists()



    }
    @Test
    fun test_addition() {
        // Do something
        rule.onNode(buttonTwo).performClick()
        rule.onNode(buttonAdd).performClick()
        rule.onNode(buttonNine).performClick()
        rule.onNode(buttonEqual).performClick()

        // Check something
        rule.onNodeWithText("11.0").assertExists()
    }

    @Test
    fun test_subtraction() {
        // Do something
        rule.onNode(buttonNine).performClick()
        rule.onNode(buttonSubs).performClick()
        rule.onNode(buttonTwo).performClick()
        rule.onNode(buttonEqual).performClick()

        // Check something
        rule.onNodeWithText("7.0").assertExists()
    }

    @Test
    fun test_multiplication() {
        // Do something
        rule.onNode(buttonFour).performClick()
        rule.onNode(buttonMultiply).performClick()
        rule.onNode(buttonThree).performClick()
        rule.onNode(buttonEqual).performClick()

        // Check something
        rule.onNodeWithText("12.0").assertExists()
    }

    @Test
    fun test_division() {
        // Do something
        rule.onNode(buttonOne).performClick()
        rule.onNode(buttonFive).performClick()
        rule.onNode(buttonDivide).performClick()
        rule.onNode(buttonTwo).performClick()
        rule.onNode(buttonEqual).performClick()
        rule.onNodeWithText("=").performClick()

        // Check something
        rule.onNodeWithText("7.5").assertExists()
    }

    @Test
    fun test_AC() {
        // Do something
        rule.onNode(buttonSix).performClick()
        rule.onNode(buttonSeven).performClick()
        rule.onNode(buttonEight).performClick()

        // Check something
        rule.onNodeWithText("678").assertExists()

        // Do something
        rule.onNode(buttonAc).performClick()

        // Check something
        rule.onNodeWithText("678").assertDoesNotExist()
    }

    @Test
    fun test_Delete() {
        // Do something
        rule.onNode(buttonSix).performClick()
        rule.onNode(buttonZero).performClick()
        rule.onNode(buttonEight).performClick()

        // Check something
        rule.onNodeWithText("608").assertExists()

        rule.onNode(buttonDel).performClick()
        rule.onNodeWithText("608").assertDoesNotExist()
        rule.onNodeWithText("60").assertExists()
    }

    @Test
    fun test_Decimal() {
        // Do something
        rule.onNode(buttonSix).performClick()
        rule.onNode(buttonDecimal).performClick()
        rule.onNode(buttonEight).performClick()
        rule.onNode(buttonMultiply).performClick()
        rule.onNode(buttonTwo).performClick()
        rule.onNode(buttonEqual).performClick()

        // Check something
        rule.onNodeWithText("13.6").assertExists()


    }


}