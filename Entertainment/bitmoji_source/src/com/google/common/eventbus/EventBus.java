// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.eventbus:
//            Dispatcher, SubscriberRegistry, SubscriberExceptionHandler, DeadEvent, 
//            SubscriberExceptionContext

public class EventBus
{
    static final class LoggingHandler
        implements SubscriberExceptionHandler
    {

        static final LoggingHandler INSTANCE = new LoggingHandler();

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


        LoggingHandler()
        {
        }
    }


    private static final Logger logger = Logger.getLogger(com/google/common/eventbus/EventBus.getName());
    private final Dispatcher dispatcher;
    private final SubscriberExceptionHandler exceptionHandler;
    private final Executor executor;
    private final String identifier;
    private final SubscriberRegistry subscribers;

    public EventBus()
    {
        this("default");
    }

    public EventBus(SubscriberExceptionHandler subscriberexceptionhandler)
    {
        this("default", MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), subscriberexceptionhandler);
    }

    public EventBus(String s)
    {
        this(s, MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), ((SubscriberExceptionHandler) (LoggingHandler.INSTANCE)));
    }

    EventBus(String s, Executor executor1, Dispatcher dispatcher1, SubscriberExceptionHandler subscriberexceptionhandler)
    {
        subscribers = new SubscriberRegistry(this);
        identifier = (String)Preconditions.checkNotNull(s);
        executor = (Executor)Preconditions.checkNotNull(executor1);
        dispatcher = (Dispatcher)Preconditions.checkNotNull(dispatcher1);
        exceptionHandler = (SubscriberExceptionHandler)Preconditions.checkNotNull(subscriberexceptionhandler);
    }

    final Executor executor()
    {
        return executor;
    }

    void handleSubscriberException(Throwable throwable, SubscriberExceptionContext subscriberexceptioncontext)
    {
        Preconditions.checkNotNull(throwable);
        Preconditions.checkNotNull(subscriberexceptioncontext);
        try
        {
            exceptionHandler.handleException(throwable, subscriberexceptioncontext);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SubscriberExceptionContext subscriberexceptioncontext)
        {
            logger.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[] {
                subscriberexceptioncontext, throwable
            }), subscriberexceptioncontext);
        }
    }

    public final String identifier()
    {
        return identifier;
    }

    public void post(Object obj)
    {
        Iterator iterator = subscribers.getSubscribers(obj);
        if (iterator.hasNext())
        {
            dispatcher.dispatch(obj, iterator);
        } else
        if (!(obj instanceof DeadEvent))
        {
            post(new DeadEvent(this, obj));
            return;
        }
    }

    public void register(Object obj)
    {
        subscribers.register(obj);
    }

    public String toString()
    {
        return MoreObjects.toStringHelper(this).addValue(identifier).toString();
    }

    public void unregister(Object obj)
    {
        subscribers.unregister(obj);
    }

}
