// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

// Referenced classes of package com.groupon.activity:
//            GiftingThemeSelection

private class <init> extends WebViewClient
{

    final GiftingThemeSelection this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        webviewProgressBar.setVisibility(8);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        webviewProgressBar.setVisibility(0);
        setActionBarTitle(getString(0x7f08011e));
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        webviewProgressBar.setVisibility(8);
        webview.loadUrl("about:blank");
        GiftingThemeSelection.access$1100(GiftingThemeSelection.this);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return false;
    }

    private ()
    {
        this$0 = GiftingThemeSelection.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
