// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.ebay.nautilus.domain.net.ImageRequest;
import com.ebay.nautilus.domain.net.ImageResponse;
import com.ebay.nautilus.shell.app.FwActivity;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

// Referenced classes of package com.ebay.common.util:
//            ImageCache

private static final class activity extends Handler
{

    public static final int FETCH_IMAGE_MSG = 1;
    private static double averageDownloadRate;
    private static volatile double lastDownloadRate;
    private static WeakReference sBitmapCache = null;
    public final WeakReference activity;
    private final LruCache bitmapCache;
    final HashMap fetching = new HashMap();

    private static LruCache createCache(int i)
    {
        com/ebay/common/util/ImageCache$ImageFetchHandler;
        JVM INSTR monitorenter ;
        if (sBitmapCache == null) goto _L2; else goto _L1
_L1:
        Object obj = (LruCache)sBitmapCache.get();
_L5:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        obj = new it>(i);
        sBitmapCache = new WeakReference(obj);
        com/ebay/common/util/ImageCache$ImageFetchHandler;
        JVM INSTR monitorexit ;
        return ((LruCache) (obj));
        obj;
_L3:
        com/ebay/common/util/ImageCache$ImageFetchHandler;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        if (true) goto _L3; else goto _L2
_L2:
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void updateDownloadRate(double d)
    {
        if (averageDownloadRate == 0.0D)
        {
            averageDownloadRate = d;
        } else
        {
            averageDownloadRate = (averageDownloadRate * 4D + d) / 5D;
        }
        lastDownloadRate = averageDownloadRate;
    }

    public final Bitmap getCachedBitmap(String s)
    {
        LruCache lrucache = bitmapCache;
        lrucache;
        JVM INSTR monitorenter ;
        Bitmap bitmap = (Bitmap)bitmapCache.get(s);
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        bitmapCache.remove(s);
        lrucache;
        JVM INSTR monitorexit ;
        return bitmap;
        s;
        lrucache;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final Bitmap getImage(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        Bitmap bitmap1 = null;
_L4:
        return bitmap1;
_L2:
        Bitmap bitmap;
        bitmap = getCachedBitmap(s);
        bitmap1 = bitmap;
        if (bitmap != null) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = (Activity)activity.get();
        bitmap1 = bitmap;
        if (!(obj instanceof FwActivity)) goto _L4; else goto _L5
_L5:
        Object obj1 = ((FwActivity)obj).getEbayContext();
        bitmap1 = bitmap;
        obj = bitmap;
        Bitmap bitmap2 = bitmap;
        Bitmap bitmap3 = bitmap;
        long l;
        try
        {
            l = SystemClock.elapsedRealtime();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return bitmap1;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return bitmap3;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return bitmap2;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return ((Bitmap) (obj));
        }
        bitmap1 = bitmap;
        obj = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        obj1 = (ImageResponse)com.ebay.nautilus.kernel.net.(((com.ebay.nautilus.kernel.content.EbayContext) (obj1)), new ImageRequest(new URL(s), true));
        bitmap1 = bitmap;
        obj = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        l = SystemClock.elapsedRealtime() - l;
        if (l <= 0L)
        {
            l = 1L;
        }
        bitmap1 = bitmap;
        obj = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap = ((ImageResponse) (obj1)).getImage();
        bitmap1 = bitmap;
        if (bitmap == null) goto _L4; else goto _L6
_L6:
        bitmap1 = bitmap;
        obj = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        putCachedBitmap(s, bitmap);
        bitmap1 = bitmap;
        obj = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        updateDownloadRate((double)((ImageResponse) (obj1)).getByteArray().length / (double)l);
        return bitmap;
    }

    public double getLastDownloadRate()
    {
        return lastDownloadRate;
    }

    public void handleMessage(Message message)
    {
        Activity activity1 = (Activity)activity.get();
        if (activity1 == null || activity1.isFinishing()) goto _L2; else goto _L1
_L1:
        message.what;
        JVM INSTR tableswitch 1 1: default 44
    //                   1 45;
           goto _L2 _L3
_L2:
        return;
_L3:
        ((activity)message.obj).();
        return;
    }

    public final void putCachedBitmap(String s, Bitmap bitmap)
    {
        synchronized (bitmapCache)
        {
            bitmapCache.put(s, bitmap);
        }
        return;
        s;
        lrucache;
        JVM INSTR monitorexit ;
        throw s;
    }


    public (Activity activity1, int i)
    {
        bitmapCache = createCache(i);
        activity = new WeakReference(activity1);
    }
}
