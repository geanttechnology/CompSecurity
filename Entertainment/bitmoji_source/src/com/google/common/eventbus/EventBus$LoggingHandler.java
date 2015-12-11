// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.eventbus:
//            SubscriberExceptionHandler, EventBus, SubscriberExceptionContext

static final class xt
    implements SubscriberExceptionHandler
{

    static final xt INSTANCE = new <init>();

    private static Logger logger(SubscriberExceptionContext subscriberexceptioncontext)
    {
        String s = String.valueOf(com/google/common/eventbus/EventBus.getName());
        subscriberexceptioncontext = subscriberexceptioncontext.getEventBus().identifier();
        return Logger.getLogger((new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(subscriberexceptioncontext).length())).append(s).append(".").append(subscriberexceptioncontext).toString());
    }

    private static String message(SubscriberExceptionContext subscriberexceptioncontext)
    {
        Object obj = subscriberexceptioncontext.getSubscriberMethod();
        String s = String.valueOf(((Method) (obj)).getName());
        obj = String.valueOf(((Method) (obj)).getParameterTypes()[0].getName());
        String s1 = String.valueOf(subscriberexceptioncontext.getSubscriber());
        subscriberexceptioncontext = String.valueOf(subscriberexceptioncontext.getEvent());
        return (new StringBuilder(String.valueOf(s).length() + 80 + String.valueOf(obj).length() + String.valueOf(s1).length() + String.valueOf(subscriberexceptioncontext).length())).append("Exception thrown by subscriber method ").append(s).append("(").append(((String) (obj))).append(")").append(" on subscriber ").append(s1).append(" when dispatching event: ").append(subscriberexceptioncontext).toString();
    }

    public void handleException(Throwable throwable, SubscriberExceptionContext subscriberexceptioncontext)
    {
        Logger logger1 = logger(subscriberexceptioncontext);
        if (logger1.isLoggable(Level.SEVERE))
        {
            logger1.log(Level.SEVERE, message(subscriberexceptioncontext), throwable);
        }
    }


    xt()
    {
    }
}
