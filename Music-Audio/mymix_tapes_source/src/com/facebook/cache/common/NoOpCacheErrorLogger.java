// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.common;


// Referenced classes of package com.facebook.cache.common:
//            CacheErrorLogger

public class NoOpCacheErrorLogger
    implements CacheErrorLogger
{

    private static NoOpCacheErrorLogger sInstance = null;

    private NoOpCacheErrorLogger()
    {
    }

    public static NoOpCacheErrorLogger getInstance()
    {
        com/facebook/cache/common/NoOpCacheErrorLogger;
        JVM INSTR monitorenter ;
        NoOpCacheErrorLogger noopcacheerrorlogger;
        if (sInstance == null)
        {
            sInstance = new NoOpCacheErrorLogger();
        }
        noopcacheerrorlogger = sInstance;
        com/facebook/cache/common/NoOpCacheErrorLogger;
        JVM INSTR monitorexit ;
        return noopcacheerrorlogger;
        Exception exception;
        exception;
        throw exception;
    }

    public void logError(CacheErrorLogger.CacheErrorCategory cacheerrorcategory, Class class1, String s, Throwable throwable)
    {
    }

}
