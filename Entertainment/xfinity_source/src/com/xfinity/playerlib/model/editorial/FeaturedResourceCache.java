// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.editorial;

import com.comcast.cim.cmasl.taskexecutor.task.BaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;

// Referenced classes of package com.xfinity.playerlib.model.editorial:
//            FeaturedResource, EditorialMovieAndSeriesResource, EditorialVideoCoverResource

public class FeaturedResourceCache extends BaseTask
{

    private final Task movieAndSeriesCache;
    private final Task videoCoverCache;

    public FeaturedResourceCache(Task task, Task task1)
    {
        movieAndSeriesCache = task;
        videoCoverCache = task1;
    }

    public void clearCachedResult()
    {
    }

    public FeaturedResource execute()
    {
        return new FeaturedResource((EditorialMovieAndSeriesResource)movieAndSeriesCache.execute(), (EditorialVideoCoverResource)videoCoverCache.execute());
    }

    public volatile Object execute()
    {
        return execute();
    }

    public FeaturedResource getCachedResultIfAvailable()
    {
        Object obj = null;
        EditorialMovieAndSeriesResource editorialmovieandseriesresource = (EditorialMovieAndSeriesResource)movieAndSeriesCache.getCachedResultIfAvailable();
        EditorialVideoCoverResource editorialvideocoverresource = (EditorialVideoCoverResource)videoCoverCache.getCachedResultIfAvailable();
        FeaturedResource featuredresource = obj;
        if (editorialmovieandseriesresource != null)
        {
            featuredresource = obj;
            if (editorialvideocoverresource != null)
            {
                featuredresource = new FeaturedResource(editorialmovieandseriesresource, editorialvideocoverresource);
            }
        }
        return featuredresource;
    }

    public volatile Object getCachedResultIfAvailable()
    {
        return getCachedResultIfAvailable();
    }

    public FeaturedResource getSecondLevelStaleResultIfAvailable()
    {
        return null;
    }

    public volatile Object getSecondLevelStaleResultIfAvailable()
    {
        return getSecondLevelStaleResultIfAvailable();
    }

    public FeaturedResource getStaleResultIfAvailable()
    {
        return null;
    }

    public volatile Object getStaleResultIfAvailable()
    {
        return getStaleResultIfAvailable();
    }
}
