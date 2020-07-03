package com.example.program.domain.entity

import java.io.Serializable

data class PaymentStatus(
    val amount: Float,
    val creditCard: CreditCard
) : Serializable