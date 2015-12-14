// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.millennialmedia.android:
//            CachedAd

final class AdCacheThreadPool
{

    private static AdCacheThreadPool a;
    private PriorityBlockingQueue b;
    private ThreadPoolExecutor c;

    private AdCacheThreadPool()
    {
        TimeUnit timeunit = TimeUnit.SECONDS;
        PriorityBlockingQueue priorityblockingqueue = new PriorityBlockingQueue(32);
        b = priorityblockingqueue;
        c = new ThreadPoolExecutor(1, 2, 30L, timeunit, priorityblockingqueue);
    }

    static AdCacheThreadPool a()
    {
        com/millennialmedia/android/AdCacheThreadPool;
        JVM INSTR monitorenter ;
        AdCacheThreadPool adcachethreadpool;
        if (a == null)
        {
            a = new AdCacheThreadPool();
        }
        adcachethreadpool = a;
        com/millennialmedia/android/AdCacheThreadPool;
        JVM INSTR monitorexit ;
        return adcachethreadpool;
        Exception exception;
        exception;
        throw exception;
    }

    final boolean a(Context context, String s, CachedAd cachedad, AdCache.AdCacheTaskListener adcachetasklistener)
    {
        this;
        JVM INSTR monitorenter ;
        if (context == null || cachedad == null) goto _L2; else goto _L1
_L1:
        s = new AdCacheTask(context, s, cachedad, adcachetasklistener);
        if (b.contains(s) || cachedad.isOnDisk(context)) goto _L2; else goto _L3
_L3:
        c.execute(s);
        boolean flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        context;
        throw context;
    }

    private class AdCacheTask
        implements Comparable, Runnable
    {

        private WeakReference a;
        private String b;
        private CachedAd c;
        private WeakReference d;

        public int compareTo(AdCacheTask adcachetask)
        {
            return c.downloadPriority - adcachetask.c.downloadPriority;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((AdCacheTask)obj);
        }

        public boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (!(obj instanceof AdCacheTask))
            {
                return false;
            } else
            {
                obj = (AdCacheTask)obj;
                return c.equals(((AdCacheTask) (obj)).c);
            }
        }

        public void run()
        {
            String s;
            Context context;
            AdCache.AdCacheTaskListener adcachetasklistener;
            String s1;
            boolean flag;
            if (d != null)
            {
                adcachetasklistener = (AdCache.AdCacheTaskListener)d.get();
            } else
            {
                adcachetasklistener = null;
            }
            if (adcachetasklistener != null)
            {
                adcachetasklistener.downloadStart(c);
            }
            HandShake.a((Context)a.get()).c(b);
            flag = c.download((Context)a.get());
            HandShake.a((Context)a.get()).d(b);
            if (flag)
            {
                break MISSING_BLOCK_LABEL_230;
            }
            s = AdCache.d((Context)a.get(), b);
            if (s == null || !c.getId().equals(s)) goto _L2; else goto _L1
_L1:
            c.delete((Context)a.get());
            context = (Context)a.get();
            s = b;
_L4:
            s1 = null;
_L5:
            AdCache.b(context, s, s1);
_L6:
            if (adcachetasklistener != null)
            {
                adcachetasklistener.downloadCompleted(c, flag);
            }
            return;
_L2:
            context = (Context)a.get();
            s = b;
            if (c.downloadAllOrNothing) goto _L4; else goto _L3
_L3:
            s1 = c.getId();
              goto _L5
            AdCache.b((Context)a.get(), b, null);
              goto _L6
        }

        AdCacheTask(Context context, String s, CachedAd cachedad, AdCache.AdCacheTaskListener adcachetasklistener)
        {
            a = new WeakReference(context.getApplicationContext());
            b = s;
            c = cachedad;
            if (adcachetasklistener != null)
            {
                d = new WeakReference(adcachetasklistener);
            }
        }
    }

}
