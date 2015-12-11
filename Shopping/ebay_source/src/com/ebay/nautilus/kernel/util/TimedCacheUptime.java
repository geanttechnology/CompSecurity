// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.os.SystemClock;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            TimedCache, SimpleMaker

public class TimedCacheUptime extends TimedCache
{

    public TimedCacheUptime(int i, long l)
    {
        super(i, l);
    }

    public TimedCacheUptime(int i, long l, SimpleMaker simplemaker)
    {
        super(i, l, simplemaker);
    }

    public long getCurrentMillis()
    {
        return SystemClock.uptimeMillis();
    }
}
