package com.example.game_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {

    fun withEditText_AI(view: View?, AIFlag:Int) {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        builder.setTitle("Enter your player name!")
        builder.setCancelable(false)
        val dialogLayout = inflater.inflate(R.layout.player_name, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.editText)
        builder.setView(dialogLayout)

        builder.setPositiveButton("OK") { _, _ ->
            val name1 = editText.text.toString()



            val intent3 = Intent(this, MainActivity::class.java)
            intent3.putExtra("name1",name1)
            intent3.putExtra("nameFlag",1)
            intent3.putExtra("AIFlag",1)
            startActivity(intent3)

        }
        builder.show()
    }

    fun withEditText1(view: View?) {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        builder.setTitle("Enter your first player name!")
        builder.setCancelable(false)
        val dialogLayout = inflater.inflate(R.layout.player_name, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.editText)
        builder.setView(dialogLayout)

        builder.setPositiveButton("OK") { _, _ ->
            val name1 = editText.text.toString()

            val builder2 = AlertDialog.Builder(this)
            val inflater2 = layoutInflater
            builder2.setTitle("Enter your second player name!")
            builder2.setCancelable(false)
            val dialogLayout2 = inflater2.inflate(R.layout.player_name, null)
            val editText2 = dialogLayout2.findViewById<EditText>(R.id.editText)
            builder2.setView(dialogLayout2)
            builder2.setPositiveButton("OK") { _, _ ->

                val name2 = editText2.text.toString()

                val intent3 = Intent(this, MainActivity::class.java)
                intent3.putExtra("name1",name1)
                intent3.putExtra("name2",name2)
                intent3.putExtra("nameFlag",1)
                startActivity(intent3)

            }
            builder2.show()


        }
        builder.show()
    }

// i love https://www.journaldev.com/309/android-alert-dialog-using-kotlin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val AIFlag = intent.extras?.getInt("AIFlag")

        if (AIFlag==1) withEditText_AI(null,AIFlag)
        else withEditText1(null)

    }
}