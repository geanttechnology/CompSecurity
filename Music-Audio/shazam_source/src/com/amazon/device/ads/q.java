// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            bj, bk, p, co, 
//            o

final class q
{

    private final co a;

    public q(co co)
    {
        a = co;
    }

    public final p a(o o)
    {
        if (o instanceof bj)
        {
            return new bk((bj)o);
        } else
        {
            return new p(o);
        }
    }
}
