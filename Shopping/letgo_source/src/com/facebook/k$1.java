// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.facebook:
//            k

static final class e
    implements ThreadFactory
{

    private final AtomicInteger a = new AtomicInteger(0);

    public Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, (new StringBuilder()).append("FacebookSdk #").append(a.incrementAndGet()).toString());
    }

    e()
    {
    }
}
