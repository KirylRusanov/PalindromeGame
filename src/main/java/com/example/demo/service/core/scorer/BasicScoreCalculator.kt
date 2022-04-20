package com.example.demo.service.core.scorer

class BasicScoreCalculator : ScoreCalculator {

    override fun calculate(text: String): Int {
        val cleanText = text.replace("\\s+".toRegex(), "").toLowerCase()
        return cleanText.length;
    }
}