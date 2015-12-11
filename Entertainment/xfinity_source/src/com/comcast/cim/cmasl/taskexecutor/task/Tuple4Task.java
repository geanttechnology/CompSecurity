// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.task;

import com.comcast.cim.cmasl.utils.container.Tuple4;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.task:
//            Task

public class Tuple4Task
    implements Task
{

    private Task c1;
    private Task c2;
    private Task c3;
    private Task c4;

    public Tuple4Task(Task task, Task task1, Task task2, Task task3)
    {
        c1 = task;
        c2 = task1;
        c3 = task2;
        c4 = task3;
    }

    public void clearCachedResult()
    {
        c1.clearCachedResult();
        c2.clearCachedResult();
        c3.clearCachedResult();
        c4.clearCachedResult();
    }

    public Tuple4 execute()
    {
        return new Tuple4(c1.execute(), c2.execute(), c3.execute(), c4.execute());
    }

    public volatile Object execute()
    {
        return execute();
    }

    public Tuple4 getCachedResultIfAvailable()
    {
        Object obj = null;
        Object obj1 = c1.getCachedResultIfAvailable();
        Object obj2 = c2.getCachedResultIfAvailable();
        Object obj3 = c3.getCachedResultIfAvailable();
        Object obj4 = c4.getCachedResultIfAvailable();
        Tuple4 tuple4 = obj;
        if (obj1 != null)
        {
            tuple4 = obj;
            if (obj2 != null)
            {
                tuple4 = obj;
                if (obj3 != null)
                {
                    tuple4 = obj;
                    if (obj4 != null)
                    {
                        tuple4 = new Tuple4(obj1, obj2, obj3, obj4);
                    }
                }
            }
        }
        return tuple4;
    }

    public volatile Object getCachedResultIfAvailable()
    {
        return getCachedResultIfAvailable();
    }

    public Tuple4 getSecondLevelStaleResultIfAvailable()
    {
        Object obj = null;
        Object obj1 = c1.getSecondLevelStaleResultIfAvailable();
        Object obj2 = c2.getSecondLevelStaleResultIfAvailable();
        Object obj3 = c3.getSecondLevelStaleResultIfAvailable();
        Object obj4 = c4.getSecondLevelStaleResultIfAvailable();
        Tuple4 tuple4 = obj;
        if (obj1 != null)
        {
            tuple4 = obj;
            if (obj2 != null)
            {
                tuple4 = obj;
                if (obj3 != null)
                {
                    tuple4 = obj;
                    if (obj4 != null)
                    {
                        tuple4 = new Tuple4(obj1, obj2, obj3, obj4);
                    }
                }
            }
        }
        return tuple4;
    }

    public volatile Object getSecondLevelStaleResultIfAvailable()
    {
        return getSecondLevelStaleResultIfAvailable();
    }

    public Tuple4 getStaleResultIfAvailable()
    {
        Object obj = null;
        Object obj1 = c1.getStaleResultIfAvailable();
        Object obj2 = c2.getStaleResultIfAvailable();
        Object obj3 = c3.getStaleResultIfAvailable();
        Object obj4 = c4.getStaleResultIfAvailable();
        Tuple4 tuple4 = obj;
        if (obj1 != null)
        {
            tuple4 = obj;
            if (obj2 != null)
            {
                tuple4 = obj;
                if (obj3 != null)
                {
                    tuple4 = obj;
                    if (obj4 != null)
                    {
                        tuple4 = new Tuple4(obj1, obj2, obj3, obj4);
                    }
                }
            }
        }
        return tuple4;
    }

    public volatile Object getStaleResultIfAvailable()
    {
        return getStaleResultIfAvailable();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append("[").append(c1.getClass().getName()).append("=").append(c1.toString()).append(",").append(c2.getClass().getName()).append("=").append(c2.toString()).append(",").append(c3.getClass().getName()).append("=").append(c3.toString()).append(",").append(c4.getClass().getName()).append("=").append(c4.toString()).append("]").toString();
    }
}
