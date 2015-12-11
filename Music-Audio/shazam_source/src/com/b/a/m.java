// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.b.a:
//            b

final class m
    implements Runnable
{

    final b a;

    m(b b1)
    {
        a = b1;
        super();
    }

    public final void run()
    {
        if (a.D())
        {
            return;
        } else
        {
            a.z.getAndIncrement();
            a.f();
            return;
        }
    }
}
