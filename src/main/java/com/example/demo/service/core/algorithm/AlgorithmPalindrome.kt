package com.example.demo.service.core.algorithm

class AlgorithmPalindrome : Algorithm {

    override fun process(text: String): Boolean {
        val cleanText = text.replace("\\s+".toRegex(), "").toLowerCase()
        val textPalindrome = cleanText.reversed()
        return cleanText == textPalindrome
    }
}
