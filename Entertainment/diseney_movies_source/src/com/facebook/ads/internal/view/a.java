// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.adapters.d;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.h;

// Referenced classes of package com.facebook.ads.internal.view:
//            d

public class com.facebook.ads.internal.view.a extends com.facebook.ads.internal.view.d
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(int i);

        public abstract void a(String s);

        public abstract void b();
    }

    private class b extends WebViewClient
    {

        final com.facebook.ads.internal.view.a a;

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
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

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            com.facebook.ads.internal.view.a.a(a).a(s);
            return true;
        }

        private b()
        {
            a = com.facebook.ads.internal.view.a.this;
            super();
        }

    }

    public class c
    {

        final com.facebook.ads.internal.view.a a;
        private final String b = com/facebook/ads/internal/view/a$c.getSimpleName();

        public void alert(String s)
        {
            Log.e(b, s);
        }

        public String getAnalogInfo()
        {
            return g.a(com.facebook.ads.internal.util.a.a());
        }

        public void onPageInitialized()
        {
            if (!a.b())
            {
                com.facebook.ads.internal.view.a.a(a).a();
                if (com.facebook.ads.internal.view.a.b(a) != null)
                {
                    com.facebook.ads.internal.view.a.b(a).a();
                    return;
                }
            }
        }

        public c()
        {
            a = com.facebook.ads.internal.view.a.this;
            super();
        }
    }


    private final a a;
    private d b;

    public com.facebook.ads.internal.view.a(Context context, a a1, int i)
    {
        super(context);
        a = a1;
        setWebViewClient(new b());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(false);
        h.b(this);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        addJavascriptInterface(new c(), "AdControl");
        b = new d(getContext(), this, i, new com.facebook.ads.internal.adapters.d.a(a1) {

            final a a;
            final com.facebook.ads.internal.view.a b;

            public void a()
            {
                a.b();
            }

            
            {
                b = com.facebook.ads.internal.view.a.this;
                a = a2;
                super();
            }
        });
    }

    static a a(com.facebook.ads.internal.view.a a1)
    {
        return a1.a;
    }

    static d b(com.facebook.ads.internal.view.a a1)
    {
        return a1.b;
    }

    public void a(int i, int j)
    {
        b.a(i);
        b.b(j);
    }

    public void destroy()
    {
        if (b != null)
        {
            b.b();
            b = null;
        }
        h.a(this);
        super.destroy();
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        if (a != null)
        {
            a.a(i);
        }
        if (i == 0)
        {
            if (b != null)
            {
                b.a();
            }
        } else
        if (i == 8 && b != null)
        {
            b.b();
            return;
        }
    }
}
