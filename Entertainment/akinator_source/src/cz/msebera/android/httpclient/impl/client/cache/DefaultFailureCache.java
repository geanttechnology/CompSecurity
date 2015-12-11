// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            FailureCache, FailureCacheValue

public class DefaultFailureCache
    implements FailureCache
{

    static final int DEFAULT_MAX_SIZE = 1000;
    static final int MAX_UPDATE_TRIES = 10;
    private final int maxSize;
    private final ConcurrentMap storage;

    public DefaultFailureCache()
    {
        this(1000);
    }

    public DefaultFailureCache(int i)
    {
        maxSize = i;
        storage = new ConcurrentHashMap();
    }

    private FailureCacheValue findValueWithOldestTimestamp()
    {
        long l = 0x7fffffffffffffffL;
        FailureCacheValue failurecachevalue = null;
        Iterator iterator = storage.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            long l1 = ((FailureCacheValue)entry.getValue()).getCreationTimeInNanos();
            if (l1 < l)
            {
                l = l1;
                failurecachevalue = (FailureCacheValue)entry.getValue();
            }
        } while (true);
        return failurecachevalue;
    }

    private void removeOldestEntryIfMapSizeExceeded()
    {
        if (storage.size() > maxSize)
        {
            FailureCacheValue failurecachevalue = findValueWithOldestTimestamp();
            if (failurecachevalue != null)
            {
                storage.remove(failurecachevalue.getKey(), failurecachevalue);
            }
        }
    }

    private void updateValue(String s)
    {
        int i = 0;
_L8:
        if (i >= 10) goto _L2; else goto _L1
_L1:
        FailureCacheValue failurecachevalue = (FailureCacheValue)storage.get(s);
        if (failurecachevalue != null) goto _L4; else goto _L3
_L3:
        failurecachevalue = new FailureCacheValue(s, 1);
        if (storage.putIfAbsent(s, failurecachevalue) != null) goto _L5; else goto _L2
_L2:
        return;
_L4:
        int j = failurecachevalue.getErrorCount();
        if (j == 0x7fffffff) goto _L2; else goto _L6
_L6:
        FailureCacheValue failurecachevalue1 = new FailureCacheValue(s, j + 1);
        if (storage.replace(s, failurecachevalue, failurecachevalue1)) goto _L2; else goto _L5
_L5:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public int getErrorCount(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("identifier may not be null");
        }
        s = (FailureCacheValue)storage.get(s);
        if (s != null)
        {
            return s.getErrorCount();
        } else
        {
            return 0;
        }
    }

    public void increaseErrorCount(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("identifier may not be null");
        } else
        {
            updateValue(s);
            removeOldestEntryIfMapSizeExceeded();
            return;
        }
    }

    public void resetErrorCount(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("identifier may not be null");
        } else
        {
            storage.remove(s);
            return;
        }
    }
}
