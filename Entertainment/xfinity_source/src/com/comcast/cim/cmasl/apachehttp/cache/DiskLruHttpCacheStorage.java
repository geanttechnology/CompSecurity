// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.cmasl.utils.collections.LruLinkedHashMap;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheEntry;
import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheUpdateCallback;
import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheUpdateException;
import com.comcast.cim.httpcomponentsandroid.client.cache.Resource;
import com.comcast.cim.httpcomponentsandroid.client.cache.ResourceFactory;
import com.jakewharton.DiskLruCache;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.cache:
//            HttpCacheKey

public class DiskLruHttpCacheStorage
{

    private final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/apachehttp/cache/DiskLruHttpCacheStorage);
    private final Map lockMap = new HashMap();
    private DiskLruCache lruCache;
    private final Provider lruCacheProvider;
    private final ResourceFactory resourceFactory;
    private LinkedHashMap volatileCache;

    public DiskLruHttpCacheStorage(Provider provider, ResourceFactory resourcefactory)
    {
        volatileCache = new LruLinkedHashMap(5);
        lruCacheProvider = provider;
        resourceFactory = resourcefactory;
    }

    private HttpCacheEntry copyEntry(HttpCacheEntry httpcacheentry, Resource resource)
    {
        return new HttpCacheEntry(httpcacheentry.getRequestDate(), httpcacheentry.getResponseDate(), httpcacheentry.getStatusLine(), httpcacheentry.getAllHeaders(), resource, httpcacheentry.getVariantMap());
    }

    private ReentrantLock getLock(HttpCacheKey httpcachekey)
    {
        Map map = lockMap;
        map;
        JVM INSTR monitorenter ;
        Object obj = (WeakReference)lockMap.get(httpcachekey);
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = (ReentrantLock)((WeakReference) (obj)).get();
_L4:
        ReentrantLock reentrantlock;
        reentrantlock = ((ReentrantLock) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        reentrantlock = new ReentrantLock();
        obj = new WeakReference(reentrantlock);
        lockMap.put(httpcachekey, obj);
        map;
        JVM INSTR monitorexit ;
        return reentrantlock;
        httpcachekey;
        map;
        JVM INSTR monitorexit ;
        throw httpcachekey;
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private DiskLruCache getLruCache()
    {
        this;
        JVM INSTR monitorenter ;
        DiskLruCache disklrucache;
        if (lruCache == null)
        {
            lruCache = (DiskLruCache)lruCacheProvider.get();
        }
        disklrucache = lruCache;
        this;
        JVM INSTR monitorexit ;
        return disklrucache;
        Exception exception;
        exception;
        throw exception;
    }

    private void removeEntryQuietly(HttpCacheKey httpcachekey)
    {
        try
        {
            removeEntry(httpcachekey);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpCacheKey httpcachekey)
        {
            LOG.error("Caught exception trying to remove entry", httpcachekey);
        }
    }

    public HttpCacheEntry getEntry(HttpCacheKey httpcachekey)
        throws IOException
    {
        ReentrantLock reentrantlock;
        reentrantlock = getLock(httpcachekey);
        reentrantlock.lock();
        Object obj = (HttpCacheEntry)volatileCache.get(httpcachekey);
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        if (obj != null)
        {
            reentrantlock.unlock();
            return ((HttpCacheEntry) (obj));
        }
        obj = null;
        obj10 = null;
        obj11 = null;
        obj9 = null;
        obj5 = null;
        obj12 = null;
        obj4 = null;
        obj7 = null;
        obj8 = null;
        obj6 = null;
        obj1 = obj11;
        obj2 = obj;
        obj3 = obj12;
        com.jakewharton.DiskLruCache.Snapshot snapshot = getLruCache().get(httpcachekey.toDigest());
        if (snapshot != null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(null);
        getLruCache().flush();
        reentrantlock.unlock();
        return null;
        obj1 = obj11;
        obj2 = obj;
        obj3 = obj12;
        obj = new ObjectInputStream(snapshot.getInputStream(0));
        obj1 = (HttpCacheKey)CommonUtils.uncheckedCast(((ObjectInputStream) (obj)).readObject());
        if (((HttpCacheKey) (obj1)).equals(httpcachekey))
        {
            break MISSING_BLOCK_LABEL_205;
        }
        LOG.error("Apparent hash collision for cache entry for key {}, stored key is {}", httpcachekey, obj1);
        removeEntryQuietly(httpcachekey);
        IOUtils.closeQuietly(((java.io.InputStream) (obj)));
        IOUtils.closeQuietly(null);
        IOUtils.closeQuietly(null);
        getLruCache().flush();
        reentrantlock.unlock();
        return null;
        try
        {
            obj3 = new ObjectInputStream(snapshot.getInputStream(1));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj4)
        {
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            httpcachekey = ((HttpCacheKey) (obj));
            obj1 = obj9;
            obj3 = obj4;
            obj = obj2;
            continue; /* Loop/switch isn't completed */
        }
        obj2 = obj7;
        obj1 = obj8;
        obj5 = (HttpCacheEntry)CommonUtils.uncheckedCast(((ObjectInputStream) (obj3)).readObject());
        obj2 = obj7;
        obj1 = obj8;
        obj4 = snapshot.getInputStream(2);
        obj2 = obj4;
        obj1 = obj4;
        obj5 = copyEntry(((HttpCacheEntry) (obj5)), resourceFactory.generate(httpcachekey.getKey(), ((java.io.InputStream) (obj4)), null));
        obj2 = obj4;
        obj1 = obj4;
        volatileCache.put(httpcachekey, obj5);
        obj2 = obj4;
        obj1 = obj4;
        LOG.debug("Returning cached entry for key {}", httpcachekey);
        IOUtils.closeQuietly(((java.io.InputStream) (obj)));
        IOUtils.closeQuietly(((java.io.InputStream) (obj3)));
        IOUtils.closeQuietly(((java.io.InputStream) (obj4)));
        getLruCache().flush();
        reentrantlock.unlock();
        return ((HttpCacheEntry) (obj5));
        obj4;
        obj = obj10;
_L4:
        obj1 = obj5;
        obj2 = obj;
        obj3 = obj6;
        LOG.error("Caught exception trying to read object, removing entry", ((Throwable) (obj4)));
        obj1 = obj5;
        obj2 = obj;
        obj3 = obj6;
        removeEntryQuietly(httpcachekey);
        IOUtils.closeQuietly(((java.io.InputStream) (obj)));
        IOUtils.closeQuietly(((java.io.InputStream) (obj5)));
        IOUtils.closeQuietly(((java.io.InputStream) (obj6)));
        getLruCache().flush();
        reentrantlock.unlock();
        return null;
        obj;
        httpcachekey = ((HttpCacheKey) (obj2));
_L2:
        IOUtils.closeQuietly(httpcachekey);
        IOUtils.closeQuietly(((java.io.InputStream) (obj1)));
        IOUtils.closeQuietly(((java.io.InputStream) (obj3)));
        getLruCache().flush();
        throw obj;
        httpcachekey;
        reentrantlock.unlock();
        throw httpcachekey;
        obj4;
        obj1 = obj3;
        httpcachekey = ((HttpCacheKey) (obj));
        obj3 = obj2;
        obj = obj4;
        if (true) goto _L2; else goto _L1
        obj4;
        obj5 = obj3;
        obj6 = obj1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void putEntry(HttpCacheKey httpcachekey, HttpCacheEntry httpcacheentry)
        throws IOException
    {
        Object obj;
        Object obj3;
        Object obj4;
        ObjectOutputStream objectoutputstream;
        Object obj5;
        ReentrantLock reentrantlock;
        reentrantlock = getLock(httpcachekey);
        reentrantlock.lock();
        volatileCache.put(httpcachekey, httpcacheentry);
        obj = null;
        objectoutputstream = null;
        obj4 = null;
        obj5 = null;
        obj3 = null;
        Object obj1 = getLruCache().edit(httpcachekey.toDigest());
        obj = obj1;
        Object obj2 = new ObjectOutputStream(((com.jakewharton.DiskLruCache.Editor) (obj1)).newOutputStream(0));
        ((ObjectOutputStream) (obj2)).writeObject(httpcachekey);
        objectoutputstream = new ObjectOutputStream(((com.jakewharton.DiskLruCache.Editor) (obj1)).newOutputStream(1));
        obj = obj5;
        objectoutputstream.writeObject(httpcacheentry);
        obj = obj5;
        obj3 = ((com.jakewharton.DiskLruCache.Editor) (obj1)).newOutputStream(2);
        obj = obj3;
        IOUtils.copy(httpcacheentry.getResource().getInputStream(), ((java.io.OutputStream) (obj3)));
        obj = obj3;
        ((com.jakewharton.DiskLruCache.Editor) (obj1)).commit();
        obj = obj3;
        LOG.debug("Successfully wrote cache entry for key {}", httpcachekey);
        IOUtils.closeQuietly(((java.io.OutputStream) (obj2)));
        IOUtils.closeQuietly(objectoutputstream);
        IOUtils.closeQuietly(((java.io.OutputStream) (obj3)));
        if (obj1 != null)
        {
            ((com.jakewharton.DiskLruCache.Editor) (obj1)).abortUnlessCommitted();
        }
        getLruCache().flush();
        reentrantlock.unlock();
        return;
        httpcacheentry;
        httpcachekey = objectoutputstream;
        obj2 = obj4;
        obj1 = obj;
_L2:
        IOUtils.closeQuietly(httpcachekey);
        IOUtils.closeQuietly(((java.io.OutputStream) (obj2)));
        IOUtils.closeQuietly(((java.io.OutputStream) (obj3)));
        if (obj1 != null)
        {
            ((com.jakewharton.DiskLruCache.Editor) (obj1)).abortUnlessCommitted();
        }
        getLruCache().flush();
        reentrantlock.unlock();
        throw httpcacheentry;
        httpcacheentry;
        httpcachekey = ((HttpCacheKey) (obj2));
        obj2 = obj4;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        httpcachekey = objectoutputstream;
        httpcacheentry = ((HttpCacheEntry) (obj2));
        obj2 = httpcachekey;
        httpcachekey = httpcacheentry;
        obj3 = obj;
        httpcacheentry = exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void removeEntry(HttpCacheKey httpcachekey)
        throws IOException
    {
        ReentrantLock reentrantlock;
        reentrantlock = getLock(httpcachekey);
        reentrantlock.lock();
        getLruCache().remove(httpcachekey.toDigest());
        LOG.debug("Removed entry for key {}", httpcachekey);
        getLruCache().flush();
        reentrantlock.unlock();
        return;
        httpcachekey;
        getLruCache().flush();
        reentrantlock.unlock();
        throw httpcachekey;
    }

    public void updateEntry(HttpCacheKey httpcachekey, HttpCacheUpdateCallback httpcacheupdatecallback)
        throws IOException, HttpCacheUpdateException
    {
        ReentrantLock reentrantlock;
        reentrantlock = getLock(httpcachekey);
        reentrantlock.lock();
        putEntry(httpcachekey, httpcacheupdatecallback.update(getEntry(httpcachekey)));
        LOG.debug("Updated entry for key {}", httpcachekey);
        reentrantlock.unlock();
        return;
        httpcachekey;
        reentrantlock.unlock();
        throw httpcachekey;
    }
}
