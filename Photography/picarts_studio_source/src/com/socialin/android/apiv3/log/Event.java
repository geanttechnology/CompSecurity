// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;


public class Event
{

    private String eventId;
    private int id;
    private String parameters;
    private String sessionId;
    private Long timeStamp;

    public Event()
    {
    }

    public Event(int i, String s, String s1, String s2, Long long1)
    {
        id = i;
        sessionId = s;
        eventId = s1;
        parameters = s2;
        timeStamp = long1;
    }

    public Event(String s, String s1, String s2, Long long1)
    {
        sessionId = s;
        eventId = s1;
        parameters = s2;
        timeStamp = long1;
    }

    public String getEventId()
    {
        return eventId;
    }

    public int getId()
    {
        return id;
    }

    public String getParameters()
    {
        return parameters;
    }

    public String getSessionId()
    {
        return sessionId;
    }

    public Long getTimeStamp()
    {
        return timeStamp;
    }

    public void setEventId(String s)
    {
        eventId = s;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setParameters(String s)
    {
        parameters = s;
    }

    public void setSessionId(String s)
    {
        sessionId = s;
    }

    public void setTimeStamp(Long long1)
    {
        timeStamp = long1;
    }
}
