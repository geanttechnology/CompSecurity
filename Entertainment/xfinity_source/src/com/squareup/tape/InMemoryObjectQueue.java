// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.tape;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

// Referenced classes of package com.squareup.tape:
//            ObjectQueue

public class InMemoryObjectQueue
    implements ObjectQueue
{

    private ObjectQueue.Listener listener;
    private final Queue tasks = new LinkedList();

    public InMemoryObjectQueue()
    {
    }

    public void add(Object obj)
    {
        tasks.add(obj);
        if (listener != null)
        {
            listener.onAdd(this, obj);
        }
    }

    public Object peek()
    {
        return tasks.peek();
    }

    public void remove()
    {
        tasks.remove();
        if (listener != null)
        {
            listener.onRemove(this);
        }
    }

    public void setListener(ObjectQueue.Listener listener1)
    {
        if (listener1 != null)
        {
            for (Iterator iterator = tasks.iterator(); iterator.hasNext(); listener1.onAdd(this, iterator.next())) { }
        }
        listener = listener1;
    }

    public int size()
    {
        return tasks.size();
    }
}
