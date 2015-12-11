// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import java.util.IdentityHashMap;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            Sweeper, RetainedStateCreator

public abstract class BaseRetainer
{
    protected final class Tracker
        implements Sweeper.Sweep
    {

        protected Class owningClass;
        protected volatile int refCount;
        protected Object state;
        final BaseRetainer this$0;
        protected long ttl;

        protected boolean decRefCount()
        {
            refCount = refCount - 1;
            return refCount <= 0;
        }

        protected void incRefCount()
        {
            refCount = refCount + 1;
        }

        public void onSweep()
        {
            removeTracker(this);
        }

        protected Tracker(Class class1, Object obj, long l)
        {
            this$0 = BaseRetainer.this;
            super();
            owningClass = class1;
            state = obj;
            ttl = l;
            refCount = 0;
        }
    }


    protected Sweeper sweeper;
    protected IdentityHashMap trackers;

    protected BaseRetainer()
    {
        trackers = new IdentityHashMap();
        sweeper = Sweeper.get();
    }

    public void changeTtl(Class class1, long l)
    {
        this;
        JVM INSTR monitorenter ;
        class1 = (Tracker)trackers.get(class1);
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

    public Object getState(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        class1 = (Tracker)trackers.get(class1);
        if (class1 != null) goto _L2; else goto _L1
_L1:
        class1 = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return class1;
_L2:
        class1 = ((Class) (((Tracker) (class1)).state));
        if (true) goto _L4; else goto _L3
_L3:
        class1;
        throw class1;
    }

    public abstract Object obtainState(Class class1, long l, RetainedStateCreator retainedstatecreator);

    public void releaseState(Class class1)
    {
    }

    protected void removeTracker(Tracker tracker)
    {
        this;
        JVM INSTR monitorenter ;
        sweeper.remove(tracker);
        trackers.remove(tracker.owningClass);
        this;
        JVM INSTR monitorexit ;
        return;
        tracker;
        throw tracker;
    }
}
