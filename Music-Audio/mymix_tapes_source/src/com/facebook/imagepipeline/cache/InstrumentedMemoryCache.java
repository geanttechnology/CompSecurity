// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.facebook.common.references.CloseableReference;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            MemoryCache, MemoryCacheTracker

public class InstrumentedMemoryCache
    implements MemoryCache
{

    private final MemoryCache mDelegate;
    private final MemoryCacheTracker mTracker;

    public InstrumentedMemoryCache(MemoryCache memorycache, MemoryCacheTracker memorycachetracker)
    {
        mDelegate = memorycache;
        mTracker = memorycachetracker;
    }

    public CloseableReference cache(Object obj, CloseableReference closeablereference)
    {
        mTracker.onCachePut();
        return mDelegate.cache(obj, closeablereference);
    }

    public CloseableReference get(Object obj)
    {
        obj = mDelegate.get(obj);
        if (obj == null)
        {
            mTracker.onCacheMiss();
            return ((CloseableReference) (obj));
        } else
        {
            mTracker.onCacheHit();
            return ((CloseableReference) (obj));
        }
    }

    public int removeAll(Predicate predicate)
    {
        return mDelegate.removeAll(predicate);
    }
}
