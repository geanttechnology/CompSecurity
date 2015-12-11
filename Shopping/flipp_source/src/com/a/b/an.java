// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.a.b:
//            bc

final class an extends ThreadPoolExecutor
{

    an()
    {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new bc());
    }

    final void a(int i)
    {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }
}
