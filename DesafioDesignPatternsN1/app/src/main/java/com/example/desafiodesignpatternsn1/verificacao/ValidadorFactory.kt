package com.example.desafiodesignpatternsn1.verificacao

open class ValidadorFactory {
    fun getCpfCnpj(s: String) : Boolean{
        if(VerificacaoCPF().validate(s)) {
            VerificacaoCPF()
            return true
        } else if (VerificacaoCNPJ().validate(s)) {
            VerificacaoCNPJ()
            return true
        }
        return false
    }
}