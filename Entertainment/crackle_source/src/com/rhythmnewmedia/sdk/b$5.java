// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            b, i

final class b extends WebViewClient
{

    final b a;
    private boolean b;

    public final void onPageFinished(WebView webview, String s)
    {
        a.a(webview);
        a.j = false;
        b = false;
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (!b && a.j)
        {
            boolean flag;
            if (a.a(s).a == l)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                webview.stopLoading();
                webview.loadUrl("about:blank");
                b = true;
            }
        }
        if (!b)
        {
            a.e();
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (!a.j)
        {
            flag = flag1;
            if (a.a(s).a != l)
            {
                flag = true;
            }
        }
        return flag;
    }

    t(b b1)
    {
        a = b1;
        super();
        b = false;
    }
}
