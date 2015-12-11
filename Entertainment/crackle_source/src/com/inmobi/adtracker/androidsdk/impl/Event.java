// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk.impl;

import java.io.Serializable;

public class Event
    implements Serializable
{

    private int mEventCount;
    private String mGoalName;

    public Event()
    {
        setEventCount(0);
        setGoalName(null);
    }

    public Event(String s, int i)
    {
        setEventCount(i);
        setGoalName(s);
    }

    public int getEventCount()
    {
        return mEventCount;
    }

    public String getGoalName()
    {
        return mGoalName;
    }

    public void setEventCount(int i)
    {
        mEventCount = i;
    }

    public void setGoalName(String s)
    {
        mGoalName = s;
    }
}
