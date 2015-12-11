// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.a.b.j;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.f.h;

// Referenced classes of package com.facebook.ads.a.g:
//            b

public final class com.facebook.ads.a.g.a extends com.facebook.ads.a.g.b
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(int i);

        public abstract void a(String s);
    }

    private final class b extends WebViewClient
    {

        final com.facebook.ads.a.g.a a;

        public final void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            if (g.a())
            {
                sslerrorhandler.proceed();
                return;
            } else
            {
                sslerrorhandler.cancel();
                return;
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            com.facebook.ads.a.g.a.a(a).a(s);
            return true;
        }

        private b()
        {
            a = com.facebook.ads.a.g.a.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    public class c
    {

        final com.facebook.ads.a.g.a a;
        private final String b = com/facebook/ads/a/g/a$c.getSimpleName();

        public c()
        {
            a = com.facebook.ads.a.g.a.this;
            super();
        }
    }


    private final a b;
    private j c;

    public com.facebook.ads.a.g.a(Context context, a a1, int i)
    {
        super(context);
        b = a1;
        setWebViewClient(new b((byte)0));
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(false);
        h.b(this);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        addJavascriptInterface(new c(), "AdControl");
        c = new j(getContext(), this, i, new com.facebook.ads.a.b.j.a(a1) {

            final a a;
            final com.facebook.ads.a.g.a b;

            public final void a()
            {
                a.a();
            }

            
            {
                b = com.facebook.ads.a.g.a.this;
                a = a2;
                super();
            }
        });
    }

    static a a(com.facebook.ads.a.g.a a1)
    {
        return a1.b;
    }

    public final void a(int i, int k)
    {
        c.a = i;
        c.b = k;
    }

    public final void destroy()
    {
        if (c != null)
        {
            c.b();
            c = null;
        }
        h.a(this);
        super.destroy();
    }

    protected final void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        if (b != null)
        {
            b.a(i);
        }
        if (i == 0)
        {
            if (c != null)
            {
                c.a();
            }
        } else
        if (i == 8 && c != null)
        {
            c.b();
            return;
        }
    }
}
