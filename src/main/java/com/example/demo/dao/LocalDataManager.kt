package com.example.demo.dao

import com.example.demo.dao.entity.UserInfo

import java.util.HashSet

interface LocalDataManager {

    fun getAllPlayers(): List<UserInfo>

    fun getUsersWords(userName: String): HashSet<String>

    fun addWordForUser(userName: String, text: String)

    fun addScoreForUser(userName: String, score: Int)
}
