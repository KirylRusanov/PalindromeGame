package com.example.demo.service.core.scorer

interface ScoreCalculator {

    fun calculate(text: String) : Int
}