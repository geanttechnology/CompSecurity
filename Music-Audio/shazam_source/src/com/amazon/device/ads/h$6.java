// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            h, g, k

final class b
    implements Runnable
{

    final k a;
    final boolean b;
    final h c;

    public final void run()
    {
        c.b().a(a);
        c.c(b);
    }

    (h h1, k k, boolean flag)
    {
        c = h1;
        a = k;
        b = flag;
        super();
    }
}
