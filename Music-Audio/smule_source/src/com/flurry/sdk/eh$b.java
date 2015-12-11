// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

// Referenced classes of package com.flurry.sdk:
//            eh, gd

final class <init> extends WebViewClient
{

    final eh a;

    public void onPageFinished(WebView webview, String s)
    {
        gd.a(3, eh.a(a), (new StringBuilder()).append("onPageFinished: url = ").append(s).toString());
        if (s == null || webview == null || webview != eh.b(a))
        {
            return;
        } else
        {
            eh.d(a).setVisibility(8);
            eh.a(a, false);
            eh.e(a);
            return;
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        gd.a(3, eh.a(a), (new StringBuilder()).append("onPageStarted: url = ").append(s).toString());
        if (s == null || webview == null || webview != eh.b(a))
        {
            return;
        }
        a.dismissProgressDialog();
        if (android.os..VERSION.SDK_INT < 11 && eh.c(a) && a.a(s, eh.c(a)))
        {
            gd.a(3, eh.a(a), "onPageStarted: stopLoading is called");
            webview.stopLoading();
        }
        eh.d(a).setVisibility(0);
        eh.a(a, true);
        eh.e(a);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        gd.a(3, eh.a(a), (new StringBuilder()).append("onReceivedError: error = ").append(i).append(" description= ").append(s).append(" failingUrl= ").append(s1).toString());
        super.onReceivedError(webview, i, s, s1);
        webview.clearSslPreferences();
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        super.onReceivedSslError(webview, sslerrorhandler, sslerror);
        gd.a(3, eh.a(a), (new StringBuilder()).append("onReceivedSslError: error = ").append(sslerror.toString()).toString());
        webview.clearSslPreferences();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        gd.a(3, eh.a(a), (new StringBuilder()).append("shouldOverrideUrlLoading: url = ").append(s).toString());
        if (s == null || webview == null || webview != eh.b(a))
        {
            return false;
        } else
        {
            boolean flag = a.a(s, eh.c(a));
            eh.a(a, false);
            return flag;
        }
    }

    private ew(eh eh1)
    {
        a = eh1;
        super();
    }

    ewClient(eh eh1, ewClient ewclient)
    {
        this(eh1);
    }
}
