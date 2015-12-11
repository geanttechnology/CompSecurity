// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            c, q, aj, e

public class AdColonyBrowser extends Activity
{
    final class a extends View
    {

        Rect a;
        Paint b;
        final AdColonyBrowser c;

        private static boolean a(com.jirbo.adcolony.c c1, int i1, int j1)
        {
            return i1 < c1.e.left + c1.f + 16 && i1 > c1.e.left - 16 && j1 < c1.e.top + c1.g + 16 && j1 > c1.e.top - 16;
        }

        public final void a()
        {
            c.o = false;
            c.p = false;
            c.q = false;
            c.r = false;
            invalidate();
        }

        public final void onDraw(Canvas canvas)
        {
            getDrawingRect(a);
            int i1 = (c.m.getHeight() - c.d.g) / 2;
            if (!AdColonyBrowser.w)
            {
                c.d.a(canvas, c.d.f, i1);
            } else
            {
                c.k.a(canvas, c.d.f, i1);
            }
            if (!AdColonyBrowser.x)
            {
                c.g.a(canvas, c.d.e.left + c.m.getWidth() / 10 + c.d.f, i1);
            } else
            {
                c.l.a(canvas, c.d.e.left + c.m.getWidth() / 10 + c.d.f, i1);
            }
            if (AdColonyBrowser.y)
            {
                c.e.a(canvas, c.g.e.left + c.g.f + c.m.getWidth() / 10, i1);
            } else
            {
                c.f.a(canvas, c.g.e.left + c.g.f + c.m.getWidth() / 10, i1);
            }
            c.h.a(canvas, c.m.getWidth() - c.h.f * 2, i1);
            if (c.o)
            {
                c.i.b((c.d.e.left - c.i.f / 2) + c.d.f / 2, (c.d.e.top - c.i.g / 2) + c.d.g / 2);
                c.i.a(canvas);
            }
            if (c.p)
            {
                c.i.b((c.g.e.left - c.i.f / 2) + c.g.f / 2, (c.g.e.top - c.i.g / 2) + c.g.g / 2);
                c.i.a(canvas);
            }
            if (c.q)
            {
                c.i.b((c.f.e.left - c.i.f / 2) + c.f.f / 2, (c.f.e.top - c.i.g / 2) + c.f.g / 2);
                c.i.a(canvas);
            }
            if (c.r)
            {
                c.i.b((c.h.e.left - c.i.f / 2) + c.h.f / 2, (c.h.e.top - c.i.g / 2) + c.h.g / 2);
                c.i.a(canvas);
            }
            canvas = new android.widget.RelativeLayout.LayoutParams(c.s.getWidth(), c.s.getHeight());
            canvas.topMargin = (c.m.getHeight() - c.e.g) / 2;
            canvas.leftMargin = c.m.getWidth() / 10 + c.e.e.left + c.e.f;
            if (AdColonyBrowser.A && c.e.e.left != 0)
            {
                c.n.removeView(c.s);
                c.n.addView(c.s, canvas);
                AdColonyBrowser.A = false;
            }
            if (c.s.getLayoutParams() != null)
            {
                c.s.getLayoutParams().height = c.e.g;
                c.s.getLayoutParams().width = c.e.f;
            }
        }

        public final boolean onTouchEvent(MotionEvent motionevent)
        {
            int i1 = motionevent.getAction();
            int j1 = (int)motionevent.getX();
            int k1 = (int)motionevent.getY();
            if (i1 == 0)
            {
                if (a(c.d, j1, k1) && AdColonyBrowser.w)
                {
                    c.o = true;
                    invalidate();
                    return true;
                }
                if (a(c.g, j1, k1) && AdColonyBrowser.x)
                {
                    c.p = true;
                    invalidate();
                    return true;
                }
                if (a(c.f, j1, k1))
                {
                    c.q = true;
                    invalidate();
                    return true;
                }
                if (a(c.h, j1, k1))
                {
                    c.r = true;
                    invalidate();
                    return true;
                }
            }
            if (i1 == 1)
            {
                if (a(c.d, j1, k1) && AdColonyBrowser.w)
                {
                    c.c.goBack();
                    a();
                    return true;
                }
                if (a(c.g, j1, k1) && AdColonyBrowser.x)
                {
                    c.c.goForward();
                    a();
                    return true;
                }
                if (a(c.f, j1, k1) && AdColonyBrowser.y)
                {
                    c.c.stopLoading();
                    a();
                    return true;
                }
                if (a(c.f, j1, k1) && !AdColonyBrowser.y)
                {
                    c.c.reload();
                    a();
                    return true;
                }
                if (a(c.h, j1, k1))
                {
                    AdColonyBrowser.D = true;
                    c.c.loadData("", "text/html", "utf-8");
                    AdColonyBrowser.x = false;
                    AdColonyBrowser.w = false;
                    AdColonyBrowser.y = false;
                    a();
                    c.finish();
                    return true;
                }
                a();
            }
            return false;
        }

