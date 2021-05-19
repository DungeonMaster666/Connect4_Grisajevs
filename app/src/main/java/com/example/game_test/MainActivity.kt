package com.example.game_test

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlin.Float.Companion.NEGATIVE_INFINITY
import kotlin.Float.Companion.POSITIVE_INFINITY
import kotlin.math.round
import kotlin.system.exitProcess



class MainActivity : AppCompatActivity() {

//// MARKS GRISAJEVS 2.GRUPA 191RDB191

    fun withButtonCentered(view: View?, title:String, message:String,name1:String,name2:String, AIFlag:Int?, first_move:String) {

        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE,"NEW GAME") { dialog, which ->
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("newGameFlag",1)
            intent.putExtra("name1",name1)
            intent.putExtra("name2",name2)
            if (AIFlag==1) intent.putExtra("AIFlag",1)
            if (first_move=="AI") intent.putExtra("first_move","AI")
            if (first_move=="Player") intent.putExtra("first_move","Player")

            finish()
            startActivity(intent)
             }
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE,"CLOSE GAME") { dialog, which ->
            finishAffinity() }

        alertDialog.show()

        val btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)

        val layoutParams = btnPositive.layoutParams as LinearLayout.LayoutParams
        layoutParams.weight = 10f
        btnPositive.layoutParams = layoutParams
        btnNegative.layoutParams = layoutParams


    }




    override fun onCreate(savedInstanceState: Bundle?) {
        p1win=false
        p2win=false
        draw=false



        val nameFlag = intent.extras?.getInt("nameFlag")


        val newGameFlag= intent.extras?.getInt("newGameFlag")
        if(nameFlag!=1 && newGameFlag!=1){

            val intent= Intent(this, Main_menu::class.java)
            finish()
            startActivity(intent)
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val width = Resources.getSystem().displayMetrics.widthPixels
        val height= Resources.getSystem().displayMetrics.heightPixels
        val bitmap: Bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas: Canvas = Canvas(bitmap)



        val imageV=findViewById<ImageView>(R.id.imageV)

        imageV.background = BitmapDrawable(resources, bitmap)


        var left = 0
        var top = 0
        var right = width
        var bottom = height



        val line0: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( 0, top, 5, bottom)
        }
        line0.paint.color = Color.parseColor("#F6891F")
        line0.draw(canvas)


        val line1: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( width/7, top, round(width /6.9).toInt(), bottom)
        }
        line1.paint.color = Color.parseColor("#F6891F")
        line1.draw(canvas)


        val line2: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds(round(width/3.5).toInt(), top, round(width /3.445).toInt(), bottom)
        }
        line2.paint.color = Color.parseColor("#F6891F")
        line2.draw(canvas)


        val line3: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( round(width/2.33).toInt(), top, round(width /2.31).toInt(), bottom)
        }
        line3.paint.color = Color.parseColor("#F6891F")
        line3.draw(canvas)

        val line4: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( round(width/1.75).toInt(), top, round(width /1.735).toInt(), bottom)
        }
        line4.paint.color = Color.parseColor("#F6891F")
        line4.draw(canvas)


        val line5: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( round(width/1.4).toInt(), top, round(width /1.39).toInt(), bottom)
        }
        line5.paint.color = Color.parseColor("#F6891F")
        line5.draw(canvas)

        val line6: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( round(width/1.16).toInt(), top, round(width /1.155).toInt(), bottom)
        }
        line6.paint.color = Color.parseColor("#F6891F")
        line6.draw(canvas)


        val line7: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( width-5, top, width, bottom)
        }
        line7.paint.color = Color.parseColor("#F6891F")
        line7.draw(canvas)


        val yline0: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( left, 0, width , 10)
        }
        yline0.paint.color = Color.parseColor("#F6891F")
        yline0.draw(canvas)

        val yline1: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( left, height/6, width , round(height/5.9).toInt())
        }
        yline1.paint.color = Color.parseColor("#F6891F")
        yline1.draw(canvas)

        val yline2: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( left, height/3, width , round(height/2.98).toInt())
        }
        yline2.paint.color = Color.parseColor("#F6891F")
        yline2.draw(canvas)

        val yline3: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( left, height/2, width , round(height/1.99).toInt())
        }
        yline3.paint.color = Color.parseColor("#F6891F")
        yline3.draw(canvas)

        val yline4: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( left, round(height/1.5).toInt(), width , round(height/1.495).toInt())
        }
        yline4.paint.color = Color.parseColor("#F6891F")
        yline4.draw(canvas)

        val yline5: ShapeDrawable = ShapeDrawable(RectShape()).also {
            it.setBounds( left, round(height/1.2).toInt(), width , round(height/1.197).toInt())
        }
        yline5.paint.color = Color.parseColor("#F6891F")
        yline5.draw(canvas)








        val rows = 6
        val colls = 7
        var array = Array(rows) {
            IntArray(colls)
        }
        var Turn = 1
        var p=0

        val p1 = 1
        val p2 = 2

        val but0= findViewById<Button>(R.id.button0)

        val but1= findViewById<Button>(R.id.button1)
        val but2= findViewById<Button>(R.id.button2)
        val but3= findViewById<Button>(R.id.button3)
        val but4= findViewById<Button>(R.id.button4)
        val but5= findViewById<Button>(R.id.button5)
        val but6= findViewById<Button>(R.id.button6)


        val oval1=ShapeDrawable(OvalShape())
        val oval2=ShapeDrawable(OvalShape())
        val oval3=ShapeDrawable(OvalShape())
        val oval4=ShapeDrawable(OvalShape())
        val oval5=ShapeDrawable(OvalShape())
        val oval6=ShapeDrawable(OvalShape())
        val oval7=ShapeDrawable(OvalShape())
        val oval8=ShapeDrawable(OvalShape())
        val oval9=ShapeDrawable(OvalShape())
        val oval10=ShapeDrawable(OvalShape())
        val oval11=ShapeDrawable(OvalShape())
        val oval12=ShapeDrawable(OvalShape())
        val oval13=ShapeDrawable(OvalShape())
        val oval14=ShapeDrawable(OvalShape())
        val oval15=ShapeDrawable(OvalShape())
        val oval16=ShapeDrawable(OvalShape())
        val oval17=ShapeDrawable(OvalShape())
        val oval18=ShapeDrawable(OvalShape())
        val oval19=ShapeDrawable(OvalShape())
        val oval20=ShapeDrawable(OvalShape())
        val oval21=ShapeDrawable(OvalShape())
        val oval22=ShapeDrawable(OvalShape())
        val oval23=ShapeDrawable(OvalShape())
        val oval24=ShapeDrawable(OvalShape())
        val oval25=ShapeDrawable(OvalShape())
        val oval26=ShapeDrawable(OvalShape())
        val oval27=ShapeDrawable(OvalShape())
        val oval28=ShapeDrawable(OvalShape())
        val oval29=ShapeDrawable(OvalShape())
        val oval30=ShapeDrawable(OvalShape())
        val oval31=ShapeDrawable(OvalShape())
        val oval32=ShapeDrawable(OvalShape())
        val oval33=ShapeDrawable(OvalShape())
        val oval34=ShapeDrawable(OvalShape())
        val oval35=ShapeDrawable(OvalShape())
        val oval36=ShapeDrawable(OvalShape())
        val oval37=ShapeDrawable(OvalShape())
        val oval38=ShapeDrawable(OvalShape())
        val oval39=ShapeDrawable(OvalShape())
        val oval40=ShapeDrawable(OvalShape())
        val oval41=ShapeDrawable(OvalShape())
        val oval42=ShapeDrawable(OvalShape())

        val olist=mutableListOf<ShapeDrawable>()

        olist.add(oval1)
        olist.add(oval2)
        olist.add(oval3)
        olist.add(oval4)
        olist.add(oval5)
        olist.add(oval6)
        olist.add(oval7)
        olist.add(oval8)
        olist.add(oval9)
        olist.add(oval10)
        olist.add(oval11)
        olist.add(oval12)
        olist.add(oval13)
        olist.add(oval14)
        olist.add(oval15)
        olist.add(oval16)
        olist.add(oval17)
        olist.add(oval18)
        olist.add(oval19)
        olist.add(oval20)
        olist.add(oval21)
        olist.add(oval22)
        olist.add(oval23)
        olist.add(oval24)
        olist.add(oval25)
        olist.add(oval26)
        olist.add(oval27)
        olist.add(oval28)
        olist.add(oval29)
        olist.add(oval30)
        olist.add(oval31)
        olist.add(oval32)
        olist.add(oval33)
        olist.add(oval34)
        olist.add(oval35)
        olist.add(oval36)
        olist.add(oval37)
        olist.add(oval38)
        olist.add(oval39)
        olist.add(oval40)
        olist.add(oval41)
        olist.add(oval42)

        val AIFlag = intent.extras?.getInt("AIFlag")

        val arrayOfBut=mutableListOf<Button>()

        if(AIFlag==1){
            arrayOfBut.add(but0)
            arrayOfBut.add(but1)
            arrayOfBut.add(but2)
            arrayOfBut.add(but3)
            arrayOfBut.add(but4)
            arrayOfBut.add(but5)
            arrayOfBut.add(but6)
        }


        var counter:Int=0


            val name1 = intent.getStringExtra("name1").toString()
            val name2 = intent.getStringExtra("name2").toString()




        if ((nameFlag==1 || newGameFlag==1) && AIFlag==0)  Toast.makeText(this@MainActivity, "Good luck, $name1, good luck, $name2, may the Force be with you", Toast.LENGTH_LONG).show()
        if ((nameFlag==1 || newGameFlag==1) && AIFlag==1)  Toast.makeText(this@MainActivity, "Good luck, $name1, may the Force be with you", Toast.LENGTH_LONG).show()

        val first_move = intent.getStringExtra("first_move").toString()



        // Array cloning

        fun Array<IntArray>.copy() = Array(size) { get(it).clone() }
        // Checks if column in first row is filled and returns if not

        fun empty_col(t_array: Array<IntArray>,coll:Int):Boolean{
            val first_row=0
            return t_array[first_row][coll] == 0
        }
        // Return unfilled column array ( where first row isn't filled)

        fun getAllEmptyCol(t_array: Array<IntArray>):MutableList<Int>{
            val emptyColl= mutableListOf<Int>()
            for (coll in 0..6){
                if (empty_col(t_array, coll)) emptyColl.add(coll)
            }
            return emptyColl
        }
        // Returns first empty row in a certain column (Finds where piece can be placed in that column)

        fun getNextEmptyRow(t_array: Array<IntArray>,coll:Int):Int{
            for(r in 5 downTo 0){
                if (t_array[r][coll]==0) return r
            }
            return 0
        }
        // Simple turn maker. Places 1 or 2 in the array

        fun makeTurn(t_array: Array<IntArray>,row:Int,coll:Int,player:Int):Array<IntArray>{
            var temp_array=t_array.copy()
            temp_array[row][coll]=player
            return temp_array
        }
        // Check for terminal node existence (win or draw).

        fun isTerminal(t_array: Array<IntArray>,temp_counter:Int,first_move:String):Array<Boolean> {
            checkWin(t_array, temp_counter)
            var Player_win=false
            var AI_win=false
            if (first_move=="Player"){
                Player_win=p1win
                AI_win=p2win
            }
            else if (first_move=="AI"){
                Player_win=p2win
                AI_win=p1win
            }
            var tDraw=draw
            p1win=false
            p2win=false
            draw=false
            val t_array= arrayOf(Player_win,AI_win,tDraw)
            return t_array
        }

        //Return array of all row in a certain column

        fun makeColArray(t_array:Array<IntArray>,column:Int):MutableList<Int>{
            var col_array=mutableListOf<Int>()
            for (r in 5 downTo 0){
                col_array.add(t_array[r][column])
            }
            return col_array
        }
        //Return array of all columns in a certain row

        fun makeRowArray(t_array:Array<IntArray>,row:Int):MutableList<Int>{
            var row_array=mutableListOf<Int>()
                for (c in 0..6){
                    row_array.add(t_array[row][c])
                }

            return row_array
        }

        // Evaluates given array by counting piece of different players in it and returns score

        fun evaluateArea(area: MutableList<Int>, AI:Int ,Player:Int):Int{
            var score=0
            var opp_piece=Player
            var piece = AI
            if (piece==Player) opp_piece = AI

            if ((area.count {it==piece})==4) score+=1000
            else if (((area.count {it==piece})==3) && ((area.count {it==0})==1)) score+=10
            else if (((area.count {it==piece})==2) && ((area.count {it==0})==2)) score+=4
            if (((area.count {it==opp_piece})==3) && ((area.count {it==0})==1)) score-=8

            return score


        }

        // Evaluates node by making 4x4 areas, in which calculates heuristic value and then sums and return it as general heuristic value of node.

        fun heuristicValue(t_array: Array<IntArray>, AI:Int ,Player:Int):Int{
            var score:Int=0
            var center_array=mutableListOf<Int>()
            for (r in 5 downTo 0){
                center_array.add(t_array[r][3])
            }

            var centerCount=center_array.count {it==AI}
            score+=centerCount*6

            // Horizontal
            for (r in 5 downTo 0){
                var row_array=makeRowArray(t_array,r)
                for (c in 0..3){
                    var window=row_array.subList(c,c+4)
                    score+= evaluateArea(window,AI,Player)
                }
            }
            //Vertical
            for (c in 0..6){
                var col_array=makeColArray(t_array,c)
                for (r in 5 downTo 3){
                    var window=col_array.subList(5-r,9-r)
                    score+=evaluateArea(window,AI,Player)
                }
            }
            // Diagonal

            for (r in 5 downTo 3){
                for (c in 0..3){
                    var window=mutableListOf<Int>()
                    for (i in 0..3){
                        window.add(t_array[r-i][c+i])
                    }
                    score+=evaluateArea(window,AI,Player)
                }
            }

            for (r in 5 downTo 3){
                for (c in 0..3){
                    var window=mutableListOf<Int>()
                    for (i in 0..3){
                        window.add(t_array[r-i][c+3-i])
                    }
                    score+=evaluateArea(window,AI,Player)
                }
            }

        return score
        }

        // Minimax algorithm with depth and alpha-beta pruning for speed increase.
        // Node is a common array with players and AI movements.
        // After checking array(node) for terminal state or depth 0, in cycle of all available columns(a.k.a all possible movements) make a temporary array, in which makes all changes to prevent original array from changing.
        // Make a turn in temporary array and applies minimax to this temporary array with a turn (Recursion activated)
        // As terminal node or depth is reached 0, algorithm starts evaluating arrays and return heuristic values of them in descent order because of recursion (how minimax works)
        // Returning values, they are evaluating by each other to find a most profitable turn ( column, in which AI will make a turn)
        // With alpha-beta pruning algorithm cuts off unprofitable turns, increasing speed of AI decision

        fun minimax(array: Array<IntArray>, depth: Int,alpha:Int, beta:Int, maximizingPlayer:Boolean,first_move:String):Array<Int>{
            var minimax_array: Array<Int>
            var AI_piece:Int=1
            var Player_piece:Int=2

            if (first_move=="Player"){
                Player_piece=p1
                AI_piece=p2
            }
            else if (first_move=="AI"){
                Player_piece=p2
                AI_piece=p1
            }

            var column: Int

            var emptyCol=getAllEmptyCol(array)
            var isTerminal=isTerminal(array,0,first_move)
            if ((depth==0) || (isTerminal[0])|| (isTerminal[1])||(isTerminal[2])){ /* Player_win, AI_win, Draw */
                if (depth==0){
                    var minimax_array=arrayOf(-1,heuristicValue(array,AI_piece,Player_piece))
                    return minimax_array
                }
                else /* is terminal */  {
                    if (isTerminal[1]){
                        minimax_array=arrayOf(-1,1000000)
                        return (minimax_array)
                    }
                    else if (isTerminal[0]){
                        minimax_array=arrayOf(-1,-1000000)
                        return minimax_array
                    }
                    else {
                        minimax_array=arrayOf(-1,0)
                        return minimax_array
                    }
                }
            }
            if (maximizingPlayer){
                var value:Int
                var alpha1=alpha
                var beta1=beta
                value = Int.MIN_VALUE
                column = emptyCol.random()
                for (col in emptyCol){
                    var row = getNextEmptyRow(array, col)
                    var temp_array=array.copy()
                    var temp_array2=makeTurn(temp_array,row,col,AI_piece)
                    var minimax_array = minimax(temp_array2, depth-1, alpha1, beta1, false,first_move)
                    if (minimax_array[1]>value){
                        value=minimax_array[1]
                        column=col
                    }
                    alpha1=maxOf(alpha1,value)
                    if (alpha1>=beta1){
                        break
                    }
                }
                minimax_array=arrayOf(column,value)
                return minimax_array
            }
            else{  /* MINIMIZE PLAYER */
                var value:Int
                var alpha1=alpha
                var beta1=beta
                value = Int.MAX_VALUE
                column = emptyCol.random()
                for (col in emptyCol){
                    var row = getNextEmptyRow(array, col)
                    var temp_array=array.copy()
                    var temp_array2=makeTurn(temp_array,row,col,Player_piece)
                    var minimax_array = minimax(temp_array2, depth-1, alpha1, beta1, true,first_move)
                    if (minimax_array[1]<value){
                        value=minimax_array[1]
                        column=col
                    }
                    beta1=minOf(beta1,value)
                    if (alpha1>=beta1){
                        break
                    }
                }
                minimax_array=arrayOf(column,value)
                return minimax_array
            }
        }

        fun AI_turn(){
            if (AIFlag==1){
                if (first_move=="Player"){
                    if (Turn%2==0) {
                        val minimax_final=minimax(array,4, Int.MIN_VALUE, Int.MAX_VALUE,false,first_move)
                        // println(minimax_final[1])

                        arrayOfBut[minimax_final[0]].performClick()
                    }
                }
                else if(first_move=="AI") {
                    if ((Turn%2!=0)) {
                        val minimax_final=minimax(array,4, Int.MIN_VALUE, Int.MAX_VALUE,true,first_move)
                        // println(minimax_final[1])

                        arrayOfBut[minimax_final[0]].performClick()
                    }
                }
            }
        }

        fun contCheckWin(array: Array<IntArray>,counter:Int):Boolean{
            checkWin(array,counter)
            if (AIFlag==0){
                if (p1win){
                    withButtonCentered(null,"WOW","Congratulations, $name1, you won this game. Check and mate, $name2!",name1,name2,AIFlag,first_move)
                    return true
                }
                if (p2win) {
                    withButtonCentered(null,"WOW","Congratulations, $name2, you won this game. Check and mate, $name1!",name1,name2,AIFlag,first_move)
                    return true
                }
                if (draw) {
                    withButtonCentered(null,"Unfortunately","This game ended by draw, have a good luck next time!",name1,name2,AIFlag,first_move)
                    return true
                }
            }
            else {
                if (first_move=="Player"){
                    if (p1win){
                        withButtonCentered(null,"WOW","Congratulations, $name1, you won this game. Check and mate, piece of junk!",name1,name2,AIFlag,first_move)
                        return true
                    }
                    if (p2win){
                        withButtonCentered(null,"WOW","Congratulations, my little quantum processor , you won this game. Check and mate, $name1!",name1,name2,AIFlag,first_move)
                        return true
                    }
                    if (draw){
                        withButtonCentered(null,"Unfortunately","This game ended by draw, have a good luck next time!",name1,name2,AIFlag,first_move)
                        return true
                    }
                }
                else {
                    if (p2win){
                        withButtonCentered(null,"WOW","Congratulations, $name1, you won this game. Check and mate, piece of junk!",name1,name2,AIFlag,first_move)
                        return true
                    }
                    if (p1win){
                        withButtonCentered(null,"WOW","Congratulations, my little quantum processor , you won this game. Check and mate, $name1!",name1,name2,AIFlag,first_move)
                        return true
                    }
                    if (draw){
                        withButtonCentered(null,"Unfortunately","This game ended by draw, have a good luck next time!",name1,name2,AIFlag,first_move)
                        return true
                    }
                }

            }
            return false
        }




        but0.setOnClickListener{

            imageV.background = BitmapDrawable(resources, bitmap)

            val coll=0
            val limiter=coll*6
            for(row in 5 downTo 0){
                if(array[row][coll]==0){
                    val index=row+limiter
                    olist[index].also {
                        it.setBounds( 0, round(height/6.0*row).toInt()  , line1.bounds.right ,round(height-height/6.0*(5-row)).toInt())
                    }
                    if (Turn%2!=0) {
                        array[row][coll]= p1
                        olist[index].paint.color = Color.parseColor("#C22F10")
                    }
                    else {
                        array[row][coll]= p2
                        olist[index].paint.color = Color.parseColor("#766DB2")
                    }
                    ++Turn

                    olist[index].draw(canvas)
                    counter++
                    if(contCheckWin(array,counter)) break
                    AI_turn()
                    break
                }
            }
        }



        but1.setOnClickListener{
            imageV.background = BitmapDrawable(resources, bitmap)
            val coll=1
            val limiter=coll*6
            for(row in 5 downTo 0){
                if(array[row][coll]==0){
                    val index=row+limiter
                    olist[index].also {
                        it.setBounds( line1.bounds.right, round(height/6.0*row).toInt()  , line2.bounds.right ,round(height-height/6.0*(5-row)).toInt())
                    }
                    if (Turn%2!=0) {
                        array[row][coll]= p1
                        olist[index].paint.color = Color.parseColor("#C22F10")
                    }
                    else {
                        array[row][coll]= p2
                        olist[index].paint.color = Color.parseColor("#766DB2")

                    }
                    ++Turn
                    olist[index].draw(canvas)
                    counter++

                    if(contCheckWin(array,counter)) break

                    AI_turn()

                    break
                }
            }
        }

        but2.setOnClickListener{
            imageV.background = BitmapDrawable(resources, bitmap)
            val coll=2
            val limiter=coll*6

            for(row in 5 downTo 0){
                if(array[row][coll]==0){
                    val index=row+limiter
                    olist[index].also {
                        it.setBounds( line2.bounds.right, round(height/6.0*row).toInt()  , line3.bounds.right ,round(height-height/6.0*(5-row)).toInt())
                    }
                    if (Turn%2!=0) {
                        array[row][coll]= p1
                        olist[index].paint.color = Color.parseColor("#C22F10")

                    }
                    else {
                        array[row][coll]= p2
                        olist[index].paint.color = Color.parseColor("#766DB2")

                    }
                    ++Turn
                    olist[index].draw(canvas)
                    counter++

                    if(contCheckWin(array,counter)) break

                    AI_turn()

                    break
                }
            }
        }

        but3.setOnClickListener{
            imageV.background = BitmapDrawable(resources, bitmap)
            val coll=3
            val limiter=coll*6
            for(row in 5 downTo 0){
                if(array[row][coll]==0){
                    val index=row+limiter
                    olist[index].also {
                        it.setBounds( line3.bounds.right, round(height/6.0*row).toInt()  , line4.bounds.right ,round(height-height/6.0*(5-row)).toInt())
                    }
                    if (Turn%2!=0) {
                        array[row][coll]= p1
                        olist[index].paint.color = Color.parseColor("#C22F10")

                    }
                    else {
                        array[row][coll]= p2
                        olist[index].paint.color = Color.parseColor("#766DB2")

                    }
                    ++Turn

                    olist[index].draw(canvas)

                    counter++

                    if(contCheckWin(array,counter)) break

                    AI_turn()

                    break
                }
            }
        }

        but4.setOnClickListener{
            imageV.background = BitmapDrawable(resources, bitmap)
            val coll=4
            val limiter=coll*6
            for(row in 5 downTo 0){
                if(array[row][coll]==0){
                    val index=row+limiter
                    olist[index].also {
                        it.setBounds( line4.bounds.right, round(height/6.0*row).toInt()  , line5.bounds.right ,round(height-height/6.0*(5-row)).toInt())
                    }
                    if (Turn%2!=0) {
                        array[row][coll]= p1
                        olist[index].paint.color = Color.parseColor("#C22F10")

                    }
                    else {
                        array[row][coll]= p2
                        olist[index].paint.color = Color.parseColor("#766DB2")

                    }
                    ++Turn

                    olist[index].draw(canvas)

                    counter++
                    if(contCheckWin(array,counter)) break

                    AI_turn()

                    break
                }
            }
        }


        but5.setOnClickListener{
            imageV.background = BitmapDrawable(resources, bitmap)
            val coll=5
            val limiter=coll*6
            for(row in 5 downTo 0){
                val index=row+limiter
                if(array[row][coll]==0){
                    olist[index].also {
                        it.setBounds( line5.bounds.right, round(height/6.0*row).toInt()  , line6.bounds.right ,round(height-height/6.0*(5-row)).toInt())
                    }
                    if (Turn%2!=0) {
                        array[row][coll]= p1
                        olist[index].paint.color = Color.parseColor("#C22F10")

                    }
                    else {
                        array[row][coll]= p2
                        olist[index].paint.color = Color.parseColor("#766DB2")

                    }
                    ++Turn

                    olist[index].draw(canvas)

                    counter++
                    if(contCheckWin(array,counter)) break

                    AI_turn()

                    break
                }
            }
        }




        but6.setOnClickListener{

            imageV.background = BitmapDrawable(resources, bitmap)
            val coll=6
            val limiter=coll*6
            for(row in 5 downTo 0){
                if(array[row][coll]==0){
                    val index=row+limiter
                    olist[index].also {
                        it.setBounds( line6.bounds.right, round(height/6.0*row).toInt()  , width ,round(height-height/6.0*(5-row)).toInt())
                    }
                    if (Turn%2!=0) {
                        array[row][coll]= p1
                        olist[index].paint.color = Color.parseColor("#C22F10")

                    }
                    else {
                        array[row][coll]= p2
                        olist[index].paint.color = Color.parseColor("#766DB2")

                    }
                    ++Turn

                    olist[index].draw(canvas)

                    counter++
                    if(contCheckWin(array,counter)) break

                    AI_turn()

                    break
                }
            }
        }


        AI_turn()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
//https://devofandroid.blogspot.com/2018/03/add-itemsmenu-in-actionbartoolbar.html

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.itemId

        if (id == R.id.home_but) {
            val intent= Intent(this, Main_menu::class.java)
            finish()
            startActivity(intent)

        }

        return super.onOptionsItemSelected(item)

    }

//https://devofandroid.blogspot.com/2018/03/add-itemsmenu-in-actionbartoolbar.html
}




