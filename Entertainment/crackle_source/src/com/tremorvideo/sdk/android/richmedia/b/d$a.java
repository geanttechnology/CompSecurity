// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.b;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.b:
//            d

private class <init> extends WebViewClient
{

    final d a;

    public void onPageFinished(WebView webview, String s)
    {
        if (s.equals(d.b(a)) && !d.c(a))
        {
            a.b();
            d.a(a, true);
            a.a();
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (Uri.parse(s).getScheme().equals("tremorvideo"))
        {
            d.a(a, URI.create(s));
            return true;
        } else
        {
            return false;
        }
    }

    private (d d1)
    {
        a = d1;
        super();
    }

    a(d d1, a a1)
    {
        this(d1);
    }
}
