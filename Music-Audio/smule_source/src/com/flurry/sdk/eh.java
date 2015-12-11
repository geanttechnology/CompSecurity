// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            ec, i, n, hn, 
//            el, cv, ap, dr, 
//            ds, dq, cu, aw, 
//            co, r

public final class eh extends ec
{

    private final String a = getClass().getSimpleName();
    private WebView b;
    private WebViewClient c;
    private WebChromeClient d;
    private boolean e;
    private dq f;
    private ImageButton g;
    private ImageButton h;
    private ImageButton i;
    private ProgressBar j;
    private LinearLayout k;
    private boolean l;
    private ec.a m;

    public eh(Context context, String s, r r, ec.a a1, boolean flag)
    {
        super(context, r, a1);
        m = new ec.a() {

            final eh a;

            public void a()
            {
                if (eh.f(a) != null)
                {
                    a.d();
                    a.removeView(eh.f(a));
                    eh.a(a, null);
                }
            }

            public void b()
            {
                if (eh.f(a) != null)
                {
                    a.d();
                    a.removeView(eh.f(a));
                    eh.a(a, null);
                }
            }

            public void c()
            {
                if (eh.f(a) != null)
                {
                    a.d();
                    a.removeView(eh.f(a));
                    eh.a(a, null);
                }
            }

            
            {
                a = eh.this;
                super();
            }
        };
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        k = new LinearLayout(context);
        k.setOrientation(1);
        r = new android.widget.LinearLayout.LayoutParams(-1, -1);
        k.setLayoutParams(r);
        b = new WebView(context);
        c = new b();
        d = new a();
        b.getSettings().setJavaScriptEnabled(true);
        b.getSettings().setUseWideViewPort(true);
        b.getSettings().setLoadWithOverviewMode(true);
        b.getSettings().setBuiltInZoomControls(true);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            b.getSettings().setDisplayZoomControls(false);
        }
        b.setWebViewClient(c);
        b.setWebChromeClient(d);
        b.setPadding(5, 5, 5, 5);
        r = new android.widget.LinearLayout.LayoutParams(-1, -1);
        a1 = com.flurry.sdk.i.a().h().d();
        if (flag && !TextUtils.isEmpty(a1))
        {
            HashMap hashmap = new HashMap();
            hashmap.put("Cookie", a1);
            b.loadUrl(s, hashmap);
        } else
        {
            b.loadUrl(s);
        }
        j = new ProgressBar(context, null, 0x1010078);
        j.setMax(100);
        j.setProgress(0);
        s = new android.widget.RelativeLayout.LayoutParams(-1, hn.b(3));
        j.setLayoutParams(s);
        g = new ImageButton(context);
        g.setPadding(5, 0, 5, 0);
        g.setImageBitmap(el.a());
        g.setBackgroundColor(getResources().getColor(0x106000d));
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final eh a;

            public void onClick(View view)
            {
                a.a(c.c);
            }

            
            {
                a = eh.this;
                super();
            }

            private class c extends Enum
            {

                public static final c a;
                public static final c b;
                public static final c c;
                private static final c d[];

                public static c valueOf(String s)
                {
                    return (c)Enum.valueOf(com/flurry/sdk/eh$c, s);
                }

                public static c[] values()
                {
                    return (c[])d.clone();
                }

                static 
                {
                    a = new c("WEB_RESULT_UNKNOWN", 0);
                    b = new c("WEB_RESULT_BACK", 1);
                    c = new c("WEB_RESULT_CLOSE", 2);
                    d = (new c[] {
                        a, b, c
                    });
                }

