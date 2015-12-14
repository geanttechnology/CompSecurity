// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.metadata.processing;


public interface EventIdStore
{
    public static class EventIdRange
    {

        public final long lowerEventId;
        public final long maximumEventId;
        public final long upperEventId;

        public EventIdRange(long l, long l1, long l2)
        {
            lowerEventId = l;
            upperEventId = l1;
            maximumEventId = l2;
        }
    }


    public abstract EventIdRange getEventIdRange(String s);

    public abstract void updateEventIdRange(String s, EventIdRange eventidrange);
}
