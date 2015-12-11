// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;
import com.amazon.now.platform.AndroidPlatform;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.now.util:
//            NetUtil

public class ImageUtil
{
    public static interface ImageDownloadCallback
    {

        public abstract void bitmapReady(Bitmap bitmap);
    }

    public static class ImageReadyCallback
        implements ImageDownloadCallback
    {

        private final WeakReference imageViewReference;

        public void bitmapReady(Bitmap bitmap)
        {
            if (imageViewReference != null && bitmap != null)
            {
                ImageView imageview = (ImageView)imageViewReference.get();
                if (imageview != null)
                {
                    imageview.setImageBitmap(bitmap);
                }
            }
        }

        public ImageReadyCallback(ImageView imageview)
        {
            imageViewReference = new WeakReference(imageview);
        }
    }


    private static final Pattern IMAGE_SERVER = Pattern.compile("^https?://(.*images-|media-services\\.integ\\.|.*images-.*\\.|.*\\.iad[0-9]+\\.)amazon(\\.[\\w\\d]+)+(:[0-9]+)?/images/");
    private static final Pattern MSA = Pattern.compile("\\.(_.+_)\\.\\w+$");
    private static final Pattern SUFFIX = Pattern.compile("(\\.\\w+$)");
    private static final String TAG = com/amazon/now/util/ImageUtil.getSimpleName();
    private static final Pattern TRANSPARENT_MSA = Pattern.compile("_(FM[^_]+)_");
    private static final Pattern TRIMMER = Pattern.compile("\\._.+_(\\.\\w+)$");
    private static volatile LruCache sMemCache;

    public ImageUtil()
    {
    }

