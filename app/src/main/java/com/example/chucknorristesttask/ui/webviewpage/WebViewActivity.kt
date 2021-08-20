package com.example.chucknorristesttask.ui.webviewpage

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.chucknorristesttask.R


class WebViewActivity : AppCompatActivity() {

    private val prefsKey = "prefsType"
    private val prefsTypeKey = "type"

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        progressBar = findViewById(R.id.webViewProgressBar)
        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = MyWebViewClient()
        webView.loadUrl("https://www.google.com/")

        val sp = getSharedPreferences(prefsKey, Context.MODE_PRIVATE)
        if(!sp.contains(prefsKey)) {
            sp.edit().putString(prefsTypeKey, "type").apply()
        }


        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {
                if (progress < 100 && progressBar.visibility == ProgressBar.GONE) {
                    progressBar.visibility = ProgressBar.VISIBLE
                }

                progressBar.progress = progress
                if (progress == 100) {
                    progressBar.visibility = ProgressBar.GONE
                }
            }
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }
}