// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.ebay.nautilus.domain.net.ImageRequest;
import com.ebay.nautilus.domain.net.ImageResponse;
import com.ebay.nautilus.shell.app.FwActivity;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ImageCache
{
    private static final class BitmapLruCache extends LruCache
    {

        protected volatile int sizeOf(Object obj, Object obj1)
        {
            return sizeOf((String)obj, (Bitmap)obj1);
        }

        protected int sizeOf(String s, Bitmap bitmap)
        {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }

        public BitmapLruCache(int i)
        {
            super(i);
        }
    }

    public static interface ICacheConfiguration
    {

        public abstract int getMaxCacheSize();

        public abstract int getMissingImageResource();
    }

    private static final class ImageData
    {

        Bitmap bitmap;
        public final int missingImageResId;
        public ArrayList secondaryViews;
        public final String url;
        public final ArrayList views = new ArrayList(1);

        private void setImage(ImageView imageview)
        {
            if (!url.equals(imageview.getTag()))
            {
                break MISSING_BLOCK_LABEL_40;
            }
            if (bitmap == null)
            {
                imageview.setImageResource(missingImageResId);
                return;
            }
            try
            {
                imageview.setImageBitmap(bitmap);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ImageView imageview) { }
        }

        public final void add(ImageData imagedata)
        {
            if (!url.equals(imagedata.url))
            {
                throw new InvalidParameterException("URLs don't match!");
            }
            ImageView imageview;
            for (Iterator iterator = imagedata.views.iterator(); iterator.hasNext(); views.add(imageview))
            {
                imageview = (ImageView)iterator.next();
            }

            if (imagedata.secondaryViews != null)
            {
                if (secondaryViews == null)
                {
                    secondaryViews = new ArrayList(imagedata.secondaryViews.size());
                }
                View view;
                for (imagedata = imagedata.secondaryViews.iterator(); imagedata.hasNext(); secondaryViews.add(view))
                {
                    view = (View)imagedata.next();
                }

            }
        }

        public final void setImage()
        {
            if (secondaryViews != null)
            {
                for (Iterator iterator = secondaryViews.iterator(); iterator.hasNext(); ((View)iterator.next()).setVisibility(8)) { }
            }
            Iterator iterator1 = views.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                ImageView imageview = (ImageView)iterator1.next();
                setImage(imageview);
                if (secondaryViews != null)
                {
                    imageview.setVisibility(0);
                }
            } while (true);
        }

        public String toString()
        {
            return (new StringBuilder()).append("ImageData{ url=").append(url).append(" }").toString();
        }

        public ImageData(ImageView imageview, String s, View view, int i)
        {
            secondaryViews = null;
            url = s;
            missingImageResId = i;
            views.add(imageview);
            if (view != null)
            {
                secondaryViews = new ArrayList(1);
                secondaryViews.add(view);
            }
        }
    }

    private static final class ImageFetchHandler extends Handler
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
            obj = new BitmapLruCache(i);
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
            obj1 = (ImageResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(((com.ebay.nautilus.kernel.content.EbayContext) (obj1)), new ImageRequest(new URL(s), true));
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
        //                       1 45;
               goto _L2 _L3
_L2:
            return;
_L3:
            ((ImageData)message.obj).setImage();
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


        public ImageFetchHandler(Activity activity1, int i)
        {
            bitmapCache = createCache(i);
            activity = new WeakReference(activity1);
        }
    }

    private static final class ImageFetcher
        implements Runnable
    {

        private final ImageData data;
        private final ImageFetchHandler handler;

        public void run()
        {
            obj = data.url;
            break MISSING_BLOCK_LABEL_8;
_L2:
            do
            {
                return;
            } while (Thread.interrupted() || !((String) (obj)).equals(((ImageView)data.views.get(0)).getTag()));
            HashMap hashmap = handler.fetching;
            hashmap;
            JVM INSTR monitorenter ;
            ImageData imagedata = (ImageData)handler.fetching.get(obj);
            if (imagedata == null)
            {
                break MISSING_BLOCK_LABEL_84;
            }
            imagedata.add(data);
            hashmap;
            JVM INSTR monitorexit ;
            return;
            obj;
            hashmap;
            JVM INSTR monitorexit ;
            throw obj;
            handler.fetching.put(obj, data);
            hashmap;
            JVM INSTR monitorexit ;
            data.bitmap = handler.getImage(((String) (obj)));
            synchronized (handler.fetching)
            {
                handler.fetching.remove(obj);
            }
            if (Thread.interrupted()) goto _L2; else goto _L1
_L1:
            handler.obtainMessage(1, data).sendToTarget();
            return;
            obj;
            hashmap1;
            JVM INSTR monitorexit ;
            throw obj;
            Exception exception1;
            exception1;
            synchronized (handler.fetching)
            {
                handler.fetching.remove(obj);
            }
            throw exception1;
            exception;
            hashmap2;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public ImageFetcher(ImageFetchHandler imagefetchhandler, ImageData imagedata)
        {
            handler = imagefetchhandler;
            data = imagedata;
        }
    }


    private static final double SLOW_CONNECTION_THRESHOLD = 200D;
    private static ICacheConfiguration cacheConfiguration;
    private String galleryImageHost;
    private final ImageFetchHandler imageFetchHandler;
    private ExecutorService imageFetchThreadPool;
    private final int missingImageResId;
    private Pattern pattern;

    public ImageCache(Activity activity)
    {
        this(activity, null, null);
    }

    public ImageCache(Activity activity, String s)
    {
        this(activity, s, null);
    }

    public ImageCache(Activity activity, String s, Integer integer)
    {
        imageFetchThreadPool = null;
        com/ebay/common/util/ImageCache;
        JVM INSTR monitorenter ;
        if (cacheConfiguration == null)
        {
            throw new IllegalStateException("Cache not initialize. You must call ImageCache.init() before using the cache");
        }
        break MISSING_BLOCK_LABEL_34;
        activity;
        com/ebay/common/util/ImageCache;
        JVM INSTR monitorexit ;
        throw activity;
        if (integer != null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        int i = cacheConfiguration.getMissingImageResource();
_L2:
        missingImageResId = i;
        imageFetchHandler = new ImageFetchHandler(activity, cacheConfiguration.getMaxCacheSize());
        pattern = Pattern.compile("(http[s]?://)(thumbs[1-9]?\\.ebaystatic\\.com)(.*)");
        galleryImageHost = s;
        com/ebay/common/util/ImageCache;
        JVM INSTR monitorexit ;
        return;
        i = integer.intValue();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static final void forgetView(ImageView imageview)
    {
        imageview.setTag(null);
    }

    public static void init(ICacheConfiguration icacheconfiguration)
    {
        com/ebay/common/util/ImageCache;
        JVM INSTR monitorenter ;
        cacheConfiguration = icacheconfiguration;
        com/ebay/common/util/ImageCache;
        JVM INSTR monitorexit ;
        return;
        icacheconfiguration;
        throw icacheconfiguration;
    }

    public static String rewriteThumbs(String s, Pattern pattern1, String s1)
    {
        if (s == null || pattern1 == null)
        {
            return s1;
        } else
        {
            return pattern1.matcher(s1).replaceFirst((new StringBuilder()).append("$1").append(s).append("$3").toString());
        }
    }

    public static String sanitizeUrl(String s)
    {
        if (s == null)
        {
            return s;
        }
        String s1 = s;
        try
        {
            s = new URL(s);
            s = (new URI(s.getProtocol(), s.getUserInfo(), s.getHost(), s.getPort(), s.getPath(), s.getQuery(), s.getRef())).toURL().toExternalForm();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = s1;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = s1;
        }
        return s;
    }

    private final void setImage(ImageView imageview, String s, View view, Drawable drawable, Integer integer)
    {
        Integer integer1 = integer;
        if (integer == null)
        {
            integer1 = Integer.valueOf(missingImageResId);
        }
        if (TextUtils.isEmpty(s))
        {
            imageview.setTag(s);
            try
            {
                imageview.setImageResource(integer1.intValue());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ImageView imageview)
            {
                return;
            }
        }
        integer = s;
        if (galleryImageHost != null)
        {
            integer = rewriteThumbs(galleryImageHost, pattern, s);
        }
        s = sanitizeUrl(integer);
        imageview.setTag(s);
        integer = imageFetchHandler.getCachedBitmap(s);
        if (integer != null)
        {
            if (view != null)
            {
                view.setVisibility(8);
            }
            imageview.setImageBitmap(integer);
            return;
        }
        if (drawable != null)
        {
            imageview.setImageDrawable(drawable);
        } else
        {
            imageview.setImageBitmap(null);
        }
        if (view != null)
        {
            view.setVisibility(0);
            imageview.setVisibility(4);
        }
        imageview = new ImageData(imageview, s, view, integer1.intValue());
        imageview = new ImageFetcher(imageFetchHandler, imageview);
        this;
        JVM INSTR monitorenter ;
        if (imageFetchThreadPool == null)
        {
            imageFetchThreadPool = Executors.newFixedThreadPool(3);
        }
        imageFetchThreadPool.execute(imageview);
        this;
        JVM INSTR monitorexit ;
        return;
        imageview;
        this;
        JVM INSTR monitorexit ;
        throw imageview;
    }

    public final void clearImageFetching()
    {
        this;
        JVM INSTR monitorenter ;
        if (imageFetchThreadPool != null)
        {
            imageFetchThreadPool.shutdown();
            imageFetchThreadPool = null;
        }
        this;
        JVM INSTR monitorexit ;
        imageFetchHandler.removeMessages(1);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Bitmap getImage(String s)
    {
        return imageFetchHandler.getImage(s);
    }

    public boolean isDownloadRateSlow()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (imageFetchHandler != null)
        {
            double d = imageFetchHandler.getLastDownloadRate();
            flag = flag1;
            if (d > 0.0D)
            {
                flag = flag1;
                if (d < 200D)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final void setImage(ImageView imageview, String s)
    {
        setImage(imageview, s, null, null, null);
    }

    public final void setImage(ImageView imageview, String s, int i)
    {
        setImage(imageview, s, null, null, Integer.valueOf(i));
    }

    public final void setImage(ImageView imageview, String s, Drawable drawable)
    {
        setImage(imageview, s, null, drawable, null);
    }

    public final void setImage(ImageView imageview, String s, View view)
    {
        setImage(imageview, s, view, null, null);
    }
}
