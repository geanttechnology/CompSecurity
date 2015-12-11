// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tremorvideo.sdk.android.videoad.ad;
import java.net.URI;

// Referenced classes of package com.tremorvideo.sdk.android.e:
//            p, k, l

private class <init> extends WebViewClient
{

    final p a;

    public void onPageFinished(WebView webview, String s)
    {
        if (!p.a(a))
        {
            p.a(a, true);
            p.b(a).c();
            a.a(l.a(p.c(a)));
            a.p();
            if (a.j() != null)
            {
                a.j().a(a);
            }
            p.b(a, true);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (Uri.parse(s).getScheme().equals("mraid"))
        {
            p.a(a, URI.create(s));
            return true;
        }
        webview = new Intent();
        webview.setAction("android.intent.action.VIEW");
        webview.setData(Uri.parse(s));
        webview.addFlags(0x10000000);
        try
        {
            a.getContext().startActivity(webview);
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            ad.a(webview);
            return false;
        }
        return true;
    }

    private ception(p p1)
    {
        a = p1;
        super();
    }

    >(p p1, > >)
    {
        this(p1);
    }
}
