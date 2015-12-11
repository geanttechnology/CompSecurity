// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

// Referenced classes of package com.google.common.eventbus:
//            EventBus, SubscriberExceptionContext, AllowConcurrentEvents

class Subscriber
{
    static final class SynchronizedSubscriber extends Subscriber
    {

        void invokeSubscriberMethod(Object obj)
            throws InvocationTargetException
        {
            this;
            JVM INSTR monitorenter ;
            invokeSubscriberMethod(obj);
            this;
            JVM INSTR monitorexit ;
            return;
            obj;
            this;
            JVM INSTR monitorexit ;
            throw obj;
        }

        private SynchronizedSubscriber(EventBus eventbus, Object obj, Method method1)
        {
            super(eventbus, obj, method1, null);
        }

    }


    private EventBus bus;
    private final Executor executor;
    private final Method method;
    final Object target;

    private Subscriber(EventBus eventbus, Object obj, Method method1)
    {
        bus = eventbus;
        target = Preconditions.checkNotNull(obj);
        method = method1;
        method1.setAccessible(true);
        executor = eventbus.executor();
    }


    private SubscriberExceptionContext context(Object obj)
    {
        return new SubscriberExceptionContext(bus, obj, target, method);
    }

    static Subscriber create(EventBus eventbus, Object obj, Method method1)
    {
        if (isDeclaredThreadSafe(method1))
        {
            return new Subscriber(eventbus, obj, method1);
        } else
        {
            return new SynchronizedSubscriber(eventbus, obj, method1);
        }
    }

    private static boolean isDeclaredThreadSafe(Method method1)
    {
        return method1.getAnnotation(com/google/common/eventbus/AllowConcurrentEvents) != null;
    }

    final void dispatchEvent(final Object event)
    {
        executor.execute(new Runnable() {

            final Subscriber this$0;
            final Object val$event;

            public void run()
            {
                try
                {
                    invokeSubscriberMethod(event);
                    return;
                }
                catch (InvocationTargetException invocationtargetexception)
                {
                    bus.handleSubscriberException(invocationtargetexception.getCause(), context(event));
                }
            }

            
            {
                this$0 = Subscriber.this;
                event = obj;
                super();
            }
        });
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Subscriber)
        {
            obj = (Subscriber)obj;
            flag = flag1;
            if (target == ((Subscriber) (obj)).target)
            {
                flag = flag1;
                if (method.equals(((Subscriber) (obj)).method))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return (method.hashCode() + 31) * 31 + System.identityHashCode(target);
    }

    void invokeSubscriberMethod(Object obj)
        throws InvocationTargetException
    {
        try
        {
            method.invoke(target, new Object[] {
                Preconditions.checkNotNull(obj)
            });
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            obj = String.valueOf(obj);
            throw new Error((new StringBuilder(String.valueOf(obj).length() + 33)).append("Method rejected target/argument: ").append(((String) (obj))).toString(), illegalargumentexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            obj = String.valueOf(obj);
            throw new Error((new StringBuilder(String.valueOf(obj).length() + 28)).append("Method became inaccessible: ").append(((String) (obj))).toString(), illegalaccessexception);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (((InvocationTargetException) (obj)).getCause() instanceof Error)
        {
            throw (Error)((InvocationTargetException) (obj)).getCause();
        } else
        {
            throw obj;
        }
    }


}
