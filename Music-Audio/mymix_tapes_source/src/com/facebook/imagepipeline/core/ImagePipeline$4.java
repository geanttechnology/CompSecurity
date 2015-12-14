// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.core;

import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;

// Referenced classes of package com.facebook.imagepipeline.core:
//            ImagePipeline

class this._cls0
    implements Predicate
{

    final ImagePipeline this$0;

    public boolean apply(CacheKey cachekey)
    {
        return true;
    }

    public volatile boolean apply(Object obj)
    {
        return apply((CacheKey)obj);
    }

    ()
    {
        this$0 = ImagePipeline.this;
        super();
    }
}
