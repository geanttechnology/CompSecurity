// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;

// Referenced classes of package com.google.api.services.now.model:
//            Timestamp

public final class TimeRange extends b
{

    private Timestamp endTime;
    private Timestamp startTime;

    public TimeRange()
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

    public final TimeRange clone()
    {
        return (TimeRange)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final Timestamp getEndTime()
    {
        return endTime;
    }

    public final Timestamp getStartTime()
    {
        return startTime;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final TimeRange set(String s, Object obj)
    {
        return (TimeRange)super.set(s, obj);
    }

    public final TimeRange setEndTime(Timestamp timestamp)
    {
        endTime = timestamp;
        return this;
    }

    public final TimeRange setStartTime(Timestamp timestamp)
    {
        startTime = timestamp;
        return this;
    }
}
