// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.presage.utils.e;

public final class h extends WebViewClient
{
    public static interface a
    {

        public abstract void a(WebView webview, String s);
    }

    public static interface b
    {

        public abstract void a(WebView webview, String s);
    }


    private b a;
    private a b;

    public h()
    {
    }

    public final void a(a a1)
    {
        b = a1;
    }

    public final void a(b b1)
    {
        a = b1;
    }

    public final void onPageFinished(WebView webview, String s)
    {
        e.b(new String[] {
            "Page finished to be loaded:", s
        });
        super.onPageFinished(webview, s);
        if (a != null)
        {
            a.a(webview, s);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        String s1 = Uri.parse(s).getScheme();
        boolean flag;
        if (s1 != null && !s1.equals("http") && !s1.equals("https"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && b != null)
        {
            b.a(webview, s);
        }
        return flag;
    }
}
