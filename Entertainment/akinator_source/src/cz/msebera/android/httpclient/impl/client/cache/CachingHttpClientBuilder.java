// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import java.io.File;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            CacheConfig, AsynchronousValidator, ImmediateSchedulingStrategy, HeapResourceFactory, 
//            BasicHttpCacheStorage, CacheKeyGenerator, CacheInvalidator, CachingExec, 
//            BasicHttpCache, FileResourceFactory, ManagedHttpCacheStorage, SchedulingStrategy

public class CachingHttpClientBuilder extends HttpClientBuilder
{

    private CacheConfig cacheConfig;
    private File cacheDir;
    private HttpCacheInvalidator httpCacheInvalidator;
    private ResourceFactory resourceFactory;
    private SchedulingStrategy schedulingStrategy;
    private HttpCacheStorage storage;

    protected CachingHttpClientBuilder()
    {
    }

    public static CachingHttpClientBuilder create()
    {
        return new CachingHttpClientBuilder();
    }

    private AsynchronousValidator createAsynchronousRevalidator(CacheConfig cacheconfig)
    {
        if (cacheconfig.getAsynchronousWorkersMax() > 0)
        {
            cacheconfig = new AsynchronousValidator(createSchedulingStrategy(cacheconfig));
            addCloseable(cacheconfig);
            return cacheconfig;
        } else
        {
            return null;
        }
    }

    private SchedulingStrategy createSchedulingStrategy(CacheConfig cacheconfig)
    {
        if (schedulingStrategy != null)
        {
            return schedulingStrategy;
        } else
        {
            return new ImmediateSchedulingStrategy(cacheconfig);
        }
    }

    protected ClientExecChain decorateMainExec(ClientExecChain clientexecchain)
    {
        Object obj;
        Object obj1;
        CacheConfig cacheconfig;
        Object obj2;
        HttpCacheInvalidator httpcacheinvalidator;
        AsynchronousValidator asynchronousvalidator;
        CacheKeyGenerator cachekeygenerator;
        if (cacheConfig != null)
        {
            cacheconfig = cacheConfig;
        } else
        {
            cacheconfig = CacheConfig.DEFAULT;
        }
        obj1 = resourceFactory;
        obj = obj1;
        if (obj1 == null)
        {
            if (cacheDir == null)
            {
                obj = new HeapResourceFactory();
            } else
            {
                obj = new FileResourceFactory(cacheDir);
            }
        }
        obj2 = storage;
        obj1 = obj2;
        if (obj2 == null)
        {
            if (cacheDir == null)
            {
                obj1 = new BasicHttpCacheStorage(cacheconfig);
            } else
            {
                obj1 = new ManagedHttpCacheStorage(cacheconfig);
                addCloseable(((java.io.Closeable) (obj1)));
            }
        }
        asynchronousvalidator = createAsynchronousRevalidator(cacheconfig);
        cachekeygenerator = new CacheKeyGenerator();
        httpcacheinvalidator = httpCacheInvalidator;
        obj2 = httpcacheinvalidator;
        if (httpcacheinvalidator == null)
        {
            obj2 = new CacheInvalidator(cachekeygenerator, ((HttpCacheStorage) (obj1)));
        }
        return new CachingExec(clientexecchain, new BasicHttpCache(((ResourceFactory) (obj)), ((HttpCacheStorage) (obj1)), cacheconfig, cachekeygenerator, ((HttpCacheInvalidator) (obj2))), cacheconfig, asynchronousvalidator);
    }

    public final CachingHttpClientBuilder setCacheConfig(CacheConfig cacheconfig)
    {
        cacheConfig = cacheconfig;
        return this;
    }

    public final CachingHttpClientBuilder setCacheDir(File file)
    {
        cacheDir = file;
        return this;
    }

    public final CachingHttpClientBuilder setHttpCacheInvalidator(HttpCacheInvalidator httpcacheinvalidator)
    {
        httpCacheInvalidator = httpcacheinvalidator;
        return this;
    }

    public final CachingHttpClientBuilder setHttpCacheStorage(HttpCacheStorage httpcachestorage)
    {
        storage = httpcachestorage;
        return this;
    }

    public final CachingHttpClientBuilder setResourceFactory(ResourceFactory resourcefactory)
    {
        resourceFactory = resourcefactory;
        return this;
    }

    public final CachingHttpClientBuilder setSchedulingStrategy(SchedulingStrategy schedulingstrategy)
    {
        schedulingStrategy = schedulingstrategy;
        return this;
    }
}
