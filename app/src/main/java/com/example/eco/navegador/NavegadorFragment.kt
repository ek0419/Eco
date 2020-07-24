package com.example.eco.navegador

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import com.example.eco.BaseFragment
import com.example.eco.R
import kotlinx.android.synthetic.main.fragment_navegador.*


class NavegadorFragment : BaseFragment() {


    // private val BASE_URL = "https://www.darkorbit.com/"
    private val BASE_URL = "https://www.google.com/"
    private val SEATCH_PATH ="/search?q="

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_navegador, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initWebView()
        super.onViewCreated(view, savedInstanceState)
    }


    fun initWebView() {

        //barra busqueda

        searchView.setOnQueryTextListener(object : OnQueryTextListener{

            override fun onQueryTextChange(newText: String?): Boolean {
              return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    if(URLUtil.isValidUrl(it)){
                        webView.loadUrl(it)
                    }else{
                        webView.loadUrl("$BASE_URL$SEATCH_PATH$it")
                    }
                }
                return false
            }
        })

        //Refrensh
        swipeRefresh.setOnRefreshListener {
            webView.reload()
        }

        //webView
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                swipeRefresh.isRefreshing  = true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                swipeRefresh.isRefreshing = false
            }
        }
        val setting: WebSettings = webView.settings
        setting.javaScriptEnabled = true
        webView.loadUrl(BASE_URL)
    }

    override fun onBackPressed(): Boolean {
        val acction = true
        //   return super.onBackPressed()
        if (webView.canGoBack()) {
            webView.goBack()
            return acction
        } else {
            return super.onBackPressed()
        }

    }

}





