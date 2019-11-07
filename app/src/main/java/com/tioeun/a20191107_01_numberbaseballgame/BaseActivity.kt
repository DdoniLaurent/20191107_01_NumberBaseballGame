package com.tioeun.a20191107_01_numberbaseballgame

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    abstract fun setupEvents()
    abstract fun setValus()
}