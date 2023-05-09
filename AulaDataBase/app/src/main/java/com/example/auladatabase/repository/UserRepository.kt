package com.example.auladatabase.repository

import com.example.auladatabase.dao.UserDao;
import com.example.auladatabase.entity.User;
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch;
import kotlinx.coroutines.Dispatchers;

class UserRepository (private val userDao:UserDao) {

    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun addUser(user: User) {
        coroutine.launch(Dispatchers.IO) {
            userDao.insert(user)
        }
    }
}