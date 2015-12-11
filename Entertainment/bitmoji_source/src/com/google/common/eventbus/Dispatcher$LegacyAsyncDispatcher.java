// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.google.common.eventbus:
//            Dispatcher, Subscriber

private static final class <init> extends Dispatcher
{
    private static final class EventWithSubscriber
    {

        private final Object event;
        private final Subscriber subscriber;



        private EventWithSubscriber(Object obj, Subscriber subscriber1)
        {
            event = obj;
            subscriber = subscriber1;
        }

        EventWithSubscriber(Object obj, Subscriber subscriber1, Dispatcher._cls1 _pcls1)
        {
            this(obj, subscriber1);
        }
    }


    private final ConcurrentLinkedQueue queue;

    void dispatch(Object obj, Iterator iterator)
    {
        Preconditions.checkNotNull(obj);
        for (; iterator.hasNext(); queue.add(new EventWithSubscriber(obj, (Subscriber)iterator.next(), null))) { }
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

    private EventWithSubscriber()
    {
        queue = Queues.newConcurrentLinkedQueue();
    }

    queue(queue queue1)
    {
        this();
    }
}
