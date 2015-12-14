// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            PreCacheWorker, AdCache, DTOCachedVideo, CachedAd

class a
    implements skListener
{

    private PreCacheWorker a;

    public void downloadCompleted(CachedAd cachedad, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        AdCache.a(PreCacheWorker.a(a), cachedad);
        PreCacheWorker.b(a);
        a(null);
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        cachedad;
        throw cachedad;
    }

    public void downloadStart(CachedAd cachedad)
    {
        a(null);
    }

    skListener(PreCacheWorker precacheworker, DTOCachedVideo dtocachedvideo)
    {
        a = precacheworker;
        super();
    }
}
