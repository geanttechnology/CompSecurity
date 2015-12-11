// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.task;

import com.comcast.cim.cmasl.utils.collections.LruLinkedHashMap;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.task:
//            TaskFactory, Task

public class CachingTaskFactory
    implements TaskFactory
{

    private final LruLinkedHashMap cache;
    private final TaskFactory _flddelegate;

    public CachingTaskFactory(TaskFactory taskfactory, int i)
    {
        _flddelegate = taskfactory;
        cache = new LruLinkedHashMap(i);
    }

    public Task get(Object obj)
    {
        Task task1 = (Task)cache.get(obj);
        Task task = task1;
        if (task1 == null)
        {
            Task task2 = _flddelegate.get(obj);
            task = task2;
            if (task2 != null)
            {
                cache.put(obj, task2);
                task = task2;
            }
        }
        return task;
    }
}
