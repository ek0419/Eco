package com.example.eco.navegador

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.example.eco.R
import kotlinx.android.synthetic.main.fragment_navegador.*


class NavegadorFragment : Fragment() {

    private val BASE_URL = "https://www.google.com"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        initWebView()
        return inflater.inflate(R.layout.fragment_navegador, container, false)
    }

    fun initWebView(){

        webView.webChromeClient = object : WebChromeClient(){}
        webView.webViewClient = object  : WebViewClient(){}

        val setting : WebSettings = webView.settings
        setting.javaScriptEnabled = true
        webView.loadUrl(BASE_URL)
    }

}