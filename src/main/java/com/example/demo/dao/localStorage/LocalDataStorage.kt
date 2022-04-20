package com.example.demo.dao.localStorage

import com.example.demo.dao.DataStorage
import com.example.demo.dao.entity.UserInfo

import java.util.HashMap

class LocalDataStorage private constructor() : DataStorage {
    companion object {

        private var dataSource: HashMap<String, UserInfo>? = null

        fun getDataSource(): HashMap<String, UserInfo> {
            if (dataSource == null) {
                dataSource = HashMap()
            }
            return dataSource as HashMap<String, UserInfo>
        }
    }
}
