// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import com.amazon.ansel.fetch.cache.ResourceCacheListener;
import com.amazon.ansel.fetch.cache.ResourceCacheValue;

// Referenced classes of package com.amazon.ansel.fetch:
//            LoaderContext

class this._cls0
    implements ResourceCacheListener
{

    final LoaderContext this$0;

    public void evict(Object obj, ResourceCacheValue resourcecachevalue)
    {
        if (LoaderContext.access$000(LoaderContext.this))
        {
            invalidateResource(obj);
        }
    }

    public volatile void evict(Object obj, Object obj1)
    {
        evict(obj, (ResourceCacheValue)obj1);
    }

    cheValue()
    {
        this$0 = LoaderContext.this;
        super();
    }
}
