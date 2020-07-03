package com.example.program.domain.entity

import java.io.Serializable

data class CreditCard(
    val number: String,
    val date: String,
    val cvv: String
) : Serializable