    public static void addBitmapToMemoryCache(String s, Bitmap bitmap)
    {
        if (getBitmapFromMemoryCache(s) == null)
        {
            synchronized (sMemCache)
            {
                sMemCache.put(s, bitmap);
            }
            return;
        } else
        {
            return;
        }
        s;
        lrucache;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void clearCache()
    {
        synchronized (sMemCache)
        {
            sMemCache.evictAll();
        }
        return;
        exception;
        lrucache;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static Bitmap getBitmapFromMemoryCache(String s)
    {
        synchronized (sMemCache)
        {
            s = (Bitmap)sMemCache.get(s);
        }
        return s;
        s;
        lrucache;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static int getImageInSampleSize(int i, int j, int k, int l)
    {
        int i1 = 1;
        boolean flag = true;
        if (j > l || i > k)
        {
            j /= 2;
            int j1 = i / 2;
            i = ((flag) ? 1 : 0);
            do
            {
                i1 = i;
                if (j / i <= l)
                {
                    break;
                }
                i1 = i;
                if (j1 / i <= k)
                {
                    break;
                }
                i *= 2;
            } while (true);
        }
        return i1;
    }

    public static String getImageUrl(String s)
    {
        if (isImageServerUrl(s))
        {
            return TRIMMER.matcher(s).replaceAll("$1");
        } else
        {
            return null;
        }
    }

    public static String getImageUrlReplacingTags(String s, int i, int j)
    {
        return replaceTags(s, getSizeTags(i, j));
    }

    private static HttpURLConnection getInputStreamForUrl(String s)
    {
        try
        {
            s = (HttpURLConnection)NetUtil.getURLConnection(s);
            s.setConnectTimeout(5000);
            s.setReadTimeout(5000);
            s.setRequestProperty("User-Agent", AndroidPlatform.getInstance().getUserAgent());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, "Failure to establish connection. Aborting Image Download.", s);
            return null;
        }
        return s;
    }

    private static String getSizeTags(int i, int j)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (i > 0)
        {
            stringbuilder.append("_SX").append(i);
        }
        if (j > 0)
        {
            stringbuilder.append("_SY").append(j);
        }
        return stringbuilder.toString();
    }

    private static String getTransparencyMSAStyleString(String s)
    {
        Object obj = null;
        Matcher matcher = MSA.matcher(s);
        s = obj;
        if (matcher.find())
        {
            s = matcher.group(1);
            matcher = TRANSPARENT_MSA.matcher(s);
            s = obj;
            if (matcher.find())
            {
                s = matcher.group(1);
            }
        }
        return s;
    }

    public static boolean isImageServerUrl(String s)
    {
        return s != null && IMAGE_SERVER.matcher(s).find();
    }

    private static String replaceTags(String s, String s1)
    {
        if (isImageServerUrl(s))
        {
            String s2 = getTransparencyMSAStyleString(s);
            Matcher matcher = SUFFIX.matcher(getImageUrl(s));
            s1 = (new StringBuilder()).append(".").append(s1);
            if (TextUtils.isEmpty(s2))
            {
                s = "_$1";
            } else
            {
                s = (new StringBuilder()).append("_").append(s2).append("_$1").toString();
            }
            return matcher.replaceAll(s1.append(s).toString());
        } else
        {
            return null;
        }
    }

    public static void setImageFromUrl(ImageDownloadCallback imagedownloadcallback, String s)
    {
        setImageFromUrl(imagedownloadcallback, s, -1, -1, false);
    }

    public static void setImageFromUrl(ImageDownloadCallback imagedownloadcallback, String s, int i, int j, boolean flag)
    {
        if (imagedownloadcallback == null || TextUtils.isEmpty(s))
        {
            return;
        }
        if (flag)
        {
            Bitmap bitmap = getBitmapFromMemoryCache(s);
            if (bitmap != null)
            {
                imagedownloadcallback.bitmapReady(bitmap);
                return;
            }
        }
        (new AsyncTask(s, i, j, flag, imagedownloadcallback) {

            final boolean val$cache;
            final ImageDownloadCallback val$callback;
            final String val$imageUrl;
            final int val$maxHeight;
            final int val$maxWidth;

            protected transient Bitmap doInBackground(Void avoid[])
            {
                Object obj;
                Object obj2;
                InputStream inputstream;
                HttpURLConnection httpurlconnection;
                InputStream inputstream1;
                InputStream inputstream2;
                InputStream inputstream3;
                InputStream inputstream4;
                Object obj4;
                String s1;
                obj4 = null;
                s1 = imageUrl;
                inputstream1 = null;
                inputstream4 = null;
                httpurlconnection = null;
                obj2 = null;
                avoid = null;
                obj = null;
                inputstream2 = httpurlconnection;
                inputstream3 = inputstream1;
                inputstream = inputstream4;
                Object obj3 = ImageUtil.getInputStreamForUrl(s1);
                if (obj3 != null) goto _L2; else goto _L1
_L1:
                if (false)
                {
                    try
                    {
                        throw new NullPointerException();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        Log.e(ImageUtil.TAG, "Error closing stream", avoid);
                    }
                }
                avoid = obj4;
                if (obj3 != null)
                {
                    ((HttpURLConnection) (obj3)).disconnect();
                    avoid = obj4;
                }
_L3:
                return avoid;
_L2:
                obj = obj3;
                inputstream2 = httpurlconnection;
                obj2 = obj3;
                inputstream3 = inputstream1;
                avoid = ((Void []) (obj3));
                inputstream = inputstream4;
                inputstream4 = ((HttpURLConnection) (obj3)).getInputStream();
                obj = obj3;
                inputstream2 = inputstream4;
                obj2 = obj3;
                inputstream3 = inputstream4;
                avoid = ((Void []) (obj3));
                inputstream = inputstream4;
                android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                obj = obj3;
                inputstream2 = inputstream4;
                obj2 = obj3;
                inputstream3 = inputstream4;
                avoid = ((Void []) (obj3));
                inputstream = inputstream4;
                options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
                httpurlconnection = ((HttpURLConnection) (obj3));
                inputstream1 = inputstream4;
                obj = obj3;
                inputstream2 = inputstream4;
                obj2 = obj3;
                inputstream3 = inputstream4;
                avoid = ((Void []) (obj3));
                inputstream = inputstream4;
                if (maxWidth <= 0)
                {
                    break MISSING_BLOCK_LABEL_508;
                }
                httpurlconnection = ((HttpURLConnection) (obj3));
                inputstream1 = inputstream4;
                obj = obj3;
                inputstream2 = inputstream4;
                obj2 = obj3;
                inputstream3 = inputstream4;
                avoid = ((Void []) (obj3));
                inputstream = inputstream4;
                if (maxHeight <= 0)
                {
                    break MISSING_BLOCK_LABEL_508;
                }
                obj = obj3;
                inputstream2 = inputstream4;
                obj2 = obj3;
                inputstream3 = inputstream4;
                avoid = ((Void []) (obj3));
                inputstream = inputstream4;
                options.inJustDecodeBounds = true;
                obj = obj3;
                inputstream2 = inputstream4;
                obj2 = obj3;
                inputstream3 = inputstream4;
                avoid = ((Void []) (obj3));
                inputstream = inputstream4;
                BitmapFactory.decodeStream(inputstream4, null, options);
                obj = obj3;
                inputstream2 = inputstream4;
                obj2 = obj3;
                inputstream3 = inputstream4;
                avoid = ((Void []) (obj3));
                inputstream = inputstream4;
                options.inSampleSize = ImageUtil.getImageInSampleSize(options.outWidth, options.outHeight, maxWidth, maxHeight);
                obj = obj3;
                inputstream2 = inputstream4;
                obj2 = obj3;
                inputstream3 = inputstream4;
                avoid = ((Void []) (obj3));
                inputstream = inputstream4;
                options.inJustDecodeBounds = false;
                obj = obj3;
                inputstream2 = inputstream4;
                obj2 = obj3;
                inputstream3 = inputstream4;
                avoid = ((Void []) (obj3));
                inputstream = inputstream4;
                ((HttpURLConnection) (obj3)).disconnect();
                obj = obj3;
                inputstream2 = inputstream4;
                obj2 = obj3;
                inputstream3 = inputstream4;
                avoid = ((Void []) (obj3));
                inputstream = inputstream4;
                httpurlconnection = ImageUtil.getInputStreamForUrl(s1);
label0:
                {
                    if (httpurlconnection != null)
                    {
                        break label0;
                    }
                    if (inputstream4 != null)
                    {
                        try
                        {
                            inputstream4.close();
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void avoid[])
                        {
                            Log.e(ImageUtil.TAG, "Error closing stream", avoid);
                        }
                    }
                    avoid = obj4;
                    if (httpurlconnection != null)
                    {
                        httpurlconnection.disconnect();
                        return null;
                    }
                }
                  goto _L3
                obj = httpurlconnection;
                inputstream2 = inputstream4;
                obj2 = httpurlconnection;
                inputstream3 = inputstream4;
                avoid = httpurlconnection;
                inputstream = inputstream4;
                inputstream1 = httpurlconnection.getInputStream();
                obj = httpurlconnection;
                inputstream2 = inputstream1;
                obj2 = httpurlconnection;
                inputstream3 = inputstream1;
                avoid = httpurlconnection;
                inputstream = inputstream1;
                obj3 = BitmapFactory.decodeStream(inputstream1, null, options);
                obj = obj3;
                if (inputstream1 != null)
                {
                    try
                    {
                        inputstream1.close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        Log.e(ImageUtil.TAG, "Error closing stream", avoid);
                    }
                }
                avoid = ((Void []) (obj));
                if (httpurlconnection != null)
                {
                    httpurlconnection.disconnect();
                    return ((Bitmap) (obj));
                }
                  goto _L3
                obj2;
                avoid = ((Void []) (obj));
                inputstream = inputstream2;
                Log.e(ImageUtil.TAG, "Failure to download image", ((Throwable) (obj2)));
                if (inputstream2 != null)
                {
                    try
                    {
                        inputstream2.close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        Log.e(ImageUtil.TAG, "Error closing stream", avoid);
                    }
                }
                avoid = obj4;
                if (obj != null)
                {
                    ((HttpURLConnection) (obj)).disconnect();
                    return null;
                }
                  goto _L3
                Object obj1;
                obj1;
                avoid = ((Void []) (obj2));
                inputstream = inputstream3;
                Log.e(ImageUtil.TAG, "Out of Memory! Aborting download", ((Throwable) (obj1)));
                if (inputstream3 != null)
                {
                    try
                    {
                        inputstream3.close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        Log.e(ImageUtil.TAG, "Error closing stream", avoid);
                    }
                }
                avoid = obj4;
                if (obj2 == null) goto _L3; else goto _L4
_L4:
                ((HttpURLConnection) (obj2)).disconnect();
                return null;
                obj1;
                if (inputstream != null)
                {
                    try
                    {
                        inputstream.close();
                    }
                    catch (IOException ioexception)
                    {
                        Log.e(ImageUtil.TAG, "Error closing stream", ioexception);
                    }
                }
                if (avoid != null)
                {
                    avoid.disconnect();
                }
                throw obj1;
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Bitmap bitmap1)
            {
                if (bitmap1 != null)
                {
                    if (cache)
                    {
                        ImageUtil.addBitmapToMemoryCache(imageUrl, bitmap1);
                    }
                    callback.bitmapReady(bitmap1);
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Bitmap)obj);
            }

            
            {
                imageUrl = s;
                maxWidth = i;
                maxHeight = j;
                cache = flag;
                callback = imagedownloadcallback;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static void setupBitmapCache()
    {
        if (sMemCache == null)
        {
            sMemCache = new LruCache(15);
        }
    }



}
