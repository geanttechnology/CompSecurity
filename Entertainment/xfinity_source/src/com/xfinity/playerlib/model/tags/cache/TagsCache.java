// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags.cache;

import com.comcast.cim.cmasl.taskexecutor.task.BaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import java.util.List;

public abstract class TagsCache extends BaseTask
{

    private final Task tagsRootCache;

    public void clearCachedResult()
    {
    }

    public volatile Object execute()
    {
        return execute();
    }

    public List execute()
    {
        return getList((TagsRoot)tagsRootCache.execute());
    }

    public volatile Object getCachedResultIfAvailable()
    {
        return getCachedResultIfAvailable();
    }

    public List getCachedResultIfAvailable()
    {
        TagsRoot tagsroot = (TagsRoot)tagsRootCache.getCachedResultIfAvailable();
        if (tagsroot == null)
        {
            return null;
        } else
        {
            return getList(tagsroot);
        }
    }

    protected abstract List getList(TagsRoot tagsroot);

    public volatile Object getSecondLevelStaleResultIfAvailable()
    {
        return getSecondLevelStaleResultIfAvailable();
    }

    public List getSecondLevelStaleResultIfAvailable()
    {
        return null;
    }

    public volatile Object getStaleResultIfAvailable()
    {
        return getStaleResultIfAvailable();
    }

    public List getStaleResultIfAvailable()
    {
        return null;
    }
}