                private c(String s, int i1)
                {
                    super(s, i1);
                }
            }

        });
        h = new ImageButton(context);
        h.setId(1);
        h.setPadding(5, 0, 5, 0);
        h.setImageBitmap(el.b());
        h.setBackgroundColor(getResources().getColor(0x106000d));
        h.setVisibility(0);
        h.setOnClickListener(new android.view.View.OnClickListener() {

            final eh a;

            public void onClick(View view)
            {
                if (eh.b(a) != null && eh.b(a).canGoBack())
                {
                    eh.b(a).goBack();
                    return;
                } else
                {
                    a.a(c.b);
                    return;
                }
            }

            
            {
                a = eh.this;
                super();
            }
        });
        i = new ImageButton(context);
        i.setPadding(5, 0, 5, 0);
        i.setImageBitmap(el.c());
        i.setBackgroundColor(getResources().getColor(0x106000d));
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final eh a;

            public void onClick(View view)
            {
                if (eh.b(a) != null && eh.b(a).canGoForward())
                {
                    eh.b(a).goForward();
                }
            }

            
            {
                a = eh.this;
                super();
            }
        });
        context = new RelativeLayout(context);
        context.setBackgroundColor(getResources().getColor(0x1060000));
        context.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
        context.setPadding(10, 10, 10, 10);
        s = new android.widget.RelativeLayout.LayoutParams(hn.b(35), hn.b(35));
        s.addRule(11);
        s.addRule(13);
        s.setMargins(10, 10, 10, 10);
        context.addView(g, s);
        a1 = new android.widget.RelativeLayout.LayoutParams(hn.b(35), hn.b(35));
        a1.addRule(9);
        s.addRule(13);
        a1.addRule(0, i.getId());
        a1.setMargins(10, 10, 10, 10);
        context.addView(h, a1);
        a1 = new android.widget.RelativeLayout.LayoutParams(hn.b(35), hn.b(35));
        a1.addRule(1, h.getId());
        s.addRule(13);
        a1.setMargins(10, 10, 10, 10);
        context.addView(i, a1);
        showProgressDialog();
        context.setGravity(17);
        e();
        k.addView(context);
        k.addView(j);
        k.addView(b, r);
        setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        addView(k);
    }

    static dq a(eh eh1, dq dq1)
    {
        eh1.f = dq1;
        return dq1;
    }

    static String a(eh eh1)
    {
        return eh1.a;
    }

    static boolean a(eh eh1, boolean flag)
    {
        eh1.l = flag;
        return flag;
    }

    private boolean a(String s, String s1)
    {
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
        {
            if (!TextUtils.isEmpty(s1 = Uri.parse(s1).getQueryParameter("link")) && s1.equalsIgnoreCase(s))
            {
                return true;
            }
        }
        return false;
    }

    static WebView b(eh eh1)
    {
        return eh1.b;
    }

    static boolean b(eh eh1, boolean flag)
    {
        eh1.e = flag;
        return flag;
    }

    static boolean c(eh eh1)
    {
        return eh1.l;
    }

    static ProgressBar d(eh eh1)
    {
        return eh1.j;
    }

    private void e()
    {
        if (b.canGoForward())
        {
            i.setVisibility(0);
            return;
        } else
        {
            i.setVisibility(4);
            return;
        }
    }

    static void e(eh eh1)
    {
        eh1.e();
    }

    static dq f(eh eh1)
    {
        return eh1.f;
    }

    private void g()
    {
        onViewClose();
    }

    private void h()
    {
        onViewBack();
    }

    public void a(c c1)
    {
        if (c1.equals(c.c) || c1.equals(c.a))
        {
            g();
            return;
        } else
        {
            h();
            return;
        }
    }

    public boolean a()
    {
        return e || b != null && b.canGoBack();
    }

    public boolean a(String s, boolean flag)
    {
        if (cv.g(s))
        {
            if (cv.g(s))
            {
                if (getAdController().q())
                {
                    new dr();
                    f = dr.a(getContext(), ds.b, getAdObject(), m);
                } else
                {
                    new dr();
                    f = dr.a(getContext(), ds.c, getAdObject(), m);
                }
                f.initLayout();
                addView(f);
            }
            return true;
        }
        if (cv.d(s))
        {
            boolean flag1 = flag;
            if (!flag)
            {
                flag1 = a(s, getUrl());
            }
            cu.a(getContext(), s);
            if (flag1)
            {
                g();
            }
            co.a(aw.O, Collections.emptyMap(), getContext(), getAdObject(), getAdController(), 0);
            return true;
        }
        boolean flag2;
        if (cv.f(s))
        {
            boolean flag3 = cu.b(getContext(), s);
            flag2 = flag3;
            if (flag3)
            {
                flag2 = flag;
                if (!flag)
                {
                    flag2 = a(s, getUrl());
                }
                if (flag2)
                {
                    g();
                }
                co.a(aw.O, Collections.emptyMap(), getContext(), getAdObject(), getAdController(), 0);
                return flag3;
            }
        } else
        {
            boolean flag4 = cu.c(getContext(), s);
            flag2 = flag4;
            if (flag4)
            {
                flag2 = flag;
                if (!flag)
                {
                    flag2 = a(s, getUrl());
                }
                if (flag2)
                {
                    g();
                }
                co.a(aw.O, Collections.emptyMap(), getContext(), getAdObject(), getAdController(), 0);
                flag2 = flag4;
            }
        }
        return flag2;
    }

    public void b()
    {
        if (e)
        {
            d.onHideCustomView();
        } else
        if (b != null)
        {
            b.goBack();
            return;
        }
    }

    public void c()
    {
        if (b != null)
        {
            dismissProgressDialog();
            removeView(b);
            b.stopLoading();
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                b.onPause();
            }
            b.destroy();
            b = null;
        }
    }

    public void d()
    {
        setVisibility(0);
        if (f != null)
        {
            f.d();
        }
    }

    public String getUrl()
    {
        String s = null;
        if (b != null)
        {
            s = b.getUrl();
        }
        return s;
    }

    public void initLayout()
    {
        super.initLayout();
        setOrientation(4);
    }

    public void onActivityDestroy()
    {
        super.onActivityDestroy();
        c();
    }

    public void onActivityPause()
    {
        super.onActivityPause();
        if (b != null && android.os.Build.VERSION.SDK_INT >= 11)
        {
            b.onPause();
        }
    }

    public void onActivityResume()
    {
        super.onActivityResume();
        if (b != null && android.os.Build.VERSION.SDK_INT >= 11)
        {
            b.onResume();
        }
    }

    public boolean onBackKey()
    {
        if (a())
        {
            b();
        } else
        {
            a(c.b);
        }
        d();
        return true;
    }

    protected void onViewLoadTimeout()
    {
        co.a(aw.s, Collections.emptyMap(), getContext(), getAdObject(), getAdController(), 0);
    }

    private class b extends WebViewClient
    {

        final eh a;

        public void onPageFinished(WebView webview, String s)
        {
            gd.a(3, eh.a(a), (new StringBuilder()).append("onPageFinished: url = ").append(s).toString());
            if (s == null || webview == null || webview != eh.b(a))
            {
                return;
            } else
            {
                eh.d(a).setVisibility(8);
                eh.a(a, false);
                eh.e(a);
                return;
            }
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            gd.a(3, eh.a(a), (new StringBuilder()).append("onPageStarted: url = ").append(s).toString());
            if (s == null || webview == null || webview != eh.b(a))
            {
                return;
            }
            a.dismissProgressDialog();
            if (android.os.Build.VERSION.SDK_INT < 11 && eh.c(a) && a.a(s, eh.c(a)))
            {
                gd.a(3, eh.a(a), "onPageStarted: stopLoading is called");
                webview.stopLoading();
            }
            eh.d(a).setVisibility(0);
            eh.a(a, true);
            eh.e(a);
        }

        public void onReceivedError(WebView webview, int i1, String s, String s1)
        {
            gd.a(3, eh.a(a), (new StringBuilder()).append("onReceivedError: error = ").append(i1).append(" description= ").append(s).append(" failingUrl= ").append(s1).toString());
            super.onReceivedError(webview, i1, s, s1);
            webview.clearSslPreferences();
        }

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
            gd.a(3, eh.a(a), (new StringBuilder()).append("onReceivedSslError: error = ").append(sslerror.toString()).toString());
            webview.clearSslPreferences();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            gd.a(3, eh.a(a), (new StringBuilder()).append("shouldOverrideUrlLoading: url = ").append(s).toString());
            if (s == null || webview == null || webview != eh.b(a))
            {
                return false;
            } else
            {
                boolean flag = a.a(s, eh.c(a));
                eh.a(a, false);
                return flag;
            }
        }

        private b()
        {
            a = eh.this;
            super();
        }

    }


    private class a extends WebChromeClient
    {

        final eh a;

        public void onHideCustomView()
        {
            gd.a(3, eh.a(a), "onHideCustomView()");
            eh.b(a, false);
            eh.d(a).setVisibility(8);
            eh.e(a);
        }

        public void onProgressChanged(WebView webview, int i1)
        {
            eh.d(a).setProgress(i1);
            super.onProgressChanged(webview, i1);
            if (i1 == 100)
            {
                eh.d(a).setVisibility(8);
            }
        }

        public void onShowCustomView(View view, int i1, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            gd.a(3, eh.a(a), "onShowCustomView(14)");
            eh.b(a, true);
            eh.d(a).setVisibility(0);
            eh.e(a);
        }

        public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
            gd.a(3, eh.a(a), "onShowCustomView(7)");
            eh.b(a, true);
            eh.d(a).setVisibility(0);
            eh.e(a);
        }

        private a()
        {
            a = eh.this;
            super();
        }

    }

}
