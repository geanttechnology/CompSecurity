// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            v, e

final class 
    implements Runnable
{

    final v a;

    public final void run()
    {
        if (a.D && a.d != null && a.P && a.a != null)
        {
            a.d.l = true;
            a.c();
        }
    }

    (v v1)
    {
        a = v1;
        super();
    }
}
