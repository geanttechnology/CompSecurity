// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SizeBoundedQueue
    implements Queue
{

    private static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/analytics/java/xua/SizeBoundedQueue);
    private int maxSize;
    private Queue queue;

    public SizeBoundedQueue()
    {
        this(100);
    }

    public SizeBoundedQueue(int i)
    {
        this(((Queue) (new ConcurrentLinkedQueue())), i);
    }

    public SizeBoundedQueue(Queue queue1, int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("Queue size must be greater than 0.");
        } else
        {
            logger.debug("new SizeBoundedQueue created");
            queue = queue1;
            maxSize = i;
            return;
        }
    }

    private void makeRoom(int i)
    {
        if (i >= maxSize)
        {
            queue.clear();
        } else
        {
            while (queue.size() + i > maxSize) 
            {
                queue.remove();
            }
        }
    }

    public boolean add(Object obj)
    {
        logger.debug("add");
        makeRoom(1);
        return queue.add(obj);
    }

    public boolean addAll(Collection collection)
    {
        if (collection == this)
        {
            throw new IllegalArgumentException("Cannot add a queue to itself.");
        }
        logger.debug("addAll");
        boolean flag = false;
        collection = collection.iterator();
        int i = 0;
        while (i < maxSize && collection.hasNext()) 
        {
            if (add(collection.next()) || flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i++;
        }
        return flag;
    }

    public void clear()
    {
        logger.debug("clear");
        queue.clear();
    }

    public boolean contains(Object obj)
    {
        logger.debug("contains");
        return queue.contains(obj);
    }

    public boolean containsAll(Collection collection)
    {
        logger.debug("containsAll");
        return queue.containsAll(collection);
    }

    public Object element()
    {
        logger.debug("element");
        return queue.element();
    }

    public boolean isEmpty()
    {
        logger.debug("isEmpty");
        return queue.isEmpty();
    }

    public Iterator iterator()
    {
        logger.debug("iterator");
        return queue.iterator();
    }

    public int maxSize()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        logger.debug("maxSize");
        i = maxSize;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean offer(Object obj)
    {
        logger.debug("offer");
        makeRoom(1);
        return queue.offer(obj);
    }

    public Object peek()
    {
        logger.debug("peek");
        return queue.peek();
    }

    public Object poll()
    {
        logger.debug("poll");
        return queue.poll();
    }

    public Object remove()
    {
        logger.debug("remove");
        return queue.remove();
    }

    public boolean remove(Object obj)
    {
        logger.debug("remove");
        return queue.remove(obj);
    }

    public boolean removeAll(Collection collection)
    {
        logger.debug("removeAll");
        return queue.removeAll(collection);
    }

    public boolean retainAll(Collection collection)
    {
        logger.debug("retainAll");
        return queue.retainAll(collection);
    }

    public void setMaxSize(int i)
    {
        this;
        JVM INSTR monitorenter ;
        logger.debug("setMaxSize");
        maxSize = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int size()
    {
        logger.debug("size");
        return queue.size();
    }

    public Object[] toArray()
    {
        logger.debug("toArray");
        return queue.toArray();
    }

    public Object[] toArray(Object aobj[])
    {
        logger.debug("toArray");
        return queue.toArray(aobj);
    }

}
