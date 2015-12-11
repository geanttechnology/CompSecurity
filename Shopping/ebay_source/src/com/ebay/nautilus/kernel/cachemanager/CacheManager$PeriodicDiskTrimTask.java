// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.cachemanager;

import com.ebay.nautilus.kernel.util.DelayedAsyncTask;

// Referenced classes of package com.ebay.nautilus.kernel.cachemanager:
//            CacheManager

private final class diskLimit extends DelayedAsyncTask
{

    private final long diskLimit;
    final CacheManager this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (CacheManager.logger.rimTask)
        {
            log("Starting on disk cache trim.");
        }
        int i;
        synchronized (CacheManager.access$000(CacheManager.this))
        {
            CacheManager.access$102(CacheManager.this, null);
            i = CacheManager.access$300(CacheManager.this, CacheManager.access$200(CacheManager.this), diskLimit, false);
        }
        if (CacheManager.logger.diskLimit)
        {
            log((new StringBuilder()).append("Finished on disk cache trim. Trimmed ").append(i).append(" items.").toString());
        }
        return null;
        exception;
        avoid;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected (long l)
    {
        this$0 = CacheManager.this;
        super();
        diskLimit = l;
    }
}
