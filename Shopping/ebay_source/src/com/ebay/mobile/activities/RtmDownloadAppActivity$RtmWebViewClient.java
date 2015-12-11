// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.ui_stuff.Util;

// Referenced classes of package com.ebay.mobile.activities:
//            RtmDownloadAppActivity

private class <init> extends WebViewClient
{

    final RtmDownloadAppActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        setTitle(RtmDownloadAppActivity.access$200(RtmDownloadAppActivity.this));
        CookieSyncManager.getInstance().sync();
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (!isFinishing())
        {
            Util.resetAppStatus(RtmDownloadAppActivity.this);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Log.e("RtmDownloadAppActivity", (new StringBuilder()).append((new Exception()).getStackTrace()[0].getMethodName()).append(": errorCode = <").append(i).append(">").append(": description = <").append(s).append(">").append(": failingUrl = <").append(s1).append(">").toString());
        webview = s;
        if (i > 0)
        {
            webview = (new StringBuilder()).append(s).append(" (").append(i).append(")").toString();
        }
        dialogManager.showDynamicAlertDialog(null, webview, true);
        finish();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Log.v("RtmDownloadAppActivity", (new StringBuilder()).append("url = <").append(s).append(">").toString());
        webview.loadUrl(s);
        return false;
    }

    private ()
    {
        this$0 = RtmDownloadAppActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
