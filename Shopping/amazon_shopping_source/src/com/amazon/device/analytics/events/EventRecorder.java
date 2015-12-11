// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events;


// Referenced classes of package com.amazon.device.analytics.events:
//            Event

public interface EventRecorder
{

    public abstract void addGlobalAttribute(String s, String s1);

    public abstract Event createEvent(String s);

    public abstract void recordEvent(Event event);
}
