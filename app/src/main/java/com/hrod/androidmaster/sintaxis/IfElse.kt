package com.hrod.androidmaster.sintaxis

fun main(){
    comparaciones("cat", true)
}

fun comparaciones(pet:String, isHappy:Boolean){

    if(pet =="dog" || (pet=="cat" && isHappy)){
        println("Es un perro o un gato feliz")
    }else{
        println("Es un perro o un gato triste")
    }
}

