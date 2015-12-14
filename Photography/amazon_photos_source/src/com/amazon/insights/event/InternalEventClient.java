// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.event;

import com.amazon.insights.Event;
import com.amazon.insights.EventClient;

public interface InternalEventClient
    extends EventClient
{

    public abstract void recordEvent(Event event, boolean flag);
}
