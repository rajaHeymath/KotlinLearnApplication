package com.heymath.kotlinlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
//   Github password token(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)
//    https://www.androhub.com/working-with-git-in-android-studio/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button =findViewById<Button>(R.id.clickMe)
        button.setOnClickListener {
            Toast.makeText(this@MainActivity,"Its First function",Toast.LENGTH_SHORT).show()
        }
    }
}