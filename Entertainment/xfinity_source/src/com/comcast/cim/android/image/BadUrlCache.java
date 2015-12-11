// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.image;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BadUrlCache
{
    private class BadUrlEntry
    {

        long expirationTime;
        final BadUrlCache this$0;
        final String url;

        BadUrlEntry(String s, long l)
        {
            this$0 = BadUrlCache.this;
            super();
            url = s;
            expirationTime = l;
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/image/BadUrlCache);
    private final Map cache;
    private final Deque lruDeque = new LinkedList();
    private final long maxAgeMillis;
    private final int maxSize;

    public BadUrlCache(int i, int j)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag);
        if (j >= 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Validate.isTrue(flag);
        maxSize = i;
        maxAgeMillis = j * 1000;
        cache = new HashMap(i);
    }

    private long computeExpirationTime(long l)
    {
        if (maxAgeMillis == 0L)
        {
            return 0x7fffffffffffffffL;
        } else
        {
            return maxAgeMillis + l;
        }
    }

    private void trimCache(long l)
    {
        long l2 = cache.size();
        for (long l1 = ((BadUrlEntry)lruDeque.peekFirst()).expirationTime; (l2 > (long)maxSize || l1 < l) && l2 > 0L;)
        {
            cache.remove(((BadUrlEntry)lruDeque.removeFirst()).url);
            l2--;
            if (l2 > 0L)
            {
                l1 = ((BadUrlEntry)lruDeque.peekFirst()).expirationTime;
            } else
            {
                l1 = 0x7fffffffffffffffL;
            }
        }

    }

    public boolean isBadUrl(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = cache.containsKey(s);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        LOG.debug("Skipping bad URL {}", s);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public void setBadUrl(String s)
    {
        this;
        JVM INSTR monitorenter ;
        BadUrlEntry badurlentry;
        long l;
        badurlentry = (BadUrlEntry)cache.get(s);
        l = System.currentTimeMillis();
        if (badurlentry != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        badurlentry = new BadUrlEntry(s, computeExpirationTime(l));
_L1:
        cache.put(s, badurlentry);
        lruDeque.addLast(badurlentry);
        trimCache(l);
        this;
        JVM INSTR monitorexit ;
        return;
        lruDeque.removeFirstOccurrence(badurlentry);
        badurlentry.expirationTime = computeExpirationTime(l);
          goto _L1
        s;
        throw s;
    }

}
