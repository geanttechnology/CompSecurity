// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.ca;
import com.google.android.gms.b.cb;
import com.google.android.gms.b.cj;
import com.google.android.gms.b.ck;
import com.google.android.gms.b.cl;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            l, h, AdOverlayInfoParcel, f, 
//            a, j

public class com.google.android.gms.ads.internal.overlay.c extends com.google.android.gms.b.bh.a
    implements l
{
    private static final class a extends Exception
    {

        public a(String s)
        {
            super(s);
        }
    }

    static final class b extends RelativeLayout
    {

        cb a;

        public boolean onInterceptTouchEvent(MotionEvent motionevent)
        {
            a.a(motionevent);
            return false;
        }

        public b(Context context, String s)
        {
            super(context);
            a = new cb(context, s);
        }
    }

    public static class c
    {

        public final int a;
        public final android.view.ViewGroup.LayoutParams b;
        public final ViewGroup c;
        public final Context d;

        public c(cj cj1)
            throws a
        {
            b = cj1.getLayoutParams();
            android.view.ViewParent viewparent = cj1.getParent();
            d = cj1.d();
            if (viewparent != null && (viewparent instanceof ViewGroup))
            {
                c = (ViewGroup)viewparent;
                a = c.indexOfChild(cj1.getWebView());
                c.removeView(cj1.getWebView());
                cj1.a(true);
                return;
            } else
            {
                throw new a("Could not get the parent of the WebView for an overlay.");
            }
        }
    }


    static final int a = Color.argb(0, 0, 0, 0);
    AdOverlayInfoParcel b;
    h c;
    cj d;
    c e;
    j f;
    boolean g;
    FrameLayout h;
    android.webkit.WebChromeClient.CustomViewCallback i;
    boolean j;
    boolean k;
    RelativeLayout l;
    boolean m;
    int n;
    private final Activity o;
    private boolean p;
    private boolean q;
    private boolean r;

    public com.google.android.gms.ads.internal.overlay.c(Activity activity)
    {
        g = false;
        j = false;
        k = false;
        m = false;
        n = 0;
        q = false;
        r = true;
        o = activity;
    }

    public void a()
    {
        n = 2;
        o.finish();
    }

    public void a(int i1)
    {
        o.setRequestedOrientation(i1);
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        if (c != null)
        {
            c.a(i1, j1, k1, l1);
        }
    }

    public void a(Bundle bundle)
    {
        boolean flag = false;
        if (bundle != null)
        {
            flag = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        j = flag;
        b = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.a(o.getIntent());
        if (b == null)
        {
            throw new a("Could not get info for ad overlay.");
        }
          goto _L1
_L10:
        return;
_L1:
        if (b.n.d > 0x7270e0)
        {
            n = 3;
        }
        if (o.getIntent() != null)
        {
            r = o.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
        }
        if (b.q == null) goto _L3; else goto _L2
_L2:
        k = b.q.b;
_L9:
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        if (b.d != null && r)
        {
            b.d.b();
        }
        if (b.l != 1 && b.c != null)
        {
            b.c.a();
        }
        l = new b(o, b.p);
        b.l;
        JVM INSTR tableswitch 1 4: default 382
    //                   1 286
    //                   2 292
    //                   3 316
    //                   4 322;
           goto _L4 _L5 _L6 _L7 _L8
_L4:
        throw new a("Could not determine ad overlay type.");
_L3:
        k = false;
          goto _L9
_L5:
        try
        {
            b(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            com.google.android.gms.ads.internal.util.client.b.e(bundle.getMessage());
            n = 3;
            o.finish();
        }
          goto _L10
_L6:
        e = new c(b.e);
        b(false);
        return;
_L7:
        b(true);
        return;
_L8:
        if (j)
        {
            n = 3;
            o.finish();
            return;
        }
        if (com.google.android.gms.ads.internal.c.a().a(o, b.b, b.j)) goto _L10; else goto _L11
_L11:
        n = 3;
        o.finish();
        return;
    }

    public void a(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        h = new FrameLayout(o);
        h.setBackgroundColor(0xff000000);
        h.addView(view, -1, -1);
        o.setContentView(h);
        l();
        i = customviewcallback;
        g = true;
    }

    public void a(boolean flag)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams;
        byte byte0;
        if (flag)
        {
            byte0 = 50;
        } else
        {
            byte0 = 32;
        }
        f = new j(o, byte0, this);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(10);
        if (flag)
        {
            byte0 = 11;
        } else
        {
            byte0 = 9;
        }
        layoutparams.addRule(byte0);
        f.a(flag, b.h);
        l.addView(f, layoutparams);
    }

    public void a(boolean flag, boolean flag1)
    {
        if (f != null)
        {
            f.a(flag, flag1);
        }
    }

    public h b()
    {
        return c;
    }

    protected void b(int i1)
    {
        d.a(i1);
    }

    public void b(int i1, int j1, int k1, int l1)
    {
        if (c == null)
        {
            c = new h(o, d);
            l.addView(c, 0, new android.view.ViewGroup.LayoutParams(-1, -1));
            c.a(i1, j1, k1, l1);
            d.h().a(false);
        }
    }

    public void b(Bundle bundle)
    {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", j);
    }

    protected void b(boolean flag)
        throws a
    {
        if (!p)
        {
            o.requestWindowFeature(1);
        }
        Object obj = o.getWindow();
        if (obj == null)
        {
            throw new a("Invalid activity, no window available.");
        }
        if (!k || b.q != null && b.q.c)
        {
            ((Window) (obj)).setFlags(1024, 1024);
        }
        boolean flag3 = b.e.h().b();
        m = false;
        if (flag3)
        {
            if (b.k == com.google.android.gms.ads.internal.c.e().a())
            {
                boolean flag1;
                if (o.getResources().getConfiguration().orientation == 1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                m = flag1;
            } else
            if (b.k == com.google.android.gms.ads.internal.c.e().b())
            {
                boolean flag2;
                if (o.getResources().getConfiguration().orientation == 2)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                m = flag2;
            }
        }
        com.google.android.gms.ads.internal.util.client.b.a((new StringBuilder()).append("Delay onShow to next orientation change: ").append(m).toString());
        a(b.k);
        if (com.google.android.gms.ads.internal.c.e().a(((Window) (obj))))
        {
            com.google.android.gms.ads.internal.util.client.b.a("Hardware acceleration on the AdActivity window enabled.");
        }
        if (!k)
        {
            l.setBackgroundColor(0xff000000);
        } else
        {
            l.setBackgroundColor(a);
        }
        o.setContentView(l);
        l();
        if (flag)
        {
            d = com.google.android.gms.ads.internal.c.d().a(o, b.e.g(), true, flag3, null, b.n);
            d.h().a(null, null, b.f, b.j, true, b.o, null, b.e.h().a(), null);
            d.h().a(new _cls1());
            if (b.m != null)
            {
                d.loadUrl(b.m);
            } else
            if (b.i != null)
            {
                d.loadDataWithBaseURL(b.g, b.i, "text/html", "UTF-8", null);
            } else
            {
                throw new a("No URL or HTML to display in ad overlay.");
            }
            if (b.e != null)
            {
                b.e.b(this);
            }
        } else
        {
            d = b.e;
            d.setContext(o);
        }
        d.a(this);
        obj = d.getParent();
        if (obj != null && (obj instanceof ViewGroup))
        {
            ((ViewGroup)obj).removeView(d.getWebView());
        }
        if (k)
        {
            d.setBackgroundColor(a);
        }
        l.addView(d.getWebView(), -1, -1);
        if (!flag && !m)
        {
            p();
        }
        a(flag3);
        if (d.i())
        {
            a(flag3, true);
        }
    }

    public void c()
    {
        if (b != null && g)
        {
            a(b.k);
        }
        if (h != null)
        {
            o.setContentView(l);
            l();
            h.removeAllViews();
            h = null;
        }
        if (i != null)
        {
            i.onCustomViewHidden();
            i = null;
        }
        g = false;
    }

    public void d()
    {
        n = 1;
        o.finish();
    }

    public void e()
    {
        n = 0;
    }

    public void f()
    {
    }

    public void g()
    {
    }

    public void h()
    {
        if (b != null && b.l == 4)
        {
            if (j)
            {
                n = 3;
                o.finish();
            } else
            {
                j = true;
            }
        }
        if (d != null && !d.m())
        {
            com.google.android.gms.ads.internal.c.e().b(d.getWebView());
            return;
        } else
        {
            com.google.android.gms.ads.internal.util.client.b.e("The webview does not exit. Ignoring action.");
            return;
        }
    }

    public void i()
    {
        if (c != null)
        {
            c.g();
        }
        c();
        if (d != null && (!o.isFinishing() || e == null))
        {
            com.google.android.gms.ads.internal.c.e().a(d.getWebView());
        }
        n();
    }

    public void j()
    {
        n();
    }

    public void k()
    {
        if (c != null)
        {
            c.l();
        }
        if (d != null)
        {
            l.removeView(d.getWebView());
        }
        n();
    }

    public void l()
    {
        p = true;
    }

    public void m()
    {
        l.removeView(f);
        a(true);
    }

    protected void n()
    {
        if (o.isFinishing() && !q)
        {
            q = true;
            if (o.isFinishing())
            {
                if (d != null)
                {
                    b(n);
                    l.removeView(d.getWebView());
                    if (e != null)
                    {
                        d.setContext(e.d);
                        d.a(false);
                        e.c.addView(d.getWebView(), e.a, e.b);
                        e = null;
                    }
                }
                if (b != null && b.d != null)
                {
                    b.d.a();
                    return;
                }
            }
        }
    }

    public void o()
    {
        if (m)
        {
            m = false;
            p();
        }
    }

    protected void p()
    {
        d.b();
    }


    /* member class not found */
    class _cls1 {}

}
