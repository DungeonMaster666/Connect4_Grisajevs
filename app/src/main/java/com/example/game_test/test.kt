package com.example.game_test


const val p1 = 1
const val p2 = 2
var p1win=false
var p2win=false
var draw=false

fun arrprint(array: Array<IntArray>){
    println()
    for (row in array){
        for (value in row){
            print("$value ")
        }
        println()
    }
}

fun CheckHorizontal(array: Array<IntArray>): Boolean { //HORIZONTAL

    for(i in 0..5){
        var countp1=0
        var countp2=0
        for ( j in 0..6){
            if (array[i][j]==p1){
                countp1++
                if (countp1==4){
                    p1win=true
                    return true
                }
            }
            else countp1=0
            if (array[i][j]==p2){
                countp2++
                if (countp2==4){
                    p2win=true
                    return true
                }
            }
            else countp2=0
        }
    }
    return false
}


fun CheckVertical(array: Array<IntArray>): Boolean { //VERTICAL

    for(j in 0..6){
        var countp1=0
        var countp2=0
        for ( i in 0..5 ){
            if (array[i][j]==p1){
                countp1++
                if (countp1==4){
                    p1win=true
                    return true
                }
            }
            else countp1=0
            if (array[i][j]==p2){
                countp2++
                if (countp2==4){
                    p2win=true
                    return true
                }
            }
            else countp2=0
        }
    }
    return false
}

fun CheckDiagonalRight(array: Array<IntArray>): Boolean { //RIGHT DIAGONAL on the left side

    for(i in 0..2){
        var countp1=0
        var countp2=0
        for ((i2, j) in (i..5).zip(0..6) ){
            if (array[i2][j]==p1){
                countp1++
                if (countp1==4){
                    p1win=true
                    return true
                }
            }
            else countp1=0
            if (array[i2][j]==p2){
                countp2++
                if (countp2==4){
                    p2win=true
                    return true
                }
            }
            else countp2=0
        }
    }
    return false
}

fun CheckDiagonalRight2(array: Array<IntArray>): Boolean { //RIGHT DIAGONAL on the right side

    for(j in 1..3){
        var countp1=0
        var countp2=0
        for ((j2, i) in (j..6).zip(0..5) ){
            if (array[i][j2]==p1){
                countp1++
                if (countp1==4){
                    p1win=true
                    return true
                }
            }
            else countp1=0
            if (array[i][j2]==p2){
                countp2++
                if (countp2==4){
                    p2win=true

                    return true
                }
            }
            else countp2=0
        }
    }
    return false
}

fun CheckDiagonalLeft(array: Array<IntArray>): Boolean { //Left DIAGONAL on the right side

    for(i in 0..2){
        var countp1=0
        var countp2=0
        for ((i2, j) in (i..5).zip(6 downTo 1) ){
            if (array[i2][j]==p1){
                countp1++
                if (countp1==4){
                    p1win=true
                    return true
                }
            }
            else countp1=0
            if (array[i2][j]==p2){
                countp2++
                if (countp2==4){
                    p2win=true
                    return true
                }
            }
            else countp2=0
        }
    }
    return false
}

fun CheckDiagonalLeft2(array: Array<IntArray>): Boolean { //LEFT DIAGONAL on the left side

    for(j in 5 downTo 3){
        var countp1=0
        var countp2=0
        for ((j2, i) in (j downTo 0).zip(0..5) ){
            if (array[i][j2]==p1){
                countp1++
                if (countp1==4){
                    p1win=true
                    return true
                }
            }
            else countp1=0
            if (array[i][j2]==p2){
                countp2++
                if (countp2==4){
                    p2win=true
                    return true
                }
            }
            else countp2=0
        }
    }
    return false
}

fun checkDraw(count:Int): Boolean {
    return if ((count==42)&& (!p1win)&&(!p2win)){
        println("IT'S DRAW!")
        draw=true
        true
    } else false
}



fun checkWin(array: Array<IntArray>,count:Int){
    if(!checkDraw(count)) {
        if (!CheckHorizontal(array)) {
            if (!CheckVertical(array)) {
                if (!CheckDiagonalRight(array)) {
                    if (!CheckDiagonalRight2(array)) {
                        if (!CheckDiagonalLeft(array)) {
                            if (!CheckDiagonalLeft2(array)) {
                                return
                            } else {
                                if (p1win) println("WIN P1 BY DIAGONAL");

                                else println("WIN P2 BY DIAGONAL")
                            }
                        } else {
                            if (p1win) println("WIN P1 BY DIAGONAL")
                            else println("WIN P2 BY DIAGONAL")
                        }
                    } else {
                        if (p1win) println("WIN P1 BY DIAGONAL")
                        else println("WIN P2 BY DIAGONAL")
                    }
                } else {
                    if (p1win) println("WIN P1 BY DIAGONAL")
                    else println("WIN P2 BY DIAGONAL")
                }
            } else {
                if (p1win) println("WIN P1 BY VERTICAL")
                else println("WIN P2 BY VERTICAL")
            }
        } else {
            if (p1win) println("WIN P1 BY HORIZONTAL")
            else println("WIN P2 BY HORIZONTAL")
        }

    }
}


fun main(args: Array<String>) {
    val rows = 6
    val coll = 7
    val array = Array(rows) {
        IntArray(coll)
    }



    arrprint(array)

    if (!CheckHorizontal(array)) {
        if (!CheckVertical(array)) {
            if (!CheckDiagonalRight(array)) {
                if (!CheckDiagonalRight2(array)) {
                    if (!CheckDiagonalLeft(array)) {
                        if (!CheckDiagonalLeft2(array)) {
                            println("IT'S DRAW!")
                        }
                    }
                }
            }
        }
    }
}


