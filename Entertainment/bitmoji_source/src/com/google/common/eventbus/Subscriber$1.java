// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.google.common.eventbus:
//            Subscriber, EventBus

class val.event
    implements Runnable
{

    final Subscriber this$0;
    final Object val$event;

    public void run()
    {
        try
        {
            invokeSubscriberMethod(val$event);
            return;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Subscriber.access$200(Subscriber.this).handleSubscriberException(invocationtargetexception.getCause(), Subscriber.access$100(Subscriber.this, val$event));
        }
    }

    ion()
    {
        this$0 = final_subscriber;
        val$event = Object.this;
        super();
    }
}
