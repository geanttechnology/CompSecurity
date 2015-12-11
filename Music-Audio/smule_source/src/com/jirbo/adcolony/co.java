// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ak, be, ct, bz, 
//            h

class co
{

    boolean a;
    int b;
    int c;
    String d;
    String e;
    bz f;
    bz g;
    bz h;
    bz i;

    co()
    {
    }

    boolean a()
    {
        if (a)
        {
            if (!ak.c.c.a(d))
            {
                return false;
            }
            if (!h.a())
            {
                return false;
            }
            if (!i.a())
            {
                return false;
            }
            if (!g.a())
            {
                return false;
            }
            if (!f.a())
            {
                return false;
            }
        }
        return true;
    }

    boolean a(h h1)
    {
        if (h1 != null)
        {
            a = h1.g("enabled");
            if (!a)
            {
                return true;
            }
            b = h1.f("width");
            c = h1.f("height");
            d = h1.d("background_image");
            e = h1.d("background_image_last_modified");
            if (ak.b != null)
            {
                d = ak.b;
            }
            h = new bz();
            if (h.a(h1.a("replay")))
            {
                i = new bz();
                if (i.a(h1.a("continue")))
                {
                    g = new bz();
                    if (g.a(h1.a("download")))
                    {
                        f = new bz();
                        if (f.a(h1.a("info")))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    void b()
    {
        if (!a)
        {
            return;
        } else
        {
            ak.c.c.a(d, e);
            h.b();
            i.b();
            g.b();
            f.b();
            return;
        }
    }
}
