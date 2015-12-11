// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PushWebview extends Activity
{
    private class HelloWebViewClient extends WebViewClient
    {

        final PushWebview this$0;

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            finish();
            webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
            startActivity(webview);
            return false;
        }

        private HelloWebViewClient()
        {
            this$0 = PushWebview.this;
            super();
        }

    }


    public PushWebview()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new WebView(this);
        String s = getIntent().getStringExtra("url");
        bundle.getSettings().setJavaScriptEnabled(true);
        bundle.setWebViewClient(new HelloWebViewClient());
        bundle.reload();
        bundle.loadUrl(s);
        setContentView(bundle);
    }
}
