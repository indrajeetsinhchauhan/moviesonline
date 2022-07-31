package com.indrajeetsinhchauhan.moviesonline

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mWebView = findViewById<WebView>(R.id.web_view)
        mWebView.loadUrl("https://www1.kk01.net/home")
        mWebView.settings.javaScriptEnabled = true
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateWindow(view: WebView?, isDialog: Boolean, isUserGesture: Boolean, resultMsg: Message?): Boolean {
        val newWebView = WebView()
        val transport = resultMsg?.obj as WebView.WebViewTransport
        transport.webView = newWebView

        val settings = newWebView.getSettings()
        settings.javaScriptEnabled = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.setSupportMultipleWindows(true)
        settings.useWideViewPort = false
        newWebView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                Toast.makeText(context, url, Toast.LENGTH_LONG).show()
                super.onPageStarted(view, url, favicon)
            }
        }
        resultMsg.sendToTarget()

        return true
    }
}