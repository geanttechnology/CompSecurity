// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.framework.network:
//            NetworkExecutor

class this._cls0
    implements ThreadFactory
{

    private final AtomicInteger count = new AtomicInteger(1);
    final NetworkExecutor this$0;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, (new StringBuilder()).append("NetworkExecutor BGThread#").append(count.getAndIncrement()).toString());
        runnable.setPriority(2);
        return runnable;
    }

    ()
    {
        this$0 = NetworkExecutor.this;
        super();
    }
}
