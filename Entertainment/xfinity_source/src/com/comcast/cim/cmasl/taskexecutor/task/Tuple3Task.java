// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.task;

import com.comcast.cim.cmasl.utils.container.Tuple3;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.task:
//            Task

public class Tuple3Task
    implements Task
{

    private final Task c1;
    private final Task c2;
    private final Task c3;

    public Tuple3Task(Task task, Task task1, Task task2)
    {
        c1 = task;
        c2 = task1;
        c3 = task2;
    }

    public void clearCachedResult()
    {
        c1.clearCachedResult();
        c2.clearCachedResult();
        c3.clearCachedResult();
    }

    public Tuple3 execute()
    {
        return new Tuple3(c1.execute(), c2.execute(), c3.execute());
    }

    public volatile Object execute()
    {
        return execute();
    }

    public Tuple3 getCachedResultIfAvailable()
    {
        Object obj = null;
        Object obj1 = c1.getCachedResultIfAvailable();
        Object obj2 = c2.getCachedResultIfAvailable();
        Object obj3 = c3.getCachedResultIfAvailable();
        Tuple3 tuple3 = obj;
        if (obj1 != null)
        {
            tuple3 = obj;
            if (obj2 != null)
            {
                tuple3 = obj;
                if (obj3 != null)
                {
                    tuple3 = new Tuple3(obj1, obj2, obj3);
                }
            }
        }
        return tuple3;
    }

    public volatile Object getCachedResultIfAvailable()
    {
        return getCachedResultIfAvailable();
    }

    public Tuple3 getSecondLevelStaleResultIfAvailable()
    {
        Object obj = null;
        Object obj1 = c1.getSecondLevelStaleResultIfAvailable();
        Object obj2 = c2.getSecondLevelStaleResultIfAvailable();
        Object obj3 = c3.getSecondLevelStaleResultIfAvailable();
        Tuple3 tuple3 = obj;
        if (obj1 != null)
        {
            tuple3 = obj;
            if (obj2 != null)
            {
                tuple3 = obj;
                if (obj3 != null)
                {
                    tuple3 = new Tuple3(obj1, obj2, obj3);
                }
            }
        }
        return tuple3;
    }

    public volatile Object getSecondLevelStaleResultIfAvailable()
    {
        return getSecondLevelStaleResultIfAvailable();
    }

    public Tuple3 getStaleResultIfAvailable()
    {
        Object obj = null;
        Object obj1 = c1.getStaleResultIfAvailable();
        Object obj2 = c2.getStaleResultIfAvailable();
        Object obj3 = c3.getStaleResultIfAvailable();
        Tuple3 tuple3 = obj;
        if (obj1 != null)
        {
            tuple3 = obj;
            if (obj2 != null)
            {
                tuple3 = obj;
                if (obj3 != null)
                {
                    tuple3 = new Tuple3(obj1, obj2, obj3);
                }
            }
        }
        return tuple3;
    }

    public volatile Object getStaleResultIfAvailable()
    {
        return getStaleResultIfAvailable();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append("[").append(c1.getClass().getName()).append("=").append(c1.toString()).append(",").append(c2.getClass().getName()).append("=").append(c2.toString()).append(",").append(c3.getClass().getName()).append("=").append(c3.toString()).append("]").toString();
    }
}
