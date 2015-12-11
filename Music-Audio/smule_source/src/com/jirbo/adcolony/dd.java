// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            bl, h, be, db, 
//            bc, ak, ap, bd, 
//            bg, bk, bx, bt, 
//            bq, ay

class dd
{

    be a;
    boolean b;
    boolean c;
    boolean d;
    boolean e;
    double f;
    double g;
    double h;
    int i;
    String j;

    dd(be be1)
    {
        d = false;
        e = false;
        j = "uuid";
        a = be1;
    }

    void a()
    {
    }

    void a(double d1)
    {
        bl.a.a("Submitting session duration ").b(d1);
        h h1 = new h();
        h1.b("session_length", (int)d1);
        a.d.a("session_end", h1);
    }

    void b()
    {
        if (a.b.b)
        {
            if (d)
            {
                d = false;
                a.d.a("install", null);
            }
            if (e)
            {
                e = false;
                a.d.a("session_start", null);
            }
        }
    }

    void c()
    {
        bl.b.b("AdColony resuming");
        ak.i = true;
        if (b)
        {
            bl.d.b("AdColony.onResume() called multiple times in succession.");
        }
        b = true;
        g();
        double d1 = ap.b();
        if (c)
        {
            if (d1 - g > (double)a.a.d)
            {
                a(h);
                f = d1;
                h();
            }
            c = false;
            f();
        } else
        {
            f = d1;
            h();
        }
        ak.f();
    }

    void d()
    {
        bl.b.b("AdColony suspending");
        ak.i = true;
        if (!b)
        {
            bl.d.b("AdColony.onPause() called without initial call to onResume().");
        }
        b = false;
        c = true;
        g = ap.b();
        f();
    }

    void e()
    {
        bl.b.b("AdColony terminating");
        ak.i = true;
        a(h);
        c = false;
        f();
    }

    void f()
    {
        h h1 = new h();
        h1.b("allow_resume", c);
        h1.b("start_time", f);
        h1.b("finish_time", g);
        h1.b("session_time", h);
        bk.a(new bg("session_info.txt"), h1);
    }

    void g()
    {
        h h1 = bk.b(new bg("session_info.txt"));
        if (h1 != null)
        {
            c = h1.g("allow_resume");
            f = h1.e("start_time");
            g = h1.e("finish_time");
            h = h1.e("session_time");
            return;
        } else
        {
            d = true;
            return;
        }
    }

    void h()
    {
        e = true;
        j = ap.a();
        h = 0.0D;
        i = 0;
        if (ak.c != null && ak.c.b != null && ak.c.b.j != null && ak.c.b.j.n != null)
        {
            int k = 0;
            while (k < ak.c.b.j.n.a()) 
            {
                if (ak.c.b.j.n.a(k).k != null)
                {
                    ak.c.b.j.n.a(k).k.d = 0;
                }
                k++;
            }
        }
    }
}
