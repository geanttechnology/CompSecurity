// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            gs, kr, gm

final class gt extends gs
{

    private gm a;
    private int b;
    private byte c[];
    private int d;

    gt(gm gm, int i, byte abyte0[], int j)
    {
        a = gm;
        b = i;
        c = abyte0;
        d = 0;
        super();
    }

    public final gm a()
    {
        return a;
    }

    public final void a(kr kr1)
    {
        kr1.b(c, d, b);
    }

    public final long b()
    {
        return (long)b;
    }
}
