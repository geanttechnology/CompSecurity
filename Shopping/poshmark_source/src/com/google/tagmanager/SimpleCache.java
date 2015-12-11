// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            Cache

class SimpleCache
    implements Cache
{

    private final Map mHashMap = new HashMap();
    private final int mMaxSize;
    private final CacheFactory.CacheSizeManager mSizeManager;
    private int mTotalSize;

    SimpleCache(int i, CacheFactory.CacheSizeManager cachesizemanager)
    {
        mMaxSize = i;
        mSizeManager = cachesizemanager;
    }

    public Object get(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = mHashMap.get(obj);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    public void put(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null && obj1 != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        throw new NullPointerException("key == null || value == null");
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        mTotalSize = mTotalSize + mSizeManager.sizeOf(obj, obj1);
        if (mTotalSize > mMaxSize)
        {
            Iterator iterator = mHashMap.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                mTotalSize = mTotalSize - mSizeManager.sizeOf(entry.getKey(), entry.getValue());
                iterator.remove();
            } while (mTotalSize > mMaxSize);
        }
        mHashMap.put(obj, obj1);
        this;
        JVM INSTR monitorexit ;
    }
}
