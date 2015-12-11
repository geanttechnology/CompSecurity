// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

// Referenced classes of package com.jirbo.adcolony:
//            AdColonyBrowser, v, bl, ak, 
//            o

class a extends WebViewClient
{

    final AdColonyBrowser a;

    public void onPageFinished(WebView webview, String s)
    {
        if (!AdColonyBrowser.D)
        {
            AdColonyBrowser.z = true;
            AdColonyBrowser.y = false;
            a.s.setVisibility(4);
            AdColonyBrowser.w = a.c.canGoBack();
            AdColonyBrowser.x = a.c.canGoForward();
        }
        a.u.invalidate();
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (!AdColonyBrowser.D)
        {
            AdColonyBrowser.y = true;
            AdColonyBrowser.z = false;
            a.s.setVisibility(0);
        }
        a.u.invalidate();
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        bl.d.a("Error viewing URL: ").b(s);
        a.finish();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s.startsWith("market://") || s.startsWith("amzn://"))
        {
            webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
            if (ak.B != null)
            {
                ak.B.startActivity(webview);
            }
            return true;
        } else
        {
            return false;
        }
    }

    (AdColonyBrowser adcolonybrowser)
    {
        a = adcolonybrowser;
        super();
    }
}
