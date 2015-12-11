// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import java.util.IdentityHashMap;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            BaseRetainer, RetainedStateCreator, Sweeper

public class RefCountedRetainer extends BaseRetainer
{

    private static RefCountedRetainer inst = new RefCountedRetainer();

    private RefCountedRetainer()
    {
    }

    public static RefCountedRetainer get()
    {
        return inst;
    }

    public Object obtainState(Class class1, long l, RetainedStateCreator retainedstatecreator)
    {
        this;
        JVM INSTR monitorenter ;
        BaseRetainer.Tracker tracker1 = (BaseRetainer.Tracker)trackers.get(class1);
        BaseRetainer.Tracker tracker;
        tracker = tracker1;
        if (tracker1 != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        retainedstatecreator = ((RetainedStateCreator) (retainedstatecreator.createRetainedState()));
        if (retainedstatecreator != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        throw new NullPointerException("You must return state to track");
        class1;
        this;
        JVM INSTR monitorexit ;
        throw class1;
        tracker = new BaseRetainer.Tracker(this, class1, retainedstatecreator, l);
        trackers.put(class1, tracker);
        tracker.ttl = l;
        sweeper.remove(tracker);
        tracker.incRefCount();
        class1 = ((Class) (tracker.state));
        this;
        JVM INSTR monitorexit ;
        return class1;
    }

    public void releaseState(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        class1 = (BaseRetainer.Tracker)trackers.get(class1);
        if (class1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (class1.decRefCount())
        {
            sweeper.add(class1, ((BaseRetainer.Tracker) (class1)).ttl);
        }
        if (true) goto _L1; else goto _L3
_L3:
        class1;
        throw class1;
    }

}
