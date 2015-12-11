// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            al, q, ac, am

static final class 
{

    int a;
    int b;
    int c;
    String d;
    String e;
    boolean f;

    final boolean a()
    {
        if (!f)
        {
            return true;
        } else
        {
            return q.c.c.a(d);
        }
    }

    final boolean a(d d1)
    {
        boolean flag = true;
        if (d1 == null)
        {
            flag = false;
        } else
        {
            f = d1.("enabled", true);
            a = d1.("width");
            b = d1.("height");
            c = d1.("scale");
            d = d1.("image", "");
            e = d1.("image_last_modified", "");
            if (e.equals(""))
            {
                e = d1.("last_modified", "");
                return true;
            }
        }
        return flag;
    }

    final void b()
    {
        q.c.c.a(d, e);
    }

    ()
    {
    }
}
