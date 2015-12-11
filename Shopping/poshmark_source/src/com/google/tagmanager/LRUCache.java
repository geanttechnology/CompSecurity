// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.util.LruCache;

// Referenced classes of package com.google.tagmanager:
//            Cache

class LRUCache
    implements Cache
{

    private LruCache lruCache;

    LRUCache(final int final_i, CacheFactory.CacheSizeManager cachesizemanager)
    {
        lruCache = new LruCache(cachesizemanager) {

            final LRUCache this$0;
            final CacheFactory.CacheSizeManager val$sizeManager;

            protected int sizeOf(Object obj, Object obj1)
            {
                return sizeManager.sizeOf(obj, obj1);
            }

            
            {
                this$0 = LRUCache.this;
                sizeManager = cachesizemanager;
                super(final_i);
            }
        };
    }

    public Object get(Object obj)
    {
        return lruCache.get(obj);
    }

    public void put(Object obj, Object obj1)
    {
        lruCache.put(obj, obj1);
    }
}
