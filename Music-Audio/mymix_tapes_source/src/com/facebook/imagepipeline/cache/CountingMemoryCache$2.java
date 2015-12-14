// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.common.references.ResourceReleaser;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            CountingMemoryCache

class try
    implements ResourceReleaser
{

    final CountingMemoryCache this$0;
    final try val$entry;

    public void release(Object obj)
    {
        CountingMemoryCache.access$000(CountingMemoryCache.this, val$entry);
    }

    try()
    {
        this$0 = final_countingmemorycache;
        val$entry = try.this;
        super();
    }
}
