package com.hrod.androidmaster.sintaxis

val mes=5

fun main(){
    getMesbyNumber(mes)
    getTrimestre(mes)
    println(result(mes))
}

fun result(value: Any) = when(value){
        is Int -> value
        is String -> print(value)
        is Boolean -> if(value) print("Hola men")else println("habla falso")
        else ->"no es un tipo valido"
    }

fun getMesbyNumber(month: Int){
    when(month){
        1->println("Enero")
        2->println("Febrero")
        3->println("Marzo")
        4-> println("Abril")
        5-> println("Mayo")
        else-> println("no es un mes válido")
    }
}

fun getTrimestre(month: Int){
    when(month){
        in 1..3-> println("primer trimestre")
        in 3..6-> println("segundo trimestre")
        7,8,9 -> println("tercer trimestre")
        10,11,12-> println("cuarto trimestre")
        else-> println("dato invalido")
    }
}