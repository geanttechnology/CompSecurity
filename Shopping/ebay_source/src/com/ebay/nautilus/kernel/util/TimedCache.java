// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.os.SystemClock;
import android.util.LruCache;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.ebay.nautilus.kernel.util:
//            SimpleMaker

public class TimedCache
{
    private static final class CacheEntry
    {

        private static AtomicLong idGen = new AtomicLong(1L);
        protected final long creationId;
        protected long expiresAt;
        protected final Object key;
        protected final Object value;

        public long expiresIn(long l)
        {
            return expiresAt - l;
        }

        public boolean isExpired(long l)
        {
            return expiresIn(l) < 0L;
        }

        protected void setExpiration(long l, long l1)
        {
            expiresAt = l + l1;
        }


        protected CacheEntry(long l)
        {
            key = null;
            value = null;
            expiresAt = l - 1L;
            creationId = 0x7fffffffffffffffL;
        }

        protected CacheEntry(Object obj, Object obj1, long l, long l1)
        {
            key = obj;
            value = obj1;
            creationId = idGen.incrementAndGet();
            setExpiration(l, l1);
        }
    }

    private final class CacheEntryLruCache extends LruCache
    {

        final TimedCache this$0;

        protected void entryRemoved(boolean flag, Object obj, CacheEntry cacheentry, CacheEntry cacheentry1)
        {
            if (flag)
            {
                evictedFromCache(cacheentry);
            }
        }

        protected volatile void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
        {
            entryRemoved(flag, obj, (CacheEntry)obj1, (CacheEntry)obj2);
        }

        public int sizeOf(Object obj, CacheEntry cacheentry)
        {
            return TimedCache.this.sizeOf(cacheentry.key, cacheentry.value);
        }

        public volatile int sizeOf(Object obj, Object obj1)
        {
            return sizeOf(obj, (CacheEntry)obj1);
        }

        public CacheEntryLruCache(int i)
        {
            this$0 = TimedCache.this;
            super(i);
        }
    }


    private final CacheEntryLruCache cache;
    private final SimpleMaker maker;
    private final ConcurrentSkipListSet queue;
    private final long ttl;

    public TimedCache(int i, long l)
    {
        this(i, l, null);
    }

    public TimedCache(int i, long l, SimpleMaker simplemaker)
    {
        if (l > 0x3fffffffffffffffL)
        {
            throw new IllegalArgumentException("ttl must not exceed IntervalTimer.MAX_TTL");
        } else
        {
            ttl = l;
            cache = new CacheEntryLruCache(i);
            queue = new ConcurrentSkipListSet(new Comparator() {

                final TimedCache this$0;

                public int compare(CacheEntry cacheentry, CacheEntry cacheentry1)
                {
                    int j;
                    if (cacheentry == cacheentry1)
                    {
                        j = 0;
                    } else
                    {
                        int k = gatedCompare(cacheentry.expiresAt, cacheentry1.expiresAt);
                        j = k;
                        if (k == 0)
                        {
                            return gatedCompare(cacheentry.creationId, cacheentry1.creationId);
                        }
                    }
                    return j;
                }

                public volatile int compare(Object obj, Object obj1)
                {
                    return compare((CacheEntry)obj, (CacheEntry)obj1);
                }

            
            {
                this$0 = TimedCache.this;
                super();
            }
            });
            maker = simplemaker;
            return;
        }
    }

