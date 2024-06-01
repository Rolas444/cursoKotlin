package com.hrod.androidmaster.excercise

var weekDays = mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

fun main (){
    getDays(weekDays)
}

fun getDays(values: MutableList<String>){

    values[3]= "feliz "+values[3]

    for (position in values.indices){
        println(values[position])
    }

    for((position, value) in values.withIndex()){
        println("la posición $position, contine $value ")
    }

    for(weekDay in values){
        println(weekDay)
    }



    println(values)
}