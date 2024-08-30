package com.example.webview
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.webview.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webApp.loadUrl("https://www.myntra.com/")

        binding.webApp.settings.javaScriptEnabled = true

        binding.webApp.webViewClient = object : WebViewClient(){

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

                binding.webApp.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE

            }
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                binding.webApp.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
            }
        }
    }
    override fun onBackPressed() {
        if (binding.webApp.canGoBack()){
            binding.webApp.goBack()
        }
        else{
            super.onBackPressed()
        }
    }
}