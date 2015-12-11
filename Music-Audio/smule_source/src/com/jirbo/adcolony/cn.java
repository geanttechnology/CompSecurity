// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ak, be, ct, ce, 
//            cm, h

class cn
{

    String a;
    String b;
    ce c;
    cm d;

    cn()
    {
    }

    boolean a()
    {
        while (!ak.c.c.a(a) || !c.a() || !d.a()) 
        {
            return false;
        }
        return true;
    }

    boolean a(h h1)
    {
        a = h1.d("background_image");
        b = h1.d("background_image_last_modified");
        c = new ce();
        if (c.a(h1.a("background_logo")))
        {
            d = new cm();
            if (d.a(h1.a("dialog")))
            {
                return true;
            }
        }
        return false;
    }

    void b()
    {
        ak.c.c.a(a, b);
        c.b();
        d.b();
    }
}
