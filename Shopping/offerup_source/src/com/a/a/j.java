// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.a.a:
//            i, h

final class j extends WebViewClient
{

    private h a;
    private i b;

    j(i k)
    {
        b = k;
        super();
        a = b.a;
    }

    public final void onLoadResource(WebView webview, String s)
    {
        h.a(a, webview, s);
    }

    public final void onPageFinished(WebView webview, String s)
    {
        h.b(a, webview, s);
    }

    public final void onReceivedError(WebView webview, int k, String s, String s1)
    {
        h.a(a, webview, k, s, s1);
    }

    public final void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        h.a(a, webview, sslerrorhandler, sslerror);
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return h.c(a, webview, s);
    }
}
