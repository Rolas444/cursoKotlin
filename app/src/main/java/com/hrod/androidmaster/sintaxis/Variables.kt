package com.hrod.androidmaster.sintaxis

/*
    Variables
 */

val first = 100
val second = 56

fun main (){
    tipos()
    val resto = restar(first, second)
    println(resto)
    println(restarAbreviado(first, second))
}

fun tipos (){
    val age:Int = 30
    val letra:Char = 'h'
    val name : String = "hRodland"
    val boss: Boolean = true
    println(boss)
}

fun restar(firstNumber:Int, secondNumber: Int):Int {
    return firstNumber-secondNumber
}

fun restarAbreviado(primero:Int, segundo: Int) = segundo-primero