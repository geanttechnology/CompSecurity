// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ac

abstract class ah
{

    ac n;

    ah(ac ac1)
    {
        this(ac1, true);
    }

    ah(ac ac1, boolean flag)
    {
        n = ac1;
        if (flag)
        {
            ac1.a(this);
        }
    }

    abstract void a();
}
