// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ak, be, ct, h

class cd
{

    boolean a;
    String b;
    String c;

    cd()
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
        if (h1 == null)
        {
            return false;
        } else
        {
            a = h1.a("enabled", false);
            b = h1.d("file_url");
            c = h1.d("last_modified");
            return true;
        }
    }

    void b()
    {
        ak.c.c.a(b, c);
    }
}
