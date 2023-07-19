package com.sqisoft.plantmatehusk;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String HOME = "http://192.168.89.66:3000/";
//    private static final String HOME = "https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webview);
        webView.clearCache(true);

        WebSettings webSettings = webView.getSettings();
        // React 사이트에서 JavaScript를 사용하는 경우 필요
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        // 리다이렉트 할 때 브라우저 열리는 것 방지
        webView.setWebChromeClient(new WebChromeClient());
//        webView.setWebViewClient(new WebViewClient() {
//            public void onReceivedError(WebView view, WebResourceRequest wrreq, WebResourceError wrerr){
//                Toast.makeText(getApplicationContext(), "Failed loading app!", Toast.LENGTH_SHORT).show();
//                Log.e(Integer.valueOf(wrerr.getErrorCode()).toString(), wrerr.getDescription().toString());
//            }
//        });

        webView.loadUrl(HOME);
        Log.i(TAG,"Exiting onCreate");
    }
}