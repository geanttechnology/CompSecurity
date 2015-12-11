// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.util.Log;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.IdentityHashMap;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            BaseRetainer, Sweeper, RetainedStateCreator

public class AutoRetainer extends BaseRetainer
    implements Sweeper.Sweep
{

    private static final long SWEEP_TIME = 2000L;
    private static AutoRetainer inst;
    private ReferenceQueue phantomRefs;
    private IdentityHashMap refToTracker;
    protected long sweepInterval;

    private AutoRetainer(long l)
    {
        phantomRefs = new ReferenceQueue();
        refToTracker = new IdentityHashMap();
        restartSweepTimer(l);
    }

    public static AutoRetainer get()
    {
        com/ebay/nautilus/kernel/util/AutoRetainer;
        JVM INSTR monitorenter ;
        AutoRetainer autoretainer;
        if (inst == null)
        {
            inst = new AutoRetainer(2000L);
        }
        autoretainer = inst;
        com/ebay/nautilus/kernel/util/AutoRetainer;
        JVM INSTR monitorexit ;
        return autoretainer;
        Exception exception;
        exception;
        throw exception;
    }

    public void changeTtl(Class class1, long l)
    {
        this;
        JVM INSTR monitorenter ;
        class1 = (BaseRetainer.Tracker)trackers.get(class1);
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        class1.ttl = l;
        sweeper.changeTtl(class1, l);
        this;
        JVM INSTR monitorexit ;
        return;
        class1;
        throw class1;
    }

    public Object obtainState(Class class1, long l, RetainedStateCreator retainedstatecreator)
    {
        this;
        JVM INSTR monitorenter ;
        BaseRetainer.Tracker tracker = (BaseRetainer.Tracker)trackers.get(class1);
        Object obj;
        obj = tracker;
        if (tracker != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        obj = retainedstatecreator.createRetainedState();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        throw new NullPointerException("You must return state to track");
        class1;
        this;
        JVM INSTR monitorexit ;
        throw class1;
        obj = new BaseRetainer.Tracker(this, class1, obj, l);
        trackers.put(class1, obj);
        class1 = new PhantomReference(retainedstatecreator, phantomRefs);
        obj.ttl = l;
        sweeper.remove(((Sweeper.Sweep) (obj)));
        ((BaseRetainer.Tracker) (obj)).incRefCount();
        refToTracker.put(class1, obj);
        if (refToTracker.size() == 1)
        {
            restartSweepTimer(sweepInterval);
        }
        class1 = ((Class) (((BaseRetainer.Tracker) (obj)).state));
        this;
        JVM INSTR monitorexit ;
        return class1;
    }

    public void onSweep()
    {
        this;
        JVM INSTR monitorenter ;
_L2:
        Object obj = phantomRefs.poll();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        Log.v("AutoRetainer", "Phantom Ref released");
        obj = (BaseRetainer.Tracker)refToTracker.remove(obj);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!((BaseRetainer.Tracker) (obj)).decRefCount()) goto _L2; else goto _L3
_L3:
        sweeper.add(((Sweeper.Sweep) (obj)), ((BaseRetainer.Tracker) (obj)).ttl);
          goto _L2
        Exception exception;
        exception;
        throw exception;
        if (refToTracker.size() == 0)
        {
            restartSweepTimer(0x3fffffffffffffffL);
        }
        this;
        JVM INSTR monitorexit ;
    }

    public void restartSweepTimer(long l)
    {
        if (l == 0x3fffffffffffffffL)
        {
            sweeper.remove(this);
            return;
        } else
        {
            sweeper.add(this, l);
            return;
        }
    }
}
