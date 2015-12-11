// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.google.common.eventbus:
//            Subscriber, EventBus

static final class <init> extends Subscriber
{

    void invokeSubscriberMethod(Object obj)
        throws InvocationTargetException
    {
        this;
        JVM INSTR monitorenter ;
        super.invokeSubscriberMethod(obj);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private (EventBus eventbus, Object obj, Method method)
    {
        super(eventbus, obj, method, null);
    }

    (EventBus eventbus, Object obj, Method method,  )
    {
        this(eventbus, obj, method);
    }
}
