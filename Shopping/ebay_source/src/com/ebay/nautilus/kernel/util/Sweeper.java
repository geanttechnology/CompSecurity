// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;

public class Sweeper
{
    public static interface Sweep
    {

        public abstract void onSweep();
    }

    protected static final class Tracker
    {

        protected long expiresAt;
        protected Sweep sweep;
        protected long ttl;

        protected long getExpiresAt()
        {
            return expiresAt;
        }

        protected boolean isExpired(long l)
        {
            return expiresAt < l;
        }

        protected void prepExpire(long l)
        {
            expiresAt = ttl + l;
        }

        protected Tracker(Sweep sweep1, long l)
        {
            sweep = sweep1;
            ttl = l;
            prepExpire(SystemClock.uptimeMillis());
        }
    }


    private static Sweeper inst;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private volatile boolean holdPrepareNextSweep;
    protected long sweepInterval;
    private final Runnable sweeper = new Runnable() {

        final Sweeper this$0;

        public void run()
        {
            performSweep();
        }

            
            {
                this$0 = Sweeper.this;
                super();
            }
    };
    private final ArrayList trackers = new ArrayList();

    private Sweeper()
    {
    }

    public static Sweeper get()
    {
        com/ebay/nautilus/kernel/util/Sweeper;
        JVM INSTR monitorenter ;
        Sweeper sweeper1;
        if (inst == null)
        {
            inst = new Sweeper();
        }
        sweeper1 = inst;
        com/ebay/nautilus/kernel/util/Sweeper;
        JVM INSTR monitorexit ;
        return sweeper1;
        Exception exception;
        exception;
        throw exception;
    }

    private void prepareNextSweep()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = holdPrepareNextSweep;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        long l = 0x3fffffffffffffffL;
        for (Iterator iterator = trackers.iterator(); iterator.hasNext();)
        {
            l = Math.min(l, ((Tracker)iterator.next()).expiresAt);
        }

        handler.removeCallbacks(sweeper);
        if (l == 0x3fffffffffffffffL)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = Math.max(1L, l - SystemClock.uptimeMillis());
        handler.postDelayed(sweeper, l);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void add(Sweep sweep, long l)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = false;
        Iterator iterator = trackers.iterator();
_L2:
        boolean flag = flag1;
        Tracker tracker;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_66;
        }
        tracker = (Tracker)iterator.next();
        if (tracker.sweep != sweep) goto _L2; else goto _L1
_L1:
        tracker.ttl = l;
        tracker.prepExpire(SystemClock.uptimeMillis());
        flag = true;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        trackers.add(new Tracker(sweep, l));
        prepareNextSweep();
        this;
        JVM INSTR monitorexit ;
        return;
        sweep;
        throw sweep;
    }

    public void changeTtl(Sweep sweep, long l)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = trackers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Tracker tracker = (Tracker)iterator.next();
            if (tracker.sweep != sweep)
            {
                continue;
            }
            tracker.ttl = l;
            tracker.prepExpire(SystemClock.uptimeMillis());
            prepareNextSweep();
            break;
        } while (true);
        this;
        JVM INSTR monitorexit ;
        return;
        sweep;
        throw sweep;
    }

    protected void performSweep()
    {
        long l = SystemClock.uptimeMillis();
        holdPrepareNextSweep = true;
        this;
        JVM INSTR monitorenter ;
        Object obj = new ArrayList(trackers);
        this;
        JVM INSTR monitorexit ;
        obj = ((ArrayList) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Tracker tracker = (Tracker)((Iterator) (obj)).next();
            if (tracker.isExpired(l))
            {
                tracker.sweep.onSweep();
                tracker.prepExpire(l);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_79;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        holdPrepareNextSweep = false;
        prepareNextSweep();
        return;
    }

    public void remove(Sweep sweep)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = trackers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((Tracker)iterator.next()).sweep != sweep)
            {
                continue;
            }
            iterator.remove();
            prepareNextSweep();
            break;
        } while (true);
        this;
        JVM INSTR monitorexit ;
        return;
        sweep;
        throw sweep;
    }
}
