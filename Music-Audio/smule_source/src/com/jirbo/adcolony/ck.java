// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ak, be, ct, ce, 
//            bz, h

class ck
{

    int a;
    String b;
    int c;
    int d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    ce l;
    bz m;

    ck()
    {
    }

    boolean a()
    {
        while (!ak.c.c.a(e) || !l.a() || !m.a()) 
        {
            return false;
        }
        return true;
    }

    boolean a(h h1)
    {
        a = h1.f("scale");
        b = h1.d("label_reward");
        c = h1.f("width");
        d = h1.f("height");
        e = h1.d("image");
        f = h1.d("image_last_modified");
        g = h1.d("label");
        h = h1.d("label_rgba");
        i = h1.d("label_shadow_rgba");
        j = h1.d("label_fraction");
        k = h1.d("label_html");
        l = new ce();
        if (l.a(h1.a("logo")))
        {
            m = new bz();
            if (m.a(h1.a("option_done")))
            {
                return true;
            }
        }
        return false;
    }

    void b()
    {
        ak.c.c.a(e, f);
        l.b();
        m.b();
    }
}
