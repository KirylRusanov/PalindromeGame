package com.example.demo.dao.localStorage

import com.example.demo.dao.LocalDataManager
import com.example.demo.dao.entity.UserInfo

import java.util.*

class LocalDataManager : LocalDataManager {

    private val dataSource: HashMap<String, UserInfo> = LocalDataStorage.getDataSource()

    override fun getAllPlayers(): List<UserInfo> {
        return dataSource.values.toList()
    }

    override fun getUsersWords(userName: String): HashSet<String> {
        return if (dataSource.containsKey(userName)) dataSource[userName]!!.usedWords else HashSet()
    }

    override fun addWordForUser(userName: String, text: String) {
        val userInfo = dataSource.computeIfAbsent(userName) { UserInfo(userName, 0) }
        userInfo.addUsedWord(text)
    }

    override fun addScoreForUser(userName: String, score: Int) {
        if (dataSource.containsKey(userName)) dataSource[userName]?.addScore(score) else UserInfo(userName, 0)
    }
}
