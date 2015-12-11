// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.smule.android.network.managers:
//            ak

class a
    implements Runnable
{

    final Runnable a;
    final ak b;

    public void run()
    {
        if (ak.b(b).getAndSet(true))
        {
            if (a != null)
            {
                a.run();
            }
        } else
        {
            ak.c(b);
            ak.b(b).set(false);
            if (a != null)
            {
                a.run();
                return;
            }
        }
    }

    n(ak ak1, Runnable runnable)
    {
        b = ak1;
        a = runnable;
        super();
    }
}
