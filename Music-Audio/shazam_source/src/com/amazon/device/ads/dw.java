// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            eb, at, co, ds, 
//            cn, cx

class dw
{
    private final class a extends WebChromeClient
    {

        final dw a;

        public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
        {
            dw.a(a).b(s1, null);
            return false;
        }

        private a()
        {
            a = dw.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    private final class b extends WebViewClient
    {

        final dw a;
        private final cx b;

        public final void onPageFinished(WebView webview, String s)
        {
            if (b != null)
            {
                b.a(s);
            }
        }

        public b(cx cx1)
        {
            a = dw.this;
            super();
            b = cx1;
        }
    }


    private static final String m = com/amazon/device/ads/dw.getSimpleName();
    final ViewGroup a;
    final eb b;
    WebViewClient c;
    WebView d;
    WebView e;
    WebView f;
    int g;
    int h;
    int i;
    boolean j;
    final Set k;
    final cn l;
    private final at.a n;
    private android.view.View.OnKeyListener o;

    public dw(ViewGroup viewgroup)
    {
        this(viewgroup, eb.a(), at.a());
    }

    private dw(ViewGroup viewgroup, eb eb1, at.a a1)
    {
        g = -1;
        h = -1;
        i = 17;
        j = false;
        k = new HashSet();
        new co();
        l = co.a(m);
        a = viewgroup;
        b = eb1;
        n = a1;
    }

    static Context a(View view)
    {
        return view.getContext();
    }

    static cn a(dw dw1)
    {
        return dw1.l;
    }

    final WebView a(Context context)
    {
        WebView webview = b.a(context);
        if (!eb.a(webview, m))
        {
            context = null;
        } else
        {
            context = webview.getSettings();
            at.a.a a1 = new at.a.a(n, context);
            if (at.a(a1.b.a, 17))
            {
                a1.a.setMediaPlaybackRequiresUserGesture(false);
            }
            webview.setScrollContainer(false);
            webview.setBackgroundColor(0);
            webview.setVerticalScrollBarEnabled(false);
            webview.setHorizontalScrollBarEnabled(false);
            webview.setWebChromeClient(new a((byte)0));
            context.setDomStorageEnabled(true);
            context = webview;
            if (j)
            {
                at.a(webview);
                return webview;
            }
        }
        return context;
    }

    public final void a(android.view.View.OnKeyListener onkeylistener)
    {
        o = onkeylistener;
        b().requestFocus();
        b().setOnKeyListener(o);
    }

    final void a(WebView webview, boolean flag)
    {
        WebView webview1 = d;
        if (webview1 != null)
        {
            webview1.setOnKeyListener(null);
            webview1.setWebViewClient(new WebViewClient());
            a.removeView(webview1);
            if (flag)
            {
                a(new WebView[] {
                    webview1
                });
            }
        }
        webview.setWebViewClient(c);
        d = webview;
        c();
        webview = d;
        a.addView(webview);
        if (o != null)
        {
            a(o);
        }
    }

    final transient void a(WebView awebview[])
    {
        ds.c(new Runnable(awebview) {

            final WebView a[];
            final dw b;

            public final void run()
            {
                WebView awebview1[] = a;
                int j1 = awebview1.length;
                int i1 = 0;
                while (i1 < j1) 
                {
                    WebView webview = awebview1[i1];
                    if (webview != null)
                    {
                        if (webview.getParent() != null)
                        {
                            ((ViewGroup)webview.getParent()).removeView(webview);
                        }
                        try
                        {
                            webview.destroy();
                        }
                        catch (IllegalArgumentException illegalargumentexception)
                        {
                            dw.a(b).c("Caught an IllegalArgumentException while destroying a WebView: %s", new Object[] {
                                illegalargumentexception.getMessage()
                            });
                        }
                    }
                    i1++;
                }
            }

            
            {
                b = dw.this;
                a = awebview;
                super();
            }
        });
    }

    final boolean a()
    {
        return d != null;
    }

    final WebView b()
    {
        if (d == null)
        {
            WebView webview = a(a.getContext());
            boolean flag;
            if (webview != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                throw new IllegalStateException("Could not create WebView");
            }
            webview.setContentDescription("originalWebView");
            a(webview, false);
        }
        return d;
    }

    final void c()
    {
        if (a())
        {
            WebView webview = b();
            int i1 = h;
            int j1 = g;
            int k1 = i;
            if (webview.getLayoutParams() == null)
            {
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(i1, j1);
                layoutparams.gravity = k1;
                webview.setLayoutParams(layoutparams);
            } else
            {
                webview.getLayoutParams().width = i1;
                webview.getLayoutParams().height = j1;
                if (webview.getLayoutParams() instanceof android.widget.FrameLayout.LayoutParams)
                {
                    ((android.widget.FrameLayout.LayoutParams)webview.getLayoutParams()).gravity = k1;
                    return;
                }
            }
        }
    }

    final WebView d()
    {
        if (f == null)
        {
            f = a(a.getContext());
            f.setContentDescription("preloadedWebView");
        }
        return f;
    }

}
