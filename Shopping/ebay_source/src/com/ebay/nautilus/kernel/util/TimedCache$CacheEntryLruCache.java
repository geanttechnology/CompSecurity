// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.util.LruCache;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            TimedCache

private final class this._cls0 extends LruCache
{

    final TimedCache this$0;

    protected void entryRemoved(boolean flag, Object obj, this._cls0 _pcls0, this._cls0 _pcls0_1)
    {
        if (flag)
        {
            evictedFromCache(_pcls0);
        }
    }

    protected volatile void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
    {
        entryRemoved(flag, obj, (entryRemoved)obj1, (entryRemoved)obj2);
    }

    public int sizeOf(Object obj, entryRemoved entryremoved)
    {
        return TimedCache.this.sizeOf(entryremoved.entryRemoved, entryremoved.entryRemoved);
    }

    public volatile int sizeOf(Object obj, Object obj1)
    {
        return sizeOf(obj, (sizeOf)obj1);
    }

    public A(int i)
    {
        this$0 = TimedCache.this;
        super(i);
    }
}
