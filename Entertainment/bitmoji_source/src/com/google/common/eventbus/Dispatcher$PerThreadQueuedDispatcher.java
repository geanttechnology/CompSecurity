// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;

// Referenced classes of package com.google.common.eventbus:
//            Dispatcher, Subscriber

private static final class <init> extends Dispatcher
{
    private static final class Event
    {

        private final Object event;
        private final Iterator subscribers;



        private Event(Object obj, Iterator iterator)
        {
            event = obj;
            subscribers = iterator;
        }

        Event(Object obj, Iterator iterator, Dispatcher._cls1 _pcls1)
        {
            this(obj, iterator);
        }
    }


    private final ThreadLocal dispatching;
    private final ThreadLocal queue;

    void dispatch(Object obj, Iterator iterator)
    {
        Queue queue1;
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(iterator);
        queue1 = (Queue)queue.get();
        queue1.offer(new Event(obj, iterator, null));
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

    private _cls2.this._cls0()
    {
        queue = new ThreadLocal() {

            final Dispatcher.PerThreadQueuedDispatcher this$0;

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            protected Queue initialValue()
            {
                return Queues.newArrayDeque();
            }

            
            {
                this$0 = Dispatcher.PerThreadQueuedDispatcher.this;
                super();
            }
        };
        dispatching = new ThreadLocal() {

            final Dispatcher.PerThreadQueuedDispatcher this$0;

            protected Boolean initialValue()
            {
                return Boolean.valueOf(false);
            }

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            
            {
                this$0 = Dispatcher.PerThreadQueuedDispatcher.this;
                super();
            }
        };
    }

    _cls2.initialValue(_cls2.initialValue initialvalue)
    {
        this();
    }
}
