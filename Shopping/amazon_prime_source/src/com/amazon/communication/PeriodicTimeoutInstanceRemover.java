// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import com.amazon.communication.time.GlobalTimeSource;
import com.amazon.communication.time.TimeSource;
import com.amazon.dp.logger.DPLogger;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.communication:
//            InstanceTracker

public class PeriodicTimeoutInstanceRemover
{

    private static final DPLogger log = new DPLogger("TComm.PeriodicTimeoutInstanceRemover");
    private int mFailedToRemoveCount;
    private final InstanceTracker mInstanceTracker;
    private long mLastCleanTimestampMs;
    private final long mPeriodMs;
    private int mRemovedInstanceCount;

    public PeriodicTimeoutInstanceRemover(InstanceTracker instancetracker, long l)
    {
        if (instancetracker == null)
        {
            throw new IllegalArgumentException("instanceTracker must not be null");
        }
        if (l < 0x1b7740L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("period must at least be 1800000. Actual period: ").append(l).toString());
        } else
        {
            mInstanceTracker = instancetracker;
            mPeriodMs = l;
            mRemovedInstanceCount = 0;
            mFailedToRemoveCount = 0;
            return;
        }
    }

    private boolean isTimeUp()
    {
        return GlobalTimeSource.INSTANCE.currentTimeMillis() - mLastCleanTimestampMs > mPeriodMs;
    }

    private void resetTimer()
    {
        mLastCleanTimestampMs = GlobalTimeSource.INSTANCE.currentTimeMillis();
    }

    protected void clean()
    {
        log.info("clean", "check all tracked instances for timeout", new Object[] {
            "instance", this
        });
        Iterator iterator = mInstanceTracker.getTrackedInstances().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            if (mInstanceTracker.isTimedOut(obj))
            {
                log.info("RemoveTimeoutInstanceRunnable.run", "stop tracking a timeout instance", new Object[] {
                    "instance", obj
                });
                if (mInstanceTracker.stopTrackingInstance(obj))
                {
                    DPLogger dplogger = log;
                    int i = mRemovedInstanceCount;
                    mRemovedInstanceCount = i + 1;
                    dplogger.debug("RemoveTimeoutInstanceRunnable.run", "Successful removed instance", new Object[] {
                        "Removed instance count", Integer.valueOf(i)
                    });
                } else
                {
                    DPLogger dplogger1 = log;
                    int j = mFailedToRemoveCount;
                    mFailedToRemoveCount = j + 1;
                    dplogger1.debug("RemoveTimeoutInstanceRunnable.run", "Failed to remove instance", new Object[] {
                        "mFailedToRemoveCount", Integer.valueOf(j)
                    });
                }
            }
        } while (true);
        log.info("RemoveTimeoutInstanceRunnable.run", "done with tracking instances", new Object[] {
            "mRemovedInstanceCount", Integer.valueOf(mRemovedInstanceCount), "mFailedToRemoveCount", Integer.valueOf(mFailedToRemoveCount)
        });
    }

    public void cleanIfTimesUp()
    {
        this;
        JVM INSTR monitorenter ;
        if (isTimeUp())
        {
            resetTimer();
            clean();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
