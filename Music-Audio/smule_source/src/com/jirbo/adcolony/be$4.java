// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            bj, be, s, q, 
//            bq, ay

class nit> extends bj
{

    final s a;
    final be b;

    void b()
    {
        if (q.c(a.b) || !a.f.equals("native"))
        {
            b.a("start", (new StringBuilder()).append("{\"ad_slot\":").append(a.c.k.d).append(", \"replay\":").append(a.n).append("}").toString(), a);
        }
    }

    (be be1, be be2, s s1)
    {
        b = be1;
        a = s1;
        super(be2);
    }
}
