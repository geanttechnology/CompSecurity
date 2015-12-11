// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            CompositeDibicResource, DibicResource

public class CompositeDibicResourceCache
    implements Task
{

    private final Set caches;

    public transient CompositeDibicResourceCache(Task atask[])
    {
        caches = Collections.unmodifiableSet(Sets.newHashSet(atask));
    }

    public void clearCachedResult()
    {
    }

    public DibicResource execute()
    {
        java.util.HashSet hashset = Sets.newHashSet();
        for (Iterator iterator = caches.iterator(); iterator.hasNext(); hashset.add(((Task)iterator.next()).execute())) { }
        return new CompositeDibicResource(hashset);
    }

    public volatile Object execute()
    {
        return execute();
    }

    public DibicResource getCachedResultIfAvailable()
    {
        java.util.HashSet hashset = Sets.newHashSet();
        DibicResource dibicresource;
        for (Iterator iterator = caches.iterator(); iterator.hasNext(); hashset.add(dibicresource))
        {
            dibicresource = (DibicResource)((Task)iterator.next()).getCachedResultIfAvailable();
            if (dibicresource == null)
            {
                return null;
            }
        }

        return new CompositeDibicResource(hashset);
    }

    public volatile Object getCachedResultIfAvailable()
    {
        return getCachedResultIfAvailable();
    }

    public DibicResource getSecondLevelStaleResultIfAvailable()
    {
        return null;
    }

    public volatile Object getSecondLevelStaleResultIfAvailable()
    {
        return getSecondLevelStaleResultIfAvailable();
    }

    public DibicResource getStaleResultIfAvailable()
    {
        return null;
    }

    public volatile Object getStaleResultIfAvailable()
    {
        return getStaleResultIfAvailable();
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append(caches).toString();
    }
}
