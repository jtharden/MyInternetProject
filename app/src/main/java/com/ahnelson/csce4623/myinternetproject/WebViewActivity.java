package com.ahnelson.csce4623.myinternetproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {
    protected String webpage;
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        myWebView = (WebView)findViewById(R.id.wvMyWebView);
        webpage = this.getIntent().getStringExtra("webpage");
        myWebView.loadUrl(webpage);
    }
}
