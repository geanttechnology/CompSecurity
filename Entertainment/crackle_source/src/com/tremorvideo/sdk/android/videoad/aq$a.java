// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aq, ad

protected class a extends WebViewClient
{

    final aq a;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        ad.d((new StringBuilder()).append("HTML5 error: ").append(s1).toString());
        ad.d((new StringBuilder()).append("HTML5 error: ").append(s).toString());
        if (a.b != null)
        {
            a.b.a((new StringBuilder()).append(s1).append(" - ").append(s).toString());
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        while (a.a == null || !s.startsWith("event://tremorvideo.com/")) 
        {
            return false;
        }
        webview = s.replace("event://tremorvideo.com/", "");
        a.a.a(webview);
        return true;
    }

    protected (aq aq1)
    {
        a = aq1;
        super();
    }
}