        public a(Activity activity)
        {
            c = AdColonyBrowser.this;
            super(activity);
            a = new Rect();
            b = new Paint();
        }
    }

    final class b extends View
    {

        Rect a;
        final AdColonyBrowser b;

        public final void onDraw(Canvas canvas)
        {
            if (!AdColonyBrowser.z)
            {
                canvas.drawARGB(255, 0, 0, 0);
                getDrawingRect(a);
                b.j.a(canvas, (a.width() - b.j.f) / 2, (a.height() - b.j.g) / 2);
                invalidate();
            }
        }

        public b(Activity activity)
        {
            b = AdColonyBrowser.this;
            super(activity);
            a = new Rect();
        }
    }

    final class c extends View
    {

        Paint a;
        com.jirbo.adcolony.c b;
        com.jirbo.adcolony.c c;
        final AdColonyBrowser d;

        public final void onDraw(Canvas canvas)
        {
            canvas.drawRect(0.0F, 0.0F, d.m.getWidth(), 10F, a);
        }

        public c(Activity activity)
        {
            d = AdColonyBrowser.this;
            super(activity);
            a = new Paint();
            b = new com.jirbo.adcolony.c(com.jirbo.adcolony.q.g("close_image_normal"));
            c = new com.jirbo.adcolony.c(com.jirbo.adcolony.q.g("close_image_down"));
            try
            {
                getClass().getMethod("setLayerType", new Class[] {
                    Integer.TYPE, android/graphics/Paint
                }).invoke(this, new Object[] {
                    Integer.valueOf(1), null
                });
            }
            // Misplaced declaration of an exception variable
            catch (AdColonyBrowser adcolonybrowser) { }
            a.setColor(0xffcccccc);
            a.setStrokeWidth(10F);
            a.setStyle(android.graphics.Paint.Style.STROKE);
            a.setShadowLayer(3F, 0.0F, 1.0F, 0xff000000);
        }
    }


    static boolean A = true;
    static boolean B = false;
    static boolean C = false;
    static boolean D = false;
    public static String a;
    static boolean b = true;
    static boolean w = false;
    static boolean x = false;
    static boolean y = false;
    static boolean z = false;
    WebView c;
    com.jirbo.adcolony.c d;
    com.jirbo.adcolony.c e;
    com.jirbo.adcolony.c f;
    com.jirbo.adcolony.c g;
    com.jirbo.adcolony.c h;
    com.jirbo.adcolony.c i;
    com.jirbo.adcolony.c j;
    com.jirbo.adcolony.c k;
    com.jirbo.adcolony.c l;
    RelativeLayout m;
    RelativeLayout n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    ProgressBar s;
    DisplayMetrics t;
    a u;
    c v;

