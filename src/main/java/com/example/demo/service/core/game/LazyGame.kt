package com.example.demo.service.core.game

import com.example.demo.dao.entity.UserInfo
import com.example.demo.dao.localStorage.LocalDataManager
import com.example.demo.service.core.algorithm.AlgorithmPalindrome
import com.example.demo.service.core.scorer.ScoreCalculator
import java.util.Comparator

import java.util.Scanner
import java.util.stream.Collectors

class LazyGame(private val scoreCalculator: ScoreCalculator, private val gameMode: Mode) : Game() {

    private val dataManager: LocalDataManager = LocalDataManager()
    private lateinit var userName: String

    override fun startGame(userName: String) {
        this.userName = userName
        process()
    }

    private val textFactory = {
        val `in` = Scanner(System.`in`)
        println("Ваш текст: ")
        `in`.nextLine()
    }

    public fun getTopFivePlayers(): List<UserInfo> {
        return getTopNPlayers(5, dataManager.getAllPlayers())
    }

    public fun getTopNPlayers(n: Long, users: List<UserInfo>): List<UserInfo> {
        return users.stream()
                .sorted(Comparator.reverseOrder())
                .limit(n).collect(Collectors.toList())
    }

    private fun process() {
        var exit = false;
        while (!exit) {
            val text = textFactory.invoke()
            when (gameMode) {
                Mode.PALINDROME -> playWithPalindrome(text)
            }
        }
    }

    private fun playWithPalindrome(text: String) {
        if (!dataManager.getUsersWords(userName).contains(text) && AlgorithmPalindrome().process(text)) {
            val score = scoreCalculator.calculate(text)
            dataManager.addScoreForUser(userName, score)
        }
    }
}
