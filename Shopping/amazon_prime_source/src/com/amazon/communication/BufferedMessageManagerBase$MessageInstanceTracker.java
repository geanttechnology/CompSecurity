// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import com.amazon.communication.time.GlobalTimeSource;
import com.amazon.communication.time.TimeSource;
import com.amazon.dp.logger.DPLogger;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.communication:
//            InstanceTracker, BufferedMessageManagerBase

protected class this._cls0
    implements InstanceTracker
{

    final BufferedMessageManagerBase this$0;

    public Set getTrackedInstances()
    {
        HashSet hashset = new HashSet(mMessageFragmentMap.keySet());
        hashset.addAll(BufferedMessageManagerBase.access$000(BufferedMessageManagerBase.this).keySet());
        return hashset;
    }

    public boolean isTimedOut(this._cls0 _pcls0)
    {
        ntry ntry = (ntry)mMessageFragmentMap.get(_pcls0);
        long l = 0L;
        if (ntry != null)
        {
            l = ntry.getLastFragmentArrivalTimeInMillis();
        } else
        {
            _pcls0 = (Long)BufferedMessageManagerBase.access$000(BufferedMessageManagerBase.this).get(_pcls0);
            if (_pcls0 != null)
            {
                l = _pcls0.longValue();
            }
        }
        return mMessageTrackingTimeoutInMillis < GlobalTimeSource.INSTANCE.currentTimeMillis() - l;
    }

    public volatile boolean isTimedOut(Object obj)
    {
        return isTimedOut((isTimedOut)obj);
    }

    public boolean stopTrackingInstance(isTimedOut istimedout)
    {
        if (mMessageFragmentMap.remove(istimedout) != null)
        {
            BufferedMessageManagerBase.access$100().debug("stopTrackingInstance", "stop tracking buffered message", new Object[] {
                "instance", istimedout
            });
            return true;
        }
        if (BufferedMessageManagerBase.access$000(BufferedMessageManagerBase.this).remove(istimedout) != null)
        {
            BufferedMessageManagerBase.access$100().debug("stopTrackingInstance", "stop tracking thrown away message", new Object[] {
                "instance", istimedout
            });
            return true;
        } else
        {
            BufferedMessageManagerBase.access$100().warn("stopTrackingInstance", "message already processed", new Object[] {
                "instance", istimedout
            });
            return false;
        }
    }

    public volatile boolean stopTrackingInstance(Object obj)
    {
        return stopTrackingInstance((stopTrackingInstance)obj);
    }

    protected ntry()
    {
        this$0 = BufferedMessageManagerBase.this;
        super();
    }
}
