// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.bumptech.glide.load.engine.bitmap_recycle:
//            Poolable

class GroupedLinkedMap
{
    private static class LinkedEntry
    {

        private final Object key;
        LinkedEntry next;
        LinkedEntry prev;
        private List values;

        public void add(Object obj)
        {
            if (values == null)
            {
                values = new ArrayList();
            }
            values.add(obj);
        }

        public Object removeLast()
        {
            int i = size();
            if (i > 0)
            {
                return values.remove(i - 1);
            } else
            {
                return null;
            }
        }

        public int size()
        {
            if (values != null)
            {
                return values.size();
            } else
            {
                return 0;
            }
        }


        public LinkedEntry()
        {
            this(null);
        }

        public LinkedEntry(Object obj)
        {
            prev = this;
            next = this;
            key = obj;
        }
    }


    private final LinkedEntry head = new LinkedEntry();
    private final Map keyToEntry = new HashMap();

    GroupedLinkedMap()
    {
    }

    private void makeHead(LinkedEntry linkedentry)
    {
        removeEntry(linkedentry);
        linkedentry.prev = head;
        linkedentry.next = head.next;
        updateEntry(linkedentry);
    }

    private void makeTail(LinkedEntry linkedentry)
    {
        removeEntry(linkedentry);
        linkedentry.prev = head.prev;
        linkedentry.next = head;
        updateEntry(linkedentry);
    }

    private static void removeEntry(LinkedEntry linkedentry)
    {
        linkedentry.prev.next = linkedentry.next;
        linkedentry.next.prev = linkedentry.prev;
    }

    private static void updateEntry(LinkedEntry linkedentry)
    {
        linkedentry.next.prev = linkedentry;
        linkedentry.prev.next = linkedentry;
    }

    public Object get(Poolable poolable)
    {
        LinkedEntry linkedentry = (LinkedEntry)keyToEntry.get(poolable);
        if (linkedentry == null)
        {
            linkedentry = new LinkedEntry(poolable);
            keyToEntry.put(poolable, linkedentry);
            poolable = linkedentry;
        } else
        {
            poolable.offer();
            poolable = linkedentry;
        }
        makeHead(poolable);
        return poolable.removeLast();
    }

    public void put(Poolable poolable, Object obj)
    {
        LinkedEntry linkedentry = (LinkedEntry)keyToEntry.get(poolable);
        if (linkedentry == null)
        {
            linkedentry = new LinkedEntry(poolable);
            makeTail(linkedentry);
            keyToEntry.put(poolable, linkedentry);
            poolable = linkedentry;
        } else
        {
            poolable.offer();
            poolable = linkedentry;
        }
        poolable.add(obj);
    }

    public Object removeLast()
    {
        for (LinkedEntry linkedentry = head.prev; !linkedentry.equals(head); linkedentry = linkedentry.prev)
        {
            Object obj = linkedentry.removeLast();
            if (obj != null)
            {
                return obj;
            }
            removeEntry(linkedentry);
            keyToEntry.remove(linkedentry.key);
            ((Poolable)linkedentry.key).offer();
        }

        return null;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry linkedentry = head.next;
        boolean flag = false;
        for (; !linkedentry.equals(head); linkedentry = linkedentry.next)
        {
            flag = true;
            stringbuilder.append('{').append(linkedentry.key).append(':').append(linkedentry.size()).append("}, ");
        }

        if (flag)
        {
            stringbuilder.delete(stringbuilder.length() - 2, stringbuilder.length());
        }
        return stringbuilder.append(" )").toString();
    }
}
