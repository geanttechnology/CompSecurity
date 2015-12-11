// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;
import java.util.List;

// Referenced classes of package com.google.api.services.now.model:
//            LocalTimeRange, TimeRange

public final class Context extends b
{

    private List anyOfActivityContexts;
    private List anyOfLocationContexts;
    private List anyOfLocations;
    private List anyOfTimeContexts;
    private String contextId;
    private LocalTimeRange localTimeRange;
    private TimeRange timeRange;

    public Context()
    {
    }

    public final volatile b clone()
    {
        return clone();
    }

    public final volatile l clone()
    {
        return clone();
    }

    public final Context clone()
    {
        return (Context)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final List getAnyOfActivityContexts()
    {
        return anyOfActivityContexts;
    }

    public final List getAnyOfLocationContexts()
    {
        return anyOfLocationContexts;
    }

    public final List getAnyOfLocations()
    {
        return anyOfLocations;
    }

    public final List getAnyOfTimeContexts()
    {
        return anyOfTimeContexts;
    }

    public final String getContextId()
    {
        return contextId;
    }

    public final LocalTimeRange getLocalTimeRange()
    {
        return localTimeRange;
    }

    public final TimeRange getTimeRange()
    {
        return timeRange;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final Context set(String s, Object obj)
    {
        return (Context)super.set(s, obj);
    }

    public final Context setAnyOfActivityContexts(List list)
    {
        anyOfActivityContexts = list;
        return this;
    }

    public final Context setAnyOfLocationContexts(List list)
    {
        anyOfLocationContexts = list;
        return this;
    }

    public final Context setAnyOfLocations(List list)
    {
        anyOfLocations = list;
        return this;
    }

    public final Context setAnyOfTimeContexts(List list)
    {
        anyOfTimeContexts = list;
        return this;
    }

    public final Context setContextId(String s)
    {
        contextId = s;
        return this;
    }

    public final Context setLocalTimeRange(LocalTimeRange localtimerange)
    {
        localTimeRange = localtimerange;
        return this;
    }

    public final Context setTimeRange(TimeRange timerange)
    {
        timeRange = timerange;
        return this;
    }
}
