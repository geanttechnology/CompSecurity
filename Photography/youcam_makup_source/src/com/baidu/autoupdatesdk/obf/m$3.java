// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            m

class a
    implements ThreadFactory
{

    final m a;
    private final AtomicInteger b = new AtomicInteger(1);

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, (new StringBuilder()).append("AsyncHttpClient #").append(b.getAndIncrement()).toString());
        if (runnable.isDaemon())
        {
            runnable.setDaemon(false);
        }
        if (runnable.getPriority() != 4)
        {
            runnable.setPriority(4);
        }
        return runnable;
    }

    icInteger(m m1)
    {
        a = m1;
        super();
    }
}
