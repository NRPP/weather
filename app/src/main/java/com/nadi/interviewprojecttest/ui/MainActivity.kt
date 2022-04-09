package com.nadi.interviewprojecttest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nadi.interviewprojecttest.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }
}