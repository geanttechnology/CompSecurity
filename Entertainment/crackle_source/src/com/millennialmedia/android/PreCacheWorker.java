// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

// Referenced classes of package com.millennialmedia.android:
//            HttpGetRequest, VideoAd, AdCache, DTOCachedVideo, 
//            CachedAd

class PreCacheWorker extends Thread
{

    private static boolean busy;
    private Context appContext;
    private DTOCachedVideo cachedVideos[];
    private boolean downloadedNewVideos;
    private String noVideosToCacheURL;

    private PreCacheWorker(DTOCachedVideo adtocachedvideo[], Context context, String s)
    {
        cachedVideos = adtocachedvideo;
        noVideosToCacheURL = s;
        appContext = context.getApplicationContext();
    }

    private void handleContent(DTOCachedVideo dtocachedvideo, HttpEntity httpentity)
    {
        Object obj = httpentity.getContentType();
        if (obj != null)
        {
            obj = ((Header) (obj)).getValue();
            if (obj != null && ((String) (obj)).equalsIgnoreCase("application/json"))
            {
                handleJson(dtocachedvideo, httpentity);
            } else
            if (obj != null && ((String) (obj)).startsWith("video/"))
            {
                handleVideoFile(dtocachedvideo, httpentity);
                return;
            }
        }
    }

    private void handleJson(final DTOCachedVideo cachedVideo, HttpEntity httpentity)
    {
        Object obj = null;
        String s;
        try
        {
            s = HttpGetRequest.convertStreamToString(httpentity.getContent());
        }
        // Misplaced declaration of an exception variable
        catch (final DTOCachedVideo cachedVideo)
        {
            cachedVideo.printStackTrace();
            MMSDK.Log.d("Pre cache worker: Millennial ad return failed. Invalid response data.");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final DTOCachedVideo cachedVideo)
        {
            cachedVideo.printStackTrace();
            MMSDK.Log.d("Pre cache worker: Millennial ad return failed. Invalid response data.");
            return;
        }
        httpentity = obj;
        if (!TextUtils.isEmpty(s))
        {
            httpentity = new VideoAd(s);
        }
        if (httpentity == null || !httpentity.isValid())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        httpentity.downloadPriority = 1;
        if (!AdCache.startDownloadTask(appContext, null, httpentity, new AdCache.AdCacheTaskListener() {

        final PreCacheWorker this$0;
        final DTOCachedVideo val$cachedVideo;

        public void downloadCompleted(CachedAd cachedad, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_44;
            }
            AdCache.save(appContext, cachedad);
            downloadedNewVideos = true;
            MMSDK.Event.logEvent(cachedVideo.preCacheCompleteURL);
_L1:
            notify();
            this;
            JVM INSTR monitorexit ;
            return;
            MMSDK.Event.logEvent(cachedVideo.preCacheFailedURL);
              goto _L1
            cachedad;
            throw cachedad;
        }

        public void downloadStart(CachedAd cachedad)
        {
            MMSDK.Event.logEvent(cachedVideo.preCacheStartURL);
        }

            
            {
                this$0 = PreCacheWorker.this;
                cachedVideo = dtocachedvideo;
                super();
            }
    }))
        {
            break MISSING_BLOCK_LABEL_97;
        }
        wait();
        return;
        try
        {
            MMSDK.Event.logEvent(cachedVideo.preCacheStartURL);
            MMSDK.Event.logEvent(cachedVideo.preCacheFailedURL);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final DTOCachedVideo cachedVideo)
        {
            cachedVideo.printStackTrace();
        }
        MMSDK.Log.e("Pre cache worker interrupted: %s", new Object[] {
            cachedVideo.getMessage()
        });
        return;
    }

    private void handleVideoFile(DTOCachedVideo dtocachedvideo, HttpEntity httpentity)
    {
label0:
        {
            if (!TextUtils.isEmpty(dtocachedvideo.videoFileId))
            {
                MMSDK.Event.logEvent(dtocachedvideo.preCacheStartURL);
                if (!AdCache.downloadComponentToCache(dtocachedvideo.url, (new StringBuilder()).append(dtocachedvideo.videoFileId).append("video.dat").toString(), appContext))
                {
                    break label0;
                }
                MMSDK.Event.logEvent(dtocachedvideo.preCacheCompleteURL);
            }
            return;
        }
        MMSDK.Event.logEvent(dtocachedvideo.preCacheFailedURL);
    }

    static void preCacheVideos(DTOCachedVideo adtocachedvideo[], Context context, String s)
    {
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorenter ;
        if (!busy)
        {
            busy = true;
            (new PreCacheWorker(adtocachedvideo, context, s)).start();
        }
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        return;
        adtocachedvideo;
        throw adtocachedvideo;
    }

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        DTOCachedVideo adtocachedvideo[];
        int j;
        adtocachedvideo = cachedVideos;
        j = adtocachedvideo.length;
        int i = 0;
_L2:
        Object obj;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        obj = adtocachedvideo[i];
        Object obj1 = (new HttpGetRequest()).get(((DTOCachedVideo) (obj)).url);
        if (obj1 == null)
        {
            Exception exception;
            try
            {
                MMSDK.Log.d("Pre cache worker: HTTP response is null");
                break MISSING_BLOCK_LABEL_211;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            finally { }
            break MISSING_BLOCK_LABEL_115;
        }
        obj1 = ((HttpResponse) (obj1)).getEntity();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        MMSDK.Log.d("Pre cache worker: Null HTTP entity");
        break MISSING_BLOCK_LABEL_211;
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorenter ;
        busy = false;
        if (!downloadedNewVideos && !TextUtils.isEmpty(noVideosToCacheURL))
        {
            MMSDK.Event.logEvent(noVideosToCacheURL);
        }
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        MMSDK.Log.d("Pre cache worker HTTP error: %s", new Object[] {
            ((Exception) (obj)).getMessage()
        });
        break MISSING_BLOCK_LABEL_211;
        if (((HttpEntity) (obj1)).getContentLength() == 0L)
        {
            MMSDK.Log.d("Pre cache worker: Millennial ad return failed. Zero content length returned.");
            break MISSING_BLOCK_LABEL_211;
        }
        handleContent(((DTOCachedVideo) (obj)), ((HttpEntity) (obj1)));
        break MISSING_BLOCK_LABEL_211;
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorenter ;
        busy = false;
        if (!downloadedNewVideos && !TextUtils.isEmpty(noVideosToCacheURL))
        {
            MMSDK.Event.logEvent(noVideosToCacheURL);
        }
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        throw exception1;
        exception1;
        com/millennialmedia/android/PreCacheWorker;
        JVM INSTR monitorexit ;
        throw exception1;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }



/*
    static boolean access$102(PreCacheWorker precacheworker, boolean flag)
    {
        precacheworker.downloadedNewVideos = flag;
        return flag;
    }

*/
}