    private CacheEntry ensureValueEntry(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (maker == null)
        {
            throw new IllegalStateException("You cannot use ensureValue without a maker");
        }
        break MISSING_BLOCK_LABEL_24;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        CacheEntry cacheentry1 = getEntry(obj);
        CacheEntry cacheentry;
        cacheentry = cacheentry1;
        if (cacheentry1 != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        cacheentry = new CacheEntry(obj, maker.create(), getCurrentMillis(), ttl);
        putEntry(cacheentry);
        this;
        JVM INSTR monitorexit ;
        return cacheentry;
    }

    private int gatedCompare(long l, long l1)
    {
        if (l == l1)
        {
            return 0;
        }
        return l <= l1 ? -1 : 1;
    }

    private CacheEntry getEntry(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        trimExpired();
        obj = (CacheEntry)cache.get(obj);
        this;
        JVM INSTR monitorexit ;
        return ((CacheEntry) (obj));
        obj;
        throw obj;
    }

    private CacheEntry putEntry(CacheEntry cacheentry)
    {
        this;
        JVM INSTR monitorenter ;
        trimExpired();
        queue.add(cacheentry);
        cacheentry = (CacheEntry)cache.put(cacheentry.key, cacheentry);
        if (cacheentry == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        queue.remove(cacheentry);
        this;
        JVM INSTR monitorexit ;
        return cacheentry;
        cacheentry;
        throw cacheentry;
    }

    private void resetExpiration(CacheEntry cacheentry, long l, long l1)
    {
        queue.remove(cacheentry);
        cacheentry.setExpiration(l, l1);
        if (cacheentry.isExpired(l))
        {
            cache.remove(cacheentry.key);
            return;
        } else
        {
            queue.add(cacheentry);
            return;
        }
    }

    private void resetTimeoutIfSooner(CacheEntry cacheentry, long l)
    {
        this;
        JVM INSTR monitorenter ;
        trimExpired();
        if (cacheentry != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        long l1;
        long l2;
        l1 = getCurrentMillis();
        l2 = cacheentry.expiresIn(l1);
        if (l2 < 0L || l >= l2)
        {
            continue; /* Loop/switch isn't completed */
        }
        resetExpiration(cacheentry, l1, l);
        if (true) goto _L1; else goto _L3
_L3:
        cacheentry;
        throw cacheentry;
    }

    public int TEST_getTrackingQueueSize()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        trimExpired();
        i = queue.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final void clear()
    {
        this;
        JVM INSTR monitorenter ;
        cache.evictAll();
        queue.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long computeFutureTtl(long l)
    {
        return computeFutureTtl(l, 0x8000000000000000L);
    }

    public long computeFutureTtl(long l, long l1)
    {
        l -= getCurrentMillis();
        if (l <= l1)
        {
            return l1;
        } else
        {
            return l;
        }
    }

    public final Object ensureValue(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = ensureValueEntry(obj).value;
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    protected void evictedFromCache(CacheEntry cacheentry)
    {
        this;
        JVM INSTR monitorenter ;
        queue.remove(cacheentry);
        this;
        JVM INSTR monitorexit ;
        return;
        cacheentry;
        throw cacheentry;
    }

    public final boolean exists(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = getEntry(obj);
        boolean flag;
        if (obj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        obj;
        throw obj;
    }

    public final Object get(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = getEntry(obj);
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L2:
        obj = ((CacheEntry) (obj)).value;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public long getCurrentMillis()
    {
        return SystemClock.elapsedRealtime();
    }

    public long getTtl()
    {
        return ttl;
    }

    public final Object put(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        obj = put(obj, obj1, ttl);
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    public final Object put(Object obj, Object obj1, long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (l >= 0L) goto _L2; else goto _L1
_L1:
        obj = remove(obj);
_L4:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L2:
        obj = putEntry(new CacheEntry(obj, obj1, getCurrentMillis(), l));
        if (obj == null)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        obj = ((CacheEntry) (obj)).value;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public final Object remove(Object obj)
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        CacheEntry cacheentry;
        trimExpired();
        cacheentry = (CacheEntry)cache.remove(obj);
        if (cacheentry != null) goto _L2; else goto _L1
_L1:
        obj = obj1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L2:
        queue.remove(cacheentry);
        obj = obj1;
        if (!cacheentry.isExpired(getCurrentMillis()))
        {
            obj = cacheentry.value;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public final void resetTimeout(Object obj, long l)
    {
        this;
        JVM INSTR monitorenter ;
        obj = getEntry(obj);
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        resetExpiration(((CacheEntry) (obj)), getCurrentMillis(), l);
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public final void resetTimeoutIfSooner(Object obj, long l)
    {
        this;
        JVM INSTR monitorenter ;
        resetTimeoutIfSooner(getEntry(obj), l);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public final int size()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        trimExpired();
        i = cache.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    protected int sizeOf(Object obj, Object obj1)
    {
        return 1;
    }

    public void trimExpired()
    {
        if (queue.isEmpty())
        {
            return;
        }
        Object obj = new CacheEntry(getCurrentMillis());
        obj = queue.headSet(obj);
        CacheEntry cacheentry;
        for (Iterator iterator = ((NavigableSet) (obj)).iterator(); iterator.hasNext(); cache.remove(cacheentry.key))
        {
            cacheentry = (CacheEntry)iterator.next();
        }

        ((NavigableSet) (obj)).clear();
    }

}
