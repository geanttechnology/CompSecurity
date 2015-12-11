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
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.ax;
import com.google.android.gms.d.ay;
import com.google.android.gms.d.bb;
import com.google.android.gms.d.bd;
import com.google.android.gms.d.be;
import com.google.android.gms.d.gd;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.gn;
import com.google.android.gms.d.go;
import com.google.android.gms.d.he;
import com.google.android.gms.d.hf;
import com.google.android.gms.d.hg;
import java.util.Collections;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            o, AdOverlayInfoParcel, g, a, 
//            m, k, i, q

public final class d extends com.google.android.gms.d.ee.a
    implements o
{
    private static final class a extends Exception
    {

        public a(String s1)
        {
            super(s1);
        }
    }

    static final class b extends RelativeLayout
    {

        go a;

        public final boolean onInterceptTouchEvent(MotionEvent motionevent)
        {
            a.a(motionevent);
            return false;
        }

        public b(Context context, String s1)
        {
            super(context);
            a = new go(context, s1);
        }
    }

    public static final class c
    {

        public final int a;
        public final android.view.ViewGroup.LayoutParams b;
        public final ViewGroup c;
        public final Context d;

        public c(he he1)
        {
            b = he1.getLayoutParams();
            android.view.ViewParent viewparent = he1.getParent();
            d = he1.d();
            if (viewparent != null && (viewparent instanceof ViewGroup))
            {
                c = (ViewGroup)viewparent;
                a = c.indexOfChild(he1.getWebView());
                c.removeView(he1.getWebView());
                he1.b(true);
                return;
            } else
            {
                throw new a("Could not get the parent of the WebView for an overlay.");
            }
        }
    }


    static final int a = Color.argb(0, 0, 0, 0);
    public final Activity b;
    public final be c;
    public final bd d;
    AdOverlayInfoParcel e;
    public k f;
    public he g;
    c h;
    public m i;
    public boolean j;
    public FrameLayout k;
    public android.webkit.WebChromeClient.CustomViewCallback l;
    boolean m;
    boolean n;
    public RelativeLayout o;
    public boolean p;
    int q;
    public boolean r;
    private boolean s;
    private boolean t;

    public d(Activity activity)
    {
        j = false;
        m = false;
        n = false;
        p = false;
        q = 0;
        s = false;
        t = true;
        b = activity;
        activity = ay.G;
        c = new be(((Boolean)com.google.android.gms.ads.internal.p.n().a(activity)).booleanValue(), "show_interstitial", "interstitial");
        d = c.a();
    }

    private void b(boolean flag)
    {
        if (!r)
        {
            b.requestWindowFeature(1);
        }
        Object obj = b.getWindow();
        if (obj == null)
        {
            throw new a("Invalid activity, no window available.");
        }
        if (!n || e.q != null && e.q.c)
        {
            ((Window) (obj)).setFlags(1024, 1024);
        }
        boolean flag3 = e.e.i().a();
        p = false;
        if (flag3)
        {
            if (e.k == com.google.android.gms.ads.internal.p.g().a())
            {
                boolean flag1;
                if (b.getResources().getConfiguration().orientation == 1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                p = flag1;
            } else
            if (e.k == com.google.android.gms.ads.internal.p.g().b())
            {
                boolean flag2;
                if (b.getResources().getConfiguration().orientation == 2)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                p = flag2;
            }
        }
        (new StringBuilder("Delay onShow to next orientation change: ")).append(p);
        com.google.android.gms.ads.internal.util.client.b.a(3);
        a(e.k);
        if (com.google.android.gms.ads.internal.p.g().a(((Window) (obj))))
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
        }
        if (!n)
        {
            o.setBackgroundColor(0xff000000);
        } else
        {
            o.setBackgroundColor(a);
        }
        b.setContentView(o);
        r = true;
        if (flag)
        {
            com.google.android.gms.ads.internal.p.f();
            g = hg.a(b, e.e.h(), true, flag3, null, e.n);
            g.i().a(null, null, e.f, e.j, true, e.o, null, e.e.i().i, null);
            g.i().d = new com.google.android.gms.d.hf.a() {

                final d a;

                public final void a(he he1, boolean flag4)
                {
                    he1.b();
                }

            
            {
                a = d.this;
                super();
            }
            };
            if (e.m != null)
            {
                g.loadUrl(e.m);
            } else
            if (e.i != null)
            {
                g.loadDataWithBaseURL(e.g, e.i, "text/html", "UTF-8", null);
            } else
            {
                throw new a("No URL or HTML to display in ad overlay.");
            }
            if (e.e != null)
            {
                e.e.b(this);
            }
        } else
        {
            g = e.e;
            g.setContext(b);
        }
        g.a(this);
        obj = g.getParent();
        if (obj != null && (obj instanceof ViewGroup))
        {
            ((ViewGroup)obj).removeView(g.getWebView());
        }
        if (n)
        {
            g.setBackgroundColor(a);
        }
        o.addView(g.getWebView(), -1, -1);
        if (!flag && !p)
        {
            m();
        }
        a(flag3);
        if (g.j())
        {
            a(flag3, true);
        }
    }

    private void n()
    {
        if (b.isFinishing() && !s)
        {
            s = true;
            if (com.google.android.gms.ads.internal.p.h().c() != null)
            {
                com.google.android.gms.ads.internal.p.h().c().a(c);
            }
            if (g != null)
            {
                int i1 = q;
                g.a(i1);
                o.removeView(g.getWebView());
                if (h != null)
                {
                    g.setContext(h.d);
                    g.b(false);
                    h.c.addView(g.getWebView(), h.a, h.b);
                    h = null;
                }
                g = null;
            }
            if (e != null && e.d != null)
            {
                e.d.a_();
                return;
            }
        }
    }

    public final void a()
    {
        q = 2;
        b.finish();
    }

    public final void a(int i1)
    {
        b.setRequestedOrientation(i1);
    }

    public final void a(Bundle bundle)
    {
        boolean flag = false;
        if (bundle != null)
        {
            flag = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        m = flag;
        e = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.a(b.getIntent());
        if (e == null)
        {
            throw new a("Could not get info for ad overlay.");
        }
          goto _L1
_L10:
        return;
_L1:
        if (e.n.d > 0x7270e0)
        {
            q = 3;
        }
        if (b.getIntent() != null)
        {
            t = b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
        }
        if (e.q == null) goto _L3; else goto _L2
_L2:
        n = e.q.b;
_L9:
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        if (e.d != null && t)
        {
            e.d.b_();
        }
        if (e.l != 1 && e.c != null)
        {
            e.c.onAdClicked();
        }
        o = new b(b, e.p);
        e.l;
        JVM INSTR tableswitch 1 4: default 392
    //                   1 295
    //                   2 301
    //                   3 325
    //                   4 331;
           goto _L4 _L5 _L6 _L7 _L8
_L4:
        throw new a("Could not determine ad overlay type.");
_L3:
        n = false;
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
            bundle.getMessage();
            com.google.android.gms.ads.internal.util.client.b.a(5);
            q = 3;
            b.finish();
        }
          goto _L10
_L6:
        h = new c(e.e);
        b(false);
        return;
_L7:
        b(true);
        return;
_L8:
        if (m)
        {
            q = 3;
            b.finish();
            return;
        }
        com.google.android.gms.ads.internal.p.b();
        if (!com.google.android.gms.ads.internal.overlay.a.a(b, e.b, e.j))
        {
            q = 3;
            b.finish();
            return;
        }
          goto _L10
    }

    public final void a(boolean flag)
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
        i = new m(b, byte0, this);
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
        i.a(flag, e.h);
        o.addView(i, layoutparams);
    }

    public final void a(boolean flag, boolean flag1)
    {
        if (i != null)
        {
            i.a(flag, flag1);
        }
    }

    public final void b()
    {
        if (e != null && j)
        {
            a(e.k);
        }
        if (k != null)
        {
            b.setContentView(o);
            r = true;
            k.removeAllViews();
            k = null;
        }
        if (l != null)
        {
            l.onCustomViewHidden();
            l = null;
        }
        j = false;
    }

    public final void b(Bundle bundle)
    {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", m);
    }

    public final void c()
    {
        q = 1;
        b.finish();
    }

    public final void d()
    {
        q = 0;
    }

    public final boolean e()
    {
        q = 0;
        boolean flag;
        if (g == null)
        {
            flag = true;
        } else
        {
            boolean flag1 = g.p();
            flag = flag1;
            if (!flag1)
            {
                g.a("onbackblocked", Collections.emptyMap());
                return flag1;
            }
        }
        return flag;
    }

    public final void f()
    {
    }

    public final void g()
    {
    }

    public final void h()
    {
        if (e != null && e.l == 4)
        {
            if (m)
            {
                q = 3;
                b.finish();
            } else
            {
                m = true;
            }
        }
        if (g != null && !g.n())
        {
            com.google.android.gms.ads.internal.p.g().b(g.getWebView());
            return;
        } else
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return;
        }
    }

    public final void i()
    {
        if (f != null)
        {
            f.c.d();
        }
        b();
        if (g != null && (!b.isFinishing() || h == null))
        {
            com.google.android.gms.ads.internal.p.g().a(g.getWebView());
        }
        n();
    }

    public final void j()
    {
        n();
    }

    public final void k()
    {
        if (f != null)
        {
            k k1 = f;
            q q1 = k1.b;
            q1.a = true;
            gm.a.removeCallbacks(q1);
            k1.c.b();
            k1.h();
        }
        if (g != null)
        {
            o.removeView(g.getWebView());
        }
        n();
    }

    public final void l()
    {
        r = true;
    }

    public final void m()
    {
        g.b();
    }

}
