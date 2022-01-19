package com.example.kiddyrags;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private WebView mywebView;
    private ProgressBar progress_circular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebView = (WebView) findViewById(R.id.webview);
        progress_circular =  findViewById(R.id.progress_circular);




        //mywebView.setVisibility(View.VISIBLE);
        //progress_circular.setVisibility(View.GONE);

        String url = "https://kiddyrags.com/";
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.getSettings().setJavaScriptEnabled(true);
        mywebView.getSettings().setDomStorageEnabled(true);
        mywebView.loadUrl(url);
        progress_circular.setVisibility(View.GONE);
        mywebView.setVisibility(View.VISIBLE);

        /*mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://kiddyrags.com/");
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);*/
    }

    public class mywebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if (mywebView.canGoBack()) {
            mywebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}