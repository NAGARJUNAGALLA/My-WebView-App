package dev.wvb.testapp

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import android.view.ViewGroup.LayoutParams.MATCH_PARENT

class MainActivity : Activity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this)
        
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            useWideViewPort = true
            loadWithOverviewMode = true
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
            }
        }

        webView.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP && webView.canGoBack()) {
                webView.goBack()
                true
            } else {
                false
            }
        }

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(webView, LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT))
        }
        setContentView(root)

        // Replace this URL with the actual live link to your website
        webView.loadUrl("https://jcv-mock-tests.web.app/2026/") 
    }

    override fun onDestroy() {
        webView.destroy()
        super.onDestroy()
    }
}
