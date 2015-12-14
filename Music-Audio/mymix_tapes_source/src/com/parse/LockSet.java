// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

class LockSet
{

    private static long nextStableId = 0L;
    private static WeakHashMap stableIds = new WeakHashMap();
    private final Set locks = new TreeSet(new Comparator() {

        final LockSet this$0;

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Lock)obj, (Lock)obj1);
        }

        public int compare(Lock lock1, Lock lock2)
        {
            return LockSet.getStableId(lock1).compareTo(LockSet.getStableId(lock2));
        }

            
            {
                this$0 = LockSet.this;
                super();
            }
    });

    public LockSet(Collection collection)
    {
        locks.addAll(collection);
    }

    private static Long getStableId(Lock lock1)
    {
label0:
        {
            synchronized (stableIds)
            {
                if (!stableIds.containsKey(lock1))
                {
                    break label0;
                }
                lock1 = (Long)stableIds.get(lock1);
            }
            return lock1;
        }
        long l;
        l = nextStableId;
        nextStableId = 1L + l;
        stableIds.put(lock1, Long.valueOf(l));
        weakhashmap;
        JVM INSTR monitorexit ;
        return Long.valueOf(l);
        lock1;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw lock1;
    }

    public void lock()
    {
        for (Iterator iterator = locks.iterator(); iterator.hasNext(); ((Lock)iterator.next()).lock()) { }
    }

    public void unlock()
    {
        for (Iterator iterator = locks.iterator(); iterator.hasNext(); ((Lock)iterator.next()).unlock()) { }
    }


}
