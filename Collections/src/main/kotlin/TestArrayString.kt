package com.example.collectionsarrayslists

fun main() {
    val nomes = Array(3) {""}
    nomes[0] = "Maria"
    nomes[1] = "João"
    nomes[2] = "José"

    for (nome in nomes){
        println(nome)
    }

    println("-------------------------")
    nomes.sort()
    nomes.forEach {
        println(it)
    }

    val nomes2 = arrayOf("Maria", "José", "Pedro")

    println("---------------------------")
    nomes2.sort()
    nomes2.forEach { println(it) }
}