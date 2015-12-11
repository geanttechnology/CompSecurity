// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.os.SystemClock;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            ServiceContentOverride

private static class value
{

    public long timestamp;
    Object value;

    public boolean isOutdated()
    {
        return SystemClock.elapsedRealtime() - 0x1d4c0L > timestamp;
    }

    public (Object obj)
    {
        timestamp = SystemClock.elapsedRealtime();
        value = obj;
    }
}
