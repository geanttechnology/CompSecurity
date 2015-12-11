// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class BrowserActivity extends Activity
{

    public static final String EXTRA_URL = "url";
    private Button backButton;
    private android.view.View.OnClickListener backListener;
    private android.view.View.OnClickListener closeListener;
    private Button forwardButton;
    private android.view.View.OnClickListener forwardListener;
    private ProgressBar spinner;
    private WebView webView;
    private WebViewClient webViewClient;

    public BrowserActivity()
    {
        webViewClient = new WebViewClient() {

            final BrowserActivity this$0;

            public void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
                spinner.setVisibility(4);
                checkBackAndForwardButtons();
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                super.onLoadResource(webview, s);
                spinner.setVisibility(0);
            }

            
            {
                this$0 = BrowserActivity.this;
                super();
            }
        };
        backListener = new android.view.View.OnClickListener() {

            final BrowserActivity this$0;

            public void onClick(View view)
            {
                goBack();
            }

            
            {
                this$0 = BrowserActivity.this;
                super();
            }
        };
        forwardListener = new android.view.View.OnClickListener() {

            final BrowserActivity this$0;

            public void onClick(View view)
            {
                goForward();
            }

            
            {
                this$0 = BrowserActivity.this;
                super();
            }
        };
        closeListener = new android.view.View.OnClickListener() {

            final BrowserActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = BrowserActivity.this;
                super();
            }
        };
    }

    private void checkBackAndForwardButtons()
    {
        if (webView.canGoBack())
        {
            backButton.setEnabled(true);
        } else
        {
            backButton.setEnabled(false);
        }
        if (webView.canGoForward())
        {
            forwardButton.setEnabled(true);
            return;
        } else
        {
            forwardButton.setEnabled(false);
            return;
        }
    }

    private void goBack()
    {
        if (webView.canGoBack())
        {
            webView.goBack();
        }
    }

    private void goForward()
    {
        if (webView.canGoForward())
        {
            webView.goForward();
        }
    }

    private void setupButtons()
    {
        backButton = (Button)findViewById(getApplicationContext().getResources().getIdentifier("backButton", "id", getApplicationContext().getPackageName()));
        backButton.setOnClickListener(backListener);
        forwardButton = (Button)findViewById(getApplicationContext().getResources().getIdentifier("forwardButton", "id", getApplicationContext().getPackageName()));
        forwardButton.setOnClickListener(forwardListener);
        findViewById(getApplicationContext().getResources().getIdentifier("closeButton", "id", getApplicationContext().getPackageName())).setOnClickListener(closeListener);
    }

    private void setupSpinner()
    {
        spinner = (ProgressBar)findViewById(getApplicationContext().getResources().getIdentifier("progressBar", "id", getApplicationContext().getPackageName()));
    }

    private void setupWebView()
    {
        webView = (WebView)findViewById(getApplicationContext().getResources().getIdentifier("webView", "id", getApplicationContext().getPackageName()));
        webView.setWebViewClient(webViewClient);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getIntent().getStringExtra("url"));
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(getApplicationContext().getResources().getIdentifier("activity_browser", "layout", getApplicationContext().getPackageName()));
        setupSpinner();
        setupWebView();
        setupButtons();
    }




}
