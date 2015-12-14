// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.common;


// Referenced classes of package com.facebook.cache.common:
//            CacheEventListener

public class NoOpCacheEventListener
    implements CacheEventListener
{

    private static NoOpCacheEventListener sInstance = null;

    private NoOpCacheEventListener()
    {
    }

    public static NoOpCacheEventListener getInstance()
    {
        com/facebook/cache/common/NoOpCacheEventListener;
        JVM INSTR monitorenter ;
        NoOpCacheEventListener noopcacheeventlistener;
        if (sInstance == null)
        {
            sInstance = new NoOpCacheEventListener();
        }
        noopcacheeventlistener = sInstance;
        com/facebook/cache/common/NoOpCacheEventListener;
        JVM INSTR monitorexit ;
        return noopcacheeventlistener;
        Exception exception;
        exception;
        throw exception;
    }

    public void onEviction(CacheEventListener.EvictionReason evictionreason, int i, long l)
    {
    }

    public void onHit()
    {
    }

    public void onMiss()
    {
    }

    public void onReadException()
    {
    }

    public void onWriteAttempt()
    {
    }

    public void onWriteException()
    {
    }

}
