// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view;

import android.content.Context;
import android.webkit.WebSettings;
import com.facebook.ads.internal.adapters.d;
import com.facebook.ads.internal.adapters.k;
import com.facebook.ads.internal.adapters.l;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.h;

// Referenced classes of package com.facebook.ads.internal.view:
//            d

public class c extends com.facebook.ads.internal.view.d
{

    private static final String a = com/facebook/ads/internal/view/c.getSimpleName();
    private final k b;
    private final int c;
    private final com.facebook.ads.internal.ssp.ANAdRenderer.Listener d;
    private l e;
    private d f;
    private long g;
    private com.facebook.ads.internal.util.b.a h;

    public c(Context context, k k1, int i, com.facebook.ads.internal.ssp.ANAdRenderer.Listener listener)
    {
        super(context);
        if (k1 == null || listener == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            b = k1;
            c = i;
            d = listener;
            c();
            return;
        }
    }

    static long a(c c1, long l1)
    {
        c1.g = l1;
        return l1;
    }

    static com.facebook.ads.internal.ssp.ANAdRenderer.Listener a(c c1)
    {
        return c1.d;
    }

    static com.facebook.ads.internal.util.b.a a(c c1, com.facebook.ads.internal.util.b.a a1)
    {
        c1.h = a1;
        return a1;
    }

    static String a()
    {
        return a;
    }

    static l b(c c1)
    {
        return c1.e;
    }

    private void c()
    {
        setWebViewClient(new a(null));
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(false);
        com.facebook.ads.internal.util.h.b(this);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        addJavascriptInterface(new b(null), "AdControl");
        e = new l(getContext(), this, new _cls1());
        e.a(b);
        f = new d(getContext(), this, c, new _cls2());
        f.a(b.j());
        f.b(b.k());
        f.a();
        loadDataWithBaseURL(com.facebook.ads.internal.util.h.a(), b.d(), "text/html", "utf-8", null);
    }

    static void c(c c1)
    {
        c1.d();
    }

    static d d(c c1)
    {
        return c1.f;
    }

    private void d()
    {
        e.c();
    }

    public void destroy()
    {
        if (f != null)
        {
            f.b();
            f = null;
        }
        com.facebook.ads.internal.util.h.a(this);
        super.destroy();
    }

    protected void onWindowVisibilityChanged(int i)
    {
        super.onWindowVisibilityChanged(i);
        if (i == 0)
        {
            if (g > 0L && h != null)
            {
                com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(g, h, b.i()));
                g = 0L;
                h = null;
            }
            if (f != null)
            {
                f.a();
            }
        } else
        if (i == 8 && f != null)
        {
            f.b();
            return;
        }
    }


    private class a extends WebViewClient
    {

        final c a;

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            if (com.facebook.ads.internal.util.g.a())
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
            webview = Uri.parse(s);
            if ("fbad".equals(webview.getScheme()) && "close".equals(webview.getAuthority()))
            {
                c.a(a).onAdClose();
            } else
            {
                c.a(a).onAdClick();
                webview = com.facebook.ads.internal.action.b.a(a.getContext(), webview);
                if (webview != null)
                {
                    try
                    {
                        c.a(a, webview.a());
                        c.a(a, System.currentTimeMillis());
                        webview.b();
                    }
                    // Misplaced declaration of an exception variable
                    catch (WebView webview)
                    {
                        Log.e(c.a(), "Error executing action", webview);
                        return true;
                    }
                    return true;
                }
            }
            return true;
        }

        private a()
        {
            a = c.this;
            super();
        }

        a(_cls1 _pcls1)
        {
            this();
        }
    }


    private class b
    {

        final c a;
        private final String b;

        public void alert(String s)
        {
            Log.e(b, s);
        }

        public String getAnalogInfo()
        {
            return com.facebook.ads.internal.util.g.a(com.facebook.ads.internal.util.a.a());
        }

        public void onPageInitialized()
        {
            if (!a.b())
            {
                c.c(a);
                if (com.facebook.ads.internal.view.c.d(a) != null)
                {
                    com.facebook.ads.internal.view.c.d(a).a();
                    return;
                }
            }
        }

        private b()
        {
            a = c.this;
            super();
            b = com/facebook/ads/internal/view/c$b.getSimpleName();
        }

        b(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls1 extends com.facebook.ads.internal.adapters.b
    {

        final c a;

        public void d()
        {
            c.a(a).onAdImpression();
        }

        _cls1()
        {
            a = c.this;
            super();
        }
    }


    private class _cls2 extends com.facebook.ads.internal.adapters.d.a
    {

        final c a;

        public void a()
        {
            com.facebook.ads.internal.view.c.b(a).a();
        }

        _cls2()
        {
            a = c.this;
            super();
        }
    }

}
