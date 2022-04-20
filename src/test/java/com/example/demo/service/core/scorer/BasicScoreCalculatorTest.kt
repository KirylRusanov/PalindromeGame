package com.example.demo.service.core.scorer

import org.junit.Test

import org.junit.Assert.*

class BasicScoreCalculatorTest {

    @Test
    fun calculate() {
        val actualScore1 = BasicScoreCalculator().calculate("Hello")
        assertEquals(5, actualScore1)
        val actualScore2 = BasicScoreCalculator().calculate("tes,tes")
        assertEquals(7, actualScore2)
        val actualScore3 = BasicScoreCalculator().calculate("Пиу Пиу")
        assertEquals(6, actualScore3)
    }
}