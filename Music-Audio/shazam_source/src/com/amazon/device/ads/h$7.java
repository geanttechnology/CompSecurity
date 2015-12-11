// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            h, g, v

final class a
    implements Runnable
{

    final v a;
    final h b;

    public final void run()
    {
        if (!b.n())
        {
            return;
        } else
        {
            b.b().a(a);
            return;
        }
    }

    (h h1, v v)
    {
        b = h1;
        a = v;
        super();
    }
}
