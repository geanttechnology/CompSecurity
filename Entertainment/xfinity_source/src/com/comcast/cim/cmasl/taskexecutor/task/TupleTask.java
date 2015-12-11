// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.task;

import com.comcast.cim.cmasl.utils.container.Tuple;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.task:
//            Task

public class TupleTask
    implements Task
{

    private final Task c1;
    private final Task c2;

    public TupleTask(Task task, Task task1)
    {
        c1 = task;
        c2 = task1;
    }

    public void clearCachedResult()
    {
        c1.clearCachedResult();
        c2.clearCachedResult();
    }

    public Tuple execute()
    {
        return new Tuple(c1.execute(), c2.execute());
    }

    public volatile Object execute()
    {
        return execute();
    }

    public Tuple getCachedResultIfAvailable()
    {
        Object obj = null;
        Object obj1 = c1.getCachedResultIfAvailable();
        Object obj2 = c2.getCachedResultIfAvailable();
        Tuple tuple = obj;
        if (obj1 != null)
        {
            tuple = obj;
            if (obj2 != null)
            {
                tuple = new Tuple(obj1, obj2);
            }
        }
        return tuple;
    }

    public volatile Object getCachedResultIfAvailable()
    {
        return getCachedResultIfAvailable();
    }

    public Tuple getSecondLevelStaleResultIfAvailable()
    {
        Object obj = null;
        Object obj1 = c1.getSecondLevelStaleResultIfAvailable();
        Object obj2 = c2.getSecondLevelStaleResultIfAvailable();
        Tuple tuple = obj;
        if (obj1 != null)
        {
            tuple = obj;
            if (obj2 != null)
            {
                tuple = new Tuple(obj1, obj2);
            }
        }
        return tuple;
    }

    public volatile Object getSecondLevelStaleResultIfAvailable()
    {
        return getSecondLevelStaleResultIfAvailable();
    }

    public Tuple getStaleResultIfAvailable()
    {
        Object obj = null;
        Object obj1 = c1.getStaleResultIfAvailable();
        Object obj2 = c2.getStaleResultIfAvailable();
        Tuple tuple = obj;
        if (obj1 != null)
        {
            tuple = obj;
            if (obj2 != null)
            {
                tuple = new Tuple(obj1, obj2);
            }
        }
        return tuple;
    }

    public volatile Object getStaleResultIfAvailable()
    {
        return getStaleResultIfAvailable();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append("[").append(c1.getClass().getName()).append("=").append(c1.toString()).append(",").append(c2.getClass().getName()).append("=").append(c2.toString()).append("]").toString();
    }
}
