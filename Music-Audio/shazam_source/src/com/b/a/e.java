// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.b.a:
//            b

final class e
    implements Runnable
{

    final b a;

    e(b b1)
    {
        a = b1;
        super();
    }

    public final void run()
    {
        while (a.D() || a.z.get() <= 0) 
        {
            return;
        }
        a.z.getAndDecrement();
        a.f();
    }
}
