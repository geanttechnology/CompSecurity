// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities.do;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import io.presage.activities.PresageActivity;
import io.presage.ads.d;
import io.presage.formats.a;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.activities.do:
//            a, b

public final class e extends io.presage.activities.do.a
{
    final class a extends WebChromeClient
    {

        final e a;

        public final void onConsoleMessage(String s, int j, String s1)
        {
            io.presage.utils.e.a(new String[] {
                "PresageActivity", s, "-- From line", Integer.toString(j), "of", s1
            });
        }

        public a()
        {
            a = e.this;
            super();
        }
    }

    public final class b
    {

        final e a;
        private io.presage.formats.a b;
        private io.presage.do.e c;

        public final String param(String s)
        {
            return (new Gson()).toJson(c.a(s));
        }

        public final void sendAction(String s)
        {
            io.presage.utils.e.b(new String[] {
                "PresageActivity", "sendAction:", s
            });
            if (s.equals("close") || s.equals("cancel"))
            {
                a.a(s);
                if (s.equals("close"))
                {
                    b.a().b("home");
                }
            }
            b.a().b(s);
        }

        public final String stringParam(String s)
        {
            return c.a(s).toString();
        }

        public b(d d1)
        {
            a = e.this;
            super();
            b = d1.d();
            c = d1.d().g();
        }
    }


    private WebView c;
    private String d;
    private FrameLayout e;
    private android.widget.FrameLayout.LayoutParams f;

    public e(c.a a1, PresageActivity presageactivity, io.presage.activities.do.b b1, d d1)
    {
        super(a1, presageactivity, b1, d1);
        if (d1.d() != null)
        {
            d = (String)d1.d().a("webview_url");
        }
    }

    public final void c()
    {
        super.c();
        if (c != null)
        {
            c.loadUrl("about:blank");
            c.destroy();
            c = null;
        }
    }

    public final FrameLayout g()
    {
        return e;
    }

    public final android.widget.FrameLayout.LayoutParams h()
    {
        return f;
    }

    public final void i()
    {
        e = new FrameLayout(f());
        e.setBackgroundColor(0);
        f = new android.widget.FrameLayout.LayoutParams(-1, -1);
        f.setMargins(0, 0, 0, 0);
        c = new WebView(f());
        CookieSyncManager.createInstance(f());
        CookieManager.getInstance().removeAllCookie();
        c.setBackgroundColor(0);
        c.clearHistory();
        c.clearCache(true);
        c.clearAnimation();
        c.resumeTimers();
        c.getSettings().setJavaScriptEnabled(true);
        WebView webview = c;
        f();
        webview.addJavascriptInterface(new b(e()), "Presage");
        c.setWebChromeClient(new a());
        c.setWebViewClient(new WebViewClient());
        c.setVerticalScrollBarEnabled(false);
        c.setHorizontalScrollBarEnabled(false);
        c.loadUrl(d);
        e.addView(c);
        b.a("shown");
        c.setBackgroundResource(0x106000d);
        c.setTag("webview");
    }
}
