// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import java.util.concurrent.Executor;

// Referenced classes of package com.google.common.eventbus:
//            EventBus, Dispatcher, SubscriberExceptionHandler

public class AsyncEventBus extends EventBus
{

    public AsyncEventBus(String s, Executor executor)
    {
        super(s, executor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }

    public AsyncEventBus(Executor executor)
    {
        super("default", executor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }

    public AsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberexceptionhandler)
    {
        super("default", executor, Dispatcher.legacyAsync(), subscriberexceptionhandler);
    }
}
