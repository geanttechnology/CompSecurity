// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            cx, ak, bl, ch, 
//            ce, bz, h

class cc
{

    boolean a;
    double b;
    boolean c;
    boolean d;
    String e;
    ch f;
    String g;
    ce h;
    bz i;
    bz j;

    cc()
    {
    }

    boolean a()
    {
        boolean flag1 = false;
        boolean flag;
        if (!cx.c())
        {
            ak.T = 8;
            flag = bl.c.b("Ad not ready due to no network connection.");
        } else
        {
            flag = flag1;
            if (a)
            {
                flag = flag1;
                if (f.a())
                {
                    flag = flag1;
                    if (h.a())
                    {
                        flag = flag1;
                        if (i.a())
                        {
                            flag = flag1;
                            if (j.a())
                            {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    boolean a(h h1)
    {
        if (h1 != null)
        {
            a = h1.g("enabled");
            b = h1.e("load_timeout");
            c = h1.g("load_timeout_enabled");
            d = h1.g("load_spinner_enabled");
            e = h1.d("background_color");
            g = h1.d("html5_tag");
            f = new ch();
            if (f.a(h1.a("mraid_js")))
            {
                h = new ce();
                if (h.a(h1.a("background_logo")))
                {
                    i = new bz();
                    if (i.a(h1.a("replay")))
                    {
                        j = new bz();
                        if (j.a(h1.a("close")))
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
        if (a)
        {
            if (f != null)
            {
                f.b();
            }
            if (h != null)
            {
                h.b();
            }
            if (i != null)
            {
                i.b();
            }
            if (j != null)
            {
                j.b();
                return;
            }
        }
    }
}
