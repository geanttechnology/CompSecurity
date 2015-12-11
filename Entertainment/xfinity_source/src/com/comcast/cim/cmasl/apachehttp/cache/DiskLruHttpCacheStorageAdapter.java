// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheEntry;
import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheStorage;
import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheUpdateCallback;
import com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheUpdateException;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.cache:
//            HttpCacheKeyFactory, DiskLruHttpCacheStorage

public class DiskLruHttpCacheStorageAdapter
    implements HttpCacheStorage
{

    private final HttpCacheKeyFactory cacheKeyFactory;
    private final DiskLruHttpCacheStorage _flddelegate;

    public DiskLruHttpCacheStorageAdapter(DiskLruHttpCacheStorage disklruhttpcachestorage, HttpCacheKeyFactory httpcachekeyfactory)
    {
        _flddelegate = disklruhttpcachestorage;
        cacheKeyFactory = httpcachekeyfactory;
    }

    public HttpCacheEntry getEntry(String s)
        throws IOException
    {
        return _flddelegate.getEntry(cacheKeyFactory.create(s));
    }

    public void putEntry(String s, HttpCacheEntry httpcacheentry)
        throws IOException
    {
        _flddelegate.putEntry(cacheKeyFactory.create(s), httpcacheentry);
    }

    public void removeEntry(String s)
        throws IOException
    {
        _flddelegate.removeEntry(cacheKeyFactory.create(s));
    }

    public void updateEntry(String s, HttpCacheUpdateCallback httpcacheupdatecallback)
        throws IOException, HttpCacheUpdateException
    {
        _flddelegate.updateEntry(cacheKeyFactory.create(s), httpcacheupdatecallback);
    }
}
