// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.y;

public class xc extends xn
{

    private static final int a = Color.argb(0, 0, 0, 0);
    private final Activity b;
    private dr c;
    private dt d;
    private gu e;
    private xf f;
    private du g;
    private boolean h;
    private boolean i;
    private FrameLayout j;
    private android.webkit.WebChromeClient.CustomViewCallback k;
    private boolean l;
    private boolean m;
    private boolean n;
    private RelativeLayout o;

    public xc(Activity activity)
    {
        i = false;
        l = false;
        m = false;
        n = false;
        b = activity;
    }

    public static void a(Context context, dr dr1)
    {
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", dr1.n.e);
        dr.a(intent, dr1);
        if (!aej.e())
        {
            intent.addFlags(0x80000);
        }
        if (!(context instanceof Activity))
        {
            intent.addFlags(0x10000000);
        }
        context.startActivity(intent);
    }

    private static android.widget.RelativeLayout.LayoutParams c(int i1, int j1, int k1, int l1)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(k1, l1);
        layoutparams.setMargins(i1, j1, 0, 0);
        layoutparams.addRule(10);
        layoutparams.addRule(9);
        return layoutparams;
    }

    public void a()
    {
        b.finish();
    }

    public void a(int i1)
    {
        b.setRequestedOrientation(i1);
    }

    public void a(int i1, int j1, int k1, int l1)
    {
        if (d != null)
        {
            d.setLayoutParams(c(i1, j1, k1, l1));
        }
    }

    public void a(Bundle bundle)
    {
        boolean flag = false;
        if (bundle != null)
        {
            flag = bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        l = flag;
        c = dr.a(b.getIntent());
        if (c == null)
        {
            throw new xd("Could not get info for ad overlay.");
        }
          goto _L1
_L10:
        return;
_L1:
        if (c.q == null) goto _L3; else goto _L2
_L2:
        n = c.q.b;
_L9:
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        if (c.d != null)
        {
            c.d.q();
        }
        if (c.l != 1 && c.c != null)
        {
            c.c.s();
        }
        c.l;
        JVM INSTR tableswitch 1 4: default 289
    //                   1 206
    //                   2 212
    //                   3 236
    //                   4 242;
           goto _L4 _L5 _L6 _L7 _L8
_L4:
        throw new xd("Could not determine ad overlay type.");
_L3:
        n = false;
          goto _L9
_L5:
        try
        {
            c(false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            acb.e(bundle.getMessage());
            b.finish();
        }
          goto _L10
_L6:
        f = new xf(c.e);
        c(false);
        return;
_L7:
        c(true);
        return;
_L8:
        if (l)
        {
            b.finish();
            return;
        }
        if (xa.a(b, c.b, c.j)) goto _L10; else goto _L11
_L11:
        b.finish();
        return;
    }

    public void a(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        j = new FrameLayout(b);
        j.setBackgroundColor(0xff000000);
        j.addView(view, -1, -1);
        b.setContentView(j);
        j();
        k = customviewcallback;
        i = true;
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
        g = new du(b, byte0);
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
        g.a(c.h);
        o.addView(g, layoutparams);
    }

    public dt b()
    {
        return d;
    }

    public void b(int i1, int j1, int k1, int l1)
    {
        if (d == null)
        {
            d = new dt(b, e);
            o.addView(d, 0, c(i1, j1, k1, l1));
            e.f().a(false);
        }
    }

    public void b(Bundle bundle)
    {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", l);
    }

    public void b(boolean flag)
    {
        if (g != null)
        {
            g.a(flag);
        }
    }

    public void c()
    {
        if (c != null && i)
        {
            a(c.k);
        }
        if (j != null)
        {
            b.setContentView(o);
            j();
            j.removeAllViews();
            j = null;
        }
        if (k != null)
        {
            k.onCustomViewHidden();
            k = null;
        }
        i = false;
    }

    void c(boolean flag)
    {
        if (!h)
        {
            b.requestWindowFeature(1);
        }
        Window window = b.getWindow();
        if (!n || c.q.c)
        {
            window.setFlags(1024, 1024);
        }
        a(c.k);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            acb.a("Enabling hardware acceleration on the AdActivity window.");
            abv.a(window);
        }
        o = new xe(b, c.p);
        boolean flag1;
        if (!n)
        {
            o.setBackgroundColor(0xff000000);
        } else
        {
            o.setBackgroundColor(a);
        }
        b.setContentView(o);
        j();
        flag1 = c.e.f().b();
        if (flag)
        {
            e = gu.a(b, c.e.e(), true, flag1, null, c.n);
            e.f().a(null, null, c.f, c.j, true, c.o, c.e.f().a());
            e.f().a(new acf() {

                final xc a;

                public void a(gu gu1)
                {
                    gu1.c();
                }

            
            {
                a = xc.this;
                super();
            }
            });
            android.view.ViewParent viewparent;
            if (c.m != null)
            {
                e.loadUrl(c.m);
            } else
            if (c.i != null)
            {
                e.loadDataWithBaseURL(c.g, c.i, "text/html", "UTF-8", null);
            } else
            {
                throw new xd("No URL or HTML to display in ad overlay.");
            }
        } else
        {
            e = c.e;
            e.setContext(b);
        }
        e.a(this);
        viewparent = e.getParent();
        if (viewparent != null && (viewparent instanceof ViewGroup))
        {
            ((ViewGroup)viewparent).removeView(e);
        }
        if (n)
        {
            e.setBackgroundColor(a);
        }
        o.addView(e, -1, -1);
        if (!flag)
        {
            m();
        }
        a(flag1);
        if (e.g())
        {
            b(true);
        }
    }

    public void d()
    {
    }

    public void e()
    {
    }

    public void f()
    {
        if (c != null && c.l == 4)
        {
            if (l)
            {
                b.finish();
            } else
            {
                l = true;
            }
        }
        if (e != null)
        {
            abq.b(e);
        }
    }

    public void g()
    {
        if (d != null)
        {
            d.c();
        }
        c();
        if (e != null && (!b.isFinishing() || f == null))
        {
            abq.a(e);
        }
        l();
    }

    public void h()
    {
        l();
    }

    public void i()
    {
        if (d != null)
        {
            d.a();
        }
        if (e != null)
        {
            o.removeView(e);
        }
        l();
    }

    public void j()
    {
        h = true;
    }

    public void k()
    {
        o.removeView(g);
        a(true);
    }

    void l()
    {
        if (b.isFinishing() && !m)
        {
            m = true;
            if (b.isFinishing())
            {
                if (e != null)
                {
                    n();
                    o.removeView(e);
                    if (f != null)
                    {
                        e.a(false);
                        f.c.addView(e, f.a, f.b);
                    }
                }
                if (c != null && c.d != null)
                {
                    c.d.p();
                    return;
                }
            }
        }
    }

    void m()
    {
        e.c();
    }

    void n()
    {
        e.b();
    }

}
