// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import com.amazon.identity.auth.device.framework.AlarmManagerWrapper;
import com.amazon.identity.auth.device.framework.PendingIntentWrapper;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            RetrySyncDirtyDataScheduler

public final class <init>
{

    private final PendingIntentWrapper mDirtyDataIntent;
    private final Long mLastScheduledDirtySyncTime;
    final RetrySyncDirtyDataScheduler this$0;

    public void markDataNotDirty()
    {
label0:
        {
            synchronized (RetrySyncDirtyDataScheduler.access$000(RetrySyncDirtyDataScheduler.this))
            {
                if (mDirtyDataIntent != null)
                {
                    break label0;
                }
                RetrySyncDirtyDataScheduler.access$100();
            }
            return;
        }
        RetrySyncDirtyDataScheduler.access$200(RetrySyncDirtyDataScheduler.this).cancel(mDirtyDataIntent);
        RetrySyncDirtyDataScheduler.access$300(RetrySyncDirtyDataScheduler.this, mLastScheduledDirtySyncTime);
        aobj;
        JVM INSTR monitorexit ;
        return;
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private (PendingIntentWrapper pendingintentwrapper, Long long1)
    {
        this$0 = RetrySyncDirtyDataScheduler.this;
        super();
        mDirtyDataIntent = pendingintentwrapper;
        mLastScheduledDirtySyncTime = long1;
    }

    mLastScheduledDirtySyncTime(PendingIntentWrapper pendingintentwrapper, Long long1, byte byte0)
    {
        this(pendingintentwrapper, long1);
    }
}
