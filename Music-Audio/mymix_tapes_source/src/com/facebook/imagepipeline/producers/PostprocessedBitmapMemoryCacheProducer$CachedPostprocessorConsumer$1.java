// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            PostprocessedBitmapMemoryCacheProducer

class this._cls0
    implements Predicate
{

    final apply this$0;

    public boolean apply(CacheKey cachekey)
    {
        if (cachekey instanceof BitmapMemoryCacheKey)
        {
            return cess._mth000(this._cls0.this).equals(((BitmapMemoryCacheKey)cachekey).getPostprocessorName());
        } else
        {
            return false;
        }
    }

    public volatile boolean apply(Object obj)
    {
        return apply((CacheKey)obj);
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
