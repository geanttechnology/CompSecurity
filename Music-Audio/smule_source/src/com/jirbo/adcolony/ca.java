// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            cc, co, h

class ca
{

    String a;
    int b;
    int c;
    boolean d;
    boolean e;
    boolean f;
    double g;
    co h;
    cc i;

    ca()
    {
    }

    boolean a()
    {
        if (!i.a || i.a())
        {
            if (!d)
            {
                return true;
            }
            if (h.a() || i.a())
            {
                return true;
            }
        }
        return false;
    }

    boolean a(h h1)
    {
        if (h1 != null)
        {
            d = h1.g("enabled");
            if (!d)
            {
                return true;
            }
            a = h1.d("uuid");
            b = h1.f("ad_id");
            c = h1.f("ad_campaign_id");
            e = h1.g("dissolve");
            f = h1.g("enable_in_app_store");
            g = h1.e("dissolve_delay");
            h = new co();
            if (h.a(h1.a("static")))
            {
                i = new cc();
                if (i.a(h1.a("html5")))
                {
                    return true;
                }
            }
        }
        return false;
    }

    void b()
    {
        if (!d)
        {
            return;
        } else
        {
            h.b();
            i.b();
            return;
        }
    }
}
