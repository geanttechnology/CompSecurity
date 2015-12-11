// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            ea, eb, co, cm, 
//            dn, aw, cf, ds, 
//            at, bg, cn, dq, 
//            dz

class by
    implements AdActivity.b
{
    public static class a
    {

        private static final String f = com/amazon/device/ads/by$a.getSimpleName();
        final cn a;
        final aw b;
        Context c;
        String d;
        boolean e;


        public a()
        {
            aw aw1 = aw.a();
            new co();
            this(aw1);
        }

        private a(aw aw1)
        {
            b = aw1;
            a = co.a(f);
        }
    }

    final class b extends ds.f
    {

        final by a;
        private final ViewGroup b;
        private final int c;
        private final int d;
        private final Intent e;

        protected final Object doInBackground(Object aobj[])
        {
            by.a(a, by.a(a, by.e(a).a("amazon_ads_leftarrow.png"), 9, -1, c, d));
            by.f(a).setContentDescription("inAppBrowserBackButton");
            by.f(a).setId(10537);
            by.b(a, by.a(a, by.e(a).a("amazon_ads_rightarrow.png"), 1, by.f(a).getId(), c, d));
            by.g(a).setContentDescription("inAppBrowserForwardButton");
            by.g(a).setId(10794);
            by.c(a, by.a(a, by.e(a).a("amazon_ads_close.png"), 11, -1, c, d));
            by.h(a).setContentDescription("inAppBrowserCloseButton");
            if (by.i(a))
            {
                by.d(a, by.a(a, by.e(a).a("amazon_ads_open_external_browser.png"), 1, by.g(a).getId(), c, d));
                by.j(a).setContentDescription("inAppBrowserOpenExternalBrowserButton");
                by.j(a).setId(10795);
                by.e(a, by.a(a, by.e(a).a("amazon_ads_refresh.png"), 1, by.j(a).getId(), c, d));
            } else
            {
                by.e(a, by.a(a, by.e(a).a("amazon_ads_refresh.png"), 1, by.g(a).getId(), c, d));
            }
            by.k(a).setContentDescription("inAppBrowserRefreshButton");
            return null;
        }

        protected final void onPostExecute(Object obj)
        {
            b.addView(by.f(a));
            b.addView(by.g(a));
            b.addView(by.k(a));
            b.addView(by.h(a));
            if (by.i(a))
            {
                b.addView(by.j(a));
            }
            by.a(a, e);
            by.l(a).set(true);
        }

        public b(Intent intent, ViewGroup viewgroup, int i1, int j1)
        {
            a = by.this;
            super();
            e = intent;
            b = viewgroup;
            c = i1;
            d = j1;
        }
    }


    protected static final String a = com/amazon/device/ads/by.getSimpleName();
    private final ea b;
    private final eb c;
    private WebView d;
    private ImageButton e;
    private ImageButton f;
    private ImageButton g;
    private ImageButton h;
    private ImageButton i;
    private final AtomicBoolean j;
    private Activity k;
    private boolean l;
    private final cn m;
    private final cm n;
    private final dn o;
    private final aw p;
    private final cf q;
    private final eb.a r;
    private final ds.k s;

    by()
    {
        ea ea1 = new ea();
        eb eb1 = eb.a();
        new co();
        this(ea1, eb1, cm.a(), dn.a(), aw.a(), new cf(), new eb.a(), ds.a());
    }

    private by(ea ea1, eb eb1, cm cm1, dn dn1, aw aw1, cf cf1, eb.a a1, 
            ds.k k1)
    {
        j = new AtomicBoolean(false);
        b = ea1;
        c = eb1;
        m = co.a(a);
        n = cm1;
        o = dn1;
        p = aw1;
        q = cf1;
        r = a1;
        s = k1;
    }

    static ImageButton a(by by1, ImageButton imagebutton)
    {
        by1.e = imagebutton;
        return imagebutton;
    }

    static ImageButton a(by by1, String s1, int i1, int j1, int k1, int l1)
    {
        by1 = new ImageButton(by1.k);
        by1.setImageBitmap(BitmapFactory.decodeFile(s1));
        s1 = new android.widget.RelativeLayout.LayoutParams(k1, l1);
        s1.addRule(i1, j1);
        s1.addRule(12);
        by1.setLayoutParams(s1);
        by1.setBackgroundColor(0);
        by1.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        return by1;
    }

    static cn a(by by1)
    {
        return by1.m;
    }

    private void a(DisplayMetrics displaymetrics)
    {
        ((WindowManager)k.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
    }

    static void a(by by1, Intent intent)
    {
        by1.e.setOnClickListener(by1. new android.view.View.OnClickListener() {

            final by a;

            public final void onClick(View view)
            {
                if (by.d(a).canGoBack())
                {
                    by.d(a).goBack();
                }
            }

            
            {
                a = by.this;
                super();
            }
        });
        by1.f.setOnClickListener(by1. new android.view.View.OnClickListener() {

            final by a;

            public final void onClick(View view)
            {
                if (by.d(a).canGoForward())
                {
                    by.d(a).goForward();
                }
            }

            
            {
                a = by.this;
                super();
            }
        });
        by1.g.setOnClickListener(by1. new android.view.View.OnClickListener() {

            final by a;

            public final void onClick(View view)
            {
                by.d(a).reload();
            }

            
            {
                a = by.this;
                super();
            }
        });
        by1.h.setOnClickListener(by1. new android.view.View.OnClickListener() {

            final by a;

            public final void onClick(View view)
            {
                by.c(a).finish();
            }

            
            {
                a = by.this;
                super();
            }
        });
        if (by1.l)
        {
            intent = intent.getStringExtra("extra_url");
            by1.i.setOnClickListener(by1. new android.view.View.OnClickListener(intent) {

                final String a;
                final by b;

                public final void onClick(View view)
                {
                    String s1 = by.d(b).getUrl();
                    view = s1;
                    if (s1 == null)
                    {
                        by.a(b).c("The current URL is null. Reverting to the original URL for external browser.", null);
                        view = a;
                    }
                    by.b(b);
                    dz.a(view, by.d(b).getContext());
                }

            
            {
                b = by.this;
                a = s1;
                super();
            }
            });
        }
    }

    static void a(by by1, WebView webview)
    {
label0:
        {
            if (by1.e != null && by1.f != null)
            {
                if (webview.canGoBack())
                {
                    at.a(by1.e, 255);
                } else
                {
                    at.a(by1.e, 102);
                }
                if (!webview.canGoForward())
                {
                    break label0;
                }
                at.a(by1.f, 255);
            }
            return;
        }
        at.a(by1.f, 102);
    }

    static ImageButton b(by by1, ImageButton imagebutton)
    {
        by1.f = imagebutton;
        return imagebutton;
    }

    static ea b(by by1)
    {
        return by1.b;
    }

    static Activity c(by by1)
    {
        return by1.k;
    }

    static ImageButton c(by by1, ImageButton imagebutton)
    {
        by1.h = imagebutton;
        return imagebutton;
    }

    static WebView d(by by1)
    {
        return by1.d;
    }

    static ImageButton d(by by1, ImageButton imagebutton)
    {
        by1.i = imagebutton;
        return imagebutton;
    }

    static ImageButton e(by by1, ImageButton imagebutton)
    {
        by1.g = imagebutton;
        return imagebutton;
    }

    static aw e(by by1)
    {
        return by1.p;
    }

    static ImageButton f(by by1)
    {
        return by1.e;
    }

    static ImageButton g(by by1)
    {
        return by1.f;
    }

    static ImageButton h(by by1)
    {
        return by1.h;
    }

    private boolean h()
    {
        return o.a("shouldPauseWebViewTimersInWebViewRelatedActivities", false);
    }

    static boolean i(by by1)
    {
        return by1.l;
    }

    static ImageButton j(by by1)
    {
        return by1.i;
    }

    static ImageButton k(by by1)
    {
        return by1.g;
    }

    static AtomicBoolean l(by by1)
    {
        return by1.j;
    }

    public final void a()
    {
    }

    public final void a(Activity activity)
    {
        k = activity;
    }

    public final void b()
    {
        k.getWindow().requestFeature(2);
        k.getWindow().setFeatureInt(2, -1);
        Intent intent = k.getIntent();
        l = intent.getBooleanExtra("extra_open_btn", false);
        Object obj = new DisplayMetrics();
        a(((DisplayMetrics) (obj)));
        float f1 = ((DisplayMetrics) (obj)).density;
        int j1 = (int)(50F * f1 + 0.5F);
        int k1 = (int)(f1 * 3F + 0.5F);
        Object obj1;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        int i1;
        if (l)
        {
            i1 = 5;
        } else
        {
            i1 = 4;
        }
        i1 = Math.min(((DisplayMetrics) (obj)).widthPixels / i1, j1 * 2);
        obj = cf.a(k, cf.a.a, "inAppBrowserButtonLayout");
        ((ViewGroup) (obj)).setId(10280);
        obj1 = new android.widget.RelativeLayout.LayoutParams(-1, j1 + k1);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((ViewGroup) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((ViewGroup) (obj)).setBackgroundColor(0xfff0f0f0);
        s.a(new b(intent, ((ViewGroup) (obj)), i1, j1), new Void[0]);
        obj1 = new View(k);
        ((View) (obj1)).setContentDescription("inAppBrowserHorizontalRule");
        ((View) (obj1)).setBackgroundColor(0xffcccccc);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, k1);
        layoutparams.addRule(10);
        ((View) (obj1)).setLayoutParams(layoutparams);
        ((ViewGroup) (obj)).addView(((View) (obj1)));
        d = c.a(k);
        d.getSettings().setUserAgentString((new StringBuilder()).append(n.b.i()).append("-inAppBrowser").toString());
        d.setContentDescription("inAppBrowserWebView");
        obj1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(2, ((ViewGroup) (obj)).getId());
        d.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        obj1 = cf.a(k, cf.a.a, "inAppBrowserRelativeLayout");
        ((ViewGroup) (obj1)).setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
        ((ViewGroup) (obj1)).addView(d);
        ((ViewGroup) (obj1)).addView(((View) (obj)));
        obj = (LinearLayout)cf.a(k, cf.a.b, "inAppBrowserMainLayout");
        ((LinearLayout) (obj)).setOrientation(1);
        ((LinearLayout) (obj)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        ((LinearLayout) (obj)).addView(((View) (obj1)));
        k.setContentView(((View) (obj)));
        eb.a(d, a);
        d.loadUrl(intent.getStringExtra("extra_url"));
        d.setWebViewClient(new WebViewClient() {

            final by a;

            public final void onReceivedError(WebView webview, int l1, String s1, String s2)
            {
                by.a(a).c("InApp Browser error: %s", new Object[] {
                    s1
                });
            }

            public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
            {
                if (!dq.b(s1))
                {
                    by.b(a);
                    webview = dz.b(s1);
                    if (!webview.equals("http") && !webview.equals("https"))
                    {
                        by.b(a);
                        return dz.a(s1, by.c(a));
                    }
                }
                return false;
            }

            
            {
                a = by.this;
                super();
            }
        });
        d.setWebChromeClient(new WebChromeClient() {

            final by a;

            public final void onProgressChanged(WebView webview, int l1)
            {
                Activity activity = (Activity)webview.getContext();
                activity.setTitle("Loading...");
                activity.setProgress(l1 * 100);
                if (l1 == 100)
                {
                    activity.setTitle(webview.getUrl());
                }
                by.a(a, webview);
            }

            
            {
                a = by.this;
                super();
            }
        });
        r.a(k);
        CookieSyncManager.getInstance().startSync();
    }

    public final void c()
    {
        m.b("onPause", null);
        d.onPause();
        boolean flag;
        if (d != null && h())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            d.pauseTimers();
        }
        CookieSyncManager.getInstance().stopSync();
    }

    public final void d()
    {
        m.b("onResume", null);
        d.onResume();
        boolean flag;
        if (d != null && h())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            d.resumeTimers();
        }
        CookieSyncManager.getInstance().startSync();
    }

    public final void e()
    {
    }

    public final void f()
    {
        Object obj = new DisplayMetrics();
        a(((DisplayMetrics) (obj)));
        int j1 = (int)(((DisplayMetrics) (obj)).density * 50F + 0.5F);
        int i1;
        if (l)
        {
            i1 = 5;
        } else
        {
            i1 = 4;
        }
        i1 = Math.min(((DisplayMetrics) (obj)).widthPixels / i1, j1 * 2);
        m.b((new StringBuilder("Width: ")).append(((DisplayMetrics) (obj)).widthPixels).append(" ButtonWidth: ").append(i1).toString(), null);
        obj = new android.widget.RelativeLayout.LayoutParams(i1, j1);
        if (e != null)
        {
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
            e.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        }
        if (f != null)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(i1, j1);
            layoutparams.addRule(1, e.getId());
            layoutparams.addRule(12);
            f.setLayoutParams(layoutparams);
        }
        if (h != null)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(i1, j1);
            layoutparams1.addRule(11);
            layoutparams1.addRule(12);
            h.setLayoutParams(layoutparams1);
        }
        if (i != null)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(i1, j1);
            layoutparams2.addRule(1, f.getId());
            layoutparams2.addRule(12);
            i.setLayoutParams(layoutparams2);
            if (g != null)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams3 = new android.widget.RelativeLayout.LayoutParams(i1, j1);
                layoutparams3.addRule(1, i.getId());
                layoutparams3.addRule(12);
                g.setLayoutParams(layoutparams3);
            }
        } else
        if (g != null)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams4 = new android.widget.RelativeLayout.LayoutParams(i1, j1);
            layoutparams4.addRule(1, f.getId());
            layoutparams4.addRule(12);
            g.setLayoutParams(layoutparams4);
            return;
        }
    }

    public final boolean g()
    {
        return false;
    }

}
