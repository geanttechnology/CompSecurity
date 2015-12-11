// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ao, bc, dq

static final class <init>
{

    boolean a;
    String b;
    boolean c;
    String d;
    private final bc e;

    final String a()
    {
        return e.a("debug.idfa", b);
    }

    final boolean b()
    {
        return !dq.a(a());
    }

    final boolean c()
    {
        return e.a("debug.optOut", Boolean.valueOf(c)).booleanValue();
    }

    final String d()
    {
        return e.a("debug.adid", d);
    }

    final boolean e()
    {
        return d() != null;
    }

    private (bc bc1)
    {
        e = bc1;
        a = true;
    }

    a(bc bc1, byte byte0)
    {
        this(bc1);
    }
}
