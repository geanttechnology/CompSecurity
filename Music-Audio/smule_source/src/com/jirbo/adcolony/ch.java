// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ak, be, ct, h

class ch
{

    boolean a;
    String b;
    String c;

    ch()
    {
    }

    boolean a()
    {
        while (!a || ak.c.c.a(b)) 
        {
            return true;
        }
        return false;
    }

    boolean a(h h1)
    {
        boolean flag = true;
        if (h1 == null)
        {
            flag = false;
        } else
        {
            a = h1.g("enabled");
            if (a)
            {
                b = h1.d("url");
                c = h1.d("last_modified");
                return true;
            }
        }
        return flag;
    }

    void b()
    {
        ak.c.c.a(b, c);
    }
}
