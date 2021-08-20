package com.example.chucknorristesttask

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import com.example.chucknorristesttask.ui.categorypage.CategoriesActivity
import com.example.chucknorristesttask.ui.webviewpage.WebViewActivity


class MainActivity : AppCompatActivity() {

    private val prefsKey = "prefsType"
    private val prefsTypeKey = "type"
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.mainPB)
        progressBar.visibility = ProgressBar.VISIBLE
        val typeExtra = intent.getStringExtra("type")

        val sharedPreferences = getSharedPreferences(prefsKey, Context.MODE_PRIVATE)


        if(typeExtra != null || sharedPreferences.contains(prefsTypeKey)) {
            val webViewIntent = Intent(this, WebViewActivity::class.java)
            startActivity(webViewIntent)
            progressBar.visibility = ProgressBar.GONE
        } else {
            val categoryIntent = Intent(this, CategoriesActivity::class.java)
            startActivity(categoryIntent)
            progressBar.visibility = ProgressBar.GONE
        }
    }
}