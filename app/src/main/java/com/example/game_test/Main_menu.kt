package com.example.game_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog

class Main_menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val but = findViewById<Button>(R.id.button)
        val but7 = findViewById<Button>(R.id.button7)
        val but8 = findViewById<Button>(R.id.button8)


        but.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        but7.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("AIFlag", 1)
            startActivity(intent)
        }
        but8.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle("GAME RULES")
            alertDialog.setMessage("The aim for both players is to make a straight line of four own pieces; the line can be vertical, horizontal or diagonal. ")

            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE") { dialog, which ->
                alertDialog.dismiss()
            }
            alertDialog.show()
            val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
            val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
            layoutParams.weight = 10f
            btnPositive.layoutParams = layoutParams
        }
    }
}