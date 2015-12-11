// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Preconditions;
import com.mopub.common.util.DeviceUtils;
import com.mopub.volley.toolbox.BasicNetwork;
import com.mopub.volley.toolbox.DiskBasedCache;
import com.mopub.volley.toolbox.ImageLoader;
import java.io.File;

// Referenced classes of package com.mopub.network:
//            MaxWidthImageLoader, PlayServicesUrlRewriter, CustomSSLSocketFactory, RequestQueueHttpStack, 
//            MoPubRequestQueue

public class Networking
{

    static final String CACHE_DIRECTORY_NAME = "mopub-volley-cache";
    private static final String DEFAULT_USER_AGENT = System.getProperty("http.agent");
    private static volatile MaxWidthImageLoader sMaxWidthImageLoader;
    private static volatile MoPubRequestQueue sRequestQueue;
    public static boolean sUseHttps = false;
    private static volatile String sUserAgent;

    public Networking()
    {
    }

    public static void clearForTesting()
    {
        com/mopub/network/Networking;
        JVM INSTR monitorenter ;
        sRequestQueue = null;
        sMaxWidthImageLoader = null;
        sUserAgent = null;
        com/mopub/network/Networking;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getCachedUserAgent()
    {
        String s1 = sUserAgent;
        String s = s1;
        if (s1 == null)
        {
            s = DEFAULT_USER_AGENT;
        }
        return s;
    }

    public static ImageLoader getImageLoader(Context context)
    {
        MaxWidthImageLoader maxwidthimageloader = sMaxWidthImageLoader;
        if (maxwidthimageloader != null) goto _L2; else goto _L1
_L1:
        com/mopub/network/Networking;
        JVM INSTR monitorenter ;
        MaxWidthImageLoader maxwidthimageloader1 = sMaxWidthImageLoader;
        maxwidthimageloader = maxwidthimageloader1;
        if (maxwidthimageloader1 != null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        maxwidthimageloader = new MaxWidthImageLoader(getRequestQueue(context), context, new com.mopub.volley.toolbox.ImageLoader.ImageCache(new LruCache(DeviceUtils.memoryCacheSizeBytes(context)) {

            protected volatile int sizeOf(Object obj, Object obj1)
            {
                return sizeOf((String)obj, (Bitmap)obj1);
            }

            protected int sizeOf(String s, Bitmap bitmap)
            {
                if (bitmap != null)
                {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                } else
                {
                    return super.sizeOf(s, bitmap);
                }
            }

        }) {

            final LruCache val$imageCache;

            public Bitmap getBitmap(String s)
            {
                return (Bitmap)imageCache.get(s);
            }

            public void putBitmap(String s, Bitmap bitmap)
            {
                imageCache.put(s, bitmap);
            }

            
            {
                imageCache = lrucache;
                super();
            }
        });
        sMaxWidthImageLoader = maxwidthimageloader;
        com/mopub/network/Networking;
        JVM INSTR monitorexit ;
        return maxwidthimageloader;
_L4:
        com/mopub/network/Networking;
        JVM INSTR monitorexit ;
        throw context;
        context;
        continue; /* Loop/switch isn't completed */
_L2:
        return maxwidthimageloader;
        context;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static MoPubRequestQueue getRequestQueue()
    {
        return sRequestQueue;
    }

    public static MoPubRequestQueue getRequestQueue(Context context)
    {
        Object obj = sRequestQueue;
        if (obj != null) goto _L2; else goto _L1
_L1:
        com/mopub/network/Networking;
        JVM INSTR monitorenter ;
        MoPubRequestQueue mopubrequestqueue = sRequestQueue;
        obj = mopubrequestqueue;
        if (mopubrequestqueue != null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj = new PlayServicesUrlRewriter(ClientMetadata.getInstance(context).getDeviceId(), context);
        CustomSSLSocketFactory customsslsocketfactory = CustomSSLSocketFactory.getDefault(10000);
        obj = new BasicNetwork(new RequestQueueHttpStack(getUserAgent(context.getApplicationContext()), ((com.mopub.volley.toolbox.HurlStack.UrlRewriter) (obj)), customsslsocketfactory));
        context = new File((new StringBuilder()).append(context.getCacheDir().getPath()).append(File.separator).append("mopub-volley-cache").toString());
        obj = new MoPubRequestQueue(new DiskBasedCache(context, (int)DeviceUtils.diskCacheSizeBytes(context, 0xa00000L)), ((com.mopub.volley.Network) (obj)));
        sRequestQueue = ((MoPubRequestQueue) (obj));
        ((MoPubRequestQueue) (obj)).start();
        com/mopub/network/Networking;
        JVM INSTR monitorexit ;
        return ((MoPubRequestQueue) (obj));
_L4:
        com/mopub/network/Networking;
        JVM INSTR monitorexit ;
        throw context;
        context;
        continue; /* Loop/switch isn't completed */
_L2:
        return ((MoPubRequestQueue) (obj));
        context;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getUserAgent(Context context)
    {
        Object obj;
        Preconditions.checkNotNull(context);
        obj = sUserAgent;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        com/mopub/network/Networking;
        JVM INSTR monitorenter ;
        String s = sUserAgent;
        obj = s;
        if (s != null) goto _L2; else goto _L1
_L1:
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        context = (new WebView(context)).getSettings().getUserAgentString();
_L3:
        sUserAgent = context;
        obj = context;
_L2:
        com/mopub/network/Networking;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        context = DEFAULT_USER_AGENT;
          goto _L3
        context;
        com/mopub/network/Networking;
        JVM INSTR monitorexit ;
        throw context;
        return ((String) (obj));
    }

    public static void setImageLoaderForTesting(MaxWidthImageLoader maxwidthimageloader)
    {
        com/mopub/network/Networking;
        JVM INSTR monitorenter ;
        sMaxWidthImageLoader = maxwidthimageloader;
        com/mopub/network/Networking;
        JVM INSTR monitorexit ;
        return;
        maxwidthimageloader;
        throw maxwidthimageloader;
    }

    public static void setRequestQueueForTesting(MoPubRequestQueue mopubrequestqueue)
    {
        com/mopub/network/Networking;
        JVM INSTR monitorenter ;
        sRequestQueue = mopubrequestqueue;
        com/mopub/network/Networking;
        JVM INSTR monitorexit ;
        return;
        mopubrequestqueue;
        throw mopubrequestqueue;
    }

    public static void setUserAgentForTesting(String s)
    {
        com/mopub/network/Networking;
        JVM INSTR monitorenter ;
        sUserAgent = s;
        com/mopub/network/Networking;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static void useHttps(boolean flag)
    {
        sUseHttps = flag;
    }

    public static boolean useHttps()
    {
        return sUseHttps;
    }

}
