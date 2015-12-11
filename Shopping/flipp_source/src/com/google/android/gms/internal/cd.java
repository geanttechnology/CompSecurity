// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import java.util.HashMap;

// Referenced classes of package com.google.android.gms.internal:
//            cr, bm, cu, cm, 
//            et, ew, ez, ce, 
//            cf, cg, ci, kq, 
//            ca, ej, cj, ck, 
//            er

public final class cd extends cr
{

    final Activity a;
    cj b;
    ew c;
    cm d;
    FrameLayout e;
    android.webkit.WebChromeClient.CustomViewCallback f;
    RelativeLayout g;
    private bm h;
    private cg i;
    private boolean j;
    private boolean k;

    public cd(Activity activity)
    {
        j = false;
        k = false;
        a = activity;
    }

    static android.widget.RelativeLayout.LayoutParams a(int l, int i1, int j1, int k1)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(j1, k1);
        layoutparams.setMargins(l, i1, 0, 0);
        layoutparams.addRule(10);
        layoutparams.addRule(9);
        return layoutparams;
    }

    public static void a(Context context, bm bm1)
    {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", bm1.n.e);
        bm.a(intent, bm1);
        intent.addFlags(0x80000);
        context.startActivity(intent);
    }

    private void a(boolean flag)
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
        d = new cm(a, byte0);
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
        d.a(h.h);
        g.addView(d, layoutparams);
    }

    private void b(boolean flag)
    {
        a.requestWindowFeature(1);
        Window window = a.getWindow();
        window.setFlags(1024, 1024);
        a(h.k);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            et.a("Enabling hardware acceleration on the AdActivity window.");
            window.setFlags(0x1000000, 0x1000000);
        }
        g = new RelativeLayout(a);
        g.setBackgroundColor(0xff000000);
        a.setContentView(g);
        boolean flag1 = h.e.a.a();
        if (flag)
        {
            c = ew.a(a, h.e.c(), true, flag1, null, h.n);
            c.a.a(null, null, h.f, h.j, true);
            c.a.f = new ce(this);
            ew ew1;
            if (h.m != null)
            {
                c.loadUrl(h.m);
            } else
            if (h.i != null)
            {
                c.loadDataWithBaseURL(h.g, h.i, "text/html", "UTF-8", null);
            } else
            {
                throw new cf("No URL or HTML to display in ad overlay.");
            }
        } else
        {
            c = h.e;
            c.setContext(a);
        }
        ew1 = c;
        synchronized (ew1.b)
        {
            ew1.e = this;
        }
        g.addView(c, -1, -1);
        if (!flag)
        {
            c.a();
        }
        a(flag1);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void i()
    {
        if (a.isFinishing() && !k)
        {
            k = true;
            if (a.isFinishing())
            {
                if (c != null)
                {
                    ew ew1 = c;
                    HashMap hashmap = new HashMap(1);
                    hashmap.put("version", ew1.d.b);
                    ew1.a("onhide", hashmap);
                    g.removeView(c);
                    if (i != null)
                    {
                        c.a(false);
                        i.c.addView(c, i.a, i.b);
                    }
                }
                if (h != null && h.d != null)
                {
                    h.d.o();
                    return;
                }
            }
        }
    }

    public final void a()
    {
        if (h != null)
        {
            a(h.k);
        }
        if (e != null)
        {
            a.setContentView(g);
            e.removeAllViews();
            e = null;
        }
        if (f != null)
        {
            f.onCustomViewHidden();
            f = null;
        }
    }

    public final void a(int l)
    {
        a.setRequestedOrientation(l);
    }

    public final void a(Bundle bundle)
    {
        boolean flag = false;
        if (bundle != null)
        {
            flag = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        j = flag;
        h = bm.a(a.getIntent());
        if (h == null)
        {
            throw new cf("Could not get info for ad overlay.");
        }
          goto _L1
_L7:
        return;
_L1:
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        if (h.d != null)
        {
            h.d.p();
        }
        if (h.l != 1 && h.c != null)
        {
            h.c.r();
        }
        h.l;
        JVM INSTR tableswitch 1 4: default 258
    //                   1 175
    //                   2 181
    //                   3 205
    //                   4 211;
           goto _L2 _L3 _L4 _L5 _L6
_L2:
        throw new cf("Could not determine ad overlay type.");
_L3:
        b(false);
        return;
_L4:
        try
        {
            i = new cg(h.e);
            b(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            et.d(bundle.getMessage());
            a.finish();
        }
          goto _L7
_L5:
        b(true);
        return;
_L6:
        if (j)
        {
            a.finish();
            return;
        }
        if (ca.a(a, h.b, h.j)) goto _L7; else goto _L8
_L8:
        a.finish();
        return;
    }

    public final void b()
    {
    }

    public final void b(Bundle bundle)
    {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", j);
    }

    public final void c()
    {
    }

    public final void d()
    {
        if (h != null && h.l == 4)
        {
            if (j)
            {
                a.finish();
            } else
            {
                j = true;
            }
        }
        if (c != null)
        {
            ej.b(c);
        }
    }

    public final void e()
    {
        if (b != null)
        {
            b.d.pause();
        }
        a();
        if (c != null && (!a.isFinishing() || i == null))
        {
            ej.a(c);
        }
        i();
    }

    public final void f()
    {
        i();
    }

    public final void g()
    {
        if (b != null)
        {
            cj cj1 = b;
            ck ck1 = cj1.c;
            ck1.b = true;
            er.a.removeCallbacks(ck1.a);
            cj1.d.stopPlayback();
        }
        if (c != null)
        {
            g.removeView(c);
        }
        i();
    }

    public final void h()
    {
        g.removeView(d);
        a(true);
    }
}
