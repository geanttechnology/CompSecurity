// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            h, bg, bk, d, 
//            ak, be, db

class by
{

    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    h h;

    by()
    {
    }

    boolean a(h h1)
    {
        if (h1 == null)
        {
            return true;
        }
        a = h1.a("update", null);
        b = h1.a("install", null);
        c = h1.a("dynamic_interests", null);
        d = h1.a("user_meta_data", null);
        e = h1.a("in_app_purchase", null);
        g = h1.a("session_end", null);
        f = h1.a("session_start", null);
        h = new h();
        h.b("update", a);
        h.b("install", b);
        h.b("dynamic_interests", c);
        h.b("user_meta_data", d);
        h.b("in_app_purchase", e);
        h.b("session_end", g);
        h.b("session_start", f);
        h1 = new bg("iap_cache.txt");
        d d1 = bk.c(h1);
        if (d1 != null)
        {
            for (int i = 0; i < d1.a_(); i++)
            {
                h h2 = d1.a(i, new h());
                ak.c.d.a("in_app_purchase", h2);
            }

            h1.c();
            ak.Q.j();
        }
        ak.w = true;
        return true;
    }
}
