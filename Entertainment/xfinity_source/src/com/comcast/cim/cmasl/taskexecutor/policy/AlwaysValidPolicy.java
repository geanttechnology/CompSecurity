// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.policy;


// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.policy:
//            RevalidationPolicy

public class AlwaysValidPolicy
    implements RevalidationPolicy
{

    public AlwaysValidPolicy()
    {
    }

    public Integer getCurrentVersion()
    {
        return Integer.valueOf(0);
    }

    public volatile Object getCurrentVersion()
    {
        return getCurrentVersion();
    }

    public boolean shouldFallBackToLastCached(Integer integer)
    {
        return false;
    }

    public volatile boolean shouldFallBackToLastCached(Object obj)
    {
        return shouldFallBackToLastCached((Integer)obj);
    }

    public boolean shouldRevalidate(Integer integer)
    {
        return false;
    }

    public volatile boolean shouldRevalidate(Object obj)
    {
        return shouldRevalidate((Integer)obj);
    }
}
