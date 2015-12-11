// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.flurry.android:
//            cf, h

final class db extends WebViewClient
{

    private cf bR;

    db(cf cf1)
    {
        this(cf1, (byte)0);
    }

    private db(cf cf1, byte byte0)
    {
        bR = cf1;
        super();
    }

    public final void onPageFinished(WebView webview, String s)
    {
        (new StringBuilder()).append("onPageFinished: url = ").append(s).toString();
        if (s == null || webview == null || webview != cf.a(bR))
        {
            return;
        } else
        {
            cf.a(bR, false);
            return;
        }
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        (new StringBuilder()).append("onPageStarted: url = ").append(s).toString();
        if (s == null || webview == null || webview != cf.a(bR))
        {
            return;
        }
        if (cf.c(bR))
        {
            boolean flag = false;
            if (cf.b(bR) != null)
            {
                flag = cf.b(bR).a(bR, s, cf.c(bR));
            }
            if (flag)
            {
                webview.stopLoading();
            }
        }
        cf.a(bR, true);
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        (new StringBuilder()).append("shouldOverrideUrlLoading: url = ").append(s).toString();
        if (s == null || webview == null || webview != cf.a(bR))
        {
            return false;
        }
        boolean flag;
        if (cf.b(bR) != null)
        {
            flag = cf.b(bR).a(bR, s, cf.c(bR));
        } else
        {
            flag = false;
        }
        cf.a(bR, false);
        return flag;
    }
}
