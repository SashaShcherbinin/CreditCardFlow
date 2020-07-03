package com.example.program.domain.utils

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class CreditCardValidatorTest {

    lateinit var validator: CreditCardValidator

    @Before
    fun setUp() {
        validator = CreditCardValidator();
    }

    @Test
    fun validateCardNumber() {
        assertTrue(validator.validateCardNumber("6011 5555 5555 5555"))
        assertFalse(validator.validateCardNumber("6011555555555555"))
        assertFalse(validator.validateCardNumber("6011555555555"))
        assertFalse(validator.validateCardNumber("60115555555ttt555"))
        assertFalse(validator.validateCardNumber("6011555ggg5555ttt555"))
        assertFalse(validator.validateCardNumber("601 1555ggg5 555ttt555"))
        assertFalse(validator.validateCardNumber("601 1555g gg5 555ttt555"))
        assertFalse(validator.validateCardNumber("601 1555g gg5 555ttt 555"))
    }

    @Test
    fun validateDate() {
        assertTrue(validator.validateDate("44/55"))
        assertFalse(validator.validateDate("4f/55"))
        assertFalse(validator.validateDate("4/5"))
        assertFalse(validator.validateDate("465"))
        assertFalse(validator.validateDate("46455"))
        assertFalse(validator.validateDate("346455"))
        assertFalse(validator.validateDate("/346455"))
    }

    @Test
    fun validateCvv() {
        assertTrue(validator.validateCvv("455"))
        assertFalse(validator.validateCvv("4554"))
        assertFalse(validator.validateCvv("45"))
        assertFalse(validator.validateCvv("4"))
        assertFalse(validator.validateCvv(""))
    }
}