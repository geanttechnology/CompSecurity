// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            af, h, k, j

public final class ad
{

    int a;
    final h b;
    final af c;
    boolean d;
    k e;

    public ad(h h1, af af1)
    {
        d = false;
        b = h1;
        if (af1 == null)
        {
            c = new af();
            return;
        } else
        {
            c = af1;
            return;
        }
    }

    final void a(j j)
    {
        b.o = j;
    }

    final void a(k k)
    {
        b.a(k);
    }
}
