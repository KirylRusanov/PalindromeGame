package com.example.demo.service.core.algorithm

import org.junit.Test

import org.junit.Assert.*

class AlgorithmPalindromeTest {

    @Test
    fun process() {
        val palindrome = AlgorithmPalindrome()
        assertTrue(palindrome.process("ТОПОТ"))
        assertFalse(palindrome.process("тест"))
        assertTrue(palindrome.process("пооп"))
        assertTrue(palindrome.process("а роза упала на лапу Азора"))
    }
}