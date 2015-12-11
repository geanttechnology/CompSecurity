// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            be

abstract class bj
{

    be n;

    bj(be be1)
    {
        this(be1, true);
    }

    bj(be be1, boolean flag)
    {
        n = be1;
        if (flag)
        {
            be1.a(this);
        }
    }

    abstract void b();
}
