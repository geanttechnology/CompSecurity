// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.events;

import commonlib.loader.event.UpdateEvent;

public class DialogCallbackEvent extends UpdateEvent
{

    public static final String NEGATIVE_CLICK = "negative_click";
    public static final String POSITIVE_CLICK = "positive_click";
    protected String eventId;

    public DialogCallbackEvent(String s)
    {
        eventId = s;
    }

    public String getEventId()
    {
        return eventId;
    }
}
