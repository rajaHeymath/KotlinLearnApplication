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

class MainActivity : AppCompatActivity() {
    //   Github password token(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)
//    https://www.androhub.com/working-with-git-in-android-studio/
//    https://www.javatpoint.com/kotlin-for-loop
    val age = 24
    var name = "Yazhini";
    val border = "%"
    val timeToRepeat = 22
    val layer = 5

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

        button.setOnClickListener {
            onClickRequestPermission(button)
        }

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