// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import com.amazon.retailsearch.android.api.log.LogEventHandler;

public class DCMLogEventHandler
    implements LogEventHandler
{

    private Object event;

    public DCMLogEventHandler(Object obj)
    {
        event = obj;
    }

    public void clearEvent()
    {
        event = null;
    }

    public Object getEvent()
    {
        return event;
    }
}
