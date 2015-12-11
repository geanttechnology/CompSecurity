// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class Monitor
{
    public static abstract class Guard
    {

        final Condition condition;
        final Monitor monitor;
        Guard next;
        int waiterCount;

        public abstract boolean isSatisfied();

        protected Guard(Monitor monitor1)
        {
            waiterCount = 0;
            monitor = (Monitor)Preconditions.checkNotNull(monitor1, "monitor");
            condition = monitor1.lock.newCondition();
        }
    }


    private Guard activeGuards;
    private final boolean fair;
    private final ReentrantLock lock;

    public Monitor()
    {
        this(false);
    }

    public Monitor(boolean flag)
    {
        activeGuards = null;
        fair = flag;
        lock = new ReentrantLock(flag);
    }

    private void await(Guard guard, boolean flag)
        throws InterruptedException
    {
        if (flag)
        {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do
        {
            guard.condition.await();
            flag = guard.isSatisfied();
        } while (!flag);
        endWaitingFor(guard);
        return;
        Exception exception;
        exception;
        endWaitingFor(guard);
        throw exception;
    }

    private boolean awaitNanos(Guard guard, long l, boolean flag)
        throws InterruptedException
    {
        boolean flag1 = true;
_L4:
        if (l > 0L) goto _L2; else goto _L1
_L1:
        boolean flag4 = false;
        flag = flag4;
        if (!flag1)
        {
            endWaitingFor(guard);
            flag = flag4;
        }
_L6:
        return flag;
_L2:
        boolean flag2;
        boolean flag3;
        flag2 = flag1;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        flag3 = flag1;
        signalNextWaiter();
        flag3 = flag1;
        beginWaitingFor(guard);
        flag2 = false;
        flag3 = flag2;
        l = guard.condition.awaitNanos(l);
        flag3 = flag2;
        boolean flag5 = guard.isSatisfied();
        flag1 = flag2;
        if (!flag5) goto _L4; else goto _L3
_L3:
        flag = true;
        if (flag2) goto _L6; else goto _L5
_L5:
        endWaitingFor(guard);
        return true;
        Exception exception;
        exception;
        if (!flag3)
        {
            endWaitingFor(guard);
        }
        throw exception;
    }

    private void awaitUninterruptibly(Guard guard, boolean flag)
    {
        if (flag)
        {
            signalNextWaiter();
        }
        beginWaitingFor(guard);
        do
        {
            guard.condition.awaitUninterruptibly();
            flag = guard.isSatisfied();
        } while (!flag);
        endWaitingFor(guard);
        return;
        Exception exception;
        exception;
        endWaitingFor(guard);
        throw exception;
    }

    private void beginWaitingFor(Guard guard)
    {
        int i = guard.waiterCount;
        guard.waiterCount = i + 1;
        if (i == 0)
        {
            guard.next = activeGuards;
            activeGuards = guard;
        }
    }

    private void endWaitingFor(Guard guard)
    {
        int i;
        i = guard.waiterCount - 1;
        guard.waiterCount = i;
        if (i != 0) goto _L2; else goto _L1
_L1:
        Guard guard1;
        Guard guard2;
        guard1 = activeGuards;
        guard2 = null;
_L6:
        if (guard1 != guard) goto _L4; else goto _L3
_L3:
        if (guard2 == null)
        {
            activeGuards = guard1.next;
        } else
        {
            guard2.next = guard1.next;
        }
        guard1.next = null;
_L2:
        return;
_L4:
        guard2 = guard1;
        guard1 = guard1.next;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static long initNanoTime(long l)
    {
        if (l <= 0L)
        {
            l = 0L;
        } else
        {
            long l1 = System.nanoTime();
            l = l1;
            if (l1 == 0L)
            {
                return 1L;
            }
        }
        return l;
    }

    private boolean isSatisfied(Guard guard)
    {
        boolean flag;
        try
        {
            flag = guard.isSatisfied();
        }
        // Misplaced declaration of an exception variable
        catch (Guard guard)
        {
            signalAllWaiters();
            throw Throwables.propagate(guard);
        }
        return flag;
    }

    private static long remainingNanos(long l, long l1)
    {
        if (l1 <= 0L)
        {
            return 0L;
        } else
        {
            return l1 - (System.nanoTime() - l);
        }
    }

    private void signalAllWaiters()
    {
        for (Guard guard = activeGuards; guard != null; guard = guard.next)
        {
            guard.condition.signalAll();
        }

    }

    private void signalNextWaiter()
    {
        Guard guard = activeGuards;
        do
        {
label0:
            {
                if (guard != null)
                {
                    if (!isSatisfied(guard))
                    {
                        break label0;
                    }
                    guard.condition.signal();
                }
                return;
            }
            guard = guard.next;
        } while (true);
    }

    private static long toSafeNanos(long l, TimeUnit timeunit)
    {
        long l1 = timeunit.toNanos(l);
        if (l1 <= 0L)
        {
            l = 0L;
        } else
        {
            l = l1;
            if (l1 > 0x5ffffffffffffffdL)
            {
                return 0x5ffffffffffffffdL;
            }
        }
        return l;
    }

    public void enter()
    {
        lock.lock();
    }

    public boolean enter(long l, TimeUnit timeunit)
    {
        long l1;
        l1 = toSafeNanos(l, timeunit);
        timeunit = lock;
        if (fair || !timeunit.tryLock()) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L6:
        return flag1;
_L2:
        boolean flag;
        flag = Thread.interrupted();
        flag1 = flag;
        long l2 = System.nanoTime();
        l = l1;
_L4:
        flag1 = flag;
        boolean flag2 = timeunit.tryLock(l, TimeUnit.NANOSECONDS);
        flag1 = flag2;
        if (flag)
        {
            Thread.currentThread().interrupt();
            return flag2;
        }
        continue; /* Loop/switch isn't completed */
        InterruptedException interruptedexception;
        interruptedexception;
        flag1 = true;
        flag = true;
        l = remainingNanos(l2, l1);
        if (true) goto _L4; else goto _L3
_L3:
        timeunit;
        if (flag1)
        {
            Thread.currentThread().interrupt();
        }
        throw timeunit;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean enterIf(Guard guard)
    {
        ReentrantLock reentrantlock;
        if (guard.monitor != this)
        {
            throw new IllegalMonitorStateException();
        }
        reentrantlock = lock;
        reentrantlock.lock();
        boolean flag = guard.isSatisfied();
        if (!flag)
        {
            reentrantlock.unlock();
        }
        return flag;
        guard;
        if (true)
        {
            reentrantlock.unlock();
        }
        throw guard;
    }

    public boolean enterIf(Guard guard, long l, TimeUnit timeunit)
    {
        if (guard.monitor != this)
        {
            throw new IllegalMonitorStateException();
        }
        if (enter(l, timeunit)) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        boolean flag1 = guard.isSatisfied();
        flag = flag1;
        if (flag1) goto _L4; else goto _L3
_L3:
        lock.unlock();
        return flag1;
        guard;
        if (true)
        {
            lock.unlock();
        }
        throw guard;
    }

    public boolean enterIfInterruptibly(Guard guard)
        throws InterruptedException
    {
        ReentrantLock reentrantlock;
        if (guard.monitor != this)
        {
            throw new IllegalMonitorStateException();
        }
        reentrantlock = lock;
        reentrantlock.lockInterruptibly();
        boolean flag = guard.isSatisfied();
        if (!flag)
        {
            reentrantlock.unlock();
        }
        return flag;
        guard;
        if (true)
        {
            reentrantlock.unlock();
        }
        throw guard;
    }

    public boolean enterIfInterruptibly(Guard guard, long l, TimeUnit timeunit)
        throws InterruptedException
    {
        ReentrantLock reentrantlock;
        if (guard.monitor != this)
        {
            throw new IllegalMonitorStateException();
        }
        reentrantlock = lock;
        if (reentrantlock.tryLock(l, timeunit)) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        boolean flag1 = guard.isSatisfied();
        flag = flag1;
        if (flag1) goto _L4; else goto _L3
_L3:
        reentrantlock.unlock();
        return flag1;
        guard;
        if (true)
        {
            reentrantlock.unlock();
        }
        throw guard;
    }

    public void enterInterruptibly()
        throws InterruptedException
    {
        lock.lockInterruptibly();
    }

    public boolean enterInterruptibly(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        return lock.tryLock(l, timeunit);
    }

    public void enterWhen(Guard guard)
        throws InterruptedException
    {
        boolean flag;
        if (guard.monitor != this)
        {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantlock = lock;
        flag = reentrantlock.isHeldByCurrentThread();
        reentrantlock.lockInterruptibly();
        if (!guard.isSatisfied())
        {
            await(guard, flag);
        }
        if (false)
        {
            leave();
        }
        return;
        guard;
        if (true)
        {
            leave();
        }
        throw guard;
    }

    public boolean enterWhen(Guard guard, long l, TimeUnit timeunit)
        throws InterruptedException
    {
        ReentrantLock reentrantlock;
        long l1;
        long l2;
        boolean flag1;
        l2 = toSafeNanos(l, timeunit);
        if (guard.monitor != this)
        {
            throw new IllegalMonitorStateException();
        }
        reentrantlock = lock;
        flag1 = reentrantlock.isHeldByCurrentThread();
        l1 = 0L;
        if (fair) goto _L2; else goto _L1
_L1:
        if (Thread.interrupted())
        {
            throw new InterruptedException();
        }
        if (!reentrantlock.tryLock()) goto _L2; else goto _L3
_L3:
        if (guard.isSatisfied()) goto _L5; else goto _L4
_L4:
        if (l1 != 0L) goto _L7; else goto _L6
_L6:
        l = l2;
_L10:
        boolean flag = awaitNanos(guard, l, flag1);
        if (!flag) goto _L8; else goto _L5
_L5:
        flag = true;
_L11:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        if (true || flag1)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        signalNextWaiter();
        reentrantlock.unlock();
        return flag;
_L2:
        l1 = initNanoTime(l2);
        if (reentrantlock.tryLock(l, timeunit)) goto _L3; else goto _L9
_L9:
        return false;
_L7:
        l = remainingNanos(l1, l2);
          goto _L10
_L8:
        flag = false;
          goto _L11
        guard;
        reentrantlock.unlock();
        throw guard;
        guard;
        if (false)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        if (false || flag1)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        signalNextWaiter();
        reentrantlock.unlock();
        throw guard;
        guard;
        reentrantlock.unlock();
        throw guard;
          goto _L10
    }

    public void enterWhenUninterruptibly(Guard guard)
    {
        boolean flag;
        if (guard.monitor != this)
        {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantlock = lock;
        flag = reentrantlock.isHeldByCurrentThread();
        reentrantlock.lock();
        if (!guard.isSatisfied())
        {
            awaitUninterruptibly(guard, flag);
        }
        if (false)
        {
            leave();
        }
        return;
        guard;
        if (true)
        {
            leave();
        }
        throw guard;
    }

    public boolean enterWhenUninterruptibly(Guard guard, long l, TimeUnit timeunit)
    {
        long l1;
        boolean flag;
        boolean flag2;
        boolean flag3;
        l1 = toSafeNanos(l, timeunit);
        if (guard.monitor != this)
        {
            throw new IllegalMonitorStateException();
        }
        timeunit = lock;
        l = 0L;
        flag3 = timeunit.isHeldByCurrentThread();
        flag2 = Thread.interrupted();
        flag = flag2;
        if (fair) goto _L2; else goto _L1
_L1:
        boolean flag1;
        flag1 = flag2;
        flag = flag2;
        if (timeunit.tryLock()) goto _L3; else goto _L2
_L2:
        flag = flag2;
        l = initNanoTime(l1);
        long l2;
        l2 = l1;
        flag1 = flag2;
_L16:
        flag = flag1;
        flag2 = timeunit.tryLock(l2, TimeUnit.NANOSECONDS);
        if (!flag2) goto _L4; else goto _L3
_L3:
        flag = flag3;
_L14:
        l2 = l;
        flag2 = guard.isSatisfied();
        if (!flag2) goto _L6; else goto _L5
_L5:
        flag2 = true;
_L11:
        if (flag2)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        flag = flag1;
        timeunit.unlock();
        flag = flag2;
        if (flag1)
        {
            Thread.currentThread().interrupt();
            flag = flag2;
        }
_L8:
        return flag;
_L4:
        flag = false;
        if (!flag1) goto _L8; else goto _L7
_L7:
        Thread.currentThread().interrupt();
        return false;
        InterruptedException interruptedexception;
        interruptedexception;
        flag = true;
        flag1 = true;
        l2 = remainingNanos(l, l1);
        continue; /* Loop/switch isn't completed */
_L6:
        if (l != 0L) goto _L10; else goto _L9
_L9:
        l2 = l;
        l = initNanoTime(l1);
        long l3 = l1;
_L12:
        l2 = l;
        flag2 = awaitNanos(guard, l3, flag);
          goto _L11
_L10:
        l2 = l;
        l3 = remainingNanos(l, l1);
          goto _L12
        interruptedexception;
        flag1 = true;
        flag = false;
        l = l2;
        if (true) goto _L14; else goto _L13
_L13:
        guard;
        if (false)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        flag = flag1;
        timeunit.unlock();
        flag = flag1;
        throw guard;
        guard;
        if (flag)
        {
            Thread.currentThread().interrupt();
        }
        throw guard;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public int getOccupiedDepth()
    {
        return lock.getHoldCount();
    }

    public int getQueueLength()
    {
        return lock.getQueueLength();
    }

    public int getWaitQueueLength(Guard guard)
    {
        if (guard.monitor != this)
        {
            throw new IllegalMonitorStateException();
        }
        lock.lock();
        int i = guard.waiterCount;
        lock.unlock();
        return i;
        guard;
        lock.unlock();
        throw guard;
    }

    public boolean hasQueuedThread(Thread thread)
    {
        return lock.hasQueuedThread(thread);
    }

    public boolean hasQueuedThreads()
    {
        return lock.hasQueuedThreads();
    }

    public boolean hasWaiters(Guard guard)
    {
        return getWaitQueueLength(guard) > 0;
    }

    public boolean isFair()
    {
        return fair;
    }

    public boolean isOccupied()
    {
        return lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread()
    {
        return lock.isHeldByCurrentThread();
    }

    public void leave()
    {
        ReentrantLock reentrantlock = lock;
        if (reentrantlock.getHoldCount() == 1)
        {
            signalNextWaiter();
        }
        reentrantlock.unlock();
        return;
        Exception exception;
        exception;
        reentrantlock.unlock();
        throw exception;
    }

    public boolean tryEnter()
    {
        return lock.tryLock();
    }

    public boolean tryEnterIf(Guard guard)
    {
        ReentrantLock reentrantlock;
        if (guard.monitor != this)
        {
            throw new IllegalMonitorStateException();
        }
        reentrantlock = lock;
        if (reentrantlock.tryLock()) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        boolean flag1 = guard.isSatisfied();
        flag = flag1;
        if (flag1) goto _L4; else goto _L3
_L3:
        reentrantlock.unlock();
        return flag1;
        guard;
        if (true)
        {
            reentrantlock.unlock();
        }
        throw guard;
    }

    public void waitFor(Guard guard)
        throws InterruptedException
    {
        boolean flag;
        if (guard.monitor == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!(flag & lock.isHeldByCurrentThread()))
        {
            throw new IllegalMonitorStateException();
        }
        if (!guard.isSatisfied())
        {
            await(guard, true);
        }
    }

    public boolean waitFor(Guard guard, long l, TimeUnit timeunit)
        throws InterruptedException
    {
        l = toSafeNanos(l, timeunit);
        boolean flag;
        if (guard.monitor == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!(flag & lock.isHeldByCurrentThread()))
        {
            throw new IllegalMonitorStateException();
        }
        if (guard.isSatisfied())
        {
            return true;
        }
        if (Thread.interrupted())
        {
            throw new InterruptedException();
        } else
        {
            return awaitNanos(guard, l, true);
        }
    }

    public void waitForUninterruptibly(Guard guard)
    {
        boolean flag;
        if (guard.monitor == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!(flag & lock.isHeldByCurrentThread()))
        {
            throw new IllegalMonitorStateException();
        }
        if (!guard.isSatisfied())
        {
            awaitUninterruptibly(guard, true);
        }
    }

    public boolean waitForUninterruptibly(Guard guard, long l, TimeUnit timeunit)
    {
        long l1;
        l1 = toSafeNanos(l, timeunit);
        boolean flag;
        if (guard.monitor == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!(flag & lock.isHeldByCurrentThread()))
        {
            throw new IllegalMonitorStateException();
        }
        if (!guard.isSatisfied()) goto _L2; else goto _L1
_L1:
        boolean flag2 = true;
_L6:
        return flag2;
_L2:
        long l2;
        boolean flag1;
        boolean flag3;
        flag3 = true;
        l2 = initNanoTime(l1);
        flag1 = Thread.interrupted();
        l = l1;
_L4:
        flag2 = flag1;
        flag3 = awaitNanos(guard, l, flag3);
        flag2 = flag3;
        if (flag1)
        {
            Thread.currentThread().interrupt();
            return flag3;
        }
        continue; /* Loop/switch isn't completed */
        timeunit;
        boolean flag4;
        flag4 = true;
        flag1 = true;
        flag2 = flag4;
        flag3 = guard.isSatisfied();
        if (flag3)
        {
            flag2 = true;
            if (true)
            {
                Thread.currentThread().interrupt();
                return true;
            }
            continue; /* Loop/switch isn't completed */
        }
        flag3 = false;
        flag2 = flag4;
        l = remainingNanos(l2, l1);
        if (true) goto _L4; else goto _L3
_L3:
        guard;
        if (flag2)
        {
            Thread.currentThread().interrupt();
        }
        throw guard;
        if (true) goto _L6; else goto _L5
_L5:
    }

}
