// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.facebook.widget:
//            WorkQueue, ImageRequest, UrlRedirectCache, ImageResponseCache

class ImageDownloader
{

    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static final Handler handler = new Handler();
    private static final Map pendingRequests = new HashMap();

    ImageDownloader()
    {
    }

    static boolean cancelRequest(ImageRequest imagerequest)
    {
        RequestKey requestkey = new RequestKey(imagerequest.getImageUrl(), imagerequest.getCallerTag());
        imagerequest = pendingRequests;
        imagerequest;
        JVM INSTR monitorenter ;
        DownloaderContext downloadercontext = (DownloaderContext)pendingRequests.get(requestkey);
        if (downloadercontext == null) goto _L2; else goto _L1
_L1:
        if (!downloadercontext.workItem.cancel()) goto _L4; else goto _L3
_L3:
        pendingRequests.remove(requestkey);
        boolean flag = true;
_L6:
        imagerequest;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        downloadercontext.isCancelled = true;
        flag = true;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        imagerequest;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static void download(RequestKey requestkey, Context context)
    {
        Object obj1;
        Object obj2;
        Bitmap bitmap;
        boolean flag;
        boolean flag1;
        bitmap = null;
        obj1 = null;
        obj2 = null;
        flag1 = true;
        flag = true;
        HttpURLConnection httpurlconnection = (HttpURLConnection)requestkey.url.openConnection();
        httpurlconnection.setInstanceFollowRedirects(false);
        httpurlconnection.getResponseCode();
        JVM INSTR lookupswitch 3: default 415
    //                   200: 279
    //                   301: 189
    //                   302: 189;
           goto _L1 _L2 _L3 _L3
_L1:
        Object obj = httpurlconnection.getErrorStream();
        context = ((Context) (obj));
        obj1 = obj;
        Object obj3 = new InputStreamReader(((java.io.InputStream) (obj)));
        context = ((Context) (obj));
        obj1 = obj;
        char ac[] = new char[128];
        context = ((Context) (obj));
        obj1 = obj;
        StringBuilder stringbuilder = new StringBuilder();
_L5:
        context = ((Context) (obj));
        obj1 = obj;
        int i = ((InputStreamReader) (obj3)).read(ac, 0, ac.length);
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        context = ((Context) (obj));
        obj1 = obj;
        stringbuilder.append(ac, 0, i);
        if (true) goto _L5; else goto _L4
        obj1;
        obj = context;
        context = ((Context) (obj1));
_L13:
        Utility.closeQuietly(((java.io.Closeable) (obj)));
        Utility.disconnectQuietly(httpurlconnection);
        obj1 = obj2;
_L9:
        if (flag)
        {
            issueResponse(requestkey, context, ((Bitmap) (obj1)), false);
        }
        return;
_L3:
        obj = httpurlconnection.getHeaderField("location");
        if (Utility.isNullOrEmpty(((String) (obj))))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new URL(((String) (obj)));
        UrlRedirectCache.cacheUrlRedirect(context, requestkey.url, ((URL) (obj)));
        context = removePendingRequest(requestkey);
        if (context == null) goto _L7; else goto _L6
_L6:
        if (!((DownloaderContext) (context)).isCancelled)
        {
            enqueueCacheRead(((DownloaderContext) (context)).request, new RequestKey(((URL) (obj)), requestkey.tag), false);
        }
_L7:
        flag = false;
        context = null;
        obj = null;
        obj1 = bitmap;
_L10:
        Utility.closeQuietly(((java.io.Closeable) (obj)));
        Utility.disconnectQuietly(httpurlconnection);
        if (true) goto _L9; else goto _L8
_L2:
        obj = ImageResponseCache.interceptAndCacheImageStream(context, httpurlconnection);
        context = ((Context) (obj));
        obj1 = obj;
        bitmap = BitmapFactory.decodeStream(((java.io.InputStream) (obj)));
        context = null;
        obj1 = bitmap;
        flag = flag1;
          goto _L10
_L4:
        context = ((Context) (obj));
        obj1 = obj;
        Utility.closeQuietly(((java.io.Closeable) (obj3)));
        context = ((Context) (obj));
        obj1 = obj;
        obj3 = new FacebookException(stringbuilder.toString());
        flag = flag1;
        obj1 = bitmap;
        context = ((Context) (obj3));
          goto _L10
        requestkey;
        context = httpurlconnection;
_L12:
        Utility.closeQuietly(((java.io.Closeable) (obj1)));
        Utility.disconnectQuietly(context);
        throw requestkey;
        requestkey;
        context = null;
        continue; /* Loop/switch isn't completed */
        requestkey;
        context = httpurlconnection;
        if (true) goto _L12; else goto _L11
_L11:
        context;
        obj = null;
        httpurlconnection = null;
          goto _L13
        context;
        obj = null;
          goto _L13
        context;
        obj = null;
        flag = false;
          goto _L13
_L8:
        flag = false;
        context = null;
        obj = null;
        obj1 = bitmap;
          goto _L10
    }

    static void downloadAsync(ImageRequest imagerequest)
    {
        RequestKey requestkey;
        if (imagerequest == null)
        {
            return;
        }
        requestkey = new RequestKey(imagerequest.getImageUrl(), imagerequest.getCallerTag());
        Map map = pendingRequests;
        map;
        JVM INSTR monitorenter ;
        DownloaderContext downloadercontext = (DownloaderContext)pendingRequests.get(requestkey);
        if (downloadercontext == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        downloadercontext.request = imagerequest;
        downloadercontext.isCancelled = false;
        downloadercontext.workItem.moveToFront();
_L1:
        map;
        JVM INSTR monitorexit ;
        return;
        imagerequest;
        map;
        JVM INSTR monitorexit ;
        throw imagerequest;
        enqueueCacheRead(imagerequest, requestkey, imagerequest.isCachedRedirectAllowed());
          goto _L1
    }

    private static void enqueueCacheRead(ImageRequest imagerequest, RequestKey requestkey, boolean flag)
    {
        enqueueRequest(imagerequest, requestkey, cacheReadQueue, new CacheReadWorkItem(imagerequest.getContext(), requestkey, flag));
    }

    private static void enqueueDownload(ImageRequest imagerequest, RequestKey requestkey)
    {
        enqueueRequest(imagerequest, requestkey, downloadQueue, new DownloadImageWorkItem(imagerequest.getContext(), requestkey));
    }

    private static void enqueueRequest(ImageRequest imagerequest, RequestKey requestkey, WorkQueue workqueue, Runnable runnable)
    {
        synchronized (pendingRequests)
        {
            DownloaderContext downloadercontext = new DownloaderContext(null);
            downloadercontext.request = imagerequest;
            pendingRequests.put(requestkey, downloadercontext);
            downloadercontext.workItem = workqueue.addActiveWorkItem(runnable);
        }
        return;
        imagerequest;
        map;
        JVM INSTR monitorexit ;
        throw imagerequest;
    }

    private static void issueResponse(final RequestKey request, final Exception error, final Bitmap bitmap, final boolean isCachedRedirect)
    {
        request = removePendingRequest(request);
        if (request != null && !((DownloaderContext) (request)).isCancelled)
        {
            request = ((DownloaderContext) (request)).request;
            final ImageRequest.Callback callback = request.getCallback();
            if (callback != null)
            {
                handler.post(new _cls1());
            }
        }
    }

    static void prioritizeRequest(ImageRequest imagerequest)
    {
        Object obj = new RequestKey(imagerequest.getImageUrl(), imagerequest.getCallerTag());
        imagerequest = pendingRequests;
        imagerequest;
        JVM INSTR monitorenter ;
        obj = (DownloaderContext)pendingRequests.get(obj);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        ((DownloaderContext) (obj)).workItem.moveToFront();
        imagerequest;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        imagerequest;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static void readFromCache(RequestKey requestkey, Context context, boolean flag)
    {
        boolean flag1 = false;
        if (!flag) goto _L2; else goto _L1
_L1:
        Object obj = UrlRedirectCache.getRedirectedUrl(context, requestkey.url);
        if (obj == null) goto _L2; else goto _L3
_L3:
        obj = ImageResponseCache.getCachedImageStream(((URL) (obj)), context);
        flag = flag1;
        if (obj != null)
        {
            flag = true;
        }
_L9:
        if (!flag)
        {
            obj = ImageResponseCache.getCachedImageStream(requestkey.url, context);
        }
        if (obj == null) goto _L5; else goto _L4
_L4:
        context = BitmapFactory.decodeStream(((java.io.InputStream) (obj)));
        Utility.closeQuietly(((java.io.Closeable) (obj)));
        issueResponse(requestkey, null, context, flag);
_L7:
        return;
_L5:
        context = removePendingRequest(requestkey);
        if (context == null || ((DownloaderContext) (context)).isCancelled) goto _L7; else goto _L6
_L6:
        enqueueDownload(((DownloaderContext) (context)).request, requestkey);
        return;
_L2:
        flag = false;
        obj = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private static DownloaderContext removePendingRequest(RequestKey requestkey)
    {
        synchronized (pendingRequests)
        {
            requestkey = (DownloaderContext)pendingRequests.remove(requestkey);
        }
        return requestkey;
        requestkey;
        map;
        JVM INSTR monitorexit ;
        throw requestkey;
    }




    private class RequestKey
    {

        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        Object tag;
        URL url;

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj instanceof RequestKey)
                {
                    obj = (RequestKey)obj;
                    flag = flag1;
                    if (((RequestKey) (obj)).url == url)
                    {
                        flag = flag1;
                        if (((RequestKey) (obj)).tag == tag)
                        {
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return (url.hashCode() + 1073) * 37 + tag.hashCode();
        }

        RequestKey(URL url1, Object obj)
        {
            url = url1;
            tag = obj;
        }
    }


    private class DownloaderContext
    {

        boolean isCancelled;
        ImageRequest request;
        WorkQueue.WorkItem workItem;

        private DownloaderContext()
        {
        }

        DownloaderContext(_cls1 _pcls1)
        {
            this();
        }
    }


    private class CacheReadWorkItem
        implements Runnable
    {

        private boolean allowCachedRedirects;
        private Context context;
        private RequestKey key;

        public void run()
        {
            ImageDownloader.readFromCache(key, context, allowCachedRedirects);
        }

        CacheReadWorkItem(Context context1, RequestKey requestkey, boolean flag)
        {
            context = context1;
            key = requestkey;
            allowCachedRedirects = flag;
        }
    }


    private class DownloadImageWorkItem
        implements Runnable
    {

        private Context context;
        private RequestKey key;

        public void run()
        {
            ImageDownloader.download(key, context);
        }

        DownloadImageWorkItem(Context context1, RequestKey requestkey)
        {
            context = context1;
            key = requestkey;
        }
    }


    private class _cls1
        implements Runnable
    {

        final Bitmap val$bitmap;
        final ImageRequest.Callback val$callback;
        final Exception val$error;
        final boolean val$isCachedRedirect;
        final ImageRequest val$request;

        public final void run()
        {
            ImageResponse imageresponse = new ImageResponse(request, error, isCachedRedirect, bitmap);
            callback.onCompleted(imageresponse);
        }

        _cls1()
        {
            request = imagerequest;
            error = exception;
            isCachedRedirect = flag;
            bitmap = bitmap1;
            callback = callback1;
            super();
        }
    }

}
