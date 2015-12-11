// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.ProgressDialog;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.l;

// Referenced classes of package com.appnexus.opensdk:
//            m

final class c extends WebViewClient
{

    final m a;
    final c b;
    private boolean c;

    public final void onPageFinished(WebView webview, String s)
    {
        com.appnexus.opensdk.b.b.a(b.j, (new StringBuilder("Opening URL: ")).append(s).toString());
        l.a(b);
        if (m.j(b.b) != null)
        {
            m.j(b.b).dismiss();
        }
        if (c)
        {
            c = false;
            return;
        } else
        {
            b.tVisibility(0);
            m.a(b.b, b);
            return;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        com.appnexus.opensdk.b.b.a(b.j, (new StringBuilder("Redirecting to URL: ")).append(s).toString());
        c = com.appnexus.opensdk.m.b(b.b, s);
        if (c && m.j(b.b) != null)
        {
            m.j(b.b).dismiss();
        }
        return c;
    }

    t(t t, m m1)
    {
        b = t;
        a = m1;
        super();
        c = false;
    }
}
