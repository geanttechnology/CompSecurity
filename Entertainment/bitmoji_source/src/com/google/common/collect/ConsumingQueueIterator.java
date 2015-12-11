// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Queue;

// Referenced classes of package com.google.common.collect:
//            AbstractIterator, Lists

class ConsumingQueueIterator extends AbstractIterator
{

    private final Queue queue;

    ConsumingQueueIterator(Queue queue1)
    {
        queue = (Queue)Preconditions.checkNotNull(queue1);
    }

    transient ConsumingQueueIterator(Object aobj[])
    {
        queue = Lists.newLinkedList();
        Collections.addAll(queue, aobj);
    }

    public Object computeNext()
    {
        if (queue.isEmpty())
        {
            return endOfData();
        } else
        {
            return queue.remove();
        }
    }
}
