// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            ag, af

private class <init> extends WebViewClient
{

    final ag a;

    public void a()
    {
        a.d.loadUrl("javascript: tremorvideo.EmbedVideoPlayer.stopVideo();");
    }

    protected void a(String s)
    {
        a.d.loadUrl((new StringBuilder()).append("javascript: tremorcore.nativeCallComplete('").append(s).append("');").toString());
    }

    public void b()
    {
        a.d.loadUrl("javascript: tremorvideo.EmbedVideoPlayer.pauseVideo();");
    }

    public void c()
    {
        a.d.loadUrl("javascript: tremorvideo.EmbedVideoPlayer.resumeVideo();");
    }

    public void onPageFinished(WebView webview, String s)
    {
        if (!a.d.i)
        {
            a.d.j = false;
            a.d.loadUrl("javascript: tremorvideo.EmbedVideoPlayer.setIsAndroid()");
            a.d.loadUrl((new StringBuilder()).append("javascript: tremorvideo.EmbedVideoPlayer.initVideo('").append(a.d.e).append("');").toString());
            a.d.i = true;
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        a.h.m();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (Uri.parse(s).getScheme().equals("tremorvideo"))
        {
            a.a(URI.create(s));
            return true;
        }
        if (ag.a(a) != null && s.startsWith(ag.a(a)))
        {
            a.h.a(s);
            return true;
        } else
        {
            return false;
        }
    }

    private (ag ag1)
    {
        a = ag1;
        super();
    }

    a(ag ag1, a a1)
    {
        this(ag1);
    }
}
