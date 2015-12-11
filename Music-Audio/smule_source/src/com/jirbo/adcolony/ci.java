// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ak, be, ct, ce, 
//            h, cj

class ci
{

    boolean a;
    boolean b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    cj j;
    ce k;
    ce l;

    ci()
    {
    }

    boolean a()
    {
        while (!a || !ak.c.c.a(c) || !ak.c.c.a(g) || !k.a() || !l.a()) 
        {
            return false;
        }
        return true;
    }

    boolean a(h h1)
    {
        if (h1 != null)
        {
            a = h1.g("enabled");
            c = h1.d("poster_image");
            d = h1.d("advertiser_name");
            e = h1.d("description");
            f = h1.d("title");
            g = h1.d("thumb_image");
            h = h1.d("poster_image_last_modified");
            i = h1.d("thumb_image_last_modified");
            k = new ce();
            if (k.a(h1.a("mute")))
            {
                b = k.f;
                l = new ce();
                if (l.a(h1.a("unmute")))
                {
                    j = new cj();
                    if (j.a(h1.a("overlay")))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    void b()
    {
        ak.c.c.a(c, h);
        ak.c.c.a(g, i);
        k.b();
        l.b();
    }
}
