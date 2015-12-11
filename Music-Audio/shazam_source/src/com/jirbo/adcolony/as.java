// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            ae, ai, aj, ac, 
//            ar, s, q, aa, 
//            x

final class as
{

    ac a;
    boolean b;
    boolean c;
    boolean d;
    boolean e;
    double f;
    double g;
    double h;
    int i;
    String j;

    as(ac ac1)
    {
        d = false;
        e = false;
        j = "uuid";
        a = ac1;
    }

    final void a()
    {
        a.g g1 = new a.g();
        g1.b("allow_resume", c);
        g1.a("start_time", f);
        g1.a("finish_time", g);
        g1.a("session_time", h);
        ai.a(new ae("session_info.txt"), g1);
    }

    final void a(double d1)
    {
        aj.a.a("Submitting session duration ").b(d1);
        a.g g1 = new a.g();
        g1.a("session_length", (int)d1);
        a.d.a("session_end", g1);
    }

    final void b()
    {
        e = true;
        j = s.a();
        h = 0.0D;
        i = 0;
        if (q.c != null && q.c.b != null && q.c.b.j != null && q.c.b.j.n != null)
        {
            int k = 0;
            while (k < q.c.b.j.n.a.size()) 
            {
                if (q.c.b.j.n.a(k).k != null)
                {
                    q.c.b.j.n.a(k).k.d = 0;
                }
                k++;
            }
        }
    }
}
