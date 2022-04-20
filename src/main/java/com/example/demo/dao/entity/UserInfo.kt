package com.example.demo.dao.entity

import java.util.HashSet

class UserInfo(val name: String, score: Int) : Comparable<UserInfo> {
    val usedWords = HashSet<String>()
    var score: Int = 0
        private set

    init {
        this.score = score
    }

    fun addScore(score: Int) {
        this.score = +score
    }

    fun addUsedWord(usedWord: String) {
        this.usedWords.add(usedWord)
    }

    override fun compareTo(o: UserInfo): Int {
        return Integer.compare(this.score, o.score)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        other as UserInfo

        if (name != other.name) return false
        if (usedWords != other.usedWords) return false
        if (score != other.score) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + usedWords.hashCode()
        result = 31 * result + score
        return result
    }
}
