// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.json.JSONArray;

// Referenced classes of package com.millennialmedia.android:
//            MMJSObject, MMWebView, MMActivity, VideoPlayerActivity, 
//            AdCache, MMJSResponse, HttpGetRequest, MMLog, 
//            VideoAd, CachedAd

class BridgeMMCachedVideo extends MMJSObject
    implements AdCache.AdCacheTaskListener
{

    private boolean a;

    BridgeMMCachedVideo()
    {
    }

    private VideoPlayerActivity a()
    {
        if (c != null && c.get() != null && (((MMWebView)c.get()).h() instanceof MMActivity))
        {
            Object obj = (MMWebView)c.get();
            if (obj != null)
            {
                obj = ((MMWebView) (obj)).h();
                if (obj != null && (obj instanceof MMActivity))
                {
                    obj = (MMActivity)obj;
                    if (((MMActivity) (obj)).a != null && (((MMActivity) (obj)).a instanceof VideoPlayerActivity))
                    {
                        return (VideoPlayerActivity)((MMActivity) (obj)).a;
                    }
                }
            }
        }
        return null;
    }

    final MMJSResponse a(String s, Map map)
    {
        MMJSResponse mmjsresponse = null;
        if ("availableCachedVideos".equals(s))
        {
            mmjsresponse = availableCachedVideos(map);
        } else
        {
            if ("cacheVideo".equals(s))
            {
                return cacheVideo(map);
            }
            if ("endVideo".equals(s))
            {
                return endVideo(map);
            }
            if ("pauseVideo".equals(s))
            {
                return pauseVideo(map);
            }
            if ("playCachedVideo".equals(s))
            {
                return playCachedVideo(map);
            }
            if ("playVideo".equals(s))
            {
                return playVideo(map);
            }
            if ("restartVideo".equals(s))
            {
                return restartVideo(map);
            }
            if ("videoIdExists".equals(s))
            {
                return videoIdExists(map);
            }
        }
        return mmjsresponse;
    }

    public MMJSResponse availableCachedVideos(Map map)
    {
        Object obj = (Context)b.get();
        if (obj != null)
        {
            map = new JSONArray();
            AdCache.a(((Context) (obj)), 2, new AdCache.Iterator(((Context) (obj)), map) {

                private Context a;
                private JSONArray b;

                final boolean a(CachedAd cachedad)
                {
                    if ((cachedad instanceof VideoAd) && cachedad.isOnDisk(a) && !cachedad.isExpired())
                    {
                        b.put(cachedad.getId());
                    }
                    return true;
                }

            
            {
                a = context;
                b = jsonarray;
                super();
            }
            });
            obj = new MMJSResponse();
            obj.c = 1;
            obj.d = map;
            return ((MMJSResponse) (obj));
        } else
        {
            return null;
        }
    }

    public MMJSResponse cacheVideo(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        Context context;
        context = (Context)b.get();
        map = (String)map.get("url");
        if (map == null || context == null) goto _L2; else goto _L1
_L1:
        Object obj = (new HttpGetRequest()).a(map);
        if (obj != null) goto _L4; else goto _L3
_L3:
        MMLog.c("BridgeMMCachedVideo", "HTTP response is null");
        map = null;
_L5:
        this;
        JVM INSTR monitorexit ;
        return map;
_L4:
        obj = ((HttpResponse) (obj)).getEntity();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        MMLog.b("BridgeMMCachedVideo", "Null HTTP entity");
        map = null;
          goto _L5
        map;
        MMLog.a("BridgeMMCachedVideo", "HTTP error: ", map);
        map = null;
          goto _L5
        if (((HttpEntity) (obj)).getContentLength() != 0L)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        MMLog.b("BridgeMMCachedVideo", "Millennial ad return failed. Zero content length returned.");
        map = null;
          goto _L5
        Header header = ((HttpEntity) (obj)).getContentType();
        if (header == null) goto _L2; else goto _L6
_L6:
        if (header.getValue() == null) goto _L2; else goto _L7
_L7:
        boolean flag = header.getValue().equalsIgnoreCase("application/json");
        if (!flag) goto _L2; else goto _L8
_L8:
        obj = new VideoAd(HttpGetRequest.a(((HttpEntity) (obj)).getContent()));
        if (!((VideoAd) (obj)).isValid()) goto _L2; else goto _L9
_L9:
        obj.downloadPriority = 3;
        flag = AdCache.a(context, null, ((CachedAd) (obj)), this);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        wait();
        if (!a)
        {
            break MISSING_BLOCK_LABEL_275;
        }
        map = MMJSResponse.a(String.format("Cached video(%s)", new Object[] {
            map
        }));
        notify();
          goto _L5
        map;
        throw map;
        map;
        MMLog.a("BridgeMMCachedVideo", "Millennial ad return failed. Invalid response data.", map);
        map = null;
          goto _L5
        map;
        MMLog.a("BridgeMMCachedVideo", "Millennial ad return failed. Invalid response data.", map);
        map = null;
          goto _L5
        notify();
_L2:
        map = null;
          goto _L5
        map;
        MMLog.a("BridgeMMCachedVideo", "Caching interrupted: ", map);
        notify();
          goto _L2
        map;
        notify();
        throw map;
        map = MMJSResponse.b(String.format("Unable to start download for Cached video(%s)", new Object[] {
            map
        }));
          goto _L5
    }

    public void downloadCompleted(CachedAd cachedad, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        Context context = (Context)b.get();
        if (!flag || context == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        AdCache.a(context, cachedad);
        a = flag;
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

    public MMJSResponse endVideo(Map map)
    {
        map = a();
        if (map != null)
        {
            return a(new Callable(map) {

                private VideoPlayerActivity a;

                public MMJSResponse call()
                {
                    a.k();
                    return MMJSResponse.a();
                }

                public volatile Object call()
                {
                    return call();
                }

            
            {
                a = videoplayeractivity;
                super();
            }
            });
        } else
        {
            return null;
        }
    }

    public MMJSResponse pauseVideo(Map map)
    {
        map = a();
        if (map != null)
        {
            return a(new Callable(map) {

                private VideoPlayerActivity a;

                public MMJSResponse call()
                {
                    a.m();
                    return MMJSResponse.a();
                }

                public volatile Object call()
                {
                    return call();
                }

            
            {
                a = videoplayeractivity;
                super();
            }
            });
        } else
        {
            return null;
        }
    }

    public MMJSResponse playCachedVideo(Map map)
    {
        Context context = (Context)b.get();
        String s = (String)map.get("videoId");
        if (s != null && context != null)
        {
            VideoAd videoad = (VideoAd)AdCache.g(context, s);
            if (videoad != null && videoad.canShow(context, null, false))
            {
                videoad.show(context, a((String)map.get("PROPERTY_EXPANDING")));
                return MMJSResponse.a(String.format("Playing Video(%s)", new Object[] {
                    s
                }));
            }
        }
        return null;
    }

    public MMJSResponse playVideo(Map map)
    {
        map = a();
        if (map != null)
        {
            return a(new Callable(map) {

                private VideoPlayerActivity a;

                public MMJSResponse call()
                {
                    a.g();
                    return MMJSResponse.a();
                }

                public volatile Object call()
                {
                    return call();
                }

            
            {
                a = videoplayeractivity;
                super();
            }
            });
        } else
        {
            return null;
        }
    }

    public MMJSResponse restartVideo(Map map)
    {
        map = a();
        if (map != null)
        {
            return a(new Callable(map) {

                private VideoPlayerActivity a;

                public MMJSResponse call()
                {
                    a.h();
                    return MMJSResponse.a();
                }

                public volatile Object call()
                {
                    return call();
                }

            
            {
                a = videoplayeractivity;
                super();
            }
            });
        } else
        {
            return null;
        }
    }

    public MMJSResponse videoIdExists(Map map)
    {
        Context context = (Context)b.get();
        map = (String)map.get("videoId");
        if (map != null && context != null)
        {
            VideoAd videoad = (VideoAd)AdCache.g(context, map);
            if (videoad != null && videoad.isOnDisk(context) && !videoad.isExpired())
            {
                return MMJSResponse.a(map);
            }
        }
        return null;
    }
}
