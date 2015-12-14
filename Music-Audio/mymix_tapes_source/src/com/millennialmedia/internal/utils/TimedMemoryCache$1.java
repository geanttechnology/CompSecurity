// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.util.SparseArray;
import com.millennialmedia.MMLog;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.millennialmedia.internal.utils:
//            TimedMemoryCache

static final class cheItem
    implements Runnable
{

    public void run()
    {
_L3:
        Thread.sleep(10000L);
        long l = System.currentTimeMillis();
        int i = 0;
        while (i < TimedMemoryCache.access$100().size()) 
        {
            int j = TimedMemoryCache.access$100().keyAt(i);
            Object obj = TimedMemoryCache.access$200(j);
            if (obj == null)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(TimedMemoryCache.access$000(), (new StringBuilder()).append("Attempted to remove CacheItem with ID <").append(j).append("> but item was null").toString());
                }
            } else
            if (l > ((cheItem) (obj)).itemTimeout)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(TimedMemoryCache.access$000(), (new StringBuilder()).append("Removed CacheItem\n\t:Checked time: ").append(l).append("\n\tID: ").append(j).append("\n\tItem: ").append(obj).toString());
                }
                TimedMemoryCache.access$100().remove(j);
            }
            i++;
        }
          goto _L1
        obj;
        MMLog.e(TimedMemoryCache.access$000(), "Error occurred while cleaner was sleeping", ((Throwable) (obj)));
_L2:
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TimedMemoryCache.access$000(), "Stopping cleaner");
        }
        TimedMemoryCache.access$300().set(false);
        return;
_L1:
        if (TimedMemoryCache.access$100().size() > 0) goto _L3; else goto _L2
    }

    cheItem()
    {
    }
}
