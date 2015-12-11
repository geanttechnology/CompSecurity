// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.webview;

import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.target.ui.util.ak;
import com.target.ui.util.n;

public class b extends WebViewClient
{

    public b()
    {
    }

    protected boolean a(WebView webview, String s)
    {
        s = Uri.parse(s);
        if (ak.a(s))
        {
            n.a(webview.getContext(), s, null);
            return true;
        } else
        {
            return false;
        }
    }

    public void onPageFinished(WebView webview, String s)
    {
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        sslerrorhandler.cancel();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return a(webview, s);
    }
}
