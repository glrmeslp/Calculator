package br.com.glrmeslp.github.calculator

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.glrmeslp.github.calculator.model.Calculator
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var buttonThree: Button
    private lateinit var buttonFour: Button
    private lateinit var buttonFive: Button
    private lateinit var buttonSix: Button
    private lateinit var buttonSeven: Button
    private lateinit var buttonEight: Button
    private lateinit var buttonNine: Button
    private lateinit var buttonZero: Button
    private lateinit var buttonDot: Button

    private lateinit var buttonClear: Button
    private lateinit var buttonEqual: Button
    private lateinit var buttonSum: Button
    private lateinit var buttonSubtract: Button
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDiv: Button
    private lateinit var buttonPercent: Button

    private lateinit var operation: TextView
    private lateinit var result: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView

    private var numberX: String = ""
    private var numberY: String = ""

    private var aux: Boolean = false

    private var calculator: Calculator = Calculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.main_top_bar))
        title = ""
        initializationComponentsView()
        configureButtons()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.main_menu_about){
            openAbout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openAbout() {
        startActivity(Intent(this@MainActivity, AboutActivity::class.java))
    }

    private fun addOperationText(string: String) {
        operation.text = operation.text.toString().plus(string)
    }

    private fun operation(s: String): String {
        return when (s) {
            "+" -> calculator.sum(BigDecimal(numberX), BigDecimal(numberY))
            "-" -> calculator.subtract(BigDecimal(numberX), BigDecimal(numberY))
            "*" -> calculator.multiply(BigDecimal(numberX), BigDecimal(numberY))
            "/" -> calculator.div(BigDecimal(numberX), BigDecimal(numberY))
//            5 -> calculator.percent(n)
            else -> ""
        }
    }

    private fun resetOperation(string: String) {
        operation.text = string
    }

    private fun completeClickOperation(symbol: String) {
        aux = false
        if(!isClean()){
            if (containsOperation()) {
                setResult()
            }
            addOperationText(symbol)
        }
    }

    private fun completeClickNumber(symbol: String) {
        if (!aux) {
            addOperationText(symbol)
        } else {
            resetOperation(symbol)
            aux = false
        }
    }

    private fun setResult() {
        operation.text.dropLastWhile { it.isLetterOrDigit() }
            .run { numberX = this.dropLast(1) as String }
        operation.text.dropWhile { it.isLetterOrDigit() }.run { numberY = this.drop(1) as String }
        result4.text = result3.text
        result3.text = result2.text
        result2.text = result.text
        result.text = operation(operationSymbol())
        resetOperation(result.text.toString())
    }

    private fun containsOperation(): Boolean {
        operationSymbol().run {
            return !this.none()
        }
    }

    private fun operationSymbol(): String {
        operation.text.filterNot { it.isLetterOrDigit() }.run { return this.toString() }
    }

    private fun isClean(): Boolean {
        return operation.text.isEmpty()
    }

    private fun initializationComponentsView() {
        buttonOne = findViewById(R.id.bt_1)
        buttonTwo = findViewById(R.id.bt_2)
        buttonThree = findViewById(R.id.bt_3)
        buttonFour = findViewById(R.id.bt_4)
        buttonFive = findViewById(R.id.bt_5)
        buttonSix = findViewById(R.id.bt_6)
        buttonSeven = findViewById(R.id.bt_7)
        buttonEight = findViewById(R.id.bt_8)
        buttonNine = findViewById(R.id.bt_9)
        buttonZero = findViewById(R.id.bt_0)
        buttonDot = findViewById(R.id.bt_dot)

        buttonEqual = findViewById(R.id.bt_equal)
        buttonSum = findViewById(R.id.bt_add)
        buttonSubtract = findViewById(R.id.bt_subtract)
        buttonMultiply = findViewById(R.id.bt_multiply)
        buttonDiv = findViewById(R.id.bt_div)
        buttonPercent = findViewById(R.id.bt_percent)
        buttonClear = findViewById(R.id.bt_c)

        operation = findViewById(R.id.tv_operation)
        result = findViewById(R.id.tv_result)
        result2 = findViewById(R.id.tv_result2)
        result3 = findViewById(R.id.tv_result3)
        result4 = findViewById(R.id.tv_result4)
    }

    private fun configureButtons() {

        buttonSum.setOnClickListener {
            completeClickOperation("+")
        }

        buttonSubtract.setOnClickListener {
            completeClickOperation("-")
        }

        buttonMultiply.setOnClickListener {
            completeClickOperation("*")
        }

        buttonDiv.setOnClickListener {
            completeClickOperation("/")
        }

        buttonPercent.setOnClickListener {
            completeClickOperation("%")
        }

        buttonEqual.setOnClickListener {
            aux = true
            setResult()
        }

        buttonClear.setOnClickListener {
            resetOperation("")
        }

        buttonZero.setOnClickListener {
            completeClickNumber("0")
        }

        buttonOne.setOnClickListener {
            completeClickNumber("1")
        }

        buttonTwo.setOnClickListener {
            completeClickNumber("2")
        }

        buttonThree.setOnClickListener {
            completeClickNumber("3")
        }

        buttonFour.setOnClickListener {
            completeClickNumber("4")
        }

        buttonFive.setOnClickListener {
            completeClickNumber("5")
        }

        buttonSix.setOnClickListener {
            completeClickNumber("6")
        }

        buttonSeven.setOnClickListener {
            completeClickNumber("7")
        }

        buttonEight.setOnClickListener {
            completeClickNumber("8")
        }

        buttonNine.setOnClickListener {
            completeClickNumber("9")
        }

        buttonDot.setOnClickListener {
            completeClickNumber(".")
        }
    }

}


