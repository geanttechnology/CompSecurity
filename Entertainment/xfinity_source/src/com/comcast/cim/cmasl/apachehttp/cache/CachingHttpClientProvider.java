// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.impl.client.cache.CachingHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.cache:
//            DiskLruCacheProvider, HttpCacheConfiguration, ManagedFileResourceFactory, CombinedResourceFactory, 
//            DiskLruHttpCacheStorageAdapter, DiskLruHttpCacheStorage, HttpCacheKeyFactory

public class CachingHttpClientProvider
    implements Provider
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/apachehttp/cache/CachingHttpClientProvider);
    private final HttpCacheConfiguration cacheConfiguration;
    private final HttpClient delegateClient;

    public HttpClient get()
    {
        Object obj1 = new DiskLruCacheProvider(cacheConfiguration.getCacheDirectory(), 3, cacheConfiguration.getMaxSizeInBytes(), cacheConfiguration.getCacheVersion());
        Object obj = new ManagedFileResourceFactory(cacheConfiguration.getFileResourceDirectory());
        obj = new CombinedResourceFactory(cacheConfiguration.getPerResourceHeapLimitInBytes(), ((ManagedFileResourceFactory) (obj)));
        obj1 = new DiskLruHttpCacheStorageAdapter(new DiskLruHttpCacheStorage(((Provider) (obj1)), ((com.comcast.cim.httpcomponentsandroid.client.cache.ResourceFactory) (obj))), new HttpCacheKeyFactory());
        com.comcast.cim.httpcomponentsandroid.impl.client.cache.CacheConfig cacheconfig = cacheConfiguration.getApacheCacheConfig();
        return new CachingHttpClient(delegateClient, ((com.comcast.cim.httpcomponentsandroid.client.cache.ResourceFactory) (obj)), ((com.comcast.cim.httpcomponentsandroid.client.cache.HttpCacheStorage) (obj1)), cacheconfig);
    }

    public volatile Object get()
    {
        return get();
    }

}
