package com.example.game_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button

class Main_menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val but= findViewById<Button>(R.id.button)
        val but7= findViewById<Button>(R.id.button7)


        but.setOnClickListener{
            val intent= Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        but7.setOnClickListener{
            val intent= Intent(this, MainActivity2::class.java)
            intent.putExtra("AIFlag",1)
            startActivity(intent)
        }

    }
}