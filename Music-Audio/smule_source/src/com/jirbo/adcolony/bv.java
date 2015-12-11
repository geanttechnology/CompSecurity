// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            cn, cl, h

class bv
{

    boolean a;
    cn b;
    cl c;

    bv()
    {
    }

    boolean a()
    {
        while (!b.a() || !c.a()) 
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
            if (!a)
            {
                return true;
            }
            b = new cn();
            if (b.a(h1.a("pre_popup")))
            {
                c = new cl();
                if (c.a(h1.a("post_popup")))
                {
                    return true;
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
            b.b();
            c.b();
            return;
        }
    }
}
