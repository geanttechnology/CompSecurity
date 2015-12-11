// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            c, g

private class <init> extends WebViewClient
{

    final c a;

    public void onPageFinished(WebView webview, String s)
    {
        if (!c.b(a))
        {
            a.b();
            for (webview = c.a(a).iterator(); webview.hasNext(); ((g)webview.next()).cancel(true)) { }
            c.a(a).clear();
            a.a();
            a.c((new StringBuilder()).append("TMWI.fireEvent('init',").append(c.c(a)).append(");").toString());
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (Uri.parse(s).getScheme().equals("tmwi"))
        {
            c.a(a, URI.create(s));
            return true;
        } else
        {
            return false;
        }
    }

    private (c c1)
    {
        a = c1;
        super();
    }

    a(c c1, a a1)
    {
        this(c1);
    }
}
