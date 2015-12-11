// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.analytics;

import java.util.HashMap;
import java.util.Map;

public abstract class EventData
{

    protected Map eventData;

    public EventData()
    {
        eventData = new HashMap();
    }

    public void addData(String s, String s1)
    {
        eventData.put(s, s1);
    }

    public Map getEventData()
    {
        return eventData;
    }
}
