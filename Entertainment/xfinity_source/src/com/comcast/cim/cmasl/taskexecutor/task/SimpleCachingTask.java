// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.task;


// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.task:
//            Task

public class SimpleCachingTask
    implements Task
{

    private Object cachedResult;
    private final Task _flddelegate;
    private final Object lock;

    public void clearCachedResult()
    {
        synchronized (lock)
        {
            cachedResult = null;
        }
        _flddelegate.clearCachedResult();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object execute()
    {
label0:
        {
            Object obj1;
            synchronized (lock)
            {
                if (cachedResult == null)
                {
                    break label0;
                }
                obj1 = cachedResult;
            }
            return obj1;
        }
        obj;
        JVM INSTR monitorexit ;
        Object obj2 = _flddelegate.execute();
        synchronized (lock)
        {
            cachedResult = obj2;
        }
        return obj2;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public Object getCachedResultIfAvailable()
    {
        Object obj1;
        synchronized (lock)
        {
            if (cachedResult == null)
            {
                cachedResult = _flddelegate.getCachedResultIfAvailable();
            }
            obj1 = cachedResult;
        }
        return obj1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object getSecondLevelStaleResultIfAvailable()
    {
        Object obj = getCachedResultIfAvailable();
        if (obj != null)
        {
            return obj;
        } else
        {
            return _flddelegate.getSecondLevelStaleResultIfAvailable();
        }
    }

    public Object getStaleResultIfAvailable()
    {
        Object obj = getCachedResultIfAvailable();
        if (obj != null)
        {
            return obj;
        } else
        {
            return _flddelegate.getStaleResultIfAvailable();
        }
    }
}
