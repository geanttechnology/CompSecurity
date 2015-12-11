// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            PausableThreadPoolExecutor

protected class runnable
    implements Runnable
{

    private Runnable runnable;
    final PausableThreadPoolExecutor this$0;

    public void run()
    {
        if (!isShutdown())
        {
            runnable.run();
        }
    }

    public (Runnable runnable1)
    {
        this$0 = PausableThreadPoolExecutor.this;
        super();
        runnable = runnable1;
    }
}
