package com.example.collectionsarrayslists

fun main() {
    val salarios = DoubleArray(3)
    salarios[0] = 1235.40
    salarios[1] = 2500.0
    salarios[2] = 3156.0

    salarios.sort()
    salarios.forEach { println(it) }

    println("-----------------------")
    salarios.forEachIndexed { index, salario ->
        salarios[index] = salario * 1.1
    }
    salarios.forEach { println(it) }

    println("-----------------------")
    val salarios2 = doubleArrayOf(1501.0, 1250.0, 5000.0)
    salarios2.sort()
    salarios2.forEach { println(it) }
}