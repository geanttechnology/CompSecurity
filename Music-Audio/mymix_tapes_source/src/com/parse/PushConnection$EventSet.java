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
        Set set = Collections.EMPTY_SET;
        HashSet hashset = new HashSet(Arrays.asList(alock));
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
        alock = set;
_L5:
        l2 = SystemClock.elapsedRealtime() - l1;
        alock = new HashSet(hashset);
        alock.retainAll(signaledEvents);
        signaledEvents.removeAll(hashset);
        i = alock.size();
        if (i == 0 && (flag || l2 < l)) goto _L2; else goto _L1
_L1:
        lock.unlock();
        return alock;
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        condition.awaitUninterruptibly();
        continue; /* Loop/switch isn't completed */
        try
        {
            condition.await(l - l2, TimeUnit.MILLISECONDS);
            continue; /* Loop/switch isn't completed */
        }
        catch (InterruptedException interruptedexception) { }
        finally
        {
            if (true) goto _L0; else goto _L0
        }
        if (true) goto _L1; else goto _L3
_L3:
        alock;
        lock.unlock();
        throw alock;
        if (true) goto _L5; else goto _L4
_L4:
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
