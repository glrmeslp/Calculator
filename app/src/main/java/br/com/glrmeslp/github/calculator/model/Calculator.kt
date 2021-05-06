package br.com.glrmeslp.github.calculator.model

import java.math.BigDecimal

class Calculator() {

    fun sum(numberX: BigDecimal, numberY: BigDecimal) : String{
        return (numberX + numberY).toString()
    }

    fun subtract(numberX: BigDecimal, numberY: BigDecimal) : String {
        return (numberX - numberY).toString()
    }

    fun multiply(numberX: BigDecimal, numberY: BigDecimal) : String {
        return (numberX * numberY).toString()
    }

    fun div(numberX: BigDecimal, numberY: BigDecimal) : String{
        return (numberX / numberY).toString()
    }

//    fun percent(number: BigDecimal) {
//        result = (result * number) / BigDecimal("100")
//    }

//    private fun operationString(x: BigDecimal, y: BigDecimal, symbol:String): String{
//        return "$x $symbol $y ="
//    }
//
//
    private fun addResultHistoric(result: String){
        Historic(result)
    }

}