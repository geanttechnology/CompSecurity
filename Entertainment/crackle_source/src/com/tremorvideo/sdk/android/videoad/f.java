// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Window;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            a, bv, q, ax, 
//            ad, aq, aw, ab

public class f extends a
    implements aq.d, ax.c
{

    q a;
    ax b;
    aq e;
    bv f;

    public f(a.a a1, Activity activity, q q1)
    {
        super(a1, activity);
        f = new bv();
        f.a();
        a = q1;
        a.a(f);
        b = new ax(activity, a1, f);
        b.a(this);
        try
        {
            e = ad.a(c);
        }
        // Misplaced declaration of an exception variable
        catch (a.a a1)
        {
            ad.a(a1);
        }
        e.a(this);
        e.a(a.E());
        c.requestWindowFeature(1);
        c.getWindow().setFlags(1024, 1024);
        ad.a(c.getWindow());
        c.setContentView(e, new android.view.ViewGroup.LayoutParams(-1, -1));
        ad.a(c.getWindow());
    }

    public void a(aw aw1)
    {
        e.e();
    }

    public boolean a(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (e.a())
            {
                e.b();
            } else
            {
                e.c();
                d.a(this);
            }
            return true;
        } else
        {
            return super.a(i, keyevent);
        }
    }

    public boolean a(String s)
    {
label0:
        {
            s = a.c(s);
            if (s != null)
            {
                if (s.m())
                {
                    break label0;
                }
                s = new ab(c, f, ab.a.a, new ab.b() {

                    final f a;

                    public void a(boolean flag)
                    {
                        a.e.d();
                    }

            
            {
                a = f.this;
                super();
            }
                });
                e.e();
                s.setCanceledOnTouchOutside(false);
                s.setTitle("Unsupported Feature");
                s.a("Sorry, that feature is not supported on your device.");
                s.a("OK", "");
                s.show();
            }
            return false;
        }
        if (s.a() != aw.b.v)
        {
            b.c(s);
            return false;
        } else
        {
            b.c(s);
            e.c();
            d.a(this);
            return false;
        }
    }

    public void b()
    {
        e.e();
        super.b();
    }

    public void b(aw aw1)
    {
        e.d();
    }

    public void c()
    {
        e.d();
        super.c();
    }

    public boolean j()
    {
        return false;
    }

    public a.b n()
    {
        return a.b.b;
    }
}
