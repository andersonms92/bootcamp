package com.example.desafiodesignpatternsn1.cpfcnpj

import com.example.desafiodesignpatternsn1.verificacao.ValidadorFactory

open class CpfCnpj(private val valid: ValidadorFactory) {

    fun isValid(s: String) : Boolean {
        return valid.getCpfCnpj(s)
    }
}