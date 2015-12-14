// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import com.millennialmedia.MMLog;

// Referenced classes of package com.millennialmedia.internal.utils:
//            TimedMemoryCache

private static class itemTimeout
{

    Object cachedObject;
    long itemTimeout;

    public String toString()
    {
        return (new StringBuilder()).append("cachedObject: ").append(cachedObject).append(", itemTimeout: ").append(itemTimeout).toString();
    }

    (Object obj, Long long1)
    {
        Long long2 = long1;
        if (long1 == null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TimedMemoryCache.access$000(), "Cached item timeout is null, setting to default: 60000");
            }
            long2 = Long.valueOf(60000L);
        }
        cachedObject = obj;
        itemTimeout = System.currentTimeMillis() + long2.longValue();
    }
}
