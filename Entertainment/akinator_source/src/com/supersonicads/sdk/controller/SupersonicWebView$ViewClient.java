// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.graphics.Bitmap;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.supersonicads.sdk.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

private class <init> extends WebViewClient
{

    final SupersonicWebView this$0;

    public void onPageFinished(WebView webview, String s)
    {
        Logger.i("onPageFinished", s);
        if (s.contains("adUnit") || s.contains("index.html"))
        {
            pageFinished();
        }
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        Logger.i("onPageStarted", s);
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Logger.i("onReceivedError", (new StringBuilder()).append(s1).append(" ").append(s).toString());
        super.onReceivedError(webview, i, s, s1);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
    {
        boolean flag;
        Logger.i("shouldInterceptRequest", s);
        flag = false;
        boolean flag1 = (new URL(s)).getFile().contains("mraid.js");
        if (flag1)
        {
            flag = true;
        }
_L2:
        Object obj;
        File file;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        obj = (new StringBuilder()).append("file://").append(SupersonicWebView.access$1000(SupersonicWebView.this)).append(File.separator).append("mraid.js").toString();
        file = new File(((String) (obj)));
        new FileInputStream(file);
        obj = new WebResourceResponse("text/javascript", "UTF-8", getClass().getResourceAsStream(((String) (obj))));
        return ((WebResourceResponse) (obj));
        Object obj1;
        obj1;
        return super.shouldInterceptRequest(webview, s);
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Logger.i("shouldOverrideUrlLoading", s);
        if (handleSearchKeysURLs(s))
        {
            interceptedUrlToStore();
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }

    private ()
    {
        this$0 = SupersonicWebView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
