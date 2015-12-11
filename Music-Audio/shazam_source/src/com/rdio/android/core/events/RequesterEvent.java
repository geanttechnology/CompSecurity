// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events;


public class RequesterEvent
{

    private Object eventId;
    private Object requester;

    public RequesterEvent(Object obj, Object obj1)
    {
        requester = obj;
        eventId = obj1;
    }

    public Object getEventId()
    {
        return eventId;
    }

    public Object getRequester()
    {
        return requester;
    }
}
