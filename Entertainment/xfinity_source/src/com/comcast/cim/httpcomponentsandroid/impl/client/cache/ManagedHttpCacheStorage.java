// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client.cache;

import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheEntry;
import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheStorage;
import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheUpdateCallback;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.client.cache:
//            ResourceReference, CacheMap

public class ManagedHttpCacheStorage
    implements HttpCacheStorage
{

    private final CacheMap entries;
    private final ReferenceQueue morque;
    private final Set resources;
    private volatile boolean shutdown;

    private void ensureValidState()
        throws IllegalStateException
    {
        if (shutdown)
        {
            throw new IllegalStateException("Cache has been shut down");
        } else
        {
            return;
        }
    }

    private void keepResourceReference(HttpCacheEntry httpcacheentry)
    {
        if (httpcacheentry.getResource() != null)
        {
            httpcacheentry = new ResourceReference(httpcacheentry, morque);
            resources.add(httpcacheentry);
        }
    }

    public HttpCacheEntry getEntry(String s)
        throws IOException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("URL may not be null");
        }
        ensureValidState();
        this;
        JVM INSTR monitorenter ;
        s = (HttpCacheEntry)entries.get(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void putEntry(String s, HttpCacheEntry httpcacheentry)
        throws IOException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("URL may not be null");
        }
        if (httpcacheentry == null)
        {
            throw new IllegalArgumentException("Cache entry may not be null");
        }
        ensureValidState();
        this;
        JVM INSTR monitorenter ;
        entries.put(s, httpcacheentry);
        keepResourceReference(httpcacheentry);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void removeEntry(String s)
        throws IOException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("URL may not be null");
        }
        ensureValidState();
        this;
        JVM INSTR monitorenter ;
        entries.remove(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void updateEntry(String s, HttpCacheUpdateCallback httpcacheupdatecallback)
        throws IOException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("URL may not be null");
        }
        if (httpcacheupdatecallback == null)
        {
            throw new IllegalArgumentException("Callback may not be null");
        }
        ensureValidState();
        this;
        JVM INSTR monitorenter ;
        HttpCacheEntry httpcacheentry;
        httpcacheentry = (HttpCacheEntry)entries.get(s);
        httpcacheupdatecallback = httpcacheupdatecallback.update(httpcacheentry);
        entries.put(s, httpcacheupdatecallback);
        if (httpcacheentry == httpcacheupdatecallback)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        keepResourceReference(httpcacheupdatecallback);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }
}
