// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e.b;

import com.b.e.c;
import com.b.e.g;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.b.e.b:
//            a

public final class b
{

    com.b.a.b a;
    public BlockingQueue b;
    private a c;

    public b(com.b.a.b b1)
    {
        b = new LinkedBlockingQueue();
        c = new a(TimeUnit.MILLISECONDS, b);
        a = b1;
    }

    public final boolean a(Runnable runnable, boolean flag)
    {
        if (!flag)
        {
            runnable.run();
            return true;
        }
        c.execute(runnable);
        return true;
        runnable;
        if (g.a)
        {
            com.b.e.c.a(getClass(), "Unable to queue a task: ");
            com.b.e.c.a(runnable);
            throw runnable;
        }
        break MISSING_BLOCK_LABEL_66;
        runnable;
        if (g.a)
        {
            com.b.e.c.a(getClass(), "Unexpected null error: ");
            com.b.e.c.a(runnable);
            throw runnable;
        }
        return false;
    }
}
