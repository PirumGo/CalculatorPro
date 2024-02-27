package com.example.calculatorpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      все необходимые переменные
        val result: TextView = findViewById(R.id.result)
        val operation: TextView = findViewById(R.id.operation)

        val sqrt: TextView = findViewById(R.id.b_sqrt)
        val log2: TextView = findViewById(R.id.b_log2)
        val ln: TextView = findViewById(R.id.b_ln)
        val leftb:TextView = findViewById(R.id.b_leftb)
        val rightb:TextView = findViewById(R.id.b_rightb)

        val x_y:TextView = findViewById(R.id.b_x_y)
        val clear:TextView = findViewById(R.id.b_clear)
        val back:TextView = findViewById(R.id.b_back)
        val percent:TextView = findViewById(R.id.b_percent)
        val div: TextView = findViewById(R.id.b_div)

        val sin: TextView = findViewById(R.id.b_sin)
        val seven: TextView = findViewById(R.id.b_7)
        val eight: TextView = findViewById(R.id.b_8)
        val nine: TextView = findViewById(R.id.b_9)
        val mul: TextView = findViewById(R.id.b_mul)

        val cos: TextView = findViewById(R.id.b_cos)
        val four: TextView = findViewById(R.id.b_4)
        val five: TextView = findViewById(R.id.b_5)
        val six: TextView = findViewById(R.id.b_6)
        val sub: TextView = findViewById(R.id.b_sub)

        val pi: TextView = findViewById(R.id.b_pi)
        val one: TextView = findViewById(R.id.b_1)
        val two: TextView = findViewById(R.id.b_2)
        val three: TextView = findViewById(R.id.b_3)
        val add: TextView = findViewById(R.id.b_add)

        val e: TextView = findViewById(R.id.b_e)
        val threeZero: TextView = findViewById(R.id.b_000)
        val dot: TextView = findViewById(R.id.b_dot)
        val zero: TextView = findViewById(R.id.b_0)
        val equal: TextView = findViewById(R.id.b_equal)

        one.setOnClickListener { operation.append("1") }
        two.setOnClickListener { operation.append("2") }
        three.setOnClickListener { operation.append("3") }
        four.setOnClickListener { operation.append("4") }
        five.setOnClickListener { operation.append("5") }
        six.setOnClickListener { operation.append("6") }
        seven.setOnClickListener { operation.append("7") }
        eight.setOnClickListener { operation.append("8") }
        nine.setOnClickListener { operation.append("9") }
        threeZero.setOnClickListener { operation.append("000") }
        dot.setOnClickListener { operation.append(".") }
        zero.setOnClickListener { operation.append("0") }

        cos.setOnClickListener { operation.append("cos(") }
        sin.setOnClickListener { operation.append("sin(") }
        pi.setOnClickListener { operation.append("pi") }
        e.setOnClickListener { operation.append("e") }
        sqrt.setOnClickListener { operation.append("sqrt(") }
        log2.setOnClickListener { operation.append("log2(") }
        ln.setOnClickListener { operation.append("ln(") }

        leftb.setOnClickListener { operation.append("(") }
        rightb.setOnClickListener { operation.append(")") }
        percent.setOnClickListener { operation.append("%") }
        x_y.setOnClickListener { operation.append("^") }
        div.setOnClickListener { operation.append("/") }
        mul.setOnClickListener { operation.append("*") }
        sub.setOnClickListener { operation.append("-") }
        add.setOnClickListener { operation.append("+") }
        equal.setOnClickListener { operation.append("=") }

        //Кнопка "back"
        back.setOnClickListener {
            val s = operation.text.toString()
            if (s != "") {
                operation.text = s.substring(0,s.length-1)
            }
        }

        //Кнопка очищения текущего выражения и ответа
        clear.setOnClickListener {
            operation.text = ""
            result.text = ""
        }

        //Поле ответа
        result.setOnClickListener {
            val restext = result.text.toString()
            if (restext != "Error" && restext != ""){
                operation.text = restext
                result.text = ""
            }
        }

        equal.setOnClickListener{
            val optext = operation.text.toString() //Выражение в формате строки
            if (optext != "") {
                try {
                    val expr = ExpressionBuilder(operation.text.toString()).build() //строим выражение
                    val res = expr.evaluate() //Находим ответ (число, может быть нецелое)
                    val longres = res.toLong() //longres - число в формате long (целочисленное)
                    if (longres.toDouble() == res) { //Если число целое,
                        result.text = longres.toString() //То: Отбрасываем ноль после запятой
                    } else {
                        result.text = res.toString() //Иначе: Сохраняем числа после запятой
                    }
                } catch (e: Exception) { //Если выражение записано некорректно
                    result.text = "Error" //В поле ответа пишем 'Error'
                }
            }
        }
    }
}