    public AdColonyBrowser()
    {
        o = false;
        p = false;
        q = false;
        r = false;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        configuration = new android.widget.RelativeLayout.LayoutParams(-2, t.heightPixels - (int)(1.5D * (double)h.g));
        configuration.addRule(3, m.getId());
        c.setLayoutParams(configuration);
        A = true;
        u.invalidate();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        C = true;
        d = new com.jirbo.adcolony.c(com.jirbo.adcolony.q.g("browser_back_image_normal"));
        e = new com.jirbo.adcolony.c(com.jirbo.adcolony.q.g("browser_stop_image_normal"));
        f = new com.jirbo.adcolony.c(com.jirbo.adcolony.q.g("browser_reload_image_normal"));
        g = new com.jirbo.adcolony.c(com.jirbo.adcolony.q.g("browser_forward_image_normal"));
        h = new com.jirbo.adcolony.c(com.jirbo.adcolony.q.g("browser_close_image_normal"));
        i = new com.jirbo.adcolony.c(com.jirbo.adcolony.q.g("browser_glow_button"));
        j = new com.jirbo.adcolony.c(com.jirbo.adcolony.q.g("browser_icon"));
        k = new com.jirbo.adcolony.c(com.jirbo.adcolony.q.g("browser_back_image_normal"), '\0');
        l = new com.jirbo.adcolony.c(com.jirbo.adcolony.q.g("browser_forward_image_normal"), '\0');
        t = com.jirbo.adcolony.q.b().getResources().getDisplayMetrics();
        float f1 = (float)t.widthPixels / t.xdpi;
        float f2 = (float)t.heightPixels / t.ydpi;
        double d1 = Math.sqrt(f1 * f1 + f2 * f2);
        double d2 = Math.sqrt(t.widthPixels * t.widthPixels + t.heightPixels * t.heightPixels) / d1 / 220D;
        d1 = d2;
        if (d2 > 1.8D)
        {
            d1 = 1.8D;
        }
        A = true;
        w = false;
        x = false;
        D = false;
        d.a(d1, false);
        e.a(d1, false);
        f.a(d1, false);
        g.a(d1, false);
        h.a(d1, false);
        i.a(d1, false);
        k.a(d1, false);
        l.a(d1, false);
        s = new ProgressBar(this);
        s.setVisibility(4);
        n = new RelativeLayout(this);
        m = new RelativeLayout(this);
        m.setBackgroundColor(0xffcccccc);
        int i1;
        if (!q.d)
        {
            m.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, (int)((double)d.g * 1.5D)));
        } else
        {
            m.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, (int)((double)d.g * 1.5D)));
        }
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        getWindow().requestFeature(2);
        setVolumeControlStream(3);
        c = new WebView(this);
        c.getSettings().setJavaScriptEnabled(true);
        c.getSettings().setBuiltInZoomControls(true);
        c.getSettings().setUseWideViewPort(true);
        c.getSettings().setLoadWithOverviewMode(true);
        c.getSettings().setGeolocationEnabled(true);
        if (b)
        {
            if (!q.d)
            {
                if (android.os.Build.VERSION.SDK_INT >= 10)
                {
                    setRequestedOrientation(6);
                } else
                {
                    setRequestedOrientation(0);
                }
            } else
            {
                setRequestedOrientation(q.n);
            }
        }
        b = true;
        c.setWebChromeClient(new WebChromeClient() {

            final AdColonyBrowser a;

            public final void onGeolocationPermissionsShowPrompt(String s1, android.webkit.GeolocationPermissions.Callback callback)
            {
                callback.invoke(s1, true, false);
            }

            public final void onProgressChanged(WebView webview, int j1)
            {
                a.setProgress(j1 * 1000);
            }

            
            {
                a = AdColonyBrowser.this;
                super();
            }
        });
        c.setWebViewClient(new WebViewClient() {

            final AdColonyBrowser a;

            public final void onPageFinished(WebView webview, String s1)
            {
                if (!AdColonyBrowser.D)
                {
                    AdColonyBrowser.z = true;
                    AdColonyBrowser.y = false;
                    a.s.setVisibility(4);
                    AdColonyBrowser.w = a.c.canGoBack();
                    AdColonyBrowser.x = a.c.canGoForward();
                }
                a.u.invalidate();
            }

            public final void onPageStarted(WebView webview, String s1, Bitmap bitmap)
            {
                if (!AdColonyBrowser.D)
                {
                    AdColonyBrowser.y = true;
                    AdColonyBrowser.z = false;
                    a.s.setVisibility(0);
                }
                a.u.invalidate();
            }

            public final void onReceivedError(WebView webview, int j1, String s1, String s2)
            {
                aj.d.a("Error viewing URL: ").b(s1);
                a.finish();
            }

            public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
            {
                if (s1.startsWith("market://") || s1.startsWith("amzn://"))
                {
                    webview = new Intent("android.intent.action.VIEW", Uri.parse(s1));
                    if (q.B != null)
                    {
                        q.B.startActivity(webview);
                    }
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = AdColonyBrowser.this;
                super();
            }
        });
        u = new a(this);
        v = new c(this);
        n.setBackgroundColor(0xffffff);
        n.addView(m);
        m.setId(12345);
        bundle = new android.widget.RelativeLayout.LayoutParams(-2, t.heightPixels - (int)((double)h.g * 1.5D));
        bundle.addRule(3, m.getId());
        n.addView(c, bundle);
        bundle = new android.widget.RelativeLayout.LayoutParams(-2, 20);
        bundle.addRule(3, m.getId());
        bundle.setMargins(0, -10, 0, 0);
        n.addView(v, bundle);
        if (t.widthPixels > t.heightPixels)
        {
            i1 = t.widthPixels;
        } else
        {
            i1 = t.heightPixels;
        }
        n.addView(u, new android.widget.RelativeLayout.LayoutParams(i1 * 2, i1 * 2));
        bundle = new android.widget.RelativeLayout.LayoutParams(-2, t.heightPixels - (int)((double)h.g * 1.5D));
        bundle.addRule(3, m.getId());
        n.addView(new b(this), bundle);
        setContentView(n);
        c.loadUrl(a);
        aj.c.a("Viewing ").b(a);
    }

    public void onDestroy()
    {
        if (!q.l && B)
        {
            for (int i1 = 0; i1 < q.U.size(); i1++)
            {
                ((Bitmap)q.U.get(i1)).recycle();
            }

            q.U.clear();
        }
        B = false;
        C = false;
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
        u.a();
    }

    public void onResume()
    {
        super.onResume();
        A = true;
        u.invalidate();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
    }

}
