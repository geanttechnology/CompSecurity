// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.google.common.eventbus:
//            Subscriber

abstract class Dispatcher
{
    private static final class ImmediateDispatcher extends Dispatcher
    {

        private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();

        void dispatch(Object obj, Iterator iterator)
        {
            Preconditions.checkNotNull(obj);
            for (; iterator.hasNext(); ((Subscriber)iterator.next()).dispatchEvent(obj)) { }
        }



        private ImmediateDispatcher()
        {
        }
    }

    private static final class LegacyAsyncDispatcher extends Dispatcher
    {

        private final ConcurrentLinkedQueue queue;

        void dispatch(Object obj, Iterator iterator)
        {
            Preconditions.checkNotNull(obj);
            for (; iterator.hasNext(); queue.add(new EventWithSubscriber(obj, (Subscriber)iterator.next()))) { }
            do
            {
                obj = (EventWithSubscriber)queue.poll();
                if (obj != null)
                {
                    ((EventWithSubscriber) (obj)).subscriber.dispatchEvent(((EventWithSubscriber) (obj)).event);
                } else
                {
                    return;
                }
            } while (true);
        }

        private LegacyAsyncDispatcher()
        {
            queue = Queues.newConcurrentLinkedQueue();
        }

    }

    private static final class LegacyAsyncDispatcher.EventWithSubscriber
    {

        private final Object event;
        private final Subscriber subscriber;



        private LegacyAsyncDispatcher.EventWithSubscriber(Object obj, Subscriber subscriber1)
        {
            event = obj;
            subscriber = subscriber1;
        }

    }

    private static final class PerThreadQueuedDispatcher extends Dispatcher
    {

        private final ThreadLocal dispatching;
        private final ThreadLocal queue;

        void dispatch(Object obj, Iterator iterator)
        {
            Queue queue1;
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(iterator);
            queue1 = (Queue)queue.get();
            queue1.offer(new Event(obj, iterator));
            if (((Boolean)dispatching.get()).booleanValue())
            {
                break MISSING_BLOCK_LABEL_144;
            }
            dispatching.set(Boolean.valueOf(true));
_L1:
            obj = (Event)queue1.poll();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_130;
            }
            while (((Event) (obj)).subscribers.hasNext()) 
            {
                ((Subscriber)((Event) (obj)).subscribers.next()).dispatchEvent(((Event) (obj)).event);
            }
              goto _L1
            obj;
            dispatching.remove();
            queue.remove();
            throw obj;
            dispatching.remove();
            queue.remove();
        }

        private PerThreadQueuedDispatcher()
        {
            queue = new _cls1();
            dispatching = new _cls2();
        }

    }

    private static final class PerThreadQueuedDispatcher.Event
    {

        private final Object event;
        private final Iterator subscribers;



        private PerThreadQueuedDispatcher.Event(Object obj, Iterator iterator)
        {
            event = obj;
            subscribers = iterator;
        }

    }


    Dispatcher()
    {
    }

    static Dispatcher immediate()
    {
        return ImmediateDispatcher.INSTANCE;
    }

    static Dispatcher legacyAsync()
    {
        return new LegacyAsyncDispatcher();
    }

    static Dispatcher perThreadDispatchQueue()
    {
        return new PerThreadQueuedDispatcher();
    }

    abstract void dispatch(Object obj, Iterator iterator);

    // Unreferenced inner class com/google/common/eventbus/Dispatcher$PerThreadQueuedDispatcher$1

/* anonymous class */
    class PerThreadQueuedDispatcher._cls1 extends ThreadLocal
    {

        final PerThreadQueuedDispatcher this$0;

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected Queue initialValue()
        {
            return Queues.newArrayDeque();
        }

            
            {
                this$0 = PerThreadQueuedDispatcher.this;
                super();
            }
    }


    // Unreferenced inner class com/google/common/eventbus/Dispatcher$PerThreadQueuedDispatcher$2

/* anonymous class */
    class PerThreadQueuedDispatcher._cls2 extends ThreadLocal
    {

        final PerThreadQueuedDispatcher this$0;

        protected Boolean initialValue()
        {
            return Boolean.valueOf(false);
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

            
            {
                this$0 = PerThreadQueuedDispatcher.this;
                super();
            }
    }

}
