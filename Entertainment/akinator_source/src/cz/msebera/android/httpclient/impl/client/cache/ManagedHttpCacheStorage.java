// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.HttpCacheUpdateCallback;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.util.Args;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            CacheMap, CacheConfig, ResourceReference

public class ManagedHttpCacheStorage
    implements HttpCacheStorage, Closeable
{

    private final AtomicBoolean active = new AtomicBoolean(true);
    private final CacheMap entries;
    private final ReferenceQueue morque = new ReferenceQueue();
    private final Set resources = new HashSet();

    public ManagedHttpCacheStorage(CacheConfig cacheconfig)
    {
        entries = new CacheMap(cacheconfig.getMaxCacheEntries());
    }

    private void ensureValidState()
        throws IllegalStateException
    {
        if (!active.get())
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

    public void cleanResources()
    {
        if (!active.get()) goto _L2; else goto _L1
_L1:
        ResourceReference resourcereference;
        resourcereference = (ResourceReference)morque.poll();
        if (resourcereference == null)
        {
            break; /* Loop/switch isn't completed */
        }
        this;
        JVM INSTR monitorenter ;
        resources.remove(resourcereference);
        this;
        JVM INSTR monitorexit ;
        resourcereference.getResource().dispose();
        if (true) goto _L1; else goto _L2
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
    }

    public void close()
    {
        shutdown();
    }

    public HttpCacheEntry getEntry(String s)
        throws IOException
    {
        Args.notNull(s, "URL");
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
        Args.notNull(s, "URL");
        Args.notNull(httpcacheentry, "Cache entry");
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
        Args.notNull(s, "URL");
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

    public void shutdown()
    {
        if (!active.compareAndSet(true, false)) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        entries.clear();
        for (Iterator iterator = resources.iterator(); iterator.hasNext(); ((ResourceReference)iterator.next()).getResource().dispose()) { }
        break MISSING_BLOCK_LABEL_65;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        resources.clear();
        while (morque.poll() != null) ;
        this;
        JVM INSTR monitorexit ;
_L2:
    }

    public void updateEntry(String s, HttpCacheUpdateCallback httpcacheupdatecallback)
        throws IOException
    {
        Args.notNull(s, "URL");
        Args.notNull(httpcacheupdatecallback, "Callback");
        ensureValidState();
        this;
        JVM INSTR monitorenter ;
        HttpCacheEntry httpcacheentry;
        httpcacheentry = (HttpCacheEntry)entries.get(s);
        httpcacheupdatecallback = httpcacheupdatecallback.update(httpcacheentry);
        entries.put(s, httpcacheupdatecallback);
        if (httpcacheentry == httpcacheupdatecallback)
        {
            break MISSING_BLOCK_LABEL_60;
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
