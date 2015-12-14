// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PureWebViewActivity extends Activity
{

    protected static final String b = com/cyberlink/youcammakeup/widgetpool/PureWebViewActivity.getSimpleName();
    protected WebView a;

    public PureWebViewActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = new WebView(this);
        bundle = a.getSettings();
        bundle.setBuiltInZoomControls(true);
        bundle.setSupportZoom(true);
        bundle.setLoadWithOverviewMode(true);
        bundle.setUseWideViewPort(true);
        bundle = getIntent().getData();
        a.loadUrl(bundle.toString());
        a.setWebViewClient(new WebViewClient() {

            final PureWebViewActivity a;

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                webview.loadUrl(s);
                return true;
            }

            
            {
                a = PureWebViewActivity.this;
                super();
            }
        });
        setContentView(a);
    }

}
