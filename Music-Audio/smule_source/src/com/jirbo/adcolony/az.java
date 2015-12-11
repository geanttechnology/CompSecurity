// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            ay, bg, bk, d, 
//            be, bd, bl

class az
{

    be a;
    boolean b;
    ArrayList c;

    az(be be1)
    {
        b = false;
        c = new ArrayList();
        a = be1;
    }

    ay a(String s)
    {
        int j = c.size();
        for (int i = 0; i < j; i++)
        {
            ay ay1 = (ay)c.get(i);
            if (ay1.a.equals(s))
            {
                return ay1;
            }
        }

        b = true;
        s = new ay(s);
        c.add(s);
        return s;
    }

    void a()
    {
        boolean flag = false;
        d d1 = bk.c(new bg("zone_state.txt"));
        if (d1 != null)
        {
            c.clear();
            for (int i = 0; i < d1.a_(); i++)
            {
                h h = d1.a(i);
                ay ay1 = new ay();
                if (ay1.a(h))
                {
                    c.add(ay1);
                }
            }

        }
        String as[] = a.a.k;
        int k = as.length;
        for (int j = ((flag) ? 1 : 0); j < k; j++)
        {
            a(as[j]);
        }

    }

    void b()
    {
        int i = 0;
        bl.a.b("Saving zone state...");
        b = false;
        d d1 = new d();
        String as[] = a.a.k;
        for (int j = as.length; i < j; i++)
        {
            d1.a(a(as[i]).a());
        }

        bk.a(new bg("zone_state.txt"), d1);
        bl.a.b("Saved zone state");
    }

    void c()
    {
        if (b)
        {
            b();
        }
    }
}
