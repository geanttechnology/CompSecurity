// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.g.c:
//            c

public final class w extends ThreadPoolExecutor
{
    private static final class a extends FutureTask
        implements Comparable
    {

        private final c a;

        public final int compareTo(Object obj)
        {
            obj = (a)obj;
            u.e e = a.s;
            u.e e1 = ((a) (obj)).a.s;
            if (e == e1)
            {
                return a.a - ((a) (obj)).a.a;
            } else
            {
                return e1.ordinal() - e.ordinal();
            }
        }

        public a(c c1)
        {
            super(c1, null);
            a = c1;
        }
    }


    public w()
    {
        super(3, 3, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ah.b());
    }

    final void a(int i)
    {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public final Future submit(Runnable runnable)
    {
        runnable = new a((c)runnable);
        execute(runnable);
        return runnable;
    }
}
