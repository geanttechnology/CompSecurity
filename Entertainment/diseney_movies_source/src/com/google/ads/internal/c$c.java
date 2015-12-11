// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.webkit.WebView;
import com.google.ads.l;
import com.google.ads.n;

// Referenced classes of package com.google.ads.internal:
//            c, d, AdWebView, ActivationOverlay

private class c
    implements Runnable
{

    final c a;
    private final String b;
    private final String c;
    private final WebView d;

    public void run()
    {
        com.google.ads.internal.c.b(a).c.a(Boolean.valueOf(com.google.ads.internal.c.a(a)));
        ((d)((n)com.google.ads.internal.c.b(a).a.a()).b.a()).l().a(com.google.ads.internal.c.a(a));
        if (((n)com.google.ads.internal.c.b(a).a.a()).e.a() != null)
        {
            ActivationOverlay activationoverlay = (ActivationOverlay)((n)com.google.ads.internal.c.b(a).a.a()).e.a();
            boolean flag;
            if (!com.google.ads.internal.c.a(a))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            activationoverlay.setOverlayEnabled(flag);
        }
        if (c != null)
        {
            d.loadDataWithBaseURL(b, c, "text/html", "utf-8", null);
            return;
        } else
        {
            d.loadUrl(b);
            return;
        }
    }

    public vationOverlay(c c1, WebView webview, String s, String s1)
    {
        a = c1;
        super();
        d = webview;
        b = s;
        c = s1;
    }
}
