// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMActivity, VideoPlayerActivity, AdCache, 
//            MMJSResponse, HttpGetRequest, VideoAd, CachedAd

class BridgeMMCachedVideo extends MMJSObject
    implements AdCache.AdCacheTaskListener
{

    private boolean success;

    BridgeMMCachedVideo()
    {
    }

    private VideoPlayerActivity getVPA()
    {
        Object obj = null;
        VideoPlayerActivity videoplayeractivity = obj;
        if (contextRef != null)
        {
            videoplayeractivity = obj;
            if (contextRef.get() instanceof MMActivity)
            {
                MMActivity mmactivity = (MMActivity)contextRef.get();
                videoplayeractivity = obj;
                if (mmactivity.getWrappedActivity() != null)
                {
                    videoplayeractivity = obj;
                    if (mmactivity.getWrappedActivity() instanceof VideoPlayerActivity)
                    {
                        videoplayeractivity = (VideoPlayerActivity)mmactivity.getWrappedActivity();
                    }
                }
            }
        }
        return videoplayeractivity;
    }

    public MMJSResponse availableCachedVideos(final HashMap array)
    {
        final Context context = (Context)contextRef.get();
        if (context != null)
        {
            array = new JSONArray();
            AdCache.iterateCachedAds(context, 2, new AdCache.Iterator() {

                final BridgeMMCachedVideo this$0;
                final JSONArray val$array;
                final Context val$context;

                boolean callback(CachedAd cachedad)
                {
                    if ((cachedad instanceof VideoAd) && cachedad.isOnDisk(context) && !cachedad.isExpired())
                    {
                        array.put(cachedad.getId());
                    }
                    return true;
                }

            
            {
                this$0 = BridgeMMCachedVideo.this;
                context = context1;
                array = jsonarray;
                super();
            }
            });
            context = new MMJSResponse();
            context.result = 1;
            context.response = array;
            return context;
        } else
        {
            return null;
        }
    }

    public MMJSResponse cacheVideo(HashMap hashmap)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        Context context;
        String s;
        context = (Context)contextRef.get();
        s = (String)hashmap.get("url");
        hashmap = obj;
        if (s == null) goto _L2; else goto _L1
_L1:
        hashmap = obj;
        if (context == null) goto _L2; else goto _L3
_L3:
        System.out.println(s);
        hashmap = (new HttpGetRequest()).get(s);
        if (hashmap != null) goto _L5; else goto _L4
_L4:
        MMSDK.Log.i("HTTP response is null");
        hashmap = obj;
_L2:
        this;
        JVM INSTR monitorexit ;
        return hashmap;
_L5:
        Object obj1 = hashmap.getEntity();
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        MMSDK.Log.d("Null HTTP entity");
        hashmap = obj;
          goto _L2
        hashmap;
        throw hashmap;
        hashmap;
        MMSDK.Log.d((new StringBuilder()).append("HTTP error: ").append(hashmap.getMessage()).toString());
        hashmap = obj;
          goto _L2
        if (((HttpEntity) (obj1)).getContentLength() != 0L)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        MMSDK.Log.d("Millennial ad return failed. Zero content length returned.");
        hashmap = obj;
          goto _L2
        Header header = ((HttpEntity) (obj1)).getContentType();
        hashmap = obj;
        if (header == null) goto _L2; else goto _L6
_L6:
        hashmap = obj;
        if (header.getValue() == null) goto _L2; else goto _L7
_L7:
        boolean flag = header.getValue().equalsIgnoreCase("application/json");
        hashmap = obj;
        if (!flag) goto _L2; else goto _L8
_L8:
        obj1 = new VideoAd(HttpGetRequest.convertStreamToString(((HttpEntity) (obj1)).getContent()));
        hashmap = obj;
        if (obj1 == null) goto _L2; else goto _L9
_L9:
        hashmap = obj;
        if (!((VideoAd) (obj1)).isValid()) goto _L2; else goto _L10
_L10:
        obj1.downloadPriority = 3;
        flag = AdCache.startDownloadTask(context, null, ((CachedAd) (obj1)), this);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_374;
        }
        wait();
        if (!success)
        {
            break MISSING_BLOCK_LABEL_328;
        }
        hashmap = MMJSResponse.responseWithSuccess(String.format("Cached video(%s)", new Object[] {
            s
        }));
        notify();
          goto _L2
        hashmap;
        hashmap.printStackTrace();
        MMSDK.Log.d("Millennial ad return failed. Invalid response data.");
        hashmap = obj;
          goto _L2
        hashmap;
        hashmap.printStackTrace();
        MMSDK.Log.d("Millennial ad return failed. Invalid response data.");
        hashmap = obj;
          goto _L2
        notify();
        hashmap = obj;
          goto _L2
        hashmap;
        MMSDK.Log.e(hashmap);
        MMSDK.Log.e("Caching interrupted: %s", new Object[] {
            hashmap.getMessage()
        });
        notify();
        hashmap = obj;
          goto _L2
        hashmap;
        notify();
        throw hashmap;
        hashmap = MMJSResponse.responseWithError(String.format("Unable to start download for Cached video(%s)", new Object[] {
            s
        }));
          goto _L2
    }

    public void downloadCompleted(CachedAd cachedad, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        Context context = (Context)contextRef.get();
        if (!flag || context == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        AdCache.save(context, cachedad);
        success = flag;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        cachedad;
        this;
        JVM INSTR monitorexit ;
        throw cachedad;
    }

    public void downloadStart(CachedAd cachedad)
    {
    }

    public MMJSResponse endVideo(final HashMap vpa)
    {
        vpa = getVPA();
        if (vpa != null)
        {
            return runOnUiThreadFuture(new Callable() {

                final BridgeMMCachedVideo this$0;
                final VideoPlayerActivity val$vpa;

                public MMJSResponse call()
                {
                    vpa.endVideo();
                    return MMJSResponse.responseWithSuccess();
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$0 = BridgeMMCachedVideo.this;
                vpa = videoplayeractivity;
                super();
            }
            });
        } else
        {
            return null;
        }
    }

    public MMJSResponse pauseVideo(final HashMap vpa)
    {
        vpa = getVPA();
        if (vpa != null)
        {
            return runOnUiThreadFuture(new Callable() {

                final BridgeMMCachedVideo this$0;
                final VideoPlayerActivity val$vpa;

                public MMJSResponse call()
                {
                    vpa.pauseVideoByUser();
                    return MMJSResponse.responseWithSuccess();
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$0 = BridgeMMCachedVideo.this;
                vpa = videoplayeractivity;
                super();
            }
            });
        } else
        {
            return null;
        }
    }

    public MMJSResponse playCachedVideo(HashMap hashmap)
    {
        Object obj = null;
        Context context = (Context)contextRef.get();
        String s = (String)hashmap.get("videoId");
        MMJSResponse mmjsresponse = obj;
        if (s != null)
        {
            mmjsresponse = obj;
            if (context != null)
            {
                VideoAd videoad = (VideoAd)AdCache.load(context, s);
                mmjsresponse = obj;
                if (videoad != null)
                {
                    mmjsresponse = obj;
                    if (videoad.canShow(context, null, false))
                    {
                        videoad.show(context, getAdImplId((String)hashmap.get("PROPERTY_EXPANDING")));
                        mmjsresponse = MMJSResponse.responseWithSuccess(String.format("Playing Video(%s)", new Object[] {
                            s
                        }));
                    }
                }
            }
        }
        return mmjsresponse;
    }

    public MMJSResponse playVideo(final HashMap vpa)
    {
        vpa = getVPA();
        if (vpa != null)
        {
            return runOnUiThreadFuture(new Callable() {

                final BridgeMMCachedVideo this$0;
                final VideoPlayerActivity val$vpa;

                public MMJSResponse call()
                {
                    vpa.resumeVideo();
                    return MMJSResponse.responseWithSuccess();
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$0 = BridgeMMCachedVideo.this;
                vpa = videoplayeractivity;
                super();
            }
            });
        } else
        {
            return null;
        }
    }

    public MMJSResponse restartVideo(final HashMap vpa)
    {
        vpa = getVPA();
        if (vpa != null)
        {
            return runOnUiThreadFuture(new Callable() {

                final BridgeMMCachedVideo this$0;
                final VideoPlayerActivity val$vpa;

                public MMJSResponse call()
                {
                    vpa.restartVideo();
                    return MMJSResponse.responseWithSuccess();
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            
            {
                this$0 = BridgeMMCachedVideo.this;
                vpa = videoplayeractivity;
                super();
            }
            });
        } else
        {
            return null;
        }
    }

    public MMJSResponse videoIdExists(HashMap hashmap)
    {
        Context context = (Context)contextRef.get();
        hashmap = (String)hashmap.get("videoId");
        if (hashmap != null && context != null)
        {
            VideoAd videoad = (VideoAd)AdCache.load(context, hashmap);
            if (videoad != null && videoad.isOnDisk(context) && !videoad.isExpired())
            {
                return MMJSResponse.responseWithSuccess(hashmap);
            }
        }
        return null;
    }
}
