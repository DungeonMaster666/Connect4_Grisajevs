package com.example.game_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
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

            if (editText.text.isEmpty()){
                errorMsgDialog(null,"Field must be filled!",withEditText_AI(null,AIFlag))
            }

            else{

                val alertDialog = AlertDialog.Builder(this).create()
                alertDialog.setTitle("First move")
                alertDialog.setMessage("Choose who'll start the game")
                var first_move="none"
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "AI"
                ) { _, _ ->
                    first_move="AI"
                    val name1 = editText.text.toString()
                    val intent3 = Intent(this, MainActivity::class.java)

                    intent3.putExtra("name1",name1)
                    intent3.putExtra("nameFlag",1)
                    intent3.putExtra("AIFlag",1)
                    intent3.putExtra("first_move",first_move)

                    finish()
                    startActivity(intent3)
                }

                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Player"
                ) { _, _ ->
                    first_move="Player"
                    val name1 = editText.text.toString()
                    val intent3 = Intent(this, MainActivity::class.java)

                    intent3.putExtra("name1",name1)
                    intent3.putExtra("nameFlag",1)
                    intent3.putExtra("AIFlag",1)
                    intent3.putExtra("first_move",first_move)

                    finish()
                    startActivity(intent3)}
                alertDialog.show()

                val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
                val btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)

                val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
                layoutParams.weight = 10f
                btnPositive.layoutParams = layoutParams
                btnNegative.layoutParams = layoutParams


            }


        }
        builder.show()
    }

    fun AI_choice(view: View) {


    }


    fun errorMsgDialog(view: View?, message:String, withEditText1:Unit){

        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle("Error")
        alertDialog.setMessage(message)

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,"CLOSE") { dialog, which ->
            alertDialog.dismiss()
        }

        alertDialog.show()

        val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)

        val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 10f
        btnPositive.layoutParams = layoutParams

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

            if (editText.text.isEmpty()){
                errorMsgDialog(null,"Field must be filled!",withEditText1(null))
            }
            else{
                val name1 = editText.text.toString()

                val builder2 = AlertDialog.Builder(this)
                val inflater2 = layoutInflater
                builder2.setTitle("Enter your second player name!")
                builder2.setCancelable(false)
                val dialogLayout2 = inflater2.inflate(R.layout.player_name, null)
                val editText2 = dialogLayout2.findViewById<EditText>(R.id.editText)
                builder2.setView(dialogLayout2)
                builder2.setPositiveButton("OK") { _, _ ->
                    if (editText2.text.isEmpty()){
                        errorMsgDialog(null,"Field must be filled!",withEditText1(null))
                    }
                    else{
                        val name2 = editText2.text.toString()

                        val intent3 = Intent(this, MainActivity::class.java)
                        intent3.putExtra("name1",name1)
                        intent3.putExtra("name2",name2)
                        intent3.putExtra("nameFlag",1)
                        finish()
                        startActivity(intent3)
                    }


                }
                builder2.show()
            }


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