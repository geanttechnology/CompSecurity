// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            cb, p, h, cl

final class a
    implements Runnable
{

    final cb a;

    public final void run()
    {
        cb cb1 = a;
        cb1.e.c(cb1);
        cb1 = a;
        if (cb1.a().f != null && !cb1.a().f.b())
        {
            cb1.g();
            cb1.a().c(true);
        }
    }

    (cb cb1)
    {
        a = cb1;
        super();
    }
}
