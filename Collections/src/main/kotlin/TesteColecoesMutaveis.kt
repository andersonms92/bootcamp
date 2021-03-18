package com.example.collectionsarrayslists

fun main() {
    val joao = Funcionario("João", 2000.0, "CLT")
    val pedro = Funcionario("Pedro", 1500.0, "PJ")
    val maria = Funcionario("Maria", 4000.0, "CLT")

    println("-----------------")
    val funcionarios = mutableListOf(joao, maria)
    funcionarios.forEach { println(it) }

    println("-----------------")
    funcionarios.add(pedro)
    funcionarios.forEach { println(it) }

    println("-----------------")
    funcionarios.remove(joao)
    funcionarios.forEach { println(it) }

    println("-----------------")
    val funcionarioSet = mutableSetOf(joao)
    //funcionarioSet.forEach{ println(it) }

    funcionarioSet.add(pedro)
    funcionarioSet.add(maria)
    funcionarioSet.forEach{ println(it) }
}