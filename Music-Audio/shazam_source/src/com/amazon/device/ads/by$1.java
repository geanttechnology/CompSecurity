// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.amazon.device.ads:
//            by, cn, dq, dz

final class t extends WebViewClient
{

    final by a;

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        by.a(a).c("InApp Browser error: %s", new Object[] {
            s
        });
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (!dq.b(s))
        {
            by.b(a);
            webview = dz.b(s);
            if (!webview.equals("http") && !webview.equals("https"))
            {
                by.b(a);
                return dz.a(s, by.c(a));
            }
        }
        return false;
    }

    t(by by1)
    {
        a = by1;
        super();
    }
}
