// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

abstract class AggregateFutureState
{

    private static final AtomicIntegerFieldUpdater REMAINING_COUNT_UPDATER = AtomicIntegerFieldUpdater.newUpdater(com/google/common/util/concurrent/AggregateFutureState, "remaining");
    private static final AtomicReferenceFieldUpdater SEEN_EXCEPTIONS_UDPATER = AtomicReferenceFieldUpdater.newUpdater(com/google/common/util/concurrent/AggregateFutureState, java/util/Set, "seenExceptions");
    private volatile int remaining;
    private volatile Set seenExceptions;

    AggregateFutureState(int i)
    {
        seenExceptions = null;
        remaining = i;
    }

    abstract void addInitialException(Set set);

    final int decrementRemainingAndGet()
    {
        return REMAINING_COUNT_UPDATER.decrementAndGet(this);
    }

    final Set getOrInitSeenExceptions()
    {
        Set set1 = seenExceptions;
        Set set = set1;
        if (set1 == null)
        {
            set = Sets.newConcurrentHashSet();
            addInitialException(set);
            SEEN_EXCEPTIONS_UDPATER.compareAndSet(this, null, set);
            set = seenExceptions;
        }
        return set;
    }

}
