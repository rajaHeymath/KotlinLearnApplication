package com.heymath.kotlinlearn

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    //   Github password token(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)
//    https://www.androhub.com/working-with-git-in-android-studio/
//    https://www.javatpoint.com/kotlin-for-loop
    val age = 24
    var name = "Yazhini";
    val border = "%"
    val timeToRepeat = 22
    val layer = 5
    val value2: Char = 'A'
    var flag = true
    val id = arrayOf(1, 2, 3, 4, 5, 6)
    var firstid = 0
    var lastid = 0
    var gson = Gson()

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                Log.i("Permission: ", "Granted")
            } else {
                Log.i("Permission: ", "Denied")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.clickMe)
        printBirth()
        printCakeCandle(age)
        printCakeTop(age)
        printCakeBotton(age, layer)
        learArray()
        flag = false
        println(flag)

        // Type Conversion
        var value1: Long = 1000
        var value2: Int = value1.toInt()
        println(value2)

        //Operators
        Operators()

        button.setOnClickListener {
            onClickRequestPermission(button)
        }

    }

    private fun Operators() {
        arithmeticOperator()
        relationOperator()


    }

    private fun relationOperator() {
        val a = 10
        val b = 5
        val max = if (!(a.equals(b) ?:(false))) {
            println("a is greaterthen b.")
            a
        }  else {
            println("b is greaterthen a.")
            b
        }

        println("max=$max")

        val less = if (a.compareTo(b)<0) {
            println("a is lessthen b")
            a
        } else {
            println("b is lessthen a")
            b
        }
        println("less=$less")


    }

    private fun arithmeticOperator() {
        var a = 10
        var b = 5
        /*    println(a + b)
            println(a - b)
            println(a * b)
            println(a / b)
            println(a % b)*/
        println(a.plus(b))
        println(a.minus(b))
        println(a.times(b))
        println(a.div(b))
        println(a.rem(b))

    }

    fun learArray(): Unit {
        firstid = id[0]
        lastid = id[id.size - 1]
        println(firstid)
        println(lastid)
        val asc = Array(5, { i -> i * 2 })
        println(gson.toJson(asc))
    }

    fun printCakeTop(age: Int) {
        repeat(age + 2) {
            print("=")
        }
        println()
    }

    fun printCakeBotton(age: Int, layers: Int) {
        repeat(layers) {
            repeat(age + 2) {
                print("@")
            }
            println()
        }

    }

    fun printBirth() {
        printBorder(border, timeToRepeat)
        println("Happy Birthday ${name}")
        printBorder(border, timeToRepeat)
        println("You are alreay ${age} days old, ${name}")

    }

    fun printCakeCandle(age: Int) {
        print(" ")
        repeat(age) {
            print(",")
        }
        println()

        print(" ")
        repeat(age) {
            print("|")
        }
        println()

    }

    fun printBorder(border2: String, time: Int) {
        repeat(time) {
            print(border2)
        }
        println()

    }

    private fun onClickRequestPermission(button: Button?) {
        when {
            ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED -> {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.permission_granted),
                    Toast.LENGTH_SHORT
                ).show()

            }
            ActivityCompat.shouldShowRequestPermissionRationale(
                this@MainActivity,
                Manifest.permission.CAMERA
            ) -> {

                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.permission_required),
                    Toast.LENGTH_SHORT
                ).show()
                requestPermission.launch(Manifest.permission.CAMERA)
            }
            else -> {
                requestPermission.launch(Manifest.permission.CAMERA)
            }

        }
    }

}