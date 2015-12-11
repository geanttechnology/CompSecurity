// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import com.ebay.nautilus.kernel.util.TimedCacheWallClock;

// Referenced classes of package com.ebay.nautilus.kernel.cachemanager:
//            CacheManager

private class this._cls0 extends TimedCacheWallClock
{

    final CacheManager this$0;

    protected volatile int sizeOf(Object obj, Object obj1)
    {
        return sizeOf((String)obj, obj1);
    }

    protected int sizeOf(String s, Object obj)
    {
        return CacheManager.this.sizeOf(s, obj);
    }

    public (int i, long l)
    {
        this$0 = CacheManager.this;
        super(i, l);
    }
}
