// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.xfinity.playerlib.model.database.CachingVideoBookmarkDAO;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesResourceCache

public class SeriesCombinedTaskExecutorFactory
{

    private final CachingVideoBookmarkDAO cachingBookmarkDAO;
    private final Task dibicResourceCache;
    private final Task entitlementCache;
    private final TaskExecutorFactory providerFactory;

    public SeriesCombinedTaskExecutorFactory(TaskExecutorFactory taskexecutorfactory, Task task, Task task1, CachingVideoBookmarkDAO cachingvideobookmarkdao)
    {
        providerFactory = taskexecutorfactory;
        entitlementCache = task;
        dibicResourceCache = task1;
        cachingBookmarkDAO = cachingvideobookmarkdao;
    }

    public TaskExecutor create(Task task)
    {
        return providerFactory.create(new SeriesResourceCache(entitlementCache, task, dibicResourceCache, cachingBookmarkDAO));
    }
}
