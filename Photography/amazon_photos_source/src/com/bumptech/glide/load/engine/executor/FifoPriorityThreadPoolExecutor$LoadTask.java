// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.executor;

import java.util.concurrent.FutureTask;

// Referenced classes of package com.bumptech.glide.load.engine.executor:
//            FifoPriorityThreadPoolExecutor, Prioritized

static class order extends FutureTask
    implements Comparable
{

    private final int order;
    private final int priority;

    public int compareTo(order order1)
    {
        int j = priority - order1.priority;
        int i = j;
        if (j == 0)
        {
            i = order - order1.order;
        }
        return i;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof compareTo)
        {
            obj = (compareTo)obj;
            flag = flag1;
            if (order == ((order) (obj)).order)
            {
                flag = flag1;
                if (priority == ((priority) (obj)).priority)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return priority * 31 + order;
    }

    public (Runnable runnable, Object obj, int i)
    {
        super(runnable, obj);
        if (!(runnable instanceof Prioritized))
        {
            throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
        } else
        {
            priority = ((Prioritized)runnable).getPriority();
            order = i;
            return;
        }
    }
}
