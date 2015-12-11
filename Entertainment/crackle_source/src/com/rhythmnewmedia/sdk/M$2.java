// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            M, y

final class t extends WebViewClient
{

    final a a;
    final M b;

    public final void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        y.a("********************* ad overlay rendered and ready", new Object[0]);
        a.m();
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        y.b("********************* ad overlay render failed %d: %s", new Object[] {
            Integer.valueOf(i), s
        });
        a.m();
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        a.a(s);
        return true;
    }

    t(M m, t t)
    {
        b = m;
        a = t;
        super();
    }
}
