// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;


public class TimelineMarker
{

    protected long duration;
    protected long time;

    public TimelineMarker(long l, long l1)
    {
        duration = l1;
        time = l;
    }

    public long getDuration()
    {
        return duration;
    }

    public long getTime()
    {
        return time;
    }

    public void setDuration(long l)
    {
        duration = l;
    }

    public void setTime(long l)
    {
        time = l;
    }
}
