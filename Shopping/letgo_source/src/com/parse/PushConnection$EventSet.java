// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.os.SystemClock;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.parse:
//            PushConnection

private static class <init>
{

    private final Condition condition;
    private final Lock lock;
    private final HashSet signaledEvents;

    public transient Set await(<init> a_3C_init>[])
    {
        return timedAwait(0x7fffffffffffffffL, a_3C_init>);
    }

    public transient void removeEvents(timedAwait atimedawait[])
    {
        lock.lock();
        int j = atimedawait.length;
        int i = 0;
_L2:
        timedAwait timedawait;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        timedawait = atimedawait[i];
        signaledEvents.remove(timedawait);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        lock.unlock();
        return;
        atimedawait;
        lock.unlock();
        throw atimedawait;
    }

    public void signalEvent(lock lock1)
    {
        lock.lock();
        signaledEvents.add(lock1);
        condition.signalAll();
        lock.unlock();
        return;
        lock1;
        lock.unlock();
        throw lock1;
    }

    public transient Set timedAwait(long l, lock alock[])
    {
        boolean flag;
        long l2;
        Object obj = Collections.EMPTY_SET;
        obj = new HashSet(Arrays.asList(alock));
        long l1 = SystemClock.elapsedRealtime();
        int i;
        if (l == 0x7fffffffffffffffL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        lock.lock();
_L3:
        l2 = SystemClock.elapsedRealtime() - l1;
        alock = new HashSet(((java.util.Collection) (obj)));
        alock.retainAll(signaledEvents);
        signaledEvents.removeAll(((java.util.Collection) (obj)));
        i = alock.size();
        if (i == 0 && (flag || l2 < l)) goto _L2; else goto _L1
_L1:
        lock.unlock();
        return alock;
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        condition.awaitUninterruptibly();
          goto _L3
        alock;
        lock.unlock();
        throw alock;
        condition.await(l - l2, TimeUnit.MILLISECONDS);
          goto _L3
        InterruptedException interruptedexception;
        interruptedexception;
          goto _L1
    }

    private on()
    {
        lock = new ReentrantLock();
        condition = lock.newCondition();
        signaledEvents = new HashSet();
    }

    signaledEvents(signaledEvents signaledevents)
    {
        this();
    }
}
