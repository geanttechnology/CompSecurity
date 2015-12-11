// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ak, be, ct, h

class ce
{

    int a;
    int b;
    int c;
    String d;
    String e;
    boolean f;

    ce()
    {
    }

    boolean a()
    {
        if (!f)
        {
            return true;
        } else
        {
            return ak.c.c.a(d);
        }
    }

    boolean a(h h1)
    {
        boolean flag = true;
        if (h1 == null)
        {
            flag = false;
        } else
        {
            f = h1.a("enabled", true);
            a = h1.f("width");
            b = h1.f("height");
            c = h1.f("scale");
            d = h1.d("image");
            e = h1.d("image_last_modified");
            if (e.equals(""))
            {
                e = h1.d("last_modified");
                return true;
            }
        }
        return flag;
    }

    void b()
    {
        ak.c.c.a(d, e);
    }
}
