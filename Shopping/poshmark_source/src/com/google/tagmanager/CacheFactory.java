// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;


// Referenced classes of package com.google.tagmanager:
//            SimpleCache, LRUCache, Cache

class CacheFactory
{
    public static interface CacheSizeManager
    {

        public abstract int sizeOf(Object obj, Object obj1);
    }


    final CacheSizeManager mDefaultSizeManager = new CacheSizeManager() {

        final CacheFactory this$0;

        public int sizeOf(Object obj, Object obj1)
        {
            return 1;
        }

            
            {
                this$0 = CacheFactory.this;
                super();
            }
    };

    public CacheFactory()
    {
    }

    public Cache createCache(int i)
    {
        return createCache(i, mDefaultSizeManager);
    }

    public Cache createCache(int i, CacheSizeManager cachesizemanager)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (getSdkVersion() < 12)
        {
            return new SimpleCache(i, cachesizemanager);
        } else
        {
            return new LRUCache(i, cachesizemanager);
        }
    }

    int getSdkVersion()
    {
        return android.os.Build.VERSION.SDK_INT;
    }
}
