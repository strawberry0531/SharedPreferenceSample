package com.example.sharedpreferencesample

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "app_preferences"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val USERNAME = Pair("uname", "")
    private val PASSWORD = Pair("upwd", "")

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var username: String
        get() {
            return preferences.getString(USERNAME.first, USERNAME.second) ?: USERNAME.second
        }
        set(value) {
            preferences.edit {
                it.putString(USERNAME.first, value)
            }
        }

    var password: String
        get() {
            return preferences.getString(PASSWORD.first, PASSWORD.second) ?: PASSWORD.second
        }
        set(value) {
            preferences.edit {
                it.putString(PASSWORD.first, value)
            }
        }
}