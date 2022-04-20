package com.example.demo.service.core.game

import com.example.demo.dao.entity.UserInfo
import com.example.demo.service.core.scorer.BasicScoreCalculator
import org.junit.Test

import org.junit.Assert.*

class LazyGameTest {

    @Test
    fun getTopFivePlayers() {
        val game = LazyGame(BasicScoreCalculator(), Mode.PALINDROME)
        val players = listOf(
        UserInfo("Petya", 5),
        UserInfo("Vasya", 9),
        UserInfo("Masha", 13),
        UserInfo("Andey", 3),
        UserInfo("Dima", 1),
        UserInfo("Leva", 0))

        val actual = game.getTopNPlayers(5, players)
        val expected = listOf(
                UserInfo("Masha", 13),
                UserInfo("Vasya", 9),
                UserInfo("Petya", 5),
                UserInfo("Andey", 3),
                UserInfo("Dima", 1))

        assertEquals(expected, actual)
    }
}