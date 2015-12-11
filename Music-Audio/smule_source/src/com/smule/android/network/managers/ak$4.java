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

    final ak a;

    public void run()
    {
        ak.b(a).getAndSet(true);
        ak.c(a);
        ak.b(a).getAndSet(false);
    }

    n(ak ak1)
    {
        a = ak1;
        super();
    }
}
