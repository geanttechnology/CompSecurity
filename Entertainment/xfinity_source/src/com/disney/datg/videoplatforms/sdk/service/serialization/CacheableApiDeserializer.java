// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.serialization;

import android.content.Context;
import com.disney.datg.videoplatforms.sdk.cache.Cache;
import com.disney.datg.videoplatforms.sdk.cache.Data;
import com.disney.datg.videoplatforms.sdk.cache.DiskLRUCacheImpl;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.springframework.http.ResponseEntity;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service.serialization:
//            ApiDeserializer

public abstract class CacheableApiDeserializer extends ApiDeserializer
{

    protected static int CACHE_CAPACITY = 100;
    protected static String CACHE_CONTAINER = "";
    protected Cache cache;
    protected int expireTime;
    protected int timeToLive;

    public CacheableApiDeserializer(Context context, String s, int i, Class class1)
    {
        super(class1);
        timeToLive = -1;
        expireTime = 300;
        if (context != null)
        {
            cache = new DiskLRUCacheImpl(context);
            cache.setCacheName(s);
            cache.setCapacity(i);
        }
    }

    public Object createKey(Map map)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); stringbuilder.append((String)map.get((String)iterator.next())).append("_")) { }
        if (stringbuilder.length() > 0)
        {
            return stringbuilder.substring(0, stringbuilder.length() - 1);
        } else
        {
            return "";
        }
    }

    public Future executeAsync(final Request request, int i, final HttpRequestHandler asyncHandler)
        throws AndroidSDKException
    {
        if (request.getServiceUri() == null || request.getServiceUri().toString().isEmpty())
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_UNDEFINED_HOST);
        }
        final Object key = createKey(new HashMap() {

            final CacheableApiDeserializer this$0;
            final Request val$request;

            
            {
                this$0 = CacheableApiDeserializer.this;
                request = request1;
                super();
                put("host", request.getServiceUri().toString());
            }
        });
        if (cache != null && !cache.isEmpty())
        {
            Object obj = cache.get(key);
            if (obj != null && ((Data) (obj)).getValue() != null)
            {
                final ResponseEntity dataResponse = (ResponseEntity)((Data) (obj)).getValue();
                boolean flag1 = false;
                int j = ((Data) (obj)).getTtl();
                boolean flag = flag1;
                if (j > 0)
                {
                    Date date = new Date();
                    obj = ((Data) (obj)).getAccessTime();
                    flag = flag1;
                    if ((long)j < (date.getTime() - ((Date) (obj)).getTime()) / 1000L)
                    {
                        flag = true;
                    }
                }
                if (!flag)
                {
                    return new Future() {

                        final CacheableApiDeserializer this$0;
                        final HttpRequestHandler val$asyncHandler;
                        final ResponseEntity val$dataResponse;
                        final Request val$request;

                        public boolean cancel(boolean flag2)
                        {
                            return false;
                        }

                        public volatile Object get()
                            throws InterruptedException, ExecutionException
                        {
                            return get();
                        }

                        public volatile Object get(long l, TimeUnit timeunit)
                            throws InterruptedException, ExecutionException, TimeoutException
                        {
                            return get(l, timeunit);
                        }

                        public ResponseEntity get()
                            throws InterruptedException, ExecutionException, RejectedExecutionException
                        {
                            if (asyncHandler != null)
                            {
                                asyncHandler.onResponse(request, dataResponse);
                            }
                            return dataResponse;
                        }

                        public ResponseEntity get(long l, TimeUnit timeunit)
                            throws InterruptedException, ExecutionException, RejectedExecutionException, TimeoutException
                        {
                            if (asyncHandler != null)
                            {
                                asyncHandler.onResponse(request, dataResponse);
                            }
                            return dataResponse;
                        }

                        public boolean isCancelled()
                        {
                            return false;
                        }

                        public boolean isDone()
                        {
                            return false;
                        }

            
            {
                this$0 = CacheableApiDeserializer.this;
                asyncHandler = httprequesthandler;
                request = request1;
                dataResponse = responseentity;
                super();
            }
                    };
                }
            }
        }
        return super.executeAsync(request, i, new HttpRequestHandler() {

            final CacheableApiDeserializer this$0;
            final HttpRequestHandler val$asyncHandler;
            final Object val$key;

            public void onError(Request request1, Exception exception)
            {
                if (asyncHandler != null)
                {
                    asyncHandler.onError(request1, exception);
                }
            }

            public void onRequest(Request request1)
            {
                if (asyncHandler != null)
                {
                    asyncHandler.onRequest(request1);
                }
            }

            public void onResponse(Request request1, ResponseEntity responseentity)
            {
                if (cache != null)
                {
                    cache.put(key, responseentity, timeToLive);
                }
                if (asyncHandler != null)
                {
                    asyncHandler.onResponse(request1, responseentity);
                }
            }

            
            {
                this$0 = CacheableApiDeserializer.this;
                key = obj;
                asyncHandler = httprequesthandler;
                super();
            }
        });
    }

}
