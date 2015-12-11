// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ak, be, ct, h

class bz
{

    boolean a;
    int b;
    int c;
    int d;
    int e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    String m;
    String n;
    String o;
    String p;

    bz()
    {
    }

    boolean a()
    {
        if (a)
        {
            if (!ak.c.c.a(f))
            {
                return false;
            }
            if (!ak.c.c.a(h))
            {
                return false;
            }
        }
        return true;
    }

    boolean a(h h1)
    {
        if (h1 == null)
        {
            return false;
        } else
        {
            a = h1.a("enabled", true);
            e = h1.f("delay");
            b = h1.f("width");
            c = h1.f("height");
            d = h1.f("scale");
            f = h1.d("image_normal");
            g = h1.d("image_normal_last_modified");
            h = h1.d("image_down");
            i = h1.d("image_down_last_modified");
            j = h1.d("click_action");
            k = h1.d("click_action_type");
            l = h1.d("label");
            m = h1.d("label_rgba");
            n = h1.d("label_shadow_rgba");
            o = h1.d("label_html");
            p = h1.d("event");
            return true;
        }
    }

    void b()
    {
        ak.c.c.a(f, g);
        ak.c.c.a(h, i);
    }
}
