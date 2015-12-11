// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ak, be, ct, ce, 
//            bz, h

class cf
{

    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    ce h;
    bz i;
    bz j;
    bz k;
    bz l;
    bz m;

    cf()
    {
    }

    boolean a()
    {
        while (!ak.c.c.a(a) || !ak.c.c.a(c) || !ak.c.c.a(e) || !h.a() || !i.a() || !j.a() || !k.a() || !l.a() || !m.a()) 
        {
            return false;
        }
        return true;
    }

    boolean a(h h1)
    {
        if (h1 != null)
        {
            a = h1.d("tiny_glow_image");
            b = h1.d("tiny_glow_image_last_modified;");
            c = h1.d("background_bar_image");
            d = h1.d("background_bar_image_last_modified");
            e = h1.d("background_tile_image");
            f = h1.d("background_tile_image_last_modified");
            g = h1.d("background_color");
            h = new ce();
            if (h.a(h1.a("logo")))
            {
                h = new ce();
                if (h.a(h1.a("logo")))
                {
                    i = new bz();
                    if (i.a(h1.a("stop")))
                    {
                        j = new bz();
                        if (j.a(h1.a("back")))
                        {
                            k = new bz();
                            if (k.a(h1.a("close")))
                            {
                                l = new bz();
                                if (l.a(h1.a("forward")))
                                {
                                    m = new bz();
                                    if (m.a(h1.a("reload")))
                                    {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    void b()
    {
        ak.c.c.a(a, b);
        ak.c.c.a(c, d);
        ak.c.c.a(e, f);
        h.b();
        i.b();
        j.b();
        k.b();
        l.b();
        m.b();
    }
}
