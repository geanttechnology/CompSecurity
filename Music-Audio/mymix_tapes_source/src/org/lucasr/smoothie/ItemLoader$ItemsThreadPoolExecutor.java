// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package org.lucasr.smoothie:
//            ItemLoader

private static final class  extends ThreadPoolExecutor
{

    public Future submit(Runnable runnable)
    {
        if (runnable == null)
        {
            throw new NullPointerException();
        } else
        {
            runnable = new >((>)runnable);
            execute(runnable);
            return runnable;
        }
    }

    public (int i, int j, long l, TimeUnit timeunit, BlockingQueue blockingqueue)
    {
        super(i, j, l, timeunit, blockingqueue);
    }
}
