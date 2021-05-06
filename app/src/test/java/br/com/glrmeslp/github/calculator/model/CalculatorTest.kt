package br.com.glrmeslp.github.calculator.model

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal

internal class CalculatorTest {

    lateinit var calculator: Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun sumTwoNumbers() {
        calculator.sum(BigDecimal(2))
        calculator.sum(BigDecimal(2))
        assertEquals(BigDecimal(4),calculator.result)
    }

//    @Test
//    fun subtractTwoNumbers() {
//        Calculator(BigDecimal(4),BigDecimal(2)).subtract().run {
//            assertEquals(BigDecimal(2),this)
//        }
//    }
//
//    @Test
//    fun multiplyTwoNumbers() {
//        Calculator(BigDecimal(2),BigDecimal(2)).multiply().run {
//            assertEquals(BigDecimal(4),this)
//        }
//    }
//
//    @Test
//    fun divTwoNumbers() {
//        Calculator(BigDecimal(4),BigDecimal(2)).div().run {
//            assertEquals(BigDecimal(2),this)
//        }
//    }
//
//    @Test
//    fun percent() {
//        Calculator(BigDecimal(50),BigDecimal(50)).percent().run {
//            assertEquals(BigDecimal(25),this)
//        }
//    }
